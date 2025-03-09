package ui.tests;

import ui.base.BaseTest;
import ui.pages.LoginPage;
import ui.pages.SecurePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void openAlertsPage() {
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    @Test(dataProvider = "validCredentials")
    public void loginWithValidCredentials(String usernameValue, String password) {
        assertTrue(loginPage.isPageOpened());
        loginPage.open();
        loginPage.enterUsernameField(usernameValue);
        loginPage.enterPasswordField(password);
        SecurePage securePage = loginPage.clickOnSubmitButton();
        assertTrue(securePage.isPageOpened());
        assertTrue(securePage.isAllSuccessElementsAvailable());
        securePage.logout();
        assertTrue(loginPage.isPageOpened());
    }

    @Test(dataProvider = "invalidCredentials")
    public void loginWithInvalidCredentials(String usernameValue, String password, String errorMessage) {
        loginPage.open();
        loginPage.enterUsernameField(usernameValue);
        loginPage.enterPasswordField(password);
        loginPage.clickOnSubmitButton();
        assertTrue(loginPage.isErrorFlashPresent());
        assertTrue(loginPage.getFlashTest().contains(errorMessage.toLowerCase()));
    }

    @DataProvider(name = "validCredentials")
    public Object[][] provideValidLoginCredentials() {
        return new Object[][]{
                {USERNAME, PASSWORD}
        };
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] provideInvalidLoginCredentials() {
        return new Object[][]{
                {USERNAME + "1", PASSWORD, "Your USERNAME is invalid!"},
                {USERNAME, PASSWORD + "1", "Your PASSWORD is invalid!"},
                {USERNAME, "", "Your PASSWORD is invalid!"},
                {"", PASSWORD, "Your USERNAME is invalid!"},
                {"", "", "Your USERNAME is invalid!"}
        };
    }
}
