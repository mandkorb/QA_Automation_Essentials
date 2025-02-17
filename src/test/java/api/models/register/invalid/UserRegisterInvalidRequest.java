package api.models.register.invalid;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRegisterInvalidRequest {
    private String email;
}
