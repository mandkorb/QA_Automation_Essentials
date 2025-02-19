package api.booker.modules.auth;

import api.booker.modules.auth.models.TokenResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AuthServiceTests {
    private AuthService authService;

    @BeforeClass
    public void setup() {
        authService = new AuthService();
    }

    @Test
    public void returnTokenWhenValidAuth() {
        TokenResponse token = authService.loginUser();
        assertTrue(token.isValid());
    }
}
