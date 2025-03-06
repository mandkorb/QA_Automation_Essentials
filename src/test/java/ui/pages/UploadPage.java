package ui.pages;

import config.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.base.BasePage;
import ui.base.TestFile;


public class UploadPage extends BasePage {
    private static final String PAGE_TITLE = "The Internet";
    private static final String PAGE_SLUG = "/upload";
    private static final String DOWNLOAD_PAGE_SLUG = "/download";
    private TestFile file;

    @FindBy(id = "file-upload")
    private WebElement uploadInput;

    @FindBy(id = "file-submit")
    private WebElement submitButton;

    @FindBy(xpath = "//h3[text()='File Uploaded!']")
    private WebElement successUploadHeader;

    @FindBy(id = "uploaded-files")
    private WebElement uploadedFilePanel;

    public UploadPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String getPageSlug() {
        return PAGE_SLUG;
    }

    public void uploadFile(TestFile file) {
        this.file = file;
        uploadInput.sendKeys(file.getFile().getAbsolutePath());
        submitButton.click();
    }

    public boolean areElementsDisplayedWhenSuccessfulUpload() {
        return areAllElementsVisible(successUploadHeader, uploadedFilePanel);
    }

    public boolean isUploadedFileNameEqualsToOriginal() {
        String uploadedFileText = uploadedFilePanel.getText();
        return file.getFile().getName().equals(uploadedFileText);
    }

    public void openDownloadPage() {
        driver.get(Configuration.getProperty("heroku.url") + DOWNLOAD_PAGE_SLUG);
    }

    public boolean isUploadedFileInTheList() {
        return driver.findElement(By.linkText(file.getFile().getName())).isDisplayed();
    }
}
