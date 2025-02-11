package com.basics.tests.patterns.page_object_model.tests;

import com.basics.tests.patterns.page_object_model.base.BaseTest;
import com.basics.tests.patterns.page_object_model.pages.WindowsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsTests extends BaseTest {
    private WindowsPage windowsPage;

    @BeforeMethod
    public void openFramesPage() {
        windowsPage = new WindowsPage(driver);
        windowsPage.open();
    }

    @Test
    public void checkNewWindowContent() {
        windowsPage.openNewWindow();
        windowsPage.switchToWindow(WindowsPage.Windows.NEW);
        Assert.assertTrue(windowsPage.isNewWindowOpened());
        Assert.assertTrue(windowsPage.isNewWindowContentCorrect());
        windowsPage.closeNewWindow();
        windowsPage.switchToWindow(WindowsPage.Windows.DEFAULT);
        windowsPage.atPage();
    }
}
