package com.basics.tests.patterns.page_object_model.tests;

import com.basics.tests.config.Configuration;
import com.basics.tests.patterns.page_object_model.base.BaseTest;
import com.basics.tests.patterns.page_object_model.pages.LoginPage;
import com.basics.tests.patterns.page_object_model.pages.SecurePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void openAlertsPage(){
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    @Test(dataProvider = "validCredentials")
    public void positiveLogin(String usernameValue, String password){
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
    public void negativeLogin(String usernameValue, String password, String errorMessage){
        loginPage.open();
        loginPage.enterUsernameField(usernameValue);
        loginPage.enterPasswordField(password);
        loginPage.clickOnSubmitButton();
        assertTrue(loginPage.isErrorFlashPresent());
        assertTrue(loginPage.getFlashTest().contains(errorMessage));
    }

    @DataProvider(name = "validCredentials")
    public Object[][] provideValidLoginCredentials(){
        return new Object[][]{
                {USERNAME, PASSWORD}
        };
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] provideInvalidLoginCredentials(){
        return new Object[][]{
                {USERNAME + "1", PASSWORD, "Your username is invalid!"},
                {USERNAME, PASSWORD + "1", "Your password is invalid!"},
                {USERNAME, "", "Your password is invalid!"},
                {"", PASSWORD, "Your username is invalid!"},
                {"", "", "Your username is invalid!"}
        };
    }
}
