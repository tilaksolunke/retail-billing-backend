package in.tilaksolunke.billingsoftware.service;

import com.stripe.exception.StripeException;
import in.tilaksolunke.billingsoftware.io.StripeOrderResponse;

public interface StripeService {

    StripeOrderResponse createPaymentIntent(Double amount, String currency) throws StripeException;
}
