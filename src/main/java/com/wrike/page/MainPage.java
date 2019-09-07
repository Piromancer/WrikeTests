package com.wrike.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class MainPage extends Page {
    @FindBy(xpath = "//*[@class='wg-header__desktop']//*[contains(@class,'wg-header__free-trial-button')]")
    public WebElement startForFree;
    @FindBy(xpath = "//*[@id=\"modal-pro\"]/form/label[1]/input")
    public WebElement inputEMail;
    @FindBy(xpath = "//*[@id=\"modal-pro\"]/form/label[2]/button")
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
