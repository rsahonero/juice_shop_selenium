package com.juice.pages;

import com.juice.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Base {

    By createAccountLink = By.linkText("Create an Account");
    By SingLink = By.linkText("Sign In");


    public HomePage(WebDriver driver){
        Base.driver = driver;
    }
    public void goToRegister() {
        driver.findElement(createAccountLink).click();
    }

    public void goToSingIn(){
        driver.findElement(SingLink).click();
    }
}
