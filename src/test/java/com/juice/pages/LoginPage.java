package com.juice.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class LoginPage extends BasePage {
    private static final By emailTxt = By.id("email");
    private static final By passwordTxt = By.id("password");
    private static final By logInBtx = By.id("loginButton");
    private static final By owaspJuiceLabel = By.xpath("//span[contains(text(), ' OWASP Juice Shop ')]");
    private static final By invalidMessageLogin = By.xpath("//p[@class='error']");

    public void fillOutLogIn(String username, String password) {
        $(emailTxt).sendKeys(username);
        $(passwordTxt).sendKeys(password);
        $(logInBtx).click();
    }
    public String getOwaspJuiceLabel() {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(owaspJuiceLabel)).getText();
    }
    public String getIncorrectLoginMessage() {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(invalidMessageLogin)).getText();
    }
    public String getDisplayedMessage() {
        getWait().until(driver ->
                !driver.findElements(By.xpath("//p[@class='error']")).isEmpty()
                        || driver.getCurrentUrl().contains("/search")
        );

        List<WebElement> errors = driver.findElements(By.xpath("//p[@class='error']"));
        if (!errors.isEmpty() && errors.get(0).isDisplayed()) {
            return errors.get(0).getText();
        }
        return getOwaspJuiceLabel();

    }

}
