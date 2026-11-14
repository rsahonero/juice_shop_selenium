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
        DriverManager.cleanUp();
    }


}
