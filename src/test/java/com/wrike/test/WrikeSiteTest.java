package com.wrike.test;

import com.wrike.config.ChromeDriverConfig;
import com.wrike.page.MainPage;
import com.wrike.step.FormSteps;
import com.wrike.step.MainSteps;
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
        MainSteps mainSteps = new MainSteps(driver);
        mainSteps.runSteps();
        FormSteps formSteps = new FormSteps(driver);
        formSteps.runSteps();
    }

//    @Test
//    @DisplayName("Form functionality test")
//    @Description("Form is filled with random answers and then test checks if it was submitted successfully")
//    public void formTest(){
//        FormSteps formSteps = new FormSteps(driver);
//        formSteps.runSteps();
//    }

    @After
    public void closeDriver(){
        driver.quit();
    }
}
