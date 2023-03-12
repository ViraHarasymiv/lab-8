package edu.IFNTUNG.bpbonline.cartTests.softwareCartTests;

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
 * the price of the software's items in the cart.
 *
 * @author Vira Harasymiv
 */
@Epic("Cart test")
@Story("Check price")
public class SoftwareCartTests extends BaseTest {

    @Description("Verify the price of the software's items in the cart")
    @Severity(SeverityLevel.CRITICAL)
    @Issue(value = "3")
    @Test(dataProvider = "csvReader",dataProviderClass = CsvDataProviders.class)
    public void checkItemPriceInCart(Map<String,String> testData){
        String number = testData.get("number");
        String itemCount = testData.get("itemCount");
        log.info("Hardware Cart Tests #" + number);
        String itemPrice = new HomePage(driver,log)
                .clickOnSoftwareMenu()
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
