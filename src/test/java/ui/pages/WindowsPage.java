package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.base.BasePage;
import lombok.Getter;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class WindowsPage extends BasePage {
    private static final String PAGE_TITLE = "The Internet";
    private static final String PAGE_SLUG = "/windows";
    private static final String NEW_PAGE_TITLE = "New Window";
    private static final String NEW_PAGE_SLUG = "/windows/new";
    private static final String NEW_PAGE_CONTENT = "New Window";

    @FindBy(css = "a[href='/windows/new'][target='_blank']")
    private WebElement newPageLocator;

    @FindBy(css = ".example>h3")
    private WebElement newPageContent;

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String getPageSlug() {
        return PAGE_SLUG;
    }

    @Override
    protected String getPageTitle() {
        return PAGE_TITLE;
    }

    public void openNewWindow() {
        newPageLocator.click();
    }

    public void switchToWindow(Windows window) {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(window.getTitle())) {
                return;
            }
        }
        throw new NoSuchElementException("No window found with title: " + window.getTitle());
    }

    public boolean isNewWindowOpened() {
        return driver.getCurrentUrl().contains(NEW_PAGE_SLUG) && driver.getTitle().equals(NEW_PAGE_TITLE);
    }

    public boolean isNewWindowContentCorrect() {
        return newPageContent.getText().contains(NEW_PAGE_CONTENT);
    }

    public void closeNewWindow() {
        driver.close();
    }

    @Getter
    public enum Windows {
        DEFAULT(PAGE_TITLE),
        NEW(NEW_PAGE_TITLE);

        private final String title;

        Windows(String title) {
            this.title = title;
        }
    }
}
