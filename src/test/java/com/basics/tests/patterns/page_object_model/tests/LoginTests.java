package com.basics.tests.patterns.page_object_model.tests;

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

    @DataProvider(name = "validCredentials")
    public Object[][] provideValidLoginCredentials(){
        return new Object[][]{
                {"tomsmith", "SuperSecretPassword!"}
        };
    }
}
