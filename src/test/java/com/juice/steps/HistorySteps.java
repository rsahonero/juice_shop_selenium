package com.juice.steps;

import com.juice.pages.HistoryPage;
import com.juice.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HistorySteps {

    private final HomePage homePage = new HomePage();
    private final HistoryPage historyPage = new HistoryPage();

    @When("User navigates to the Order History page")
    public void user_navigates_to_the_order_history_page() {
        homePage.goToHistory();
    }

    @Then("The order history shows {int} orders")
    public void the_order_history_shows_orders(Integer expected) {
        Assert.assertTrue(historyPage.getOrdersCount() >= expected);
    }
    @Then("User takes a screenshot of the orders")
    public void user_takes_a_screenshot_of_the_orders() {
        historyPage.takeScreenshot("order-history");
    }

}
