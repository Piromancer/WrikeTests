package com.wrike.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract class Page {
    Page(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
}
