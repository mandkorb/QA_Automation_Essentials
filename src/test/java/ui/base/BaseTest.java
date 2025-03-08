package ui.base;

import config.Configuration;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseTest {
    protected WebDriver driver;
    protected static final String USERNAME = Configuration.getProperty("heroku.username");
    protected static final String PASSWORD = Configuration.getProperty("heroku.password");
    public static final String DOWNLOAD_DIR_PATH = "src/test/resources/downloads";
    public static final File DOWNLOAD_DIR = new File(DOWNLOAD_DIR_PATH);

    @BeforeClass
    public void setupSuite() {
        setupDownloadDir();
        driver = new ChromeDriver(getOptions());
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
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

    private void setupDownloadDir() {
        if (!DOWNLOAD_DIR.exists() && !DOWNLOAD_DIR.mkdirs()) {
            throw new RuntimeException("Failed to create download directory: " + DOWNLOAD_DIR.getAbsolutePath());
        }
    }

    private ChromeOptions getOptions() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", DOWNLOAD_DIR.getAbsolutePath());
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        options.setExperimentalOption("prefs", prefs);
        return options;
    }
}


