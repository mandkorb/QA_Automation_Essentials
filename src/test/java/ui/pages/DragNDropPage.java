package ui.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import ui.base.BasePage;

public class DragNDropPage extends BasePage {
    private static final String PAGE_TITLE = "The Internet";
    private static final String PAGE_SLUG = "/drag_and_drop";

    @FindBy(id = "column-a")
    private WebElement columnA;

    @FindBy(id = "column-b")
    private WebElement columnB;

    @FindBy(xpath = "//div[@id='column-a']/header")
    private WebElement columnAHeader;

    @FindBy(xpath = "//div[@id='column-b']/header")
    private WebElement columnBHeader;

    public DragNDropPage(WebDriver driver) {
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

    public void dragAndDrop() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(columnA, columnB).perform();
    }

    public boolean isDragAndDropSuccessful() {
        areAllElementsVisible(columnAHeader, columnBHeader);
        String headerA = columnAHeader.getText();
        String headerB = columnBHeader.getText();
        return headerA.equals(columnAHeader.getText()) && headerB.equals(columnBHeader.getText());
    }
}
