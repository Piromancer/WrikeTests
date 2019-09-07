package com.wrike.step;

import com.wrike.page.FormPage;
import com.wrike.util.PropertiesConfigurator;
import com.wrike.util.RandomGenerator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class FormSteps {
    private WebDriver driver;
    private FormPage formPage;

    private static final int waitTime = Integer.parseInt(PropertiesConfigurator.getConfigProperties().getProperty("test.loadingWaitTime"));
    private static final String twitterURL = PropertiesConfigurator.getConfigProperties().getProperty("test.twitterURL");
    private static final String alternativeURL = PropertiesConfigurator.getConfigProperties().getProperty("test.alternativeFormURL");

    public FormSteps(WebDriver driver) {
        this.driver = driver;
        formPage = new FormPage(this.driver);
    }

    @Step("Filling a form with random data")
    public void fillForm() {
        if (!formPage.formElements.get(0).getTagName().equals("span"))
            for (WebElement question : formPage.formElements) {
                List<WebElement> answers = question.findElements(By.xpath(".//*[contains(@class,'switch__button')]"));
                WebElement chosenElement = answers.get(new Random().nextInt(answers.size()));
                chosenElement.click();
            }
        else {
            Random r = new Random();
            new WebDriverWait(driver, waitTime).until(drv -> formPage.formElements.get(0).isDisplayed() && formPage.formElements.get(1).isDisplayed());
            formPage.formElements.get(r.nextInt(2)).click();
            new WebDriverWait(driver, waitTime).until(drv -> formPage.formElements.get(2).isDisplayed() && formPage.formElements.get(3).isDisplayed() && formPage.formElements.get(4).isDisplayed());
            formPage.formElements.get(r.nextInt(3)+2).click();
            new WebDriverWait(driver, waitTime).until(drv -> formPage.formElements.get(5).isDisplayed() && formPage.formElements.get(6).isDisplayed() && formPage.formElements.get(7).isDisplayed());
            formPage.formElements.get(r.nextInt(3)+5).click();
        }
        if (formPage.otherTextSection.isDisplayed())
            formPage.otherTextSection.sendKeys(RandomGenerator.generateString(5, 20));
    }

    @Step("Clicking submit")
    public void clickSubmit() {
        formPage.submit.click();
    }

    @Step("Checking if the message about successful submission appeared")
    public void checkSubmission() {
        new WebDriverWait(driver, waitTime)
                .withMessage("Submission wasn't successful")
                .until(dr -> formPage.success.isDisplayed());
    }

}
