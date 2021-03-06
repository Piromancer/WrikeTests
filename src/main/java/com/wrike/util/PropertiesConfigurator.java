package com.wrike.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesConfigurator {

    private static Properties configProperties;

    static {
        try(FileReader reader = new FileReader("src/main/resources/config.properties")) {
            configProperties = new Properties();
            configProperties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getConfigProperties() {
        return configProperties;
    }

}
