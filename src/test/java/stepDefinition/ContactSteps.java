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
import poms.ContactPage;

import java.util.List;
import java.util.Map;

public class ContactSteps {
    WebDriver driver;
    ContactPage contactPage;

    @Given("Contact web page is opened")
    @Test
    public void contact_web_page_is_opened() throws Throwable {
        contactPage = new ContactPage(driver);
        driver = contactPage.navigateToContactPage();
    }

    @Then("The Contact form is displayed")
    @Test
    public void the_contact_form_is_displayed() throws Throwable {
        contactPage.contactFormIsDisplayed();
    }

    @When("User fill the contact form:")
    @Test
    public void user_fill_the_contact_form(DataTable dataTable) throws Throwable {
        List<Map<String, String>> ListOfMaps = dataTable.asMaps(String.class, String.class);
        Map<String, String> data = ListOfMaps.get(0);

        System.out.println(data.toString());
        contactPage.contactFillForm(data);
    }

    @And("The SEND button is pressed")
    @Test
    public void the_send_button_is_pressed() throws Throwable {
        contactPage.sendButtonIsPressed();
    }

    @Test
    @Then("Validate that contact form is send succesfully")
    public void the_page_with_successful_send_contact_form_appears() throws Throwable {
        Assert.assertFalse(driver.findElement(By.xpath("//p[contains(text(), '404')]")).isDisplayed());
    }
}