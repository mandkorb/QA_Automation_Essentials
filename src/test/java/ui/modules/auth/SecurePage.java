package ui.modules.auth;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ui.base.BasePage;

public class SecurePage extends BasePage {
    private static final String PAGE_TITLE = "The Internet";
    private static final String PAGE_SLUG = "/secure";

    @FindBy(css = "#flash.success")
    private WebElement successFlash;

    @FindBy(css = "h2")
    private WebElement header;

    @FindBy(css = ".subheader")
    private WebElement description;

    @FindBy(css = "[class$=signout]")
    private WebElement signOutButton;

    public SecurePage() {
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

    public boolean isAllSuccessElementsAvailable() {
        List<WebElement> elements = List.of(successFlash, header, description, signOutButton);
        for (WebElement element : elements) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public void logout() {
        signOutButton.click();
    }
}