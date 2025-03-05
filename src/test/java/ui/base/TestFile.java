package ui.base;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import ui.pages.UploadPage;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

public class TestFile {
    private final File file;

    public TestFile() {
        this.file = generateFile();
    }

    public File getFile() {
        return file;
    }

    private File generateFile() {
        try {
            File template = new File(Objects.requireNonNull(TestFile.class.getClassLoader().getResource("textFileTemplate.txt")).getFile());
            if (!template.exists()) {
                throw new RuntimeException("Template file not found: " + template.getPath());
            }
            String baseName = FilenameUtils.getBaseName(template.getName());
            String extension = FilenameUtils.getExtension(template.getName());
            File file = new File(BaseTest.DOWNLOAD_DIR_PATH, baseName + "_" + UUID.randomUUID() + "." + extension);
            FileUtils.copyFile(template, file);
            return file; // Видалили deleteOnExit()
        } catch (IOException e) {
            throw new RuntimeException("Failed to generate file: " + e.getMessage(), e);
        }
    }
}
