package com.juice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.latest.audits.model.PropertyRuleIssueDetails;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private static final By dismissBtn = By.xpath("//span[contains(text(),'Dismiss')]");
    private static final By accountLink = By.id("navbarAccount");
    private static final By singLink = By.id("navbarLoginButton");
    private static final By registerLink = By.linkText("Not yet a customer?");


    public void dismissPopUp() {
        getWait().until(ExpectedConditions.elementToBeClickable(dismissBtn)).click();
    }

    public void goToSingIn(){
        getWait().until(ExpectedConditions.elementToBeClickable(accountLink)).click();
        getWait().until(ExpectedConditions.elementToBeClickable(singLink)).click();
    }
    public void goToRegister() {
        getWait().until(ExpectedConditions.elementToBeClickable(accountLink)).click();
        getWait().until(ExpectedConditions.elementToBeClickable(singLink)).click();
        getWait().until(ExpectedConditions.elementToBeClickable(registerLink)).click();
    }


}
