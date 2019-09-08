package com.wrike.steps;

import com.wrike.pages.MainPage;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

import static com.wrike.util.Constants.*;

public class MainSteps {

    private MainPage main;
    private WebDriver driver;

    public MainSteps(WebDriver driver) {
        this.driver = driver;
        main = new MainPage(this.driver);
    }

    @Step("Opening wrike.com")
    public MainSteps openMain() {
        driver.get(MAIN_URL);
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
        new WebDriverWait(driver, WAIT_TIME)
                .withMessage("Wrong URL after redirect.\nReceived: " + driver.getCurrentUrl() + "\nExpected: " + FORM_URL)
                .until(ExpectedConditions.urlMatches(FORM_URL));
    }

    @Step("Checking if the link references the right page")
    public void checkTwitterHref() {
        Assert.assertTrue(main.twitter.getAttribute("href").equals(WRIKE_TWITTER));
    }

    @Step("Checking the data and color match")
    public void checkTwitterData() {
        driver.get(IMG_URL);
        WebElement img = driver.findElement(By.xpath("//*[@id='twitter']")).findElements(By.xpath(".//*")).get(1);
        Assert.assertTrue(img.getAttribute("d").equals(IMG_DATA) && img.getAttribute("fill").equals(IMG_COLOR));
    }

}