package in.tilaksolunke.billingsoftware.io;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDetails {

    private String stripePaymentIntentId;
    private String stripePaymentMethodId;
    private String clientSecret;
    private PaymentStatus status;

    public enum PaymentStatus {
        PENDING, COMPLETED, FAILED, CANCELED, REQUIRES_ACTION
    }
}
