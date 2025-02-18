package api.booker.tests;

import api.booker.models.auth.TokenResponse;
import api.booker.services.AuthService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class AuthServiceTests {
    private AuthService authService;

    @BeforeClass
    public void setup() {
        authService = new AuthService();
    }

    @Test
    public void returnTokenWhenValidAuth() {
        TokenResponse token = authService.loginUser();
        assertNotNull(token);
        token.setToConfiguration();
    }
}
