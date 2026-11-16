package com.juice.pages;
import com.juice.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasketPage extends BasePage{

    private final By checkoutBtn = By.id("checkoutButton");
    private final By continueAddressBtn = By.cssSelector("button[aria-label='Proceed to payment selection']");
    private final By deliveryAddressCheckbox = By.xpath("(//mat-row//mat-radio-button)[1]");
    private final By continueDeliveryBtn = By.cssSelector("button[aria-label='Proceed to delivery method selection']");
    private final By continuePaymentBtn = By.cssSelector("button[aria-label='Proceed to review']");
    private final By placeOrderBtn = By.id("checkoutButton");
    private final By paymentOrderMessage = By.xpath("//h1[@class='confirmation']");

    public void clickCheckoutBtn(){
       getWait().until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
    }

    public void selectAddress(int index) {
        getWait().until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//mat-radio-button)[" + index + "]"))).click();

        $(continueAddressBtn).click();
    }

    public void getDeliveryAddress(){
        $(deliveryAddressCheckbox).click();
        $(continueDeliveryBtn).click();
    }

    public void selectPayment(int index) {
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("(//mat-radio-button)[" + index + "]"))).click();
        $(continuePaymentBtn).click();
    }

    public void paymentOrder() {
       getWait().until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
    }

    public String getSuccessMessageOrder(String expected) {
        getWait().until(ExpectedConditions.textToBePresentInElementLocated(paymentOrderMessage, expected));
        return DriverFactory.getDriver().findElement(paymentOrderMessage).getText();
    }


}
