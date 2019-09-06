package com.wrike.util;

import java.util.Random;

public class RandomStringGenerator {
    private static Random r = new Random();

    public static String generate(int minL, int maxL){
        char[] chars = PropertiesConfigurator.getConfigProperties().getProperty("random.allowedCharacters").toCharArray();
        int len = r.nextInt(maxL-minL) + minL,
                charsLen = chars.length;
        StringBuilder res = new StringBuilder();
        for(int i=0; i<len; i++){
            res.append(chars[r.nextInt(charsLen)]);
        }
        return res.toString();
    }
}
