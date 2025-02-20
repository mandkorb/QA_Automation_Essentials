package ui.base;

import config.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public abstract class BasePage {
    private static final int DEFAULT_ELEMENT_WAIT_DURATION = 10;
    protected final WebDriver driver;
    protected WebDriverWait wait;
    private final String baseUrl;

    public BasePage(WebDriver driver) {
        this.driver = Objects.requireNonNull(driver, "Driver cannot be null");
        baseUrl = Configuration.getProperty("heroku.url");
        setWaitDurationInSeconds(DEFAULT_ELEMENT_WAIT_DURATION);
        PageFactory.initElements(driver, this);
    }

    protected abstract String getPageSlug();

    public void open() {
        driver.get(baseUrl + getPageSlug());
    }

    public boolean atPage() {
        return wait.until(urlContains(getPageSlug()));
    }

    public void clickOnButtonByText(String buttonText) {
        By locator = By.xpath(String.format("//button[text()='%s']", buttonText.replace("'", "\\'")));
        wait.until(elementToBeClickable(locator)).click();
    }

    protected WebElement waitForElementAppearance(WebElement element) {
        return wait.until(visibilityOf(element));
    }

    protected Boolean isElementDisappeared(WebElement element) {
        return wait.until(invisibilityOf(element));
    }

    protected WebElement waitForElementClickable(WebElement element) {
        return wait.until(elementToBeClickable(element));
    }

    public void setWaitDurationInSeconds(int waitDuration) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitDuration));
    }
}


