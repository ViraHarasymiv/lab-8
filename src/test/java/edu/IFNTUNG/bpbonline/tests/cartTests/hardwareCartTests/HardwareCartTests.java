package edu.IFNTUNG.bpbonline.tests.cartTests.hardwareCartTests;

import edu.IFNTUNG.bpbonline.application.pages.HomePage;
import edu.IFNTUNG.bpbonline.application.pages.sections.product.Product;
import edu.IFNTUNG.bpbonline.asserts.Asserts;
import edu.IFNTUNG.bpbonline.runners.BaseTest;
import org.testng.annotations.Test;
import utils.CsvDataProviders;

import java.util.Map;

/**
 * This class contains user's automated steps for checking
 * the price of the hardware's items in the cart.
 *
 * @author Vira Harasymiv
 */
public class HardwareCartTests extends BaseTest {

    @Test(dataProvider = "csvReader",dataProviderClass = CsvDataProviders.class)
    public void checkItemPriceInCart(Map<String,String> testData){
        String number = testData.get("number");
        String itemCount = testData.get("itemCount");
        log.info("Hardware Cart Tests #" + number);
        String itemPrice = new HomePage(driver,log)
                .getLeftSideBar()
                .getCategories()
                .clickOnHardwareMenu()
                .getNewProducts()
                .getProductNewItem()
                .clickOnFirstProductItem()
                .getProduct()
                .getProductPrice();
        String actualTotalPrice = new Product(driver,log)
                .clickOnAddToCartButton()
                .getCartItem()
                .typeItemsQuantity(itemCount)
                .clickOnUpdateButton(itemCount)
                .getTotalPriceInCart();
        Asserts.checkPriceInCart(actualTotalPrice,itemPrice,itemCount);
    }
}
