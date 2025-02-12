package com.basics.tests.pages;

import com.basics.tests.base.BasePage;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage extends BasePage {
    private static final String PAGE_TITLE = "The Internet";
    private static final String PAGE_SLUG = "/nested_frames";
    private final By frameContentLocator = By.tagName("body");

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String getPageSlug() {
        return PAGE_SLUG;
    }

    public void switchToFrame(Frames frame) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(frame.getPlacement());
        if (!frame.getName().isEmpty()) {
            driver.switchTo().frame(frame.getName());
        }
    }

    public String getFrameContent() {
        return driver.findElement(frameContentLocator).getText().trim();
    }

    @Getter
    public enum Frames {
        LEFT("frame-top", "frame-left", "LEFT"),
        MIDDLE("frame-top", "frame-middle", "MIDDLE"),
        RIGHT("frame-top", "frame-right", "RIGHT"),
        BOTTOM("frame-bottom", "", "BOTTOM");

        private final String placement;
        private final String name;
        private final String content;

        Frames(String placement, String name, String content) {
            this.placement = placement;
            this.name = name;
            this.content = content;
        }
    }
}
