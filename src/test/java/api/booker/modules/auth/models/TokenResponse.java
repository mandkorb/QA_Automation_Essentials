package api.booker.modules.auth.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TokenResponse {
    private String token;

    public boolean isValid() {
        return token != null && !token.isEmpty();
    }
}
