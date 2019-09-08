package com.wrike.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page {

    @FindBy(xpath = "//*[@class='wg-header__desktop']//*[contains(@class,'wg-header__free-trial-button')]")
    public WebElement startForFree;

    @FindBy(xpath = "//*[contains(@class,'modal-form-trial__input')]")
    public WebElement inputEMail;

    @FindBy(xpath = "//*[contains(@class,'modal-form-trial__submit')]")
    public WebElement submitEMail;

    @FindBy(xpath = "//*[1][contains(@class,'wg-footer__social-icon')]//..")
    public WebElement twitter;

    @FindBy(xpath = "//*[1][@class='wg-footer__social-item']")
    public WebElement twitterPicture;

    @FindBy(xpath = "//*[@class='wg-header__sticky-mainmenu']")
    public WebElement header;

    @FindBy(xpath = "//*[@class='wg-footer__bottom-section-wrapper']")
    public WebElement footer;



    public MainPage(WebDriver driver) {
        super(driver);
    }
}
