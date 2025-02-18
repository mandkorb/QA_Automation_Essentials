package api.reqres.models.register.valid;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRegisterValidResponse {
    private int id;
    private String token;
}
