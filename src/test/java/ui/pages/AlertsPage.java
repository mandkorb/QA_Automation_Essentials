package ui.pages;

import ui.base.BasePage;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class AlertsPage extends BasePage {
    private static final String PAGE_TITLE = "The Internet";
    private static final String PAGE_SLUG = "/javascript_alerts";

    public AlertsPage(WebDriver driver) {
        super(driver, PAGE_TITLE, PAGE_SLUG);
    }

    @Override
    protected String getPageSlug() {
        return PAGE_SLUG;
    }

    @Override
    protected String getPageTitle() {
        return PAGE_TITLE;
    }

    public void clickOnJSAlert() {
        clickOnButtonByText(AlertButtons.ALERT.getButtonText());
    }

    public void clickOnJSConfirm() {
        clickOnButtonByText(AlertButtons.CONFIRM.getButtonText());
    }

    public void clickOnJSPrompt() {
        clickOnButtonByText(AlertButtons.PROMPT.getButtonText());
    }

    public String getResultMessage() {
        return driver.findElement(By.id("result")).getText();
    }

    public String getAlertText() {
        return wait.until(alertIsPresent()).getText();
    }

    public void acceptAlert() {
        wait.until(alertIsPresent()).accept();
    }

    public void dismissAlert() {
        wait.until(alertIsPresent()).dismiss();
    }

    public void sendKeysToAlert(String prompt) {
        wait.until(alertIsPresent()).sendKeys(prompt);
    }

    @Getter
    enum AlertButtons {
        ALERT("Click for JS Alert"),
        CONFIRM("Click for JS Confirm"),
        PROMPT("Click for JS Prompt");

        private final String buttonText;

        AlertButtons(String buttonText) {
            this.buttonText = buttonText;
        }
    }
}

