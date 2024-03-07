package com.solvd.carina.demo.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage extends BasePage{
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h1/descendant::span[@class='ux-textspans ux-textspans--BOLD']")
    private ExtendedWebElement productTitle;
    @FindBy(css = ".x-price-primary")
    private ExtendedWebElement productPrice;
    @FindBy(css = "#binBtn_btn_1")
    private ExtendedWebElement buyNowBtn;
    @FindBy(css = "div[data-testid='x-atc-action'] a[data-testid='ux-call-to-action']")
    private ExtendedWebElement addToCartBtn;
    @FindBy(css = "button[id='TABS_SPR']")
    private ExtendedWebElement shippingBtn;
    @FindBy(css = "div[class='ux-layout-section__textual-display ux-layout-section__textual-display--itemId']")
    private ExtendedWebElement itemId;

    public boolean isProductTitlePresent(){
        return productTitle.isPresent();
    }
    public boolean isProductPricePresent(){
        return  productPrice.isPresent();
    }
    public boolean isBuyNowBtnPresent(){
        return buyNowBtn.isPresent();
    }

    public CartPage clickOnAddToCartBtn(){
        addToCartBtn.click();
        return PageFactory.initElements(driver, CartPage.class);
    }
    public boolean isItemIdPresent(){
        return itemId.isPresent();
    }
}
