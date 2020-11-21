package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/Registration.feature",
        glue = {"stepDefinition"},
        stepNotifications = true)
public class RegistrationRunner {
}

