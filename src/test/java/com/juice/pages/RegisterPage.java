package com.juice.pages;
import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {
    /**
     * locators
     */
    private static final By emailTextBox= By.id("emailControl");
    private static final By passwordTextBox= By.id("passwordControl");
    private static final By repeatPasswordTextBox= By.id("repeatPasswordControl");
    private static final By dropDownSecurityQ= By.id("securityQuestionControl");
    private static final By optionSecurityQ= By.xpath("//span[contains(text(),\" Mother's maiden name? \")]");
    private static final By answerSecurityQ= By.id("securityAnswerControl");
    private static final By registerBtn= By.id("registerButton");
    private static final By successMessage= By.cssSelector("div.mdc-snackbar__label");

    public String fullMessage = "Registration completed successfully. You can now log in.";

    public void fillOutFormDataTable(String email, String password, String repeatPassword, String securityQuestion, String answer) {
        $(emailTextBox).clear();
        getWait().until(ExpectedConditions.elementToBeClickable(emailTextBox)).sendKeys(email);

        $(passwordTextBox).clear();
        getWait().until(ExpectedConditions.elementToBeClickable(passwordTextBox)).sendKeys(password);

        $(repeatPasswordTextBox).clear();
        getWait().until(ExpectedConditions.elementToBeClickable(repeatPasswordTextBox)).sendKeys(repeatPassword);

        getWait().until(ExpectedConditions.elementToBeClickable(dropDownSecurityQ)).click();
        By optionDynamic = By.xpath("//span[contains(text(), '" + securityQuestion + "' )]");
        getWait().until(ExpectedConditions.elementToBeClickable(optionDynamic)).click();

        $(answerSecurityQ).clear();
        getWait().until(ExpectedConditions.elementToBeClickable(answerSecurityQ)).sendKeys(answer);
    }

    public void fillOutRegisterFakeForm() {
        Faker faker = new Faker();
        String generatePassword = faker.regexify("[A-Z][a-z]{5}[0-9]{2}[@#$%!]");
        $(emailTextBox).sendKeys(faker.internet().emailAddress());
        $(passwordTextBox).sendKeys(generatePassword);
        $(repeatPasswordTextBox).sendKeys(generatePassword);
        $(dropDownSecurityQ).click();
        $(optionSecurityQ).click();
        $(answerSecurityQ).sendKeys("Lulu");
    }
    public void clickRegisterButton() {
        $(registerBtn).submit();
    }

    public String getRegisterMessage() {
        getWait().until(ExpectedConditions.textToBePresentInElementLocated(successMessage, fullMessage));
        return $(successMessage).getText();
    }



}
