package edu.IFNTUNG.bpbonline.application.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductItemPage extends BasePage{

    private By addToCartButton = By.xpath("//span[text()='Add to Cart']");
    private By itemPrice = By.xpath("//form[@name='cart_quantity']//h1[contains(text(),'$')]");

    public ProductItemPage(WebDriver driver, Logger log) {
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
