package ui.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ui.base.BaseTest;
import ui.pages.HoversPage;

public class HoversTests extends BaseTest {
    HoversPage hoversPage;

    @BeforeMethod
    public void setUp() {
        hoversPage = new HoversPage(driver);
        hoversPage.open();
    }

    @Test
    public void testHover() {
        assertTrue(hoversPage.isPageOpened());
        assertTrue(hoversPage.hoverOverAllFigures());
    }
}
