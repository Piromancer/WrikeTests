package com.wrike.step;

import com.wrike.page.MainPage;
import com.wrike.util.PropertiesConfigurator;
import com.wrike.util.RandomGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

public class MainSteps implements Stepper {
    private MainPage main;
    private WebDriver driver;
    private static final String mainURL = PropertiesConfigurator.getConfigProperties().getProperty("test.mainURL");
    private static final String formURL = PropertiesConfigurator.getConfigProperties().getProperty("test.formPathRegex");
    private static final int waitTime = Integer.parseInt(PropertiesConfigurator.getConfigProperties().getProperty("test.loadingWaitTime"));
    private static final String emailPostfix = PropertiesConfigurator.getConfigProperties().getProperty("test.emailPostfix");

    public MainSteps(WebDriver driver){
        this.driver = driver;
        main = new MainPage(this.driver);
    }

    @Override
    public void runSteps(){
        openMain();
        clickGetStarted();
        enterRandomEMail(RandomGenerator.generateString(5, 12) + emailPostfix);
        submitEMail();
    }

    @Step("Opening wrike.com")
    private void openMain(){
        driver.get(mainURL);
    }

    @Step("Clicking the \"Get started for free!\" button")
    private void clickGetStarted() {
        main.clickStartForFree();
    }

    @Step("Sending a generated EMail ({email})")
    private void enterRandomEMail(String email){
        main.enterEMail(email);
    }

    @Step("Clicking the \"Create my Wrike account\" button")
    private void submitEMail(){
        main.submitEMail();
        new WebDriverWait(driver, waitTime)
                .withMessage("Wrong URL after redirect.\nReceived: "+driver.getCurrentUrl()+"\nExpected: "+formURL)
                .until(ExpectedConditions.urlMatches(formURL));
    }
}
