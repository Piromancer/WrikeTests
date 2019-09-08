package com.wrike.config;

import com.wrike.util.PropertiesConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverConfig {

    static {
        String pathToDrivers = PropertiesConfigurator.getConfigProperties().getProperty("drivers.path");
        String pathToChromeDriver = pathToDrivers + PropertiesConfigurator.getConfigProperties().getProperty("driver.chrome.name");
        System.setProperty(PropertiesConfigurator.getConfigProperties().getProperty("driver.chrome.variable"), pathToChromeDriver);
    }

    public static WebDriver getChromeDriver() {
        return new ChromeDriver();
    }
}
