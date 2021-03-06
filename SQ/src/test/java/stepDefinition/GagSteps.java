package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class GagSteps {

    WebDriver driver;

    @Given("^The chrome browser is launched$")
    public void the_chrome_browser_is_launched() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "D:/CS/SQ/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @When("^The 9gag web page is opened$")
    public void the_9gag_web_page_is_opened() throws Throwable {
        driver.get("https://9gag.com/");

    }

    @Then("^Search for \"(.*?)\"$")
    public void search_for(String element) throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"top-nav\"]/div/div/div[1]/a[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"top-nav\"]/div/div/div[1]/div/form/div[1]/input")).sendKeys(element);
        driver.findElement(By.xpath("//*[@id=\"top-nav\"]/div/div/div[1]/div/form/div[1]/input")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
//        Assert.assertEquals(true, driver.findElement(By.xpath("//*[@id=\"SHORTCUT_FOCUSABLE_DIV\"]/div[2]/div/div/div/div[2]/div[1]//span[contains(text(), 'computer')]")).isDisplayed());
    }

    @Then("^Validate the header presence$")
    public void validate_the_header_presence() throws Throwable {
        boolean headerPresence = driver.findElement(By.xpath("//*[@id=\"top-nav\"]/div")).isDisplayed();
        Assert.assertEquals(true, headerPresence);
    }

    @And("^Close browser$")
    public void close_browser() throws Throwable {
        driver.quit();

    }

}
