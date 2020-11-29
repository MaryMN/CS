package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/gag.feature", glue = {"stepDefinition"},
        stepNotifications = true, //        plugin = {"json:target/cucumber.json", "pretty","html:target/cucumber-reports" },
        plugin = {"pretty", "html:target/Destination"})

public class GagRunner {
}
