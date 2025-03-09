package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.base.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

public class FramesPage extends BasePage {
    private static final String PAGE_TITLE = "The Internet";
    private static final String PAGE_SLUG = "/nested_frames";

    @FindBy(tagName = "body")
    private WebElement frameContentLocator;

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String getPageSlug() {
        return PAGE_SLUG;
    }

    @Override
    protected String getPageTitle() {
        return PAGE_TITLE;
    }

    public void switchToFrame(Frames frame) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(frame.getPlacement());
        if (!frame.getName().isEmpty()) {
            driver.switchTo().frame(frame.getName());
        }
    }

    public String getFrameContent() {
        return frameContentLocator.getText().trim();
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
