package com.wrike.util;

public class Constants {
    public static final int WAIT_TIME = Integer.parseInt(PropertiesConfigurator.getConfigProperties().getProperty("test.loadingWaitTime"));
    public static final String MAIN_URL = PropertiesConfigurator.getConfigProperties().getProperty("test.mainURL");
    public static final String FORM_URL = PropertiesConfigurator.getConfigProperties().getProperty("test.formPathRegex");
    public static final String IMG_URL = MAIN_URL + PropertiesConfigurator.getConfigProperties().getProperty("test.twitterImgURL");
    public static final String IMG_DATA = PropertiesConfigurator.getConfigProperties().getProperty("test.twitterPictureData");
    public static final String IMG_COLOR = PropertiesConfigurator.getConfigProperties().getProperty("test.twitterPictureFill");
    public static final String WRIKE_TWITTER = PropertiesConfigurator.getConfigProperties().getProperty("test.wrikeTwitter");
    public static final String PRIMARY_FORM_ANSWERS_LOCATOR = PropertiesConfigurator.getConfigProperties().getProperty("test.locator.primaryFormXpath");
}
