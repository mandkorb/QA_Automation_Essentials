package ui.tests;

import ui.base.BaseTest;
import ui.pages.AlertsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AlertsTest extends BaseTest {
    private AlertsPage alertsPage;

    @BeforeMethod
    public void openAlertsPage() {
        alertsPage = new AlertsPage();
        alertsPage.open();
    }

    @Test
    public void clickJSAlert() {
        assertTrue(alertsPage.isPageOpened());
        alertsPage.clickOnJSAlert();
        String alertText = alertsPage.getAlertText();
        assertEquals(alertText, "I am a JS Alert");
        alertsPage.acceptAlert();
        String resultMessage = alertsPage.getResultMessage();
        assertEquals(resultMessage, "You successfully clicked an alert");
    }

    @Test
    public void clickJSAlertConfirm() {
        alertsPage.clickOnJSConfirm();
        String alertText = alertsPage.getAlertText();
        assertEquals(alertText, "I am a JS Confirm");

        alertsPage.dismissAlert();
        String resultMessage = alertsPage.getResultMessage();
        assertEquals(resultMessage, "You clicked: Cancel");

        alertsPage.clickOnJSConfirm();
        alertsPage.acceptAlert();
        resultMessage = alertsPage.getResultMessage();
        assertEquals(resultMessage, "You clicked: Ok");
    }

    @Test
    public void clickJSPrompt() {
        String promptMessage = "test";

        alertsPage.clickOnJSPrompt();
        alertsPage.dismissAlert();
        String resultMessage = alertsPage.getResultMessage();
        assertEquals(resultMessage, "You entered: null");

        alertsPage.clickOnButtonByText("Click for JS Prompt");
        alertsPage.sendKeysToAlert(promptMessage);
        alertsPage.acceptAlert();
        resultMessage = alertsPage.getResultMessage();
        assertEquals(resultMessage, String.format("You entered: %s", promptMessage));
    }
}
