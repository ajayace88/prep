package features;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Aj on 18-01-2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "E:\\AjayData\\Repository\\Prep\\src\\test\\resources\\features",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/cucumber"}
)
public class TestRunner {
}
