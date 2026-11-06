package com.juice.pages;
import com.juice.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends Base {

    protected By emailTxt = By.id("email");
    protected By passwordTxt = By.id("password");
    protected By logInBtx = By.id("loginButton");
    protected By owaspJuiceLabel = By.xpath("//span[contains(text(), ' OWASP Juice Shop ')]");
    protected By invalidMessageLogin = By.xpath("//p[@class='error']");

    public LoginPage(WebDriver driver) {
        Base.driver = driver;
    }

    public void fillOutLogIn(String username, String password) {
        driver.findElement(emailTxt).sendKeys(username);
        driver.findElement(passwordTxt).sendKeys(password);
        driver.findElement(logInBtx).click();
    }
    public String getOwaspJuiceLabel() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(owaspJuiceLabel));
        return driver.findElement(owaspJuiceLabel).getText();
    }
    public String getIncorrectLoginMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(invalidMessageLogin));
        return driver.findElement(invalidMessageLogin).getText();
    }
    public String getDisplayedMessage(){
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(owaspJuiceLabel),
                ExpectedConditions.visibilityOfElementLocated(invalidMessageLogin)
        ));
        if(!driver.findElements(invalidMessageLogin).isEmpty()) {
            return getIncorrectLoginMessage();
        }
        return getOwaspJuiceLabel();
    }

}
