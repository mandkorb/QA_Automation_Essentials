package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * WebDriverHolder class implemented as a Singleton pattern.
 * This class ensures that only one WebDriver instance is created and used throughout the project.
 */
public class WebDriverHolder {
    private static final Logger logger = LoggerFactory.getLogger(WebDriverHolder.class);
    private static WebDriverHolder instance;
    private WebDriver driver;
    
    /**
     * Private constructor to prevent instantiation from outside.
     */
    private WebDriverHolder() {
        // Private constructor to enforce singleton pattern
    }
    
    /**
     * Get the singleton instance of WebDriverHolder.
     * 
     * @return The WebDriverHolder instance
     */
    public static synchronized WebDriverHolder getInstance() {
        if (instance == null) {
            instance = new WebDriverHolder();
        }
        return instance;
    }
    
    /**
     * Initialize WebDriver with specified browser type.
     * 
     * @param browserType The type of browser to initialize (chrome, firefox, edge, safari)
     * @return The WebDriver instance
     */
    public WebDriver initDriver(String browserType) {
        if (driver != null) {
            logger.info("WebDriver is already initialized. Returning existing instance.");
            return driver;
        }
        
        logger.info("Initializing {} WebDriver", browserType);
        
        switch (browserType.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                logger.info("Browser type not recognized. Defaulting to Chrome.");
                driver = new ChromeDriver();
                break;
        }
        
        // Configure the driver
        driver.manage().window().maximize();
        
        return driver;
    }
    
    /**
     * Get the current WebDriver instance.
     * 
     * @return The WebDriver instance or null if not initialized
     */
    public WebDriver getDriver() {
        if (driver == null) {
            logger.warn("WebDriver has not been initialized. Call initDriver first.");
        }
        return driver;
    }
    
    /**
     * Quit the WebDriver and reset the instance.
     */
    public void quitDriver() {
        if (driver != null) {
            logger.info("Quitting WebDriver");
            try {
                driver.quit();
            } catch (Exception e) {
                logger.error("Error quitting WebDriver: {}", e.getMessage());
            } finally {
                driver = null;
            }
        }
    }
}