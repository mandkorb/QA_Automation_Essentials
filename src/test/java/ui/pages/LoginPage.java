package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final String PAGE_TITLE = "The Internet";
    private static final String PAGE_SLUG = "/login";

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    @FindBy(id = "flash")
    private WebElement defaultFlash;

    @FindBy(css = "#flash.error")
    private WebElement errorFlash;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String getPageSlug() {
        return PAGE_SLUG;
    }

    public void enterUsernameField(String value) {
        usernameField.sendKeys(value);
    }

    public void enterPasswordField(String value) {
        passwordField.sendKeys(value);
    }

    public SecurePage clickOnSubmitButton() {
        submitButton.click();
        return new SecurePage(driver);
    }

    public boolean isErrorFlashPresent() {
        return errorFlash.isDisplayed();
    }

    public String getFlashTest() {
        return defaultFlash.getText().toLowerCase();
    }
}
