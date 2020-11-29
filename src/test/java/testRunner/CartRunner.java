package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/Cart.feature", glue = {"stepDefinition"},
//        plugin = {"json:target/cucumber.json", "pretty","html:target/cucumber-reports" },
        stepNotifications = true, plugin = {"pretty", "html:target/Destinations"})
public class CartRunner {
}
