package com.basics.tests.patterns.page_object_model.tests;

import com.basics.tests.patterns.page_object_model.base.BaseTest;
import com.basics.tests.patterns.page_object_model.pages.DropdownPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTests extends BaseTest {
    private DropdownPage dropdownPage;

    @BeforeMethod
    public void openDropdownPage() {
        dropdownPage = new DropdownPage(driver);
        dropdownPage.open();
    }

    @Test
    public void changeDropdownOptions() {
        dropdownPage.selectOptionByIndex(1);
        Assert.assertEquals(dropdownPage.getCurrentOptionText(), DropdownPage.FIRST_OPTION_TEXT);

        dropdownPage.selectOptionByValue("2");
        Assert.assertEquals(dropdownPage.getCurrentOptionText(), DropdownPage.SECOND_OPTION_TEXT);
    }
}
