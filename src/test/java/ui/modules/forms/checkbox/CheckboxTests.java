package ui.modules.forms.checkbox;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.base.BaseTest;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckboxTests extends BaseTest {
    private CheckboxPage checkboxPage;

    @BeforeClass
    public void setup() {
        checkboxPage = new CheckboxPage();
        checkboxPage.open();
        assertTrue(checkboxPage.isPageOpened());
    }

    @Test
    public void defaultValues() {
        assertTrue(checkboxPage.isChecked());
        assertTrue(checkboxPage.isUnchecked());
    }

    @Test
    public void selectCheckboxes() {
        assertTrue(checkboxPage.isChecked());
        checkboxPage.selectCheckbox();
        assertFalse(checkboxPage.isChecked());
    }
}
