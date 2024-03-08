package com.solvd.carina.demo.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class BasePage extends AbstractPage {
    protected BasePage(WebDriver driver) {
        super(driver);
    }
    public void clickOnElement(ExtendedWebElement element){
        element.click();
    }
    public  void sendKeysToElement(ExtendedWebElement element, String input){
        element.type(input);
    }
    public void wait3Seconds(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
