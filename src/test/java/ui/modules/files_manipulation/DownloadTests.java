package ui.modules.files_manipulation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.base.TestFile;

import static org.testng.Assert.assertTrue;

public class DownloadTests extends BaseTest {
    private DownloadPage downloadPage;
    private UploadPage uploadPage;
    private TestFile testFile;

    @BeforeMethod
    public void setup() {
        downloadPage = new DownloadPage();
        uploadPage = new UploadPage();
        testFile = new TestFile();
    }

    @Test
    public void testDownloadToDir() {
        uploadPage.open();
        uploadPage.uploadFile(testFile);
        downloadPage.open();
        downloadPage.downloadFile(testFile);
        assertTrue(downloadPage.isFileDownloaded());
        assertTrue(downloadPage.deleteFileFromDownloads());
    }
}
