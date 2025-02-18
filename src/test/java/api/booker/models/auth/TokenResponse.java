package api.booker.models.auth;

import config.Configuration;
import lombok.Getter;

@Getter
public class TokenResponse {
    private String token;

    public void setToConfiguration() {
        if(isValid()){
            Configuration.setProperty("booker.token", token);
        } else {
            throw new IllegalStateException("Reeceived an invalid token!");
        }
    }

    private boolean isValid() {
        return token != null && !token.isEmpty();
    }
}
