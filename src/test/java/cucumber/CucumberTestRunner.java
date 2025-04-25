package cucumber;

import config.WebDriverHolder;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions (
    features = "src/test/resources/features",
    glue = {"cucumber.step_definitions"},
    plugin = {"pretty", "html:target/cucumber-reports"}
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
  @BeforeClass(alwaysRun = true)
  public void setUp() {
    WebDriverHolder.initDriver();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() {
    WebDriverHolder.quitDriver();
  }

}
