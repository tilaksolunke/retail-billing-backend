package in.tilaksolunke.billingsoftware.controller;

import com.stripe.exception.StripeException;
import in.tilaksolunke.billingsoftware.io.OrderResponse;
import in.tilaksolunke.billingsoftware.io.PaymentRequest;
import in.tilaksolunke.billingsoftware.io.PaymentVerificationRequest;
import in.tilaksolunke.billingsoftware.io.StripeOrderResponse;
import in.tilaksolunke.billingsoftware.service.OrderService;
import in.tilaksolunke.billingsoftware.service.StripeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final StripeService stripeService;
    private final OrderService orderService;

    @PostMapping("/create-payment-intent")
    @ResponseStatus(HttpStatus.CREATED)
    public StripeOrderResponse createStripePaymentIntent(@RequestBody PaymentRequest request) throws StripeException {
        return stripeService.createPaymentIntent(request.getAmount(), request.getCurrency());
    }

    @PostMapping("/verify")
    public OrderResponse verifyPayment(@RequestBody PaymentVerificationRequest request) {
        return orderService.verifyPayment(request);
    }
}

