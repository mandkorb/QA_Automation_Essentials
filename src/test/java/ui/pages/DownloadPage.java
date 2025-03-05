package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.base.BasePage;
import ui.base.BaseTest;

import java.io.File;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class DownloadPage extends BasePage {
    private static final String PAGE_TITLE = "The Internet";
    private static final String PAGE_SLUG = "/download";
    private File file;

    @FindBy(xpath = "//h3[text()='File Downloader']")
    private WebElement header;

    public DownloadPage(WebDriver driver) {
        super(driver);
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    protected String getPageSlug() {
        return PAGE_SLUG;
    }

    public void downloadFile() {
        wait.until(elementToBeClickable(By.linkText(file.getName()))).click();
    }

    public boolean isFileDownloaded() {
        try {
            return file.exists();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean deleteFileFromDownloads() {
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }
}
