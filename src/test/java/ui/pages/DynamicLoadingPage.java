package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ui.base.BasePage;

public class DynamicLoadingPage extends BasePage {
    private static final String PAGE_TITLE = "The Internet";
    private static final String PAGE_SLUG = "/dynamic_loading";
    public static final String DYNAMIC_ELEMENT_TEXT = "Hello World!";

    @FindBy(css = "#start button")
    private WebElement startButton;

    @FindBy(css = "a[href='/dynamic_loading/1']")
    private WebElement example1Link;

    @FindBy(css = "a[href='/dynamic_loading/2']")
    private WebElement example2Link;

    @FindBy(css = "#finish h4")
    private WebElement dynamicElement;

    @FindBy(css = "#loading")
    private WebElement loader;

    public DynamicLoadingPage() {
        super();
    }

    @Override
    protected String getPageSlug() {
        return PAGE_SLUG;
    }

    @Override
    protected String getPageTitle() {
        return PAGE_TITLE;
    }

    public void openHiddenDynamicElementPage() {
        example1Link.click();
    }

    public void openRenderedAfterLoadingDynamicElementPage() {
        example2Link.click();
    }

    public void clickOnStartButton() {
        startButton.click();
    }

    public String getElementText() {
        return waitForElementsAppearance(dynamicElement).getText();
    }

    public boolean isLoadingPresented() {
        return waitForElementsAppearance(loader).isDisplayed();
    }

    public boolean isLoadingDisappeared() {
        return isElementDisappeared(loader);
    }
}
