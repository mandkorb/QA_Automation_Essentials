package ui.tests;

import ui.base.BaseTest;
import ui.pages.FramesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FramesTests extends BaseTest {
    private FramesPage framesPage;

    @BeforeMethod
    public void openFramesPage() {
        framesPage = new FramesPage(driver);
        framesPage.open();
    }

    @Test(dataProvider = "frameData")
    public void checkFramesContent(FramesPage.Frames frame, String expectedContent) {
        framesPage.switchToFrame(frame);
        assertEquals(framesPage.getFrameContent(), expectedContent);
    }

    @DataProvider(name = "frameData")
    public Object[][] provideFramesContent() {
        return new Object[][]{
                {FramesPage.Frames.LEFT, FramesPage.Frames.LEFT.getContent()},
                {FramesPage.Frames.MIDDLE, FramesPage.Frames.MIDDLE.getContent()},
                {FramesPage.Frames.RIGHT, FramesPage.Frames.RIGHT.getContent()},
                {FramesPage.Frames.BOTTOM, FramesPage.Frames.BOTTOM.getContent()},
        };
    }
}
