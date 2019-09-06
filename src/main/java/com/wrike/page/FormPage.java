package com.wrike.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FormPage extends Page {

    @FindBy(xpath = "")
    List<WebElement> form_Elements;
    WebElement submit;

    public FormPage(WebDriver driver) {
        super(driver);
    }
}
