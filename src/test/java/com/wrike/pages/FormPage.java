package com.wrike.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

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

    public FormPage(WebDriver driver) {
        super(driver);
    }
}
