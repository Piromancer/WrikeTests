package com.wrike.page;

import com.wrike.util.RandomGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class FormPage extends Page {


    @FindAll({
            @FindBy(xpath = "//*[@name='survey-form']//*[@class='survey-question' or @class='radio']"),
            @FindBy(xpath = "//span[@class='survey-question-radio__icon']")
    })
    public List<WebElement> formElements;
    @FindBy(xpath = "//*[@name='survey-form']//button[@type='submit']")
    public WebElement submit;
    @FindBy(xpath = "//*[@class='survey-success' or @class='resend-page__cell--success']")
    public WebElement success;
    @FindBy(xpath = "//input[@type='text']")
    public WebElement otherTextSection;
    public WebElement twitterIcon;

    public FormPage(WebDriver driver) {
        super(driver);
    }

//    public void clickSubmit(){
//        submit.click();
//    }
//
//    public void fillFormRandomly(){
//        RandomGenerator.generateAnswers(formElements);
//    }

//    public boolean successIsDisplayed(){
//        return success.isDisplayed();
//    }

//    public String getTwitterHRef(){
//        return twitterIcon.getAttribute("href");
//    }

//    public WebElement getTwitterElement(){
//        return twitterIcon;
//    }
//
//    public void fillOtherSection(){
//        if(otherTextSection.isDisplayed()) otherTextSection.sendKeys(RandomGenerator.generateString(5,20));
//    }
}
