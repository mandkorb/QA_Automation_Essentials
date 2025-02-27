package api.booker.modules.auth;

import api.booker.modules.auth.models.TokenResponse;

public interface AuthService {
    TokenResponse loginUser();
}
