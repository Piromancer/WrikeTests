package com.wrike.test;

import com.wrike.config.ChromeDriverConfig;
import com.wrike.steps.FormSteps;
import com.wrike.steps.MainSteps;
import com.wrike.util.RandomGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static com.wrike.util.Constants.EMAIL_POSTFIX;

public class WrikeSiteTest {

    private WebDriver driver;
    private MainSteps mainSteps;
    private FormSteps formSteps;

    @Before
    public void prepare() {
        driver = ChromeDriverConfig.getChromeDriver();
        mainSteps = new MainSteps(driver);
        formSteps = new FormSteps(driver);
    }

    @Test
    @DisplayName("Get started functionality test")
    @Description("Email validation. Q&A test")
    @Epic("Wrike site test")
    @Feature("Free trial")
    @Story("Form submission")
    public void getStartedTest() {
        mainSteps.openMain()
                .clickGetStarted()
                .enterRandomEMail(RandomGenerator.generateString(5, 12) + EMAIL_POSTFIX)
                .submitEMail();
        formSteps.fillForm()
                .clickSubmit()
                .checkMessageSuccessfulSubmission();
    }

    @Test
    @DisplayName("Twitter reference and icon test")
    @Description("Checking twitter reference. Checking if the picture is actually a picture of twitter")
    @Epic("Wrike site test")
    @Feature("Footer icon")
    @Story("Twitter footer icon")
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
