package ir.sajjad.springbootsession23.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserLoginRequest {
    @NotNull(message = "{User.shouldn't.be.null}")
    @NotBlank(message = "{User.shouldn't.be.blank}")
    private String username;
    @NotNull(message = "{password.shouldn't.be.null}")
    @NotBlank(message = "{password.shouldn't.be.blank}")
    private String password;

}
