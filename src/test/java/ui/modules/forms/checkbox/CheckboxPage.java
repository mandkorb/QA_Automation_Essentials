package ui.modules.forms.checkbox;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.base.BasePage;

public class CheckboxPage extends BasePage {
    @FindBy(xpath = "//form[@id='checkboxes']/input[1]")
    WebElement uncheckedCheckbox;

    @FindBy(xpath = "//form[@id='checkboxes']/input[2]")
    WebElement checkedCheckbox;

    @Override
    protected String getPageSlug() {
        return "/checkboxes";
    }

    @Override
    protected String getPageTitle() {
        return "";
    }

    public boolean isChecked() {
        return checkedCheckbox.isSelected();
    }

    public boolean isUnchecked() {
        return !uncheckedCheckbox.isSelected();
    }

    public void selectCheckbox() {
        checkedCheckbox.click();
    }
}
