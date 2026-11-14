package com.juice.pages;

import com.juice.config.ConfigReader;
import com.juice.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    private WebDriverWait wait;

    protected WebDriver driver() {
        if (driver == null) {
            this.driver = DriverManager.getDriver();
            this.wait = DriverManager.getWait();
        }
        return driver;
    }

    protected WebDriverWait getWait() {
        driver();
        return wait;
    }

    protected WebElement $(By locator) {
        return driver().findElement(locator);
    }

    protected String getBaseUrl() {
        return ConfigReader.getAppUrl();
    }



}
