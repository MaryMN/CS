package stepDefinition;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import poms.HomePage;

import java.util.List;
import java.util.Map;

public class RegistrationSteps {
    WebDriver driver;
    HomePage homePage;

    @Given("The EliteShop web page is opened")
    @Test
    public void the_elite_shop_web_page_is_opened() throws Throwable {
        homePage = new HomePage(driver);
        driver = homePage.navigateTo();
    }

    @Test
    @When("SIGN UP Button is pressed")
    public void sign_up_button_is_pressed() throws Throwable {
        //Assert.assertNotNull(homePage.clickOnSignUpBtn());
        homePage.clickOnSignUpBtn();

        //throw new io.cucumber.java.PendingException();
    }

    @Test
    @Then("The registration form appears")
    public void the_registration_form_appears() throws Throwable {
        homePage.registrationForm();
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @Test
    @Then("The user fill the form by type name, email, password and confirm password field:")
    public void the_user_fill_the_form_by_type_name_email_password_and_confirm_password_field(DataTable dataTable) throws Throwable {
        List<Map<String, String>> ListOfMaps = dataTable.asMaps(String.class, String.class);
        Map<String, String> data = ListOfMaps.get(0);

        System.out.println(data.toString());

        //  send registration info to form
        homePage.registrationFillForm(data);
    }

    @Test
    @Then("Click on SIGN UP button")
    public void click_on_button() throws Throwable {
        homePage.submitRegForm();
    }

    @Test
    @And("The page with successful registration appears")
    public void the_page_with_successful_registration_appears() throws Throwable {
        Assert.assertFalse(driver.findElement(By.xpath("//p[contains(text(), '404')]")).isDisplayed());
    }
}

