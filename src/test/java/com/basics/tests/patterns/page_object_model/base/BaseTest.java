package com.basics.tests.patterns.page_object_model.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeSuite
    public void setupSuite() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


