package com.automation.Pages;

import com.automation.Utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.database.model.DatabaseId;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

public class ProductListingPage extends BasePage{

    @FindBy(xpath = "//div[@aria-label='View grid 5']")
    WebElement gridViewButton;

    @FindBy(xpath = "//div[@aria-label='View grid 3']")
    WebElement threeGridViewButton;

    @FindBy(xpath = "//div[@id='0']//div[@class='nameCls']")
    List<WebElement> gridViewProductList;

    String productListingPageName = "//div[@aria-label='%s']";

    @FindBy(xpath = "//div[@aria-label='grid']/div/div[1]")
    WebElement singleProductSelection;


    public void gridViewBtnClicks() {
        gridViewButton.click();
    }


    boolean finalResult2;

    public boolean verifyRowChanged() {
        threeGridViewButton.click();
        int beforeSize = gridViewProductList.size();
        gridViewButton.click();
        int afterSize = gridViewProductList.size();

        if ((beforeSize != afterSize) && afterSize == 5 && beforeSize == 3) {
            finalResult2 = true;
        }
        System.out.println("before Size:" + beforeSize);
        System.out.println("After Size:" + afterSize);
        return finalResult2;
    }

    WebElement heading;
    public boolean productListing() {

        gridViewButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String productListingPageNameXpath = String.format(productListingPageName, ConfigReader.getConfigValue("product.search"));
        heading = driver.findElement(By.xpath(productListingPageNameXpath));

        return heading.isDisplayed();
    }

    public void singleProductClick() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        singleProductSelection.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
}
