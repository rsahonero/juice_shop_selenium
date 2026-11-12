package com.juice.steps;

import com.juice.utils.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps extends Base {

    @Given("User is on the Home Page")
    public void userIsOnTheHomePage() {
        driver.get(BASE_URL);
    }
    @When("User navigates to the Login page")
    public void userNavigatesToTheLoginPage() {
        registerPage.dismissPopUp();
        homePage.goToSingIn();
    }

    @And("User enters {string} and {string} on the Login Page")
    public void user_enters_and_is_on_the_login_page(String username, String password) {
        loginPage.fillOutLogIn(username, password);
    }

    @Then("The system displays the message {string}")
    public void theSystemDisplaysTheMessage(String message) {
        Assert.assertEquals(loginPage.getDisplayedMessage(), message);
    }


}

