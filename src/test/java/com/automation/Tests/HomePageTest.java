package com.automation.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

    @Test
    public void verifyGoToTop(){
        homePage.userOpenApplication();
        homePage.gotoBottomSection();
        homePage.clicksOnButton();

        Assert.assertTrue(homePage.verifyTopSectionDisplayed());
    }
}
