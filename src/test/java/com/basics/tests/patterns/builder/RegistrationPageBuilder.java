package com.basics.tests.patterns.builder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPageBuilder {
    private final WebDriver driver;
    private final By firstNameField = By.id("firstName");
    private final By lastNameField = By.id("lastName");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By submitButton = By.id("submit");
    private final By successMessage = By.cssSelector(".alert-success");

    public RegistrationPageBuilder(WebDriver driver) {
        this.driver = driver;
    }

    public void register(UserBuilder user) {
        enterText(firstNameField, user.getFirstName());
        enterText(lastNameField, user.getLastName());
        enterText(emailField, user.getEmail());
        enterText(passwordField, user.getPassword());
        clickSubmit();
    }

    public boolean isRegistrationSuccessful() {
        return waitForElement(successMessage).isDisplayed();
    }

    private void enterText(By locator, String text) {
        WebElement element = waitForElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    private void clickSubmit() {
        waitForElement(submitButton).click();
    }

    private WebElement waitForElement(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
