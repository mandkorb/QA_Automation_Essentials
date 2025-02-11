package com.basics.tests.patterns.page_object_model.pages;

import com.basics.tests.patterns.page_object_model.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {
    private static final String PAGE_TITLE = "The Internet";
    private static final String PAGE_SLUG = "/dropdown";
    private final By dropdown = By.id("dropdown");
    public static final String FIRST_OPTION_TEXT = "Option 1";
    public static final String SECOND_OPTION_TEXT = "Option 2";

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String getPageSlug() {
        return PAGE_SLUG;
    }

    private Select getDropdown() {
        return new Select(driver.findElement(dropdown));
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
