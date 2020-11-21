package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import poms.HomePage;

public class CartSteps {
    WebDriver driver;
    HomePage homePage;

    @When("The web page is opened")
    @Test
    public void the_web_page_is_opened() throws Throwable {
        homePage = new HomePage(driver);
        driver = homePage.navigateTo();
    }

    @Then("^Choose a product")
    @Test
    public void choose_a_product() throws Throwable {
        homePage.chooseItem();
    }

    @And("Click Add to Cart Button")
    @Test
    public void click_add_to_cart_button() {
        homePage.clickOnAddToCartBtn();

    }

    @Then("Validate that product appears on cart")
    @Test
    public void the_product_appears_on_cart() throws Throwable {
        homePage.cartAppears();
        homePage.itemAddedToCart();

        //Assert.assertEquals(0, driver.findElements(By.xpath("//p[contains(text(), '404')]")).size());
    }

}