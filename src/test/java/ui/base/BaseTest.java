package ui.base;

import config.Configuration;
import config.WebDriverHolder;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;

public abstract class BaseTest {
    protected static final String USERNAME = Configuration.getProperty("heroku.username");
    protected static final String PASSWORD = Configuration.getProperty("heroku.password");
    public static final String DOWNLOAD_DIR_PATH = "src/test/resources/downloads";
    public static final File DOWNLOAD_DIR = new File(DOWNLOAD_DIR_PATH);

    @BeforeClass
    public void setupSuite() {
        setupDownloadDir();
        WebDriverHolder.initDriver();
    }

    @AfterClass
    public void teardown() {
        WebDriverHolder.quitDriver();
    }

    @AfterMethod
    public void takeScreenshotWhenFailed(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenshot();
        }
    }

    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverHolder.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    private void setupDownloadDir() {
        if (!DOWNLOAD_DIR.exists() && !DOWNLOAD_DIR.mkdirs()) {
            throw new RuntimeException("Failed to create download directory: " + DOWNLOAD_DIR.getAbsolutePath());
        }
    }

    protected WebDriver getDriver() {
        return WebDriverHolder.getDriver();
    }
}


