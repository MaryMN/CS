package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GoogleSteps {
    public static final String USERNAME = "mariamunteanu1";
    public static final String AUTOMATE_KEY = "k1mfpX7q4uhCMFXa6RNi";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    private final By searchField = By.xpath("//input[@name='q']");
    private final By first = By.xpath("//*[@id='topstuff']/div/div");
    private final By second = By.xpath("//*[@id='tsf']/div[2]/div[1]/div[2]/div/div[2]/input");
    WebDriver driver;
    
    @Given("The browser is launched")
    public void the_browser_is_launched() throws Throwable {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "80");

        caps.setCapability("build", "Cucumber-Tests"); // CI/CD job or build name
        driver = new RemoteWebDriver(new URL(URL), caps);
    }

    @When("The google web page is opened")
    public void the_google_web_page_is_opened() throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
    }

    @Then("^Search for the \"(.*?)\"$")
    public void search_for_the(String element) throws Throwable {
        WebElement search = driver.findElement(searchField);
        search.sendKeys(element);
        search.submit();

        String results = driver.getTitle().trim();
    }

    @Then("^Validate the result is displayed as \"(.*?)\"$")
    public void validate_the_result_is_displayed(String expected) throws Throwable {
        WebElement frst = driver.findElement(first);
        WebElement scnd = driver.findElement(second);

        if (expected.equals("not_match")) {
            Assert.assertTrue(frst.isDisplayed());
        } else if (expected.equals("similar")) {
            Assert.assertTrue(scnd.isDisplayed());
        }
        driver.quit();
    }
}
