package com.basics.tests.patterns.page_object_model.tests;

import com.basics.tests.patterns.page_object_model.base.BaseTest;
import com.basics.tests.patterns.page_object_model.pages.AlertsPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class AlertsTest extends BaseTest {
    private AlertsPage alertsPage;

    @BeforeMethod
    public void openAlertsPage(){
        alertsPage = new AlertsPage(driver);
        alertsPage.open();
    }

    @Test
    public void clickJSAlert() {
        alertsPage.clickOnJSAlert();
        Alert alert = wait.until(alertIsPresent());
        Assert.assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept();

        String resultMessage = alertsPage.getResultMessage();
        Assert.assertEquals(resultMessage, "You successfully clicked an alert");
    }

    @Test
    public void clickJSAlertConfirm(){
        alertsPage.clickOnJSConfirm();
        Alert alert = wait.until(alertIsPresent());
        Assert.assertEquals(alert.getText(), "I am a JS Confirm");

        alert.dismiss();
        String resultMessage = alertsPage.getResultMessage();
        Assert.assertEquals(resultMessage, "You clicked: Cancel");

        alertsPage.clickOnJSConfirm();
        alert.accept();

        resultMessage = alertsPage.getResultMessage();
        Assert.assertEquals(resultMessage, "You clicked: Ok");
    }

    @Test
    public void clickJSPrompt(){
        String promptMessage = "test";

        alertsPage.clickOnJSPrompt();
        Alert alert = wait.until(alertIsPresent());
        alert.dismiss();
        String resultMessage = alertsPage.getResultMessage();
        Assert.assertEquals(resultMessage, "You entered: null");

        alertsPage.clickOnButtonByText("Click for JS Prompt");
        alert.sendKeys(promptMessage);
        alert.accept();
        resultMessage = alertsPage.getResultMessage();
        Assert.assertEquals(resultMessage, String.format("You entered: %s", promptMessage));
    }
}
