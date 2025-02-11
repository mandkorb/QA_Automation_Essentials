package com.basics.tests.patterns.page_object_model.pages;

import com.basics.tests.patterns.page_object_model.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage extends BasePage {
    private static final String PAGE_TITLE = "The Internet";
    private static final String PAGE_SLUG = "/dynamic_loading";
    private static final String HIDDEN_ELEMENT_PAGE_SLUG = "/dynamic_loading/1";
    private static final String AFTER_RENDERED_PAGE_SLUG = "/dynamic_loading/2";
    public static final String DYNAMIC_ELEMENT_TEXT = "Hello World!";

    private final By example1Link = By.cssSelector("a[href='%s']".formatted(HIDDEN_ELEMENT_PAGE_SLUG));
    private final By example2Link = By.cssSelector("a[href='%s']".formatted(AFTER_RENDERED_PAGE_SLUG));
    private final By startButton = By.cssSelector("#start button");
    private final By dynamicElement = By.cssSelector("#finish h4");
    private final By loader = By.cssSelector("#loading");

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String getPageSlug() {
        return PAGE_SLUG;
    }

    public void openHiddenDynamicElementPage() {
        driver.findElement(example1Link).click();
    }

    public void openRenderedAfterLoadingDynamicElementPage() {
        driver.findElement(example2Link).click();
    }

    public void clickOnStartButton() {
        driver.findElement(startButton).click();
    }

    public String getElementText() {
        return waitForElementAppearance(dynamicElement).getText();
    }

    public boolean isLoadingPresented() {
        return waitForElementAppearance(loader).isDisplayed();
    }

    public boolean isLoadingDisappeared() {
        return isElementDisappeared(loader);
    }
}
