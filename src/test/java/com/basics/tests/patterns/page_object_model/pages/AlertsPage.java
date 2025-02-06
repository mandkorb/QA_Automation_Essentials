package com.basics.tests.patterns.page_object_model.pages;

import com.basics.tests.patterns.page_object_model.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage extends BasePage {
    enum AlertButtons {
        ALERT("Click for JS Alert"),
        CONFIRM("Click for JS Confirm"),
        PROMPT("Click for JS Prompt");

        private final String buttonText;

        AlertButtons(String buttonText) {
            this.buttonText = buttonText;
        }

        public String getButtonText() {
            return buttonText;
        }
    }

    public AlertsPage(WebDriver driver) {
        super(driver);
        this.wait = createWait(10);
    }

    @Override
    protected String getPageSlug() {
        return "/javascript_alerts";
    }

    @Override
    protected String getPageTitle() {
        return driver.getTitle();
    }

    public void clickOnJSAlert(){
        clickOnButtonByText(AlertButtons.ALERT.getButtonText());
    }

    public void clickOnJSConfirm(){
        clickOnButtonByText(AlertButtons.CONFIRM.getButtonText());
    }

    public void clickOnJSPrompt(){
        clickOnButtonByText(AlertButtons.PROMPT.getButtonText());
    }

    public String getResultMessage(){
        return driver.findElement(By.id("result")).getText();
    }
}

