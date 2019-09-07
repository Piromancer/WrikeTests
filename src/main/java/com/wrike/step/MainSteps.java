package com.wrike.step;

import com.wrike.page.MainPage;
import com.wrike.util.PropertiesConfigurator;
import com.wrike.util.RandomGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

public class MainSteps{
    private MainPage main;
    private WebDriver driver;
    private static final String mainURL = PropertiesConfigurator.getConfigProperties().getProperty("test.mainURL");
    private static final String formURL = PropertiesConfigurator.getConfigProperties().getProperty("test.formPathRegex");
    private static final int waitTime = Integer.parseInt(PropertiesConfigurator.getConfigProperties().getProperty("test.loadingWaitTime"));


    public MainSteps(WebDriver driver){
        this.driver = driver;
        main = new MainPage(this.driver);
    }

//    public void runSteps(){
//        openMain();
//        clickGetStarted();
//        enterRandomEMail(RandomGenerator.generateString(5, 12) + emailPostfix);
//        submitEMail();
//    }

    @Step("Opening wrike.com")
    public void openMain(){
        driver.get(mainURL);
    }

    @Step("Clicking the \"Get started for free!\" button")
    public void clickGetStarted() {
        main.startForFree.click();
    }

    @Step("Sending a generated EMail ({email})")
    public void enterRandomEMail(String email){
        main.inputEMail.sendKeys(email);
    }

    @Step("Clicking the \"Create my Wrike account\" button")
    public void submitEMail(){
        main.submitEMail.click();
        new WebDriverWait(driver, waitTime)
                .withMessage("Wrong URL after redirect.\nReceived: "+driver.getCurrentUrl()+"\nExpected: "+formURL)
                .until(ExpectedConditions.urlMatches(formURL));
    }
}