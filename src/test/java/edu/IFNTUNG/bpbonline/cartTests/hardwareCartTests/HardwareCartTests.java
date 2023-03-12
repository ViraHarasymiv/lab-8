package edu.IFNTUNG.bpbonline.cartTests.hardwareCartTests;

import edu.IFNTUNG.bpbonline.application.pages.HomePage;
import edu.IFNTUNG.bpbonline.application.pages.ProductItemPage;
import edu.IFNTUNG.bpbonline.asserts.Asserts;
import edu.IFNTUNG.bpbonline.runners.BaseTest;
import edu.IFNTUNG.bpbonline.utils.CsvDataProviders;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * This class contains user's automated steps for checking
 * the price of the hardware's items in the cart.
 *
 * @author Vira Harasymiv
 */

@Epic("Cart test")
@Story("Check price")
public class HardwareCartTests extends BaseTest {

    @Description("Verify the price of the hardware's items in the cart ")
    @Severity(SeverityLevel.CRITICAL)
    @Issue(value = "1")
    @Test(dataProvider = "csvReader",dataProviderClass = CsvDataProviders.class)
    public void checkItemPriceInCart(Map<String,String> testData){
        String number = testData.get("number");
        String itemCount = testData.get("itemCount");
        log.info("Hardware Cart Tests #" + number);
        String itemPrice = new HomePage(driver,log)
                .clickOnHardwareMenu()
                .clickOnFirstProductItem()
                .getProductPrice();
        String actualTotalPrice = new ProductItemPage(driver,log)
                .clickOnAddToCartButton()
                .typeItemsQuantity(itemCount)
                .clickOnUpdateButton(itemCount)
                .getTotalPriceInCart();
        Asserts.checkPriceInCart(actualTotalPrice,itemPrice,itemCount);
    }
}
