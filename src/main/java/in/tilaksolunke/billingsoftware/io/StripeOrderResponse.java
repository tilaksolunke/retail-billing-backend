package in.tilaksolunke.billingsoftware.io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StripeOrderResponse {
    private String id;
    private String object;
    private Long amount;
    private String currency;
    private String status;
    private Long createdAt;
    private String clientSecret;
}
