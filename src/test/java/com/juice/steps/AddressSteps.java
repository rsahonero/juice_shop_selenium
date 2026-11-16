package com.juice.steps;

import com.juice.config.ConfigReader;
import com.juice.pages.AddressPage;
import com.juice.pages.HomePage;
import com.juice.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AddressSteps {

    private final HomePage homePage = new HomePage();
    private final AddressPage addressPage = new AddressPage();
    private final LoginPage loginPage = new LoginPage();

    @Given("User is logged in the system")
    public void userIsLoggedInTheSystem() {
        homePage.goToLogin();
        homePage.dismissPopUp();

        loginPage.fillOutLogIn(
                ConfigReader.getUsername(),
                ConfigReader.getPassword()
        );
        loginPage.getDisplayedMessage();
    }

    @When("User navigates to the Address page")
    public void user_navigates_to_the_address_page() {
        homePage.goToAddress();
    }

    @And("User registers with {string}, {string}, {string}, {string}, {string}, {string} and {string}")
    public void user_registers_with_and(String country, String name, String mobileNumber, String zipCode, String address, String city, String state) {
        addressPage.fillOutFormAddress(country,name,mobileNumber,zipCode,address,city,state);
        addressPage.clickRegisterAddressBtn();
    }

    @Then("A success message for the address at {string} should be displayed")
    public void a_success_message_for_the_address_at_should_be_displayed(String city) {
        String expected = "The address at " + city + " has been successfully added to your addresses.";
        Assert.assertEquals(addressPage.getAddressMessage(), expected);
    }



}
