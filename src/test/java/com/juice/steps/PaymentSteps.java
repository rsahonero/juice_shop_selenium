package com.juice.steps;

import com.juice.pages.HomePage;
import com.juice.pages.PaymentPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class PaymentSteps {

    private final HomePage homePage = new HomePage();
    private final PaymentPage paymentPage = new PaymentPage();

    @When("User navigates to the Payment page")
    public void user_navigates_to_the_payment_page() {
        homePage.goToPayment();
    }

    @And("User registers with {string}, {string}, {string} and {string}")
    public void user_registers_with_and(String name, String cardNumber, String expiryMonth, String expiryYear) {
        paymentPage.fillOutPayment(name, cardNumber, expiryMonth, expiryYear);
        paymentPage.clickRegisterPaymentBtn();
    }
    @Then("A success message for the card ending with {string} should be displayed")
    public void a_success_message_for_the_card_ending_with_should_be_displayed(String cardNumber) {
        String lastFour = cardNumber.substring(cardNumber.length() - 4);
        String expected = "Your card ending with " + lastFour + " has been saved for your convenience.";
        Assert.assertEquals(paymentPage.getSuccessMessage(expected), expected);
    }

}
