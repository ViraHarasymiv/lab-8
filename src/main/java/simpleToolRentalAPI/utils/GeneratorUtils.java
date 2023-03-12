package simpleToolRentalAPI.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class GeneratorUtils {
    public static String generateName(){
        return RandomStringUtils.randomAlphabetic(10);
    }

    public static String generateEmail(){
        return RandomStringUtils.randomAlphabetic(25) + "@gmail.com";
    }

    public static String generateComment(){
        return "It is a comment for " + generateName();
    }
}
