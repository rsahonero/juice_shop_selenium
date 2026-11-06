package com.juice.utils;

import com.juice.pages.HomePage;
import com.juice.pages.LoginPage;
import com.juice.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static int TIME_OUT = 5;
    protected static String BASE_URL = "http://localhost:3000/#/login";
    protected static HomePage homePage;
    protected static RegisterPage registerPage;
    protected static LoginPage loginPage;
}
