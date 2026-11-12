package com.juice.pages;
import com.juice.utils.Base;
import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends Base {

    /**
     * locators
     */
    @FindBy(xpath = "//span[contains(text(),'Dismiss')]")
    protected WebElement dismissBtn;
    @FindBy(id = "emailControl")
    protected WebElement emailTextBox;
    @FindBy(id = "passwordControl")
    protected  WebElement passwordTextBox;
    @FindBy(id="repeatPasswordControl")
    protected WebElement repeatPasswordTextBox;
    @FindBy(id = "securityQuestionControl")
    protected WebElement dropDownSecurityQ;
    @FindBy(xpath = "//span[contains(text(),\" Mother's maiden name? \")]")
    protected WebElement optionSecurityQ;
    @FindBy(id = "securityAnswerControl")
    protected WebElement answerSecurityQ;
    @FindBy(id = "registerButton")
    protected WebElement registerBtn;
    @FindBy(css = "div.mdc-snackbar__label")
    protected WebElement successMessage;

    public String fullMessage = "Registration completed successfully. You can now log in.";


    public RegisterPage(WebDriver driver) {
        Base.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void dismissPopUp() {
        dismissBtn.click();
    }

    public void fillOutFormDataTable(String email, String password, String repeatPassword, String securityQuestion, String answer) {
        emailTextBox.clear();
        emailTextBox.sendKeys(email);

        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);

        repeatPasswordTextBox.clear();
        repeatPasswordTextBox.sendKeys(repeatPassword);

       dropDownSecurityQ.click();
        By optionDynamic = By.xpath("//span[contains(text(), '" + securityQuestion + "' )]");
        wait.until(ExpectedConditions.elementToBeClickable(optionDynamic)).click();

        answerSecurityQ.clear();
        answerSecurityQ.sendKeys(answer);
    }

    public void fillOutRegisterFakeForm() {
        Faker faker = new Faker();
        String generatePassword = faker.regexify("[A-Z][a-z]{5}[0-9]{2}[@#$%!]");
        emailTextBox.sendKeys(faker.internet().emailAddress());
        passwordTextBox.sendKeys(generatePassword);
        repeatPasswordTextBox.sendKeys(generatePassword);
        dropDownSecurityQ.click();
        optionSecurityQ.click();
        answerSecurityQ.sendKeys("Lulu");
    }
    public void clickRegisterButton() {
        registerBtn.submit();
    }

    public String getRegisterMessage() {
        wait.until(ExpectedConditions.textToBePresentInElement(successMessage, fullMessage));
        return successMessage.getText();
    }



}
