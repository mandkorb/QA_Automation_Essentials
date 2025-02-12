package com.basics.tests.tests;

import com.basics.tests.base.BaseTest;
import com.basics.tests.pages.LoginPage;
import com.basics.tests.pages.SecurePage;
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
        loginPage.open();
        loginPage.enterUsernameField(usernameValue);
        loginPage.enterPasswordField(password);
        SecurePage securePage = loginPage.clickOnSubmitButton();
        assertTrue(securePage.atPage());
        assertTrue(securePage.isAllSuccessElementsAvailable());
        securePage.logout();
        assertTrue(loginPage.atPage());
    }

    @Test(dataProvider = "invalidCredentials")
    public void loginWithInvalidCredentials(String usernameValue, String password, String errorMessage) {
        loginPage.open();
        loginPage.enterUsernameField(usernameValue);
        loginPage.enterPasswordField(password);
        loginPage.clickOnSubmitButton();
        assertTrue(loginPage.isErrorFlashPresent());
        assertTrue(loginPage.getFlashTest().contains(errorMessage));
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
                {USERNAME + "1", PASSWORD, "Your username is invalid!"},
                {USERNAME, PASSWORD + "1", "Your password is invalid!"},
                {USERNAME, "", "Your password is invalid!"},
                {"", PASSWORD, "Your username is invalid!"},
                {"", "", "Your username is invalid!"}
        };
    }
}
