package com.wrike.test;

import com.wrike.config.ChromeDriverConfig;
import com.wrike.steps.FormSteps;
import com.wrike.steps.MainSteps;
import com.wrike.util.PropertiesConfigurator;
import com.wrike.util.RandomGenerator;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.WebDriver;

public class WrikeSiteTest {

    private WebDriver driver;
    private MainSteps mainSteps;
    private FormSteps formSteps;

    private static final String emailPostfix = PropertiesConfigurator.getConfigProperties().getProperty("test.emailPostfix");

    @Before
    public void prepare() {
        driver = ChromeDriverConfig.getChromeDriver();
        mainSteps = new MainSteps(driver);
        formSteps = new FormSteps(driver);
    }

    @Test
    @DisplayName("Get started functionality test")
    @Description("EMail validation. Q&A test")
    public void getStartedTest() {
        mainSteps.openMain()
                .clickGetStarted()
                .enterRandomEMail(RandomGenerator.generateString(5, 12) + emailPostfix)
                .submitEMail();
        formSteps.fillForm()
                .clickSubmit()
                .checkMessageSuccessfulSubmission();
    }

    @Test
    @DisplayName("Twitter reference and icon test")
    @Description("Checking twitter reference. Checking if the picture is actually a picture of twitter")
    public void twitterTest() {
        mainSteps.openMain()
                .checkTwitterHref();
        mainSteps.checkTwitterData();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
