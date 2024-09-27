package com.automation.Pages;

import com.automation.Utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.ObjectInputFilter;
import java.time.Duration;

public class HomePage extends BasePage{


    @FindBy(xpath = "//strong[contains(text(), 'Follow us')]")
    WebElement followUsText;

    @FindBy(xpath = "//aside[@data-testid='react-scroll-up-button']")
    WebElement goToTopBtn;

    @FindBy(xpath = "//img[@width='130px']")
    WebElement mainLogo;

    @FindBy(xpath = "//span[@aria-label='BEAUTY']")
    WebElement beautyMenu;

    @FindBy(xpath = "//input[@name='searchVal']")
    WebElement productSearchField;

    public void userOpenApplication() {
        driver.get("https://www.ajio.com/");
    }


    public void gotoBottomSection() {
        followUsText.click();
    }

    public void clicksOnButton() {
        goToTopBtn.click();
    }

    public boolean verifyTopSectionDisplayed() {
        return mainLogo.isDisplayed();
    }

    public void beautyMenuOptionClicks() {

        beautyMenu.click();
    }

    // delete button

    public void productSearchProcess() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        productSearchField.sendKeys(ConfigReader.getConfigValue("product.search"));
        productSearchField.submit();
    }
}
