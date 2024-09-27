package com.automation.Pages;

import com.automation.Utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerCarePage extends BasePage{

    @FindBy(xpath = "//li/a[@aria-label='Customer Care']")
    WebElement customerCareText;

    @FindBy(xpath = "//div[@class='qa-content section-two col-sm-4']/div/section[1]")
    WebElement issueSelection;

    String topicSelectString = "//label[contains(text(), '%s')]";

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    public void customerCarePage(){
        customerCareText.click();
    }

    public void topicAndIssueSelection(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,300);");

        String topicSelectionXpath = String.format(topicSelectString, ConfigReader.getConfigValue("Topic"));
        driver.findElement(By.xpath(topicSelectionXpath)).click();
    }

    public boolean verifyGetAssistanceMsg(){
        issueSelection.click();
        WebElement msgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@role='tabpanel']/div/following-sibling::div[@class='qa-content section-three']")));
        System.out.println(msgElement.getText());
        return msgElement.isDisplayed();
    }
}
