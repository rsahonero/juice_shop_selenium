package com.juice.steps;

import com.juice.pages.HomePage;
import com.juice.pages.LoginPage;
import com.juice.pages.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps extends BasePage {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

    @Given("User navigates to the Login page")
    public void userNavigatesToTheLoginPage() {
        homePage.goToLogin();
        homePage.dismissPopUp();
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

