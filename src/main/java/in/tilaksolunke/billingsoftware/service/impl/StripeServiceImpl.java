package in.tilaksolunke.billingsoftware.service.impl;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import in.tilaksolunke.billingsoftware.io.StripeOrderResponse;
import in.tilaksolunke.billingsoftware.service.StripeService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StripeServiceImpl implements StripeService {

    @Value("${stripe.api.secret}")
    private String stripeSecretKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = stripeSecretKey;
    }

    @Override
    public StripeOrderResponse createPaymentIntent(Double amount, String currency) throws StripeException {
        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount((long) (amount * 100)) // Convert to cents/paisa
                .setCurrency(currency.toLowerCase()) // Stripe expects lowercase currency
                .setAutomaticPaymentMethods(
                        PaymentIntentCreateParams.AutomaticPaymentMethods.builder()
                                .setEnabled(true)
                                .build()
                )
                .build();

        PaymentIntent paymentIntent = PaymentIntent.create(params);
        return convertToResponse(paymentIntent);
    }

    private StripeOrderResponse convertToResponse(PaymentIntent paymentIntent) {
        return StripeOrderResponse.builder()
                .id(paymentIntent.getId())
                .object(paymentIntent.getObject())
                .amount(paymentIntent.getAmount())
                .currency(paymentIntent.getCurrency())
                .status(paymentIntent.getStatus())
                .createdAt(paymentIntent.getCreated())
                .clientSecret(paymentIntent.getClientSecret())
                .build();
    }
}
