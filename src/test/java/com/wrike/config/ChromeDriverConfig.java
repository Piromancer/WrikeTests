package com.wrike.config;

import com.wrike.util.PropertiesConfigurator;
import org.openqa.selenium.WebDriver;

public class ChromeDriverConfig {
    private static WebDriver chromeDriver = null;

    static {
        String pathToDrivers = PropertiesConfigurator.getConfigProperties().getProperty("drivers.path");
        String pathToChromeDriver = pathToDrivers + PropertiesConfigurator.getConfigProperties().getProperty("driver.chrome.filename");
        System.setProperty(PropertiesConfigurator.getConfigProperties().getProperty("driver.chrome.variable"), pathToChromeDriver);
    }


}
