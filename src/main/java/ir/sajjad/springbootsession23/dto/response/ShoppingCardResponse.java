package ir.sajjad.springbootsession23.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingCardResponse {
    private Long shoppingCardId;
    private long factorId;
}
