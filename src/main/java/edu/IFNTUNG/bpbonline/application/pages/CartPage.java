package edu.IFNTUNG.bpbonline.application.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    private By cartItemQuantity = By.xpath("//input[@name='cart_quantity[]']");
    private By updateButton = By.xpath("//span[contains(text(),'Update')]");
    private By cartTotalPrice = By.xpath("//strong[contains(text(), 'Sub-Total')]");

    public CartPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getTotalPriceInCart(){
        return getItemPrice(cartTotalPrice);
    }

    public CartPage clickOnUpdateButton(String itemQuantity){
        waitForAttributeToBeInElement(cartItemQuantity,"value",itemQuantity);
        log.info("Click on the Update button");
        click(updateButton);
        return this;
    }
    public CartPage typeItemsQuantity(String itemQuantity){
        log.info("Type item's quantity: " + itemQuantity);
        type(itemQuantity,cartItemQuantity);
        return this;
    }
}
