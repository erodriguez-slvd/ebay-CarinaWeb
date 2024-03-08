package com.solvd.carina.demo.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

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
        quantityBtn.select(option);
        quantityBtn.getSelectedValue();
    }
    public String getProductPrice(){
        return productPrice.getText();
    }
}
