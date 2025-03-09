package ui.base;

import config.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
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

    protected abstract String getPageTitle();

    public boolean isPageOpened() {
        return wait.until(webDriver -> webDriver.getTitle().contains(getPageTitle()) && webDriver.getCurrentUrl().equals(baseUrl + getPageSlug()));
    }

    public void open() {
        driver.get(baseUrl + getPageSlug());
    }

    public void clickOnButtonByText(String buttonText) {
        By locator = By.xpath(String.format("//button[text()='%s']", buttonText.replace("'", "\\'")));
        wait.until(elementToBeClickable(locator)).click();
    }

    protected boolean areAllElementsVisible(WebElement... elements) {
        return Arrays.stream(elements)
                .allMatch(element -> {
                    try {
                        wait.until(visibilityOf(element));
                        return true;
                    } catch (TimeoutException e) {
                        return false;
                    }
                });
    }

    protected WebElement waitForElementsAppearance(WebElement element) {
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


