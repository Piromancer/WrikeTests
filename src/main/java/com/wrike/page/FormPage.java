package com.wrike.page;

import com.wrike.util.RandomGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FormPage extends Page {

    @FindBy(xpath = "//div[@class='radio']")
    private List<WebElement> formElements;
    @FindBy(xpath = "//*[@name='survey-form']//button[@type='submit']")
    private WebElement submit;
    @FindBy(xpath = "//*[@class='survey-success' or @class='resend-page__cell--success']")
    private WebElement success;

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public void clickSubmit(){
        submit.click();
    }

    public void fillFormRandomly(){
        RandomGenerator.generateAnswers(formElements);
    }

    public boolean successIsDisplayed(){
        return success.isDisplayed();
    }
}
