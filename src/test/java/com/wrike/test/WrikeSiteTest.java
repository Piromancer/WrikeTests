package com.wrike.test;

import com.wrike.config.ChromeDriverConfig;
import com.wrike.page.MainPage;
import com.wrike.step.FormSteps;
import com.wrike.step.MainSteps;
import com.wrike.util.PropertiesConfigurator;
import com.wrike.util.RandomGenerator;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.WebDriver;

public class WrikeSiteTest {
    private static WebDriver driver;

    private static String mainURL = PropertiesConfigurator.getConfigProperties().getProperty("test.mainURL");
    private static final String emailPostfix = PropertiesConfigurator.getConfigProperties().getProperty("test.emailPostfix");

    @BeforeClass
    public static void setDriver(){
        driver = ChromeDriverConfig.getChromeDriver();
    }

    @Test
    @DisplayName("Get started functionality test")
    @Description("EMail validation. Q&A test")
    public void getStartedTest(){
        MainSteps mainSteps = new MainSteps(driver);
        mainSteps.openMain();
        mainSteps.clickGetStarted();
        mainSteps.enterRandomEMail(RandomGenerator.generateString(5, 12) + emailPostfix);
        mainSteps.submitEMail();
        FormSteps formSteps = new FormSteps(driver);
        formSteps.fillForm();
        formSteps.clickSubmit();
        formSteps.checkSubmission();
    }

    @Test
    @DisplayName("Twitter reference and icon test")
    @Description("Checking twitter reference. Checking if the picture is actually a picture of twitter")
    public void twitterTest(){
        MainSteps mainSteps = new MainSteps(driver);

    }

    @AfterClass
    public static void closeDriver(){
        driver.quit();
    }
}
