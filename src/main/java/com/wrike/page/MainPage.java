package com.wrike.page;

import com.wrike.util.RandomStringGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page {
    @FindBy(xpath = "/html/body/div[1]/header/div[3]/div[2]/div/div/div[2]/div/form/button")
    private WebElement startForFree;
    @FindBy(xpath = "//*[@id=\"modal-pro\"]/form/label[1]/input")
    private WebElement inputEMail;
    @FindBy(xpath = "//*[@id=\"modal-pro\"]/form/label[2]/button")
    private WebElement submitEMail;
    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div/div[1]/div")
    private WebElement footer;
    @FindBy(xpath = "//*[@id=\"twitter\"]/path")
    private WebElement twitterIcon;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickStartForFree(){
        startForFree.click();
    }

    public void enterRandomEMail(){
        inputEMail.sendKeys(RandomStringGenerator.generate(5, 12) +"@wriketask.qaa");
    }

    public void submitEMail(){
        submitEMail.click();
    }
}
