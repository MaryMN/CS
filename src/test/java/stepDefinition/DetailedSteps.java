package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import poms.HomePage;

public class DetailedSteps {
    WebDriver driver;
    HomePage homePage;
    String expectedName;

    @When("The main page is opened")
    @Test
    public void the_main_page_is_opened() throws Throwable {
        homePage = new HomePage(driver);
        driver = homePage.navigateTo();
    }

    @Then("^Choose a product from list")
    @Test
    public void choose_a_product_from_list() throws Throwable {
        homePage.chooseItem();
        expectedName = homePage.getItemName();
    }

    @And("Click Quick View Button")
    @Test
    public void click_quick_view_button() {
        homePage.clickQuickViewBtn();

    }

    @Then("Validate that page with details about product appears")
    @Test
    public void the_page_with_details_of_product_appears() throws Throwable {
        Assert.assertEquals(expectedName, homePage.getReturnedItem());
    }

}