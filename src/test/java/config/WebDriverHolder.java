package config;

import static ui.base.BaseTest.DOWNLOAD_DIR;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WebDriverHolder {
    private static final Logger logger = LoggerFactory.getLogger(WebDriverHolder.class);
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    
    private static final String DEFAULT_BROWSER = "chrome";
    
    private WebDriverHolder() {
    }
    
    /**
     * Initialize WebDriver with specified browser type for the current thread.
     * 
     * @param browserType The type of browser to initialize (chrome, firefox, edge, safari)
     * @return The WebDriver instance for the current thread
     */


    public static WebDriver initDriver() {
        String browserType = System.getProperty("browser", DEFAULT_BROWSER);
        if (driverThreadLocal.get() != null) {
            logger.info("WebDriver is already initialized for current thread. Returning existing instance.");
            return driverThreadLocal.get();
        }
        logger.info("Initializing {} WebDriver for thread: {}", 
            browserType, Thread.currentThread());
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
            logger.warn("WebDriver has not been initialized for current thread. Calling initDriver first.");
            driver = createWebDriver(DEFAULT_BROWSER);
        }
        return driver;
    }
    
    /**
     * Quit the WebDriver and remove it from the current thread.
     */
    public static void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            logger.info("Quitting WebDriver for thread: {}", Thread.currentThread());
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
        logger.info("Creating WebDriver for browser: {}", browserType);
        switch (browserType.toLowerCase()) {
            case "chrome":
                return new ChromeDriver(getOptions());
            case "firefox":
                return new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
            case "safari":
                return new SafariDriver();
            default:
                logger.warn("Browser type '{}' not recognized. Defaulting to Chrome.", browserType);
                return new ChromeDriver(getOptions());
        }
    }

    private static ChromeOptions getOptions() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = getStringObjectPrefsMap();

        options.setExperimentalOption("prefs", prefs);

        // Command line arguments
        options.addArguments("--disable-features=PasswordsLeakDetection");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--start-maximized");
        options.addArguments("--incognito"); // Using incognito mode can help avoid saved password dialogs

        return options;
    }

    private static Map<String, Object> getStringObjectPrefsMap() {
        Map<String, Object> prefs = new HashMap<>();

        // Download preferences
        prefs.put("download.default_directory", DOWNLOAD_DIR.getAbsolutePath());
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);

        // Disable password saving completely
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("password_manager_enabled", false);

        // Additional settings to disable notifications and popups
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("profile.managed_default_content_settings.popups", 1);
        return prefs;
    }
}