package api.booker.models.auth;

import config.Configuration;
import lombok.Getter;

@Getter
public class TokenResponse {
    private String token;

    public boolean isValid() {
        return token != null && !token.isEmpty();
    }
}
