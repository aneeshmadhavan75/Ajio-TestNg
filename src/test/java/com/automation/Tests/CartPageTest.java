package com.automation.Tests;

import org.junit.Assert;
import org.testng.annotations.Test;

public class CartPageTest extends BaseTest{

    @Test
    public void verifyCartDeleteBtn(){

        homePage.userOpenApplication();
        homePage.productSearchProcess();
        productListingPage.productListing();
        productListingPage.singleProductClick();

        cartPage.tabSwitch();
        cartPage.sizeSelection();
        cartPage.addToCart();
        cartPage.goToCart();
        cartPage.deleteBtnClick();

        Assert.assertTrue(cartPage.verifyProductIsRemoved());
    }

    @Test
    public void verifyQuantityChanges(){
        homePage.userOpenApplication();
        homePage.productSearchProcess();
        productListingPage.productListing();
        productListingPage.singleProductClick();

        cartPage.tabSwitch();
        cartPage.sizeSelection();
        cartPage.addToCart();
        cartPage.goToCart();

        cartPage.changeQuantityProcess();
        Assert.assertTrue(cartPage.verifyQuantityChange());
    }
}
