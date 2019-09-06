package com.wrike.page;

import com.wrike.util.RandomGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FormPage extends Page {


    @FindBy(xpath = "//*[@name='survey-form']//*[@class='survey-question' or @class='radio']")
    private List<WebElement> formElements;
    @FindBy(xpath = "//*[@name='survey-form']//button[@type='submit']")
    private WebElement submit;
    @FindBy(xpath = "//*[@class='survey-success' or @class='resend-page__cell--success']")
    private WebElement success;

    private WebElement twitterIcon;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement otherTextSection;

    @FindBy(xpath = "//span[@class='survey-question-radio__icon]")
    private List<WebElement> answers;

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

    public String getTwitterHRef(){
        return twitterIcon.getAttribute("href");
    }

    public WebElement getTwitterElement(){
        return twitterIcon;
    }

    public void fillOtherSection(){
        if(otherTextSection.isDisplayed()) otherTextSection.sendKeys(RandomGenerator.generateString(5,20));
    }
}
