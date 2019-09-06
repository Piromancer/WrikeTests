package com.wrike.step;

import com.wrike.page.FormPage;
import com.wrike.util.PropertiesConfigurator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormSteps implements Stepper {
    private WebDriver driver;
    private FormPage formPage;

    private static final int waitTime = Integer.parseInt(PropertiesConfigurator.getConfigProperties().getProperty("test.loadingWaitTime"));
    private static final String twitterURL = PropertiesConfigurator.getConfigProperties().getProperty("test.twitterURL");
    private static final String alternativeURL = PropertiesConfigurator.getConfigProperties().getProperty("test.alternativeFormURL");

    public FormSteps(WebDriver driver){
        this.driver = driver;
        formPage = new FormPage(this.driver);
    }

    @Override
    public void runSteps() {
        fillForm();
        clickSubmit();
        checkSubmission();
    }

    @Step("Filling a form with random data")
    private void fillForm(){
        formPage.fillFormRandomly();
        formPage.fillOtherSection();
    }

    @Step("Clicking submit")
    private void clickSubmit(){
        formPage.clickSubmit();
    }

    @Step("Checking if the message about successful submission appeared")
    private void checkSubmission(){
        new WebDriverWait(driver,waitTime)
                .withMessage("Submission wasn't successful")
                .until(dr -> formPage.successIsDisplayed());
    }

    private void twitterURLCheck(){
        assert twitterURL.equals(formPage.getTwitterHRef());
    }

    private void twitterPictureCheck(){

    }
}
