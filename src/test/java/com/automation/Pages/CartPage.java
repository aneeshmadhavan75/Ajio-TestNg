package com.automation.Pages;

import com.automation.Utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage{

    String sizeXpath = "//div[@tabindex='0']/span[text()='%s']";


    List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

    @FindBy(xpath = "//div[@role='button' and @class='btn-gold']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//span[text()='GO TO BAG']")
    WebElement goToCartBtn;

    @FindBy(xpath = "//div[@aria-label='Delete']")
    WebElement deleteBtn;

    @FindBy(xpath = "//div[@class='card-delete-button']/div[2]")
    WebElement deleteBtnInPopUp;

    @FindBy(xpath = "//div[@class=' empty-cart']/p")
    WebElement emptyCartText;

    @FindBy(xpath = "//div[@class='cartqty']")
    WebElement quantityChangeBtn;

    @FindBy(xpath = "//button[@class='increment button']")
    WebElement incrementBtn;

    @FindBy(id = "updateQuantity")
    WebElement quantityUpdateBtn;

    @FindBy(className = "counter")
    WebElement quantityValue;

    @FindBy(xpath = "//span[@aria-label='items']")
    WebElement myBagsItemsQuantity;

    public void tabSwitch() {
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        String lastWindowHandle = windowHandles.get(windowHandles.size() - 1);
        driver.switchTo().window(lastWindowHandle);
    }

    public void sizeSelection() {
        String sizeStr = String.format(sizeXpath, ConfigReader.getConfigValue("product.size"));
        driver.findElement(By.xpath(sizeStr)).click();
    }

    public void addToCart() {
        addToCartBtn.click();
    }

    public void goToCart() {
        goToCartBtn.click();
    }

    public void deleteBtnClick() {

        deleteBtn.click();
        deleteBtnInPopUp.click();

    }

    public boolean verifyProductIsRemoved() {

        System.out.println("Empty cart message : "+emptyCartText.getText());

        return emptyCartText.isDisplayed();

    }

    // ---------- QUANTITY CHANGING -------------------------

    private String updatedText;
    public void changeQuantityProcess(){
        quantityChangeBtn.click();
        incrementBtn.click();
        updatedText = quantityValue.getText();
        quantityUpdateBtn.click();
    }

    public String updatedTextReturn(){
        return updatedText;
    }

    public boolean verifyQuantityChange(){
        String myBagsQuantityStr = myBagsItemsQuantity.getText();
        System.out.println("Value inside parantheses : " + myBagsQuantityStr);
        System.out.println("after quantity incremented value:"+updatedText);
        return myBagsQuantityStr.contains(updatedTextReturn());
    }


}
