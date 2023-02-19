package edu.IFNTUNG.bpbonline.asserts;

import org.testng.Assert;

public class Asserts {

    public static void checkPriceInCart(String actualItemsTotalPrice, String expectedItemsPrice, String itemCount){
        float actualPrice = Float.parseFloat(actualItemsTotalPrice);
        float expectedPrice = Float.parseFloat(expectedItemsPrice) * Float.parseFloat(itemCount);
        //Check actual and expected prices
        Assert.assertEquals(actualPrice, expectedPrice, "Actual price is " + actualPrice
                + ", but must be " + expectedPrice);
    }
}


