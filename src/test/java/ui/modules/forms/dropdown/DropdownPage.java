package ui.modules.forms.dropdown;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import ui.base.BasePage;

public class DropdownPage extends BasePage {
    private static final String PAGE_TITLE = "The Internet";
    private static final String PAGE_SLUG = "/dropdown";

    @FindBy(id = "dropdown")
    private WebElement dropdown;

    public DropdownPage() {
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
