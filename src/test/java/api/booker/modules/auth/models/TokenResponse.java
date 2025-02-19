package api.booker.modules.auth.models;

import lombok.Getter;

@Getter
public class TokenResponse {
    private String token;

    public boolean isValid() {
        return token != null && !token.isEmpty();
    }
}
