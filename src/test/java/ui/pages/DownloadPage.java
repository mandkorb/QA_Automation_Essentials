package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.base.BasePage;
import ui.base.TestFile;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class DownloadPage extends BasePage {
    private static final String PAGE_TITLE = "The Internet";
    private static final String PAGE_SLUG = "/download";
    private TestFile file;

    @FindBy(xpath = "//h3[text()='File Downloader']")
    private WebElement header;

    public DownloadPage() {
        super();
    }

    @Override
    protected String getPageSlug() {
        return PAGE_SLUG;
    }

    @Override
    protected String getPageTitle() {
        return PAGE_TITLE;
    }

    public void downloadFile(TestFile file) {
        this.file = file;
        wait.until(elementToBeClickable(By.linkText(file.getFile().getName()))).click();
    }

    public boolean isFileDownloaded() {
        try {
            return file.getFile().exists();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean deleteFileFromDownloads() {
        return file.deleteFilesFromDir();
    }
}
