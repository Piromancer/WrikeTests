package com.wrike.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class RandomGenerator {
    private static Random r = new Random();

    public static String generateString(int minL, int maxL){
        char[] chars = PropertiesConfigurator.getConfigProperties().getProperty("random.allowedCharacters").toCharArray();
        int len = r.nextInt(maxL-minL) + minL,
                charsLen = chars.length;
        StringBuilder res = new StringBuilder();
        for(int i=0; i<len; i++){
            res.append(chars[r.nextInt(charsLen)]);
        }
        return res.toString();
    }

    public static void generateAnswers(List<WebElement> formElements){
        for(WebElement question : formElements){
            List<WebElement> answers = question.findElements(By.xpath(".//*[contains(@class,'survey-question-radio__container') or contains(@class,'switch__button')]"));
            WebElement chosenElement = answers.get(r.nextInt(answers.size()));
            chosenElement.click();
        }
    }
}
