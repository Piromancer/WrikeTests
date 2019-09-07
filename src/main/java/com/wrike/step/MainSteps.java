package com.wrike.step;

import com.wrike.page.MainPage;
import com.wrike.util.PropertiesConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

public class MainSteps{
    private MainPage main;
    private WebDriver driver;
    private static final String mainURL = PropertiesConfigurator.getConfigProperties().getProperty("test.mainURL");
    private static final String formURL = PropertiesConfigurator.getConfigProperties().getProperty("test.formPathRegex");
    private static final String imgURL = mainURL+PropertiesConfigurator.getConfigProperties().getProperty("test.twitterImgURL");
    private static final String imgData = PropertiesConfigurator.getConfigProperties().getProperty("test.twitterPictureData");
    private static final String imgColor = PropertiesConfigurator.getConfigProperties().getProperty("test.twitterPictureFill");
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

    @Step("Checking the data and color match")
    public void checkTwitterData(){
        driver.get(imgURL);
        WebElement img = driver.findElement(By.xpath("//*[@id='twitter']")).findElements(By.xpath(".//*")).get(1);
        assert img.getAttribute("d").equals(imgData) && img.getAttribute("fill").equals(imgColor);
    }

//    public void saveTwitterPicture(){
//        Screenshot twitterPicture = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver, main.twitterPicture);
//        try {
//            ImageIO.write(twitterPicture.getImage(), "png", new File("src/main/resources/twitter.png"));
//        } catch (IOException e) {
//            System.out.println("Couldn't save picture");
//        }
//    } <use xlink:href="/content/themes/wrike/dist/img/sprite/vector/footer-icons.symbol.svg?v2#twitter"></use>
}