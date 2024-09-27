package com.automation.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GridViewTest extends BaseTest{

    @Test
    public void verifyGridViewButton(){
        homePage.userOpenApplication();
        homePage.beautyMenuOptionClicks();
        productListingPage.gridViewBtnClicks();
        Assert.assertTrue(productListingPage.verifyRowChanged());
    }
}
