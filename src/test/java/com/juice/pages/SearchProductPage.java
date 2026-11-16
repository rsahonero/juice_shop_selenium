package com.juice.pages;

import com.juice.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class SearchProductPage extends BasePage {
    private static final By searchIcon   = By.xpath("//mat-icon[normalize-space()='search']");
    private static final By searchInput  = By.cssSelector("#mat-input-0, app-mat-search-bar input");
    private static final By addToBasket  = By.cssSelector("button[aria-label='Add to Basket']");
    private static final By basketCount  = By.cssSelector("button[aria-label='Show the shopping cart'] .warn-notification");

    public void searchProduct(String product) {
        List<WebElement> inputs = DriverFactory.getDriver().findElements(searchInput);
        boolean barOpen = !inputs.isEmpty() && inputs.get(0).isDisplayed();

        if (!barOpen) {
            getWait().until(ExpectedConditions.elementToBeClickable(searchIcon)).click();
        }

        WebElement input = getWait().until(ExpectedConditions.elementToBeClickable(searchInput));
        input.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        input.sendKeys(product, Keys.ENTER);
    }
    public void addProductToBasket() {
        getWait().until(ExpectedConditions.elementToBeClickable(addToBasket)).click();
    }

    public void addProduct(String product) {
        searchProduct(product);
        addProductToBasket();
    }

    public int getBasketCount() {
        return Integer.parseInt(getWait()
                .until(ExpectedConditions.visibilityOfElementLocated(basketCount)).getText());
    }

}
