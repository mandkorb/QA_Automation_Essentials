package ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.pages.DownloadPage;
import ui.pages.UploadPage;

import static org.testng.Assert.assertTrue;

public class DownloadTests extends BaseTest {
    private DownloadPage downloadPage;
    private UploadPage uploadPage;

    @BeforeMethod
    public void openDownloadPage() {
        downloadPage = new DownloadPage(driver);
        uploadPage = new UploadPage(driver);
    }

    @Test
    public void testDownloadToDir() {
        uploadPage.open();
        uploadPage.uploadFile();
        downloadPage.open();
        downloadPage.setFile(uploadPage.getFile());
        downloadPage.downloadFile();
        assertTrue(downloadPage.isFileDownloaded());
        assertTrue(downloadPage.deleteFileFromDownloads());
    }
}
