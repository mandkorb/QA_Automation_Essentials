package ui.pages;

import config.Configuration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.base.BasePage;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

public class UploadPage extends BasePage {
    private static final String PAGE_TITLE = "The Internet";
    private static final String PAGE_SLUG = "/upload";
    private static final String DOWNLOAD_PAGE_SLUG = "/download";
    private File file;

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

    public void uploadFile() {
        uploadInput.sendKeys(generateFile().getAbsolutePath());
        submitButton.click();
    }

    public boolean areElementsDisplayedWhenSuccessfulUpload() {
        return areAllElementsVisible(successUploadHeader, uploadedFilePanel);
    }

    public boolean isUploadedFileNameEqualsToOriginal() {
        String uploadedFileText = uploadedFilePanel.getText();
        return file.getName().equals(uploadedFileText);
    }

    public void openDownloadPage() {
        driver.get(Configuration.getProperty("heroku.url") + DOWNLOAD_PAGE_SLUG);
    }

    public boolean isUploadedFileInTheList() {
        return driver.findElement(By.linkText(file.getName())).isDisplayed();
    }

    private File generateFile() {
        try {
            File template = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("textFileTemplate.txt")).getFile());
            if (!template.exists()) {
                throw new RuntimeException("Template file not found: " + template.getPath());
            }
            String baseName = FilenameUtils.getBaseName(template.getName());
            String extension = FilenameUtils.getExtension(template.getName());
            file = File.createTempFile(baseName + "_" + UUID.randomUUID(), "." + extension);
            FileUtils.copyFile(template, file);
            file.deleteOnExit();
            return file;
        } catch (IOException e) {
            throw new RuntimeException("Failed to generate file: " + e.getMessage(), e);
        }
    }
}
