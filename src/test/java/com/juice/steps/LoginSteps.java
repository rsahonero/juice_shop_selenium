package com.juice.steps;

import com.juice.utils.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps extends Base {

    @Given("User is on Login page")
    public void user_is_on_login_page() {
        driver.get(BASE_URL);
        registerPage.dismissPopUp();
    }

    @When("User enters {string} and {string} on the Login Page")
    public void user_enters_and_is_on_the_login_page(String username, String password) {
        loginPage.fillOutLogIn(username, password);
    }

    @Then("The system displays the message {string}")
    public void theSystemDisplaysTheMessage(String message) {
        Assert.assertEquals(loginPage.getDisplayedMessage(), message);
    }
}

