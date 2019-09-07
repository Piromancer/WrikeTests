package com.wrike.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page {
    @FindBy(xpath = "//*[@class='wg-header__desktop']//*[contains(@class,'wg-header__free-trial-button')]")
    public WebElement startForFree;
    @FindBy(xpath = "//*[@id=\"modal-pro\"]/form/label[1]/input")
    public WebElement inputEMail;
    @FindBy(xpath = "//*[@id=\"modal-pro\"]/form/label[2]/button")
    public WebElement submitEMail;

    public MainPage(WebDriver driver) {
        super(driver);
    }

//    public void clickStartForFree(){
//        startForFree.click();
//    }
//
//    public void enterEMail(String email){
//        inputEMail.sendKeys(email);
//    }
//
//    public void submitEMail(){
//        submitEMail.click();
//    }
}
