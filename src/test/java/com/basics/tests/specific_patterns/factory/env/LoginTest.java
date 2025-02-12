package com.basics.tests.specific_patterns.factory.env;

import com.basics.tests.specific_patterns.factory.driver.BrowserType;
import com.basics.tests.specific_patterns.factory.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver(BrowserType.CHROME);
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(AppConfig.getAdminUsername(), "password123");
        Assert.assertEquals(driver.getTitle(), "Home Page");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /*
     * Default: mvn test
     * Stage: mvn test -Pstage
     * Prod: mvn test -Pprod
     *
     * Additional: mvn test -Pstage -DadminUser=stage_admin
     */
}
