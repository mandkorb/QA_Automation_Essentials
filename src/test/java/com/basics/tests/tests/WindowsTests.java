package com.basics.tests.tests;

import com.basics.tests.base.BaseTest;
import com.basics.tests.pages.WindowsPage;
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
