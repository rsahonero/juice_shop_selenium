package com.juice.pages;

import com.juice.utils.Base;
import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends Base {

    /**
     * locators
     */


    protected By dismissBtn = By.xpath("//span[contains(text(),'Dismiss')]");
    protected By emailTextBox = By.id("emailControl");
    protected By passwordTextBox = By.id("passwordControl");
    protected By repeatPasswordTextBox = By.id("repeatPasswordControl");
    protected By dropDownSecurityQ =  By.id("securityQuestionControl");
    //protected By optionSecurityQ = By.xpath("//span[contains(text(),' Name of your favorite pet? ')]");
    protected By optionSecurityQ = By.xpath("//span[contains(text(),\" Mother's maiden name? \")]");
    protected By answerSecurityQ = By.id("securityAnswerControl");
    protected By registerBtn = By.id("registerButton");
    //protected By successMessage = By.xpath("//div[contains(text(),' Registration completed successfully. You can now log in.')]");
    protected By successMessage = By.cssSelector("div.mdc-snackbar__label");
    public String fullMessage = "Registration completed successfully. You can now log in.";

    public RegisterPage(WebDriver driver) {
        Base.driver = driver;
    }
    public void dismissPopUp() {
        driver.findElement(dismissBtn).click();
    }

    public void fillOutRegisterForm() {
        driver.findElement(emailTextBox).sendKeys("tayloruser13@user.com");
        driver.findElement(passwordTextBox).sendKeys("Password1!");
        driver.findElement(repeatPasswordTextBox).sendKeys("Password1!");
        driver.findElement(dropDownSecurityQ).click();
        driver.findElement(optionSecurityQ).click();
        driver.findElement(answerSecurityQ).sendKeys("Lulu");
    }
    public void fillOutRegisterFakeForm() {
        Faker faker = new Faker();
        String generatepassword = faker.regexify("[A-Z][a-z]{5}[0-9]{2}[@#$%!]");

        driver.findElement(emailTextBox).sendKeys(faker.internet().emailAddress());
        driver.findElement(passwordTextBox).sendKeys(generatepassword);
        driver.findElement(repeatPasswordTextBox).sendKeys(generatepassword);
        driver.findElement(dropDownSecurityQ).click();
        driver.findElement(optionSecurityQ).click();
        driver.findElement(answerSecurityQ).sendKeys("Lulu");
    }

    public void fillOutFormData(String remail, String rpassword, String repassword, String security) {

    }

    public void clickRegisterButton() {
        driver.findElement(registerBtn).submit();
    }

    public String getRegisterMessage() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(successMessage, fullMessage));
        return driver.findElement(successMessage).getText();
    }



}
