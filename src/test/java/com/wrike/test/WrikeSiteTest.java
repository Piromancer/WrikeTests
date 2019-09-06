package com.wrike.test;

import com.wrike.config.ChromeDriverConfig;
import com.wrike.page.MainPage;
import com.wrike.util.PropertiesConfigurator;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.WebDriver;

public class WrikeSiteTest {
    private WebDriver driver;

    private static String mainURL = PropertiesConfigurator.getConfigProperties().getProperty("test.mainURL");

    @Before
    public void setDriver(){
        driver = ChromeDriverConfig.getChromeDriver();
    }

    @Test
    @DisplayName("Get started functionality test")
    @Description("EMail validation. Q&A test")
    public void getStartedTest(){
        MainPage mainPage = new MainPage(driver);
        driver.get(mainURL);
        mainPage.clickStartForFree();
        mainPage.enterRandomEMail();
        mainPage.submitEMail();
    }

    @After
    public void closeDriver(){
        driver.quit();
    }
}
