package com.wrike.step;

import com.wrike.page.MainPage;
import com.wrike.util.PropertiesConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

public class MainSteps {

    private MainPage main;
    private WebDriver driver;

    private static final String mainURL = PropertiesConfigurator.getConfigProperties().getProperty("test.mainURL");
    private static final String formURL = PropertiesConfigurator.getConfigProperties().getProperty("test.formPathRegex");
    private static final String imgURL = mainURL + PropertiesConfigurator.getConfigProperties().getProperty("test.twitterImgURL");
    private static final String imgData = PropertiesConfigurator.getConfigProperties().getProperty("test.twitterPictureData");
    private static final String imgColor = PropertiesConfigurator.getConfigProperties().getProperty("test.twitterPictureFill");
    private static final int waitTime = Integer.parseInt(PropertiesConfigurator.getConfigProperties().getProperty("test.loadingWaitTime"));

    public MainSteps(WebDriver driver) {
        this.driver = driver;
        main = new MainPage(this.driver);
    }

    @Step("Opening wrike.com")
    public MainSteps openMain() {
        driver.get(mainURL);
        return this;
    }

    @Step("Clicking the \"Get started for free!\" button")
    public MainSteps clickGetStarted() {
        main.startForFree.click();
        return this;
    }

    @Step("Sending a generated EMail ({email})")
    public MainSteps enterRandomEMail(String email) {
        main.inputEMail.sendKeys(email);
        return this;
    }

    @Step("Clicking the \"Create my Wrike account\" button")
    public void submitEMail() {
        main.submitEMail.click();
        new WebDriverWait(driver, waitTime)
                .withMessage("Wrong URL after redirect.\nReceived: " + driver.getCurrentUrl() + "\nExpected: " + formURL)
                .until(ExpectedConditions.urlMatches(formURL));
    }

    @Step("Checking if the link references the right page")
    public void checkTwitterHref() {
        assert main.twitter.getAttribute("href").equals("https://twitter.com/wrike");
    }

    @Step("Checking the data and color match")
    public void checkTwitterData() {
        driver.get(imgURL);
        WebElement img = driver.findElement(By.xpath("//*[@id='twitter']")).findElements(By.xpath(".//*")).get(1);
        assert img.getAttribute("d").equals(imgData) && img.getAttribute("fill").equals(imgColor);
    }

}