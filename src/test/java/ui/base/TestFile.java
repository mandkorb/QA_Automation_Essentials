package ui.base;

import lombok.Getter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

import static ui.base.BaseTest.DOWNLOAD_DIR;

@Getter
public class TestFile {
    private final File file;

    public TestFile() {
        this.file = generateFile();
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
            return file;
        } catch (IOException e) {
            throw new RuntimeException("Failed to generate file: " + e.getMessage(), e);
        }
    }

    public boolean deleteFilesFromDir() {
        File[] files = DOWNLOAD_DIR.listFiles();
        try {
            Arrays.stream(Objects.requireNonNull(files))
                    .forEach(File::delete);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
