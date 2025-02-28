package ui.base;

import config.Configuration;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
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
            driver.close();
            driver.quit();
        }
    }

    @AfterMethod
    public void takeScreenshotWhenFailed(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenshot();
        }
    }

    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}


