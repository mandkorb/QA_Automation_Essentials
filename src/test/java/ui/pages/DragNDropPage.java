package ui.pages;

import org.openqa.selenium.WebDriver;

import ui.base.BasePage;

public class DragNDropPage extends BasePage {
    private static final String PAGE_TITLE = "The Internet";
    private static final String PAGE_SLUG = "/drag_and_drop";

    public DragNDropPage(WebDriver driver) {
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
        
}
