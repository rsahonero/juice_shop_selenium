package com.juice.pages;

import com.juice.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentPage extends BasePage{

    private static final By expandAddNewCard = By.id("mat-expansion-panel-header-0");
    private static final By nameCardTextBox = By.xpath("//mat-label[normalize-space()='Name']/ancestor::mat-form-field//input");
    private static final By cardNumberTextBox = By.xpath("//mat-label[normalize-space()='Card Number']/ancestor::mat-form-field//input");
    private static final By expiryMonthDpw = By.xpath("//mat-label[contains(text(),'Expiry Month')]");
    private static final By expiryYearDpw = By.xpath("//mat-label[contains(text(),'Expiry Year')]");
    private static final By submitPaymentBtn = By.id("submitButton");
    private static final By successMessage = By.xpath("//div[@class='mat-mdc-snack-bar-label mdc-snackbar__label']");


    public void fillOutPayment(String name, String cardNumber, String expiryMonth, String expiryYear) {
        getWait().until(ExpectedConditions.elementToBeClickable(expandAddNewCard)).click();

        $(nameCardTextBox).sendKeys(name);
        $(cardNumberTextBox).sendKeys(cardNumber);
        $(expiryMonthDpw).click();
        By expiryMonthOption = By.xpath("//option[@value='"+ expiryMonth +"']"); //DROP DOWN
        getWait().until(ExpectedConditions.elementToBeClickable(expiryMonthOption)).click();

        $(expiryYearDpw).click();
        By expiryYearOption = By.xpath("//option[@value='"+ expiryYear +"']"); //DROP DOWN
        getWait().until(ExpectedConditions.elementToBeClickable(expiryYearOption)).click();
    }

    public void clickRegisterPaymentBtn() {
        $(submitPaymentBtn).click();
    }

    public String getSuccessMessage(String expected) {
        getWait().until(ExpectedConditions.textToBePresentInElementLocated(successMessage, expected));
        return DriverFactory.getDriver().findElement(successMessage).getText();
    }

}
