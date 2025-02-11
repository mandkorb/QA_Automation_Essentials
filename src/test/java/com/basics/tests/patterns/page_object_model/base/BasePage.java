package com.basics.tests.patterns.page_object_model.base;

import com.basics.tests.config.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public abstract class BasePage {
    private static final int DEFAULT_WAIT_DURATION = 10;
    protected final WebDriver driver;
    protected WebDriverWait wait;
    private final String baseUrl;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        baseUrl = Configuration.getProperty("heroku.url");
        setWaitDurationInSeconds(DEFAULT_WAIT_DURATION);
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

    protected void clickOnButtonByCssSelector(By locator) {
        wait.until(elementToBeClickable(locator)).click();
    }

    protected WebElement waitForElementAppearance(By by) {
        return wait.until(visibilityOfElementLocated(by));
    }

    protected Boolean isElementDisappeared(By by) {
        return wait.until(invisibilityOfElementLocated(by));
    }

    protected WebElement waitForElementClickable(By by) {
        return wait.until(elementToBeClickable(by));
    }

    public void setWaitDurationInSeconds(int waitDuration) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitDuration));
    }
}


