package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import poms.HomePage;


public class SearchSteps {
    WebDriver driver;
    HomePage homePage;

    @When("The web page EliteShop is opened")
    @Test
    public void the_web_page_elite_shop_is_opened() throws Throwable {
        homePage = new HomePage(driver);
        driver = homePage.navigateTo();
    }

    @Then("^Search for element \"(.*?)\"$")
    @Test
    public void search_for_element(String element) throws Throwable {
        homePage.search(element);
    }

    //check for displaying the product not for displaying 404 error
    @Then("Validate that product is returned")
    @Test
    public void appearsPageWithResultsOfSearch() {
        Assert.assertFalse(driver.findElement(By.xpath("//p[contains(text(), '404')]")).isDisplayed());

    }
}