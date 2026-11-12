package com.juice.pages;
import com.juice.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginPage extends Base {

    @FindBy (id = "email")
    protected WebElement emailTxt;
    @FindBy (id = "password")
    protected WebElement passwordTxt;
    @FindBy (id = "loginButton")
    protected WebElement logInBtx;
    @FindBy (xpath = "//span[contains(text(), ' OWASP Juice Shop ')]")
    protected WebElement owaspJuiceLabel;
    @FindBy (xpath = "//p[@class='error']")
    protected WebElement invalidMessageLogin;


    public LoginPage(WebDriver driver) {
        Base.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillOutLogIn(String username, String password) {
        emailTxt.sendKeys(username);
        passwordTxt.sendKeys(password);
        logInBtx.click();
    }
    public String getOwaspJuiceLabel() {
        wait.until(ExpectedConditions.visibilityOf(owaspJuiceLabel));
        return owaspJuiceLabel.getText();
    }
    public String getIncorrectLoginMessage() {
        wait.until(ExpectedConditions.visibilityOf(invalidMessageLogin));
        return invalidMessageLogin.getText();
    }
    public String getDisplayedMessage() {
        By errorLocator = By.xpath("//p[@class='error']");

        wait.until(d -> !d.findElements(errorLocator).isEmpty()
                || !d.findElements(By.id("navbarAccount")).isEmpty());

        List<WebElement> errors = driver.findElements(errorLocator);
        if (!errors.isEmpty()) {
            return errors.get(0).getText();
        }
        return getOwaspJuiceLabel();

    }

}
