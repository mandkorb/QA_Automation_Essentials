package com.basics.tests.patterns.factory.driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FactoryTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = DriverFactory.createDriver(BrowserType.CHROME);
        driver.manage().window().maximize();
    }

    @Test
    public void test(){
        System.out.println("ok");
    }

    @AfterClass
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}