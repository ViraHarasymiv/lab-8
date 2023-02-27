package edu.IFNTUNG.bpbonline.application.pages.sections.newProducts;

import edu.IFNTUNG.bpbonline.application.locators.productsPageLocators.ProductsPageLocators;
import edu.IFNTUNG.bpbonline.application.pages.BasePage;
import edu.IFNTUNG.bpbonline.application.pages.ProductItemPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NewProductItem extends BasePage {
    private By newProductsName = ProductsPageLocators.NEW_PRODUCT_NAME.getPath();

    public NewProductItem(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Click on the first new product's item
     */
    public ProductItemPage clickOnFirstProductItem(){
        log.info("Find all new produts' items");
        List<WebElement> allNewProducts = findAll(newProductsName);
        log.info("Click on the first new product's item");
        allNewProducts.get(0).click();
        return new ProductItemPage(driver,log);
    }
}
