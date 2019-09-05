package com.wrike.test;

import com.wrike.config.ChromeDriverConfig;
import com.wrike.util.PropertiesConfigurator;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.WebDriver;

public class WrikeSiteTest {
    private WebDriver driver;

    private static String startURL = PropertiesConfigurator.getConfigProperties().getProperty("test.startURL");

    @Before
    public void setDriver(){
        driver = ChromeDriverConfig.getChromeDriver();
    }

    @Test
    @DisplayName("Get started functionality test")
    @Description("EMail validation. Q&A test")
    public void getStartedTest(){
        driver.get(startURL);
        driver.manage().window().maximize();
        assert driver.getTitle().equals("Your online project management software - Wrike");
    }

    @After
    public void closeDriver(){
        driver.quit();
    }
}
