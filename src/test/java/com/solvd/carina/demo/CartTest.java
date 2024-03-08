package com.solvd.carina.demo;

import com.solvd.carina.demo.pages.CartPage;
import com.solvd.carina.demo.pages.ProductDetailPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(BaseTest.class)
public class CartTest extends BaseTest{
    @Test
    public void changeQuantityTest(){
        ProductDetailPage product=home.clickOnACarouselProduct();
        home.switchToNewWindow();
        CartPage cart=product.clickOnAddToCartBtn();
        String oldPrice= cart.getProductPrice();
        cart.selectQuantityOptions();
        cart.wait3Seconds();
        String newPrice=cart.getProductPrice();
        Assert.assertFalse(oldPrice.equals(newPrice));
    }
}
