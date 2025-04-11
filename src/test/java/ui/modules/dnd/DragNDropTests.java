package ui.modules.dnd;

import ui.base.BaseTest;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragNDropTests extends BaseTest {
    private DragNDropPage dragNDropPage;

    @BeforeMethod
    public void openDragNDropPage() {
        dragNDropPage = new DragNDropPage();
        dragNDropPage.open();
    }

    @Test
    public void dragAndDrop() {
        assertTrue(dragNDropPage.isPageOpened());
        dragNDropPage.dragAndDrop();
        assertTrue(dragNDropPage.isDragAndDropSuccessful());
    }
}
