package api.booker.modules.auth.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserAuthRequest {
    private String username;
    private String password;
}
