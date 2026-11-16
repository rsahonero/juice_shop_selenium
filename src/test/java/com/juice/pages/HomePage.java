package com.juice.pages;

import com.juice.driver.DriverFactory;
import com.juice.driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private static final By dismissBtn = By.xpath("//span[contains(text(),'Dismiss')]");

    public void dismissPopUp() {
        WebElement btn = getWait().until(ExpectedConditions.presenceOfElementLocated(dismissBtn));
        try {
            getWait().until(ExpectedConditions.elementToBeClickable(btn)).click();
        } catch (ElementClickInterceptedException | TimeoutException e) {
            ((JavascriptExecutor) DriverFactory.getDriver())
                    .executeScript("arguments[0].click();", btn);
        }
    }


    public void goToRegister() {
        DriverManager.getDriver().get(getBaseUrl() + "/register");
    }
    public void goToAddress() {
        DriverManager.getDriver().get(getBaseUrl() + "/address/saved");
    }

    public void goToLogin() {
        DriverManager.getDriver().get(getBaseUrl() + "/login");
    }
    public void goToPayment() {
        DriverManager.getDriver().get(getBaseUrl() + "/saved-payment-methods ");
    }
    public void goToBasket(){
        DriverManager.getDriver().get(getBaseUrl() + "/basket");
    }
    public void goToHistory(){
        DriverManager.getDriver().get(getBaseUrl() + "/order-history");
    }


}
