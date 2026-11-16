package com.juice.steps;

import com.juice.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class BasketSteps {

    private final HomePage homePage = new HomePage();
    private final BasketPage basketPage = new BasketPage();
    private final SearchProductPage searchProductPage = new SearchProductPage();
    private final CatalogPage catalogPage = new CatalogPage();

    @Given("User adds the products {string} to the basket using the search option")
    public void user_adds_the_products_to_the_basket_using_the_search_option(String products) {
        for (String product : products.split(",")) {
            searchProductPage.addProduct(product.trim());
        }
    }
    @Given("User adds {int} random products from the catalog to the basket")
    public void user_adds_random_products_from_the_catalog_to_the_basket(Integer quantity) {
        catalogPage.addRandomProducts(quantity);
    }
    @When("User navigates to the Basket page")
    public void user_navigates_to_the_basket_page() {
        homePage.goToBasket();
        basketPage.clickCheckoutBtn();
    }
    @When("User selects the address number {int}")
    public void user_selects_the_address_number(Integer addressIndex) {
        basketPage.selectAddress(addressIndex);
        basketPage.getDeliveryAddress();
    }
    @When("User selects the payment method number {int}")
    public void user_selects_the_payment_method_number(Integer paymentIndex) {
        basketPage.selectPayment(paymentIndex);
    }
    @When("User places the order")
    public void user_places_the_order() {
        basketPage.paymentOrder();
    }
    @Then("The order confirmation message {string} is displayed")
    public void the_order_confirmation_message_is_displayed(String expected) {
        Assert.assertEquals(basketPage.getSuccessMessageOrder(expected), expected);
    }
}
