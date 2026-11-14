package com.juice.utils;

import com.juice.driver.DriverFactory;
import com.juice.driver.DriverManager;
import com.juice.pages.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BasePage {

    @Before
    public void setup() {
        DriverFactory.createDriver();
        DriverManager.initWait();
    }

    @After
    public void tearDown() {
        //DriverManager.cleanUp();
    }


}
    /*
    @Before
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME_OUT));

        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() {
        if(driver != null) {
            //driver.quit();
        }
    }

    */

