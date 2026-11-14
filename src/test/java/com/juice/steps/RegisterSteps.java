package com.juice.steps;

import com.juice.pages.BasePage;
import com.juice.pages.HomePage;
import com.juice.pages.LoginPage;
import com.juice.pages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class RegisterSteps extends BasePage {

    private final HomePage homePage = new HomePage();
    private final RegisterPage registerPage = new RegisterPage();

    @Given("User navigates to the Create an Account page")
    public void user_navigates_to_the_create_an_account_page() {
       homePage.dismissPopUp();
       homePage.goToRegister();
    }

    @When("User registers with {string}, {string}, {string}, {string} and {string}")
    public void userRegistersWithAnd(String email, String password, String repeatPassword, String securityPassword, String answer) {
        registerPage.fillOutFormDataTable(email, password, repeatPassword, securityPassword, answer);
        registerPage.clickRegisterButton();
    }

    @Then("A success message “Thank you for registering” should be displayed")
    public void a_success_message_thank_you_for_registering_should_be_displayed() {
        String message = registerPage.getRegisterMessage();
        Assert.assertEquals(message, registerPage.fullMessage);
    }



}
