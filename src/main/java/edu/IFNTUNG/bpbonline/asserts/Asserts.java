package edu.IFNTUNG.bpbonline.asserts;

import edu.IFNTUNG.bpbonline.application.pages.CartPage;
import edu.IFNTUNG.bpbonline.application.pages.ProductItemPage;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Asserts {
    WebDriver driver;
    Logger log;

    @Then("User checks that the item's price in the cart is equal to the {string} multiplied by it's actual price")
    public void checkPriceInCart(String itemQuantity) {
        String expectedItemsPrice = new ProductItemPage(driver,log).getProductPrice();
        String actualItemsTotalPrice = new CartPage(driver, log).getTotalPriceInCart();
        float actualPrice = Float.parseFloat(actualItemsTotalPrice);
        float expectedPrice = Float.parseFloat(expectedItemsPrice) * Float.parseFloat(itemQuantity);
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


