package com.wrike.step;

import com.wrike.page.FormPage;
import com.wrike.util.PropertiesConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormSteps implements Stepper {
    private WebDriver driver;
    private FormPage formPage;

    private static final int waitTime = Integer.parseInt(PropertiesConfigurator.getConfigProperties().getProperty("test.loadingWaitTime"));

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

    private void fillForm(){
        formPage.fillFormRandomly();
    }

    private void clickSubmit(){
        formPage.clickSubmit();
    }

    private void checkSubmission(){
        new WebDriverWait(driver,waitTime)
                .withMessage("Submission wasn't successful")
                .until(dr -> formPage.successIsDisplayed());
    }
}
