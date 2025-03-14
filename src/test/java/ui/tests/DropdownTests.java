package ui.tests;

import ui.base.BaseTest;
import ui.pages.DropdownPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTests extends BaseTest {
    private DropdownPage dropdownPage;
    private static final String FIRST_OPTION_TEXT = "Option 1";
    private static final String SECOND_OPTION_TEXT = "Option 2";

    @BeforeMethod
    public void openDropdownPage() {
        dropdownPage = new DropdownPage();
        dropdownPage.open();
    }

    @Test
    public void changeDropdownOptions() {
        dropdownPage.selectOptionByIndex(1);
        Assert.assertEquals(dropdownPage.getCurrentOptionText(), FIRST_OPTION_TEXT);

        dropdownPage.selectOptionByValue("2");
        Assert.assertEquals(dropdownPage.getCurrentOptionText(), SECOND_OPTION_TEXT);
    }
}
