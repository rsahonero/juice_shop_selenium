package com.juice.steps;

import com.juice.utils.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class RegisterSteps extends Base {

    @Given("User navigates to the Create an Account page")
    public void user_navigates_to_the_create_an_account_page() {
       driver.get(BASE_URL);
       registerPage.dismissPopUp();
    }

    @When("User completes the registration form with valid information")
    public void user_completes_the_registration_form_with_valid_information() {
        //registerPage.fillOutRegisterForm();
        registerPage.fillOutRegisterFakeForm();
    }

    @When("The user account should be created successfully")
    public void the_user_account_should_be_created_successfully() {
        registerPage.clickRegisterButton();

    }
    @Then("A success message “Thank you for registering” should be displayed")
    public void a_success_message_thank_you_for_registering_should_be_displayed() {
        String message = registerPage.getRegisterMessage();
        Assert.assertEquals(message, registerPage.fullMessage);
    }


}
