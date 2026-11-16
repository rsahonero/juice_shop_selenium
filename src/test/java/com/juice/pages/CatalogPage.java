package com.juice.pages;

import com.juice.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CatalogPage extends BasePage{

    private static final By addToBasketBtns = By.cssSelector("button[aria-label='Add to Basket']");
    private static final By popupProductAdded = By.cssSelector("div.mat-mdc-snack-bar-label");

    public void addRandomProducts(int quantity) {
        getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(addToBasketBtns));
        int total = DriverFactory.getDriver().findElements(addToBasketBtns).size();

        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            indexes.add(i);
        }
        Collections.shuffle(indexes);

        for (int i = 0; i < quantity; i++) {
            List<WebElement> buttons = DriverFactory.getDriver().findElements(addToBasketBtns);
            WebElement button = buttons.get(indexes.get(i));

            ((JavascriptExecutor) DriverFactory.getDriver())
                    .executeScript("arguments[0].scrollIntoView({block:'center'});", button);
            getWait().until(ExpectedConditions.elementToBeClickable(button)).click();


            getWait().until(ExpectedConditions.invisibilityOfElementLocated(popupProductAdded));
        }
    }
}
