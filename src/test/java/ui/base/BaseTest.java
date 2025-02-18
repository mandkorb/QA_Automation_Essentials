package ui.base;

import config.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public abstract class BaseTest {
    protected WebDriver driver;
    protected static final String USERNAME = Configuration.getProperty("heroku.username");
    protected static final String PASSWORD = Configuration.getProperty("heroku.password");

    @BeforeClass
    public void setupSuite() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


