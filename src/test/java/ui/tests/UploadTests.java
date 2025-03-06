package ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.base.TestFile;
import ui.pages.UploadPage;

import static org.testng.Assert.assertTrue;

public class UploadTests extends BaseTest {
    private UploadPage uploadPage;
    private TestFile testFile;

    @BeforeMethod
    public void openUploadPage() {
        uploadPage = new UploadPage(driver);
        uploadPage.open();
        testFile = new TestFile();
    }

    @Test
    public void successfulFileUpload() {
        uploadPage.uploadFile(testFile);
        assertTrue(uploadPage.areElementsDisplayedWhenSuccessfulUpload());
        assertTrue(uploadPage.isUploadedFileNameEqualsToOriginal());
        uploadPage.openDownloadPage();
        assertTrue(uploadPage.isUploadedFileInTheList());
    }
}
