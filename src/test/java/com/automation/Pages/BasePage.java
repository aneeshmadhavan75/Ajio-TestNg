package com.automation.Pages;

import com.automation.Utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage {

    WebDriver driver;

    public BasePage(){
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }
}
