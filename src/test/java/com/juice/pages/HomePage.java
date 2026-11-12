package com.juice.pages;

import com.juice.utils.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Base {

    @FindBy (id = "navbarAccount")
    protected WebElement accountLink;

    @FindBy (id = "navbarLoginButton")
    protected WebElement singLink;

    @FindBy (linkText = "Not yet a customer?")
    protected WebElement registerLink;


    public HomePage(WebDriver driver){
        Base.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void goToSingIn(){
        accountLink.click();
        singLink.click();
    }
    public void goToRegister() {
        accountLink.click();
        singLink.click();
        registerLink.click();
    }


}
