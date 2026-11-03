package com.juice.utils;

import com.juice.pages.HomePage;
import com.juice.pages.RegisterPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hooks extends Base{

    @Before
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME_OUT));

        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
    }

    @After
    public void tearDown() {
        if(driver != null) {
        //    driver.quit();
        }
    }
}
