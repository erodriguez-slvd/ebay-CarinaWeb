package com.solvd.carina.demo;

import com.solvd.carina.demo.pages.HomePage;
import com.solvd.carina.demo.pages.ProductDetailPage;
import com.zebrunner.carina.core.IAbstractTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;

public class BaseTest implements IAbstractTest,ITestListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    String filePath = "src/test/resources/screenshots/";
    HomePage home;
    ProductDetailPage product=new ProductDetailPage(getDriver());
    @BeforeTest
    public void setUp(){
        home=new HomePage(getDriver());
        home.open();
    }
    @Test
    public void testOpenPage() {
        home=new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.debug("CarinaListener->onTestFailure");
        takeScreenshot(result);
    }

    public void takeScreenshot(ITestResult result) {
        String methodName = result.getName().toString().trim()+result.id();
        if (ITestResult.FAILURE == result.getStatus()) {
            //Convert web driver object to TakeScreenshot
            TakesScreenshot screenshot = (TakesScreenshot) getDriver();
            //Call getScreenshotAs method to create image file
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            try {
                //Move image file to new destination
                FileUtils.moveFile(srcFile, new File(filePath+methodName+".png"));
                LOGGER.info("Placed screenshot in "+filePath+" as "+methodName+".png"+" ***");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
