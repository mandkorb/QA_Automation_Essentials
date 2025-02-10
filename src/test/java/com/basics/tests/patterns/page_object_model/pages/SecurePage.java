package com.basics.tests.patterns.page_object_model.pages;

import com.basics.tests.patterns.page_object_model.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SecurePage extends BasePage {
    private static final String PAGE_TITLE = "The Internet";
    private static final String PAGE_SLUG = "/secure";
    private final By successFlash = By.cssSelector("#flash.success");
    private final By header = By.cssSelector("h2");
    private final By description = By.cssSelector(".subheader");
    private final By signOutButton = By.cssSelector("[class$=signout]");

    public SecurePage(WebDriver driver) {
        super(driver);
    }

    public SecurePage(WebDriver driver, int waitDuration) {
        super(driver, waitDuration);
    }

    @Override
    protected String getPageSlug() {
        return PAGE_SLUG;
    }

    public boolean isAllSuccessElementsAvailable() {
        List<By> elements = List.of(successFlash, header, description, signOutButton);
        for (By locator : elements) {
            WebElement element = driver.findElement(locator);
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public void logout() {
        driver.findElement(signOutButton).click();
    }
}