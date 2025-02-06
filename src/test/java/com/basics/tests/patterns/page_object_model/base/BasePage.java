package com.basics.tests.patterns.page_object_model.base;

import com.basics.tests.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public abstract class BasePage {
    protected final WebDriver driver;
    protected WebDriverWait wait;
    protected final String baseUrl;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        baseUrl = Config.getProperty("heroku.url");
    }

    protected abstract String getPageSlug();

    protected abstract String getPageTitle();

    public void open() {
        driver.get(baseUrl + getPageSlug());
    }

    public boolean atPage(){
        try {
            wait.until(titleIs(getPageTitle()));
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

    protected WebDriverWait createWait(int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }
}


