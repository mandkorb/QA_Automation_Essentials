package api.booker.modules.auth;

import api.booker.base.BaseApiTest;
import api.booker.modules.auth.models.TokenResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AuthServiceImplTests extends BaseApiTest {
    private AuthServiceImpl authServiceImpl;

    @BeforeClass
    public void setup() {
        authServiceImpl = new AuthServiceImpl();
    }

    @Test
    public void returnTokenWhenValidAuth() {
        TokenResponse token = authServiceImpl.loginUser();
        assertTrue(token.isValid());
    }
}
