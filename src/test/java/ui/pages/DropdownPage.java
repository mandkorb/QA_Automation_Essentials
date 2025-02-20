package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {
    private static final String PAGE_TITLE = "The Internet";
    private static final String PAGE_SLUG = "/dropdown";

    @FindBy(id = "dropdown")
    private WebElement dropdown;

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String getPageSlug() {
        return PAGE_SLUG;
    }

    private Select getDropdown() {
        return new Select(dropdown);
    }

    public void selectOptionByIndex(int index) {
        getDropdown().selectByIndex(index);
    }

    public void selectOptionByValue(String value) {
        getDropdown().selectByValue(value);
    }

    public String getCurrentOptionText() {
        return getDropdown().getFirstSelectedOption().getText();
    }
}
