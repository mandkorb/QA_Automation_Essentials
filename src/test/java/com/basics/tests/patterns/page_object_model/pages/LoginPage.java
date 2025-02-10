package com.basics.tests.patterns.page_object_model.pages;

import com.basics.tests.patterns.page_object_model.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final String PAGE_TITLE = "The Internet";
    private static final String PAGE_SLUG = "/login";
    private final By usernameField = By.cssSelector("#username");
    private final By passwordField = By.cssSelector("#password");
    private final By submitButton = By.cssSelector("button[type='submit']");
    private final By errorFlash = By.cssSelector("#flash.error");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage(WebDriver driver, int waitDuration) {
        super(driver, waitDuration);
    }

    @Override
    protected String getPageSlug() {
        return PAGE_SLUG;
    }

    public void enterUsernameField(String value){
        driver.findElement(usernameField).sendKeys(value);
    }

    public void enterPasswordField(String value){
        driver.findElement(passwordField).sendKeys(value);
    }

    public SecurePage clickOnSubmitButton(){
        clickonButtonByCssSelector(submitButton);
        return new SecurePage(driver);
    }

    public boolean isErrorFlashPresent(){
        return driver.findElement(errorFlash).isDisplayed();
    }
}
