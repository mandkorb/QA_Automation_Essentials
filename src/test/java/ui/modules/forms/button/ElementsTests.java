package ui.modules.forms.button;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.base.BaseTest;

public class ElementsTests extends BaseTest {
  private ElementsPage elementsPage;
  private static final int ADDITIONAL_ELEMENTS_COUNT = 5;

  @BeforeMethod
  public void openElementsPage() {
    elementsPage = new ElementsPage();
    elementsPage.open();
    assertTrue(elementsPage.isPageOpened());
    assertEquals(elementsPage.getElementsCount(), 0);
  }

  @Test
  public void addAndDeleteSingleElement() {
    elementsPage.clickAddElementButton();
    assertEquals(elementsPage.getElementsCount(), 1);
    elementsPage.clickDeleteFirstElementButton();
    assertEquals(elementsPage.getElementsCount(), 0);
  }

  @Test
  public void addAndDeleteMultipleElements() {
    elementsPage.clickAddElementButtonMultipleTimes(ADDITIONAL_ELEMENTS_COUNT);
    assertEquals(elementsPage.getElementsCount(), ADDITIONAL_ELEMENTS_COUNT);
    elementsPage.clickDeleteAllElementButtons();
    assertEquals(elementsPage.getElementsCount(), 0);
  }
}
