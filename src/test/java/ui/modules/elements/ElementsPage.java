package ui.modules.elements;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.base.BasePage;

public class ElementsPage extends BasePage {
  private static final String PAGE_SLUG = "/add_remove_elements/";
  private static final String PAGE_TITLE = "The Internet";

  @FindBy(css = "[onclick='addElement()']")
  private WebElement addElementButton;

  @FindBy(css = ".added-manually[onclick=\"deleteElement()\"]")
  private List<WebElement> deleteElementButtons;

  @Override
  protected String getPageSlug() {
    return PAGE_SLUG;
  }

  @Override
  protected String getPageTitle() {
    return PAGE_TITLE;
  }

  public void clickAddElementButton() {
    addElementButton.click();
  }

  public void clickAddElementButtonMultipleTimes(int times) {
    for (int i = 0; i < times; i++) {
      addElementButton.click();
    }
  }

  public void clickDeleteFirstElementButton() {
    deleteElementButtons.get(0).click();
  }

  public void clickDeleteAllElementButtons() {
    deleteElementButtons.forEach(WebElement::click);
  }

  public int getElementsCount() {
    return deleteElementButtons.size();
  }
}
