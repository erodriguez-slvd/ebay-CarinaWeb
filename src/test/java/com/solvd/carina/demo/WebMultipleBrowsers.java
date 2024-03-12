package com.solvd.carina.demo;

import com.solvd.carina.demo.pages.HomePage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.webdriver.core.capability.impl.desktop.FirefoxCapabilities;
import com.zebrunner.carina.webdriver.core.capability.impl.desktop.SafariCapabilities;
import io.appium.java_client.safari.SafariDriver;
import io.appium.java_client.safari.options.SafariOptions;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import java.lang.invoke.MethodHandles;

public class WebMultipleBrowsers implements IAbstractTest {
    WebDriver driver;
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Parameters("browser")
    @BeforeTest
    public void setUp(String browser){
        if (browser.equalsIgnoreCase("firefox")) {
            LOGGER.info("Executing on Firefox");
            getDriver(browser, new FirefoxCapabilities().getCapability("Firefox Browser"));
            HomePage firefoxHomePage = new HomePage(getDriver(browser)); // return named "firefox" driver from the pool to init HomePage.
            firefoxHomePage.open();
            Assert.assertTrue(firefoxHomePage.isPageOpened(), "Firefox home page is not opened!");
        } else if (browser.equalsIgnoreCase("chrome")) {
            LOGGER.info("Executing on Chrome");
            HomePage chromeHomePage = new HomePage(getDriver(browser));
            chromeHomePage.open();
            Assert.assertTrue(chromeHomePage.isPageOpened(), "Chrome home page is not opened!");
        } else {
            throw new IllegalArgumentException("The Browser Type is Undefined");
        }
    }
}
