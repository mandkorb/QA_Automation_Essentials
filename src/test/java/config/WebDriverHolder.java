package config;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ui.base.BaseTest.DOWNLOAD_DIR;


public class WebDriverHolder {
    private static final Logger logger = LoggerFactory.getLogger(WebDriverHolder.class);
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    
    private WebDriverHolder() {
    }
    
    /**
     * Initialize WebDriver with specified browser type for the current thread.
     * 
     * @param browserType The type of browser to initialize (chrome, firefox, edge, safari)
     * @return The WebDriver instance for the current thread
     */
    public static WebDriver initDriver(String browserType) {
        if (driverThreadLocal.get() != null) {
            logger.info("WebDriver is already initialized for current thread. Returning existing instance.");
            return driverThreadLocal.get();
        }
        logger.info("Initializing {} WebDriver for thread: {}", 
            browserType, Thread.currentThread().threadId());
        WebDriver driver = createWebDriver(browserType);
        driver.manage().window().maximize();
        driverThreadLocal.set(driver);
        return driver;
    }
    
    /**
     * Get the WebDriver instance for the current thread.
     * 
     * @return The WebDriver instance or null if not initialized
     */
    public static WebDriver getDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver == null) {
            logger.warn("WebDriver has not been initialized for current thread. Call initDriver first.");
        }
        return driver;
    }
    
    /**
     * Quit the WebDriver and remove it from the current thread.
     */
    public static void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            logger.info("Quitting WebDriver for thread: {}", Thread.currentThread().threadId());
            try {
                driver.quit();
            } catch (Exception e) {
                logger.error("Error quitting WebDriver: {}", e.getMessage());
            } finally {
                driverThreadLocal.remove();
            }
        }
    }

    private static WebDriver createWebDriver(String browserType) {
        switch (browserType.toLowerCase()) {
            case "chrome": {
                return new ChromeDriver(getOptions());
            }
            case "firefox":
                return new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
            case "safari":
                return new SafariDriver();
            default:
                logger.info("Browser type not recognized. Defaulting to Chrome.");
                return new ChromeDriver();
        }
    }

    private static ChromeOptions getOptions() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", DOWNLOAD_DIR.getAbsolutePath());
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        options.setExperimentalOption("prefs", prefs);
        return options;
    }
}