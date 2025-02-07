package com.basics.tests.patterns.page_object_model.base;

import com.basics.tests.config.Configuration;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public abstract class BasePage {
    private static final int DEFAULT_WAIT_DURATION = 10;
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    private final String baseUrl;

    public BasePage(WebDriver driver) {
        this(driver, DEFAULT_WAIT_DURATION);
    }

    public BasePage(WebDriver driver, int waitDuration) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitDuration));
        baseUrl = Configuration.getProperty("heroku.url");
    }

    protected abstract String getPageSlug();

    public void open() {
        driver.get(baseUrl + getPageSlug());
    }

    public boolean atPage(String expectedTitle) {
        try {
            wait.until(titleIs(expectedTitle));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void clickOnButtonByText(String buttonText) {
        By locator = By.xpath(String.format("//button[text()='%s']", buttonText.replace("'", "\\'")));
        wait.until(elementToBeClickable(locator)).click();
    }

    protected void waitForElementAppearance(WebElement element){
        wait.until(visibilityOf(element));
    }

    protected void waitForElementClickable(WebElement element){
        wait.until(elementToBeClickable(element));
    }
}


