package com.solvd.carina.demo.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button[data-test-id='cta-top']")
    private ExtendedWebElement checkoutBtn;
    @FindBy(css = "button[data-test-id='cart-remove-item']")
    private ExtendedWebElement deleteBtn;
    @FindBy(css = "div[id='confirmation-status']")
    private ExtendedWebElement confirmationMessage;
    @FindBy(css = "div[class='quantity'] select[data-test-id='qty-dropdown']")
    private ExtendedWebElement quantityBtn;
    @FindBy(css = "div[class='item-price font-title-3']")
    private ExtendedWebElement productPrice;

    public boolean isCheckoutBtnPresent(){
        return checkoutBtn.isPresent();
    }
    public void clickOnDeleteBtn(){
        deleteBtn.click();
    }
    public boolean isConfirmationMessagePresent(){
        return confirmationMessage.isPresent();
    }
    public void selectQuantityOptions(){
        String option="2";
        quantityBtn.click();
        Select staticDropdownOptions =new Select((WebElement) quantityBtn);
        staticDropdownOptions.selectByValue(option);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(text(),'(2)')]"),option));
    }
    public String getProductPrice(){
        return productPrice.getText();
    }
}
