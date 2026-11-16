package com.juice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddressPage extends BasePage{

    private static final By addNewAddressBtn = By.cssSelector("button[aria-label='Add a new address']");
    private static final By countryTextBox = By.xpath("//input[@placeholder='Please provide a country.']");
    private static final By nameAddressTextBox = By.xpath("//input[@placeholder='Please provide a name.']");
    private static final By mobileNumberTextBox = By.xpath("//input[@placeholder='Please provide a mobile number.']");
    private static final By zipCodeTextBox = By.xpath("//input[@placeholder='Please provide a ZIP code.']");
    private static final By addressTextBox = By.xpath("//textarea[@placeholder='Please provide an address.']");
    private static final By cityTextBox = By.xpath("//input[@placeholder='Please provide a city.']");
    private static final By stateTextBox = By.xpath("//input[@placeholder='Please provide a state.']");
    private static final By saveAddressBtn = By.id("submitButton");
    private static final By successMessage = By.xpath("//div[@class='mat-mdc-snack-bar-label mdc-snackbar__label']");


    public void fillOutFormAddress(String country, String name, String mobileNumber, String zipCode, String address, String city, String state){
        $(addNewAddressBtn).click();
        $(countryTextBox).sendKeys(country);
        $(nameAddressTextBox).sendKeys(name);
        $(mobileNumberTextBox).sendKeys(mobileNumber);
        $(zipCodeTextBox).sendKeys(zipCode);
        $(addressTextBox).sendKeys(address);
        $(cityTextBox).sendKeys(city);
        $(stateTextBox).sendKeys(state);
    }
    public void clickRegisterAddressBtn() {
        $(saveAddressBtn).click();
    }

    public String getAddressMessage() {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
    }

}
