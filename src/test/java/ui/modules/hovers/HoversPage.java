package ui.modules.hovers;

import java.util.List;
import java.util.stream.IntStream;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import ui.base.BasePage;

public class HoversPage extends BasePage {
    private static final String PAGE_TITLE = "The Internet";
    private static final String PAGE_SLUG = "/hovers";

    @FindBy(className = "figure")
    private List<WebElement> figures;

    @FindBy(css = ".figure h5")
    private List<WebElement> figureCaptions;

    public HoversPage() {
        super();
    }

    @Override
    protected String getPageTitle() {
        return PAGE_TITLE;
    }

    @Override
    protected String getPageSlug() {
        return PAGE_SLUG;
    }

    public boolean hoverOverAllFigures() {
        Actions actions = new Actions(driver);
        return IntStream.range(0, figures.size())
            .allMatch(i -> {
                actions.moveToElement(figures.get(i)).perform();
                return isCaptionCorrect(i);
            });
    }

    private boolean isCaptionCorrect(int index) {
        String expectedCaption = getBaseCaptionString(index) + (index + 1);
        String actualCaption = figureCaptions.get(index).getText();
        return expectedCaption.equals(actualCaption);
    }

    private String getBaseCaptionString(int index) {
        String caption = figureCaptions.get(index).getText();
        return caption.replaceAll("\\d+$", "");
    }
}