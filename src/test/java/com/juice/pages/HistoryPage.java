package com.juice.pages;

import com.juice.driver.DriverFactory;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.ByteArrayInputStream;

public class HistoryPage extends BasePage {
    private static final By orderRows = By.xpath("//div[@class='table-container mat-elevation-z4 custom-slate']");

    public int getOrdersCount() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(orderRows));
        return DriverFactory.getDriver().findElements(orderRows).size();
    }
    public void takeScreenshot(String name) {
        byte[] bytes = ((TakesScreenshot) DriverFactory.getDriver())
                .getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(name, "image/png", new ByteArrayInputStream(bytes), "png");
    }
}
