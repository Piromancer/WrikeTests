package com.wrike.step;

import com.wrike.page.MainPage;
import com.wrike.util.PropertiesConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

import javax.imageio.ImageIO;
import org.openqa.selenium.io.FileHandler;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.Coords;
import ru.yandex.qatools.ashot.coordinates.CoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import java.io.File;
import java.io.IOException;

public class MainSteps{
    private MainPage main;
    private WebDriver driver;
    private static final String mainURL = PropertiesConfigurator.getConfigProperties().getProperty("test.mainURL");
    private static final String formURL = PropertiesConfigurator.getConfigProperties().getProperty("test.formPathRegex");
    private static final int waitTime = Integer.parseInt(PropertiesConfigurator.getConfigProperties().getProperty("test.loadingWaitTime"));


    public MainSteps(WebDriver driver){
        this.driver = driver;
        main = new MainPage(this.driver);
    }

    @Step("Opening wrike.com")
    public void openMain(){
        driver.get(mainURL);
    }

    @Step("Clicking the \"Get started for free!\" button")
    public void clickGetStarted() {
        main.startForFree.click();
    }

    @Step("Sending a generated EMail ({email})")
    public void enterRandomEMail(String email){
        main.inputEMail.sendKeys(email);
    }

    @Step("Clicking the \"Create my Wrike account\" button")
    public void submitEMail(){
        main.submitEMail.click();
        new WebDriverWait(driver, waitTime)
                .withMessage("Wrong URL after redirect.\nReceived: "+driver.getCurrentUrl()+"\nExpected: "+formURL)
                .until(ExpectedConditions.urlMatches(formURL));
    }

    @Step("Checking if the link references the right page")
    public void checkTwitterHref(){
        assert main.twitter.getAttribute("href").equals("https://twitter.com/wrike");
    }

    public void checkTwitterData(){
        //driver.manage().window().maximize();
        Screenshot screen = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(500))
                .coordsProvider(new CoordsProvider() {
                    @Override
                    public Coords ofElement(WebDriver webDriver, WebElement element) {
                        Point point = element.getLocation();
                        Dimension dimension = element.getSize();
                        return new Coords(point.getX() + 43, point.getY() + 157, dimension.getWidth(), dimension.getHeight());

                    }
                })
                .takeScreenshot(driver, main.twitterPicture);
        try {
            ImageIO.write(screen.getImage(), "png", new File("src/main/resources/twitter.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int a = 3;
    }

//    public void saveTwitterPicture(){
//        Screenshot twitterPicture = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver, main.twitterPicture);
//        try {
//            ImageIO.write(twitterPicture.getImage(), "png", new File("src/main/resources/twitter.png"));
//        } catch (IOException e) {
//            System.out.println("Couldn't save picture");
//        }
//    }
}