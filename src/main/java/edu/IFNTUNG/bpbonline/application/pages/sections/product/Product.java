package edu.IFNTUNG.bpbonline.application.pages.sections.product;

import edu.IFNTUNG.bpbonline.application.locators.productItemPageLocators.ProductItemPageLocators;
import edu.IFNTUNG.bpbonline.application.pages.BasePage;
import edu.IFNTUNG.bpbonline.application.pages.CartPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Product extends BasePage {
    private By addToCartButton = ProductItemPageLocators.ADD_TO_CART_BUTTON.getPath();
    private By itemPrice = ProductItemPageLocators.ITEM_PRICE.getPath();

    public Product(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getProductPrice(){
        log.info("Get the product's price");
        return getItemPrice(itemPrice);
    }

    public CartPage clickOnAddToCartButton(){
        log.info("Click on the Add to Cart button");
        click(addToCartButton);
        return new CartPage(driver,log);
    }

}
