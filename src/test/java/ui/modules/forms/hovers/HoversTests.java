package ui.modules.forms.hovers;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ui.base.BaseTest;

public class HoversTests extends BaseTest {
    HoversPage hoversPage;

    @BeforeMethod
    public void setUp() {
        hoversPage = new HoversPage();
        hoversPage.open();
    }

    @Test
    public void testHover() {
        assertTrue(hoversPage.isPageOpened());
        assertTrue(hoversPage.hoverOverAllFigures());
    }
}
