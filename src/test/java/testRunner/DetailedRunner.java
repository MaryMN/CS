package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/Detailed.feature", glue = {"stepDefinition"},
        stepNotifications = true)

public class DetailedRunner {
}
