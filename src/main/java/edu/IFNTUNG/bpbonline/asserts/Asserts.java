package edu.IFNTUNG.bpbonline.asserts;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Asserts {
    public static void checkPriceInCart(String actualItemsTotalPrice, String expectedItemsPrice, String itemCount){
        float actualPrice = Float.parseFloat(actualItemsTotalPrice);
        float expectedPrice = Float.parseFloat(expectedItemsPrice) * Float.parseFloat(itemCount);
        //Check actual and expected prices
        Assert.assertEquals(actualPrice, expectedPrice, "Actual price is " + actualPrice
                + ", but must be " + expectedPrice);
    }

    public static void checkMessageAboutSuccessfulRegistration(String actualMessage, String message,
                                                               String actualUrl, String expectedUrl){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualMessage.contains(message));
        softAssert.assertTrue(actualUrl.contains(expectedUrl));
        softAssert.assertAll();
    }

    public static void checkErrorMessage(String actualMessage, String expectedMessage){
        Assert.assertTrue(actualMessage.trim().contains(expectedMessage),
                "Actual message is "+ actualMessage + ", but must be " + expectedMessage);
    }
}
