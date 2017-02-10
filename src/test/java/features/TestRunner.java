package features;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Aj on 18-01-2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features/googleSearch.feature",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-html-reports"}
)
public class TestRunner {
}
