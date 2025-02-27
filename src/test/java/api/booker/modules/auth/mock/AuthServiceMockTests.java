package api.booker.modules.auth.mock;

import api.booker.modules.auth.AuthService;
import api.booker.modules.auth.models.TokenResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

public class AuthServiceMockTests {
    @Test
    public void testLoginMock() {
        AuthService mockService = mock(AuthService.class);

        TokenResponse mockTokenResponse = new TokenResponse("mockToken");
        when(mockService.loginUser()).thenReturn(mockTokenResponse);

        TokenResponse token = mockService.loginUser();
        Assert.assertEquals(token.getToken(), "mockToken", "Token should match");
        Assert.assertTrue(token.isValid(), "Token should be valid");

        verify(mockService, times(1)).loginUser();
    }
}