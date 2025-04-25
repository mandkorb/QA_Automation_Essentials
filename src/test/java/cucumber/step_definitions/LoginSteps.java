package cucumber.step_definitions;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ui.modules.auth.LoginPage;
import ui.modules.auth.SecurePage;

public class LoginSteps {
  LoginPage loginPage;
  SecurePage securePage;

  @Given("User navigate to the login page")
  public void userNavigateToLoginPage() {
    loginPage = new LoginPage();
    loginPage.open();
  }

  @When("User enter valid {string} and {string}")
  public void userEnterValid(String username, String password) {
    loginPage.enterUsernameField(username);
    loginPage.enterPasswordField(password);
  }

  @When("User submit login form")
  public void userSubmitLoginForm() {
    securePage = loginPage.clickOnSubmitButton();
  }

  @Then("User should be redirected to SecurePage")
  public void userShouldBeRedirectToSecurePage() {
    assertTrue(securePage.isPageOpened());
  }
}
