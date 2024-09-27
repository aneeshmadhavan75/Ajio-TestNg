package com.automation.Tests;

import com.automation.Pages.*;
import com.automation.Utils.ConfigReader;
import com.automation.Utils.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    HomePage homePage;
    CartPage cartPage;
    CustomerCarePage customerCarePage;
    ProductListingPage productListingPage;
    SingleProductPage singleProductPage;

    @BeforeMethod
    public void setUp(){
        DriverManager.createDriver();
        ConfigReader.createConfig();
        homePage = new HomePage();
        cartPage = new CartPage();
        customerCarePage = new CustomerCarePage();
        productListingPage = new ProductListingPage();
        singleProductPage = new SingleProductPage();
    }

    @AfterMethod
    public void cleanUp(){
        DriverManager.getDriver().quit();
    }
}
