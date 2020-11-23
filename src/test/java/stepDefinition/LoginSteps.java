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

public class LoginSteps {
    WebDriver driver;
    HomePage homePage;

    @Given("The web-shop page is open")
    @Test
    public void the_web_shop_page_is_open() throws Throwable {
        homePage = new HomePage(driver);
        driver = homePage.navigateTo();
    }

    @Test
    @When("SIGN IN Button is pressed")
    public void sign_in_button_is_pressed() throws Throwable {
        homePage.clickOnLogInBtn();
    }

    @Test
    @Then("The authentication form appears")
    public void the_authentication_form_appears() throws Throwable {
        homePage.authenticationForm();
    }

    @Test
    @And("The user type his credentials:")
    public void the_user_filltype_his_credentials(DataTable dataTable) throws Throwable {
        List<Map<String, String>> ListOfMaps = dataTable.asMaps(String.class, String.class);
        Map<String, String> data = ListOfMaps.get(0);

        System.out.println(data.toString());

        //  send registration info to form
        homePage.authenticationFillForm(data);
    }

    @Test
    @Then("Press button with value 'SIGN IN'")
    public void click_on_button() throws Throwable {
        homePage.submitLogInForm();
    }

    @Test
    @Then("The page with successful authentication appears")
    public void the_page_with_successful_authentication_appears() throws Throwable {
        Assert.assertFalse(driver.findElement(By.xpath("//p[contains(text(), '404')]")).isDisplayed());

    }

}

