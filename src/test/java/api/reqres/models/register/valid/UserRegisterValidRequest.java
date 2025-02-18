package api.reqres.models.register.valid;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRegisterValidRequest {
    private String email;
    private String password;
}
