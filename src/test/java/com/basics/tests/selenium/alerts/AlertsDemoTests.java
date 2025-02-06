package com.basics.tests.selenium.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class AlertsDemoTests {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setupDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeMethod
    public void openMainPage() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void clickJSAlert() {
        clickOnJSAlert();

        Alert alert = wait.until(alertIsPresent());
        Assert.assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept();

        WebElement resultMessage = driver.findElement(By.id("result"));
        Assert.assertEquals(resultMessage.getText(), "You successfully clicked an alert");
    }

    @Test
    public void clickJSAlertConfirm() {
        clickOnJSConfirm();
        Alert alert = wait.until(alertIsPresent());
        Assert.assertEquals(alert.getText(), "I am a JS Confirm");

        alert.dismiss();
        WebElement resultMessage = driver.findElement(By.id("result"));
        Assert.assertEquals(resultMessage.getText(), "You clicked: Cancel");

        clickOnButtonByText("Click for JS Confirm");
        alert.accept();

        Assert.assertEquals(resultMessage.getText(), "You clicked: Ok");
    }

    @Test
    public void clickJSPrompt(){
        String promptMessage = "test";

        clickOnJSPrompt();
        Alert alert = wait.until(alertIsPresent());
        alert.dismiss();
        WebElement resultMessage = driver.findElement(By.id("result"));
        Assert.assertEquals(resultMessage.getText(), "You entered: null");

        clickOnButtonByText("Click for JS Prompt");
        alert.sendKeys(promptMessage);
        alert.accept();
        Assert.assertEquals(resultMessage.getText(), String.format("You entered: %s", promptMessage));
    }

    void clickOnButtonByText(String text) {
        driver.findElement(By.xpath("//button[text()='%s']".formatted(text))).click();
    }

    private void clickOnJSAlert(){
        clickOnButtonByText(AlertButtonsDemo.ALERT.getButtonText());
    }

    private void clickOnJSConfirm(){
        clickOnButtonByText(AlertButtonsDemo.CONFIRM.getButtonText());
    }

    private void clickOnJSPrompt(){
        clickOnButtonByText(AlertButtonsDemo.PROMPT.getButtonText());
    }
}
