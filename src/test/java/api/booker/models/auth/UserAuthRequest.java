package api.booker.models.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserAuthRequest {
    private String username;
    private String password;
}
