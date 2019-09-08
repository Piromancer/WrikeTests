package com.wrike.steps;

import com.wrike.pages.FormPage;
import com.wrike.util.RandomGenerator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

import static com.wrike.util.Constants.PRIMARY_FORM_ANSWERS_LOCATOR;
import static com.wrike.util.Constants.WAIT_TIME;

public class FormSteps {

    private WebDriver driver;
    private FormPage formPage;

    public FormSteps(WebDriver driver) {
        this.driver = driver;
        formPage = new FormPage(this.driver);
    }

    @Step("Filling a form with random data")
    public FormSteps fillForm() {
        if (!formPage.formElements.get(0).getTagName().equals("span"))
            for (WebElement question : formPage.formElements) {
                List<WebElement> answers = question.findElements(By.xpath(PRIMARY_FORM_ANSWERS_LOCATOR));
                answers.get(new Random().nextInt(answers.size())).click();
            }
        else {
            Random r = new Random();
            new WebDriverWait(driver, WAIT_TIME)
                    .until(drv -> formPage.formElements.get(0).isDisplayed()
                            && formPage.formElements.get(1).isDisplayed());
            formPage.formElements.get(r.nextInt(2)).click();
            new WebDriverWait(driver, WAIT_TIME)
                    .until(drv -> formPage.formElements.get(2).isDisplayed()
                            && formPage.formElements.get(3).isDisplayed()
                            && formPage.formElements.get(4).isDisplayed());
            formPage.formElements.get(r.nextInt(3)+2).click();
            new WebDriverWait(driver, WAIT_TIME)
                    .until(drv -> formPage.formElements.get(5).isDisplayed()
                            && formPage.formElements.get(6).isDisplayed()
                            && formPage.formElements.get(7).isDisplayed());
            formPage.formElements.get(r.nextInt(3)+5).click();
        }
        if (formPage.otherTextSection.isDisplayed())
            formPage.otherTextSection.sendKeys(RandomGenerator.generateString(5, 20));
        return this;
    }

    @Step("Clicking submit")
    public FormSteps clickSubmit() {
        formPage.submit.click();
        return this;
    }

    @Step("Checking message successful submission")
    public void checkMessageSuccessfulSubmission() {
        new WebDriverWait(driver, WAIT_TIME)
                .withMessage("Submission wasn't successful")
                .until(dr -> formPage.success.isDisplayed());
    }

}
