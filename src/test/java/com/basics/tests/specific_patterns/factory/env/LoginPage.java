package com.basics.tests.specific_patterns.factory.env;

import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private String baseUrl = AppConfig.getBaseUrl();

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(baseUrl + "/login");
    }

    public void login(String username, String password) {
        // ... auth logic ...
    }
}
