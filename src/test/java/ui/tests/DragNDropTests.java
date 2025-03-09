package ui.tests;

import ui.base.BaseTest;
import ui.pages.DragNDropPage;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragNDropTests extends BaseTest {
    private DragNDropPage dragNDropPage;

    @BeforeMethod
    public void openDragNDropPage() {
        dragNDropPage = new DragNDropPage(driver);
        dragNDropPage.open();
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        assertTrue(dragNDropPage.isPageOpened());
        dragNDropPage.dragAndDrop();
        assertTrue(dragNDropPage.isDragAndDropSuccessful());
    }
}
