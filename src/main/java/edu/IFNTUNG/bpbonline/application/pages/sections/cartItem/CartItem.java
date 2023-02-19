package edu.IFNTUNG.bpbonline.application.pages.sections.cartItem;

import edu.IFNTUNG.bpbonline.application.locators.cartPageLocators.CartPageLocators;
import edu.IFNTUNG.bpbonline.application.pages.BasePage;
import edu.IFNTUNG.bpbonline.application.pages.CartPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartItem extends BasePage {
    private By cartItemQuantity = CartPageLocators.CART_QUANTITY.getPath();
    private By updateButton = CartPageLocators.UPDATE_BUTTON.getPath();

    public CartItem(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public CartItem typeItemsQuantity(String itemQuantity){
        log.info("Type item's quantity: " + itemQuantity);
        type(itemQuantity,cartItemQuantity);
        return this;
    }

    public CartPage clickOnUpdateButton(String itemQuantity){
        waitForAttributeToBeInElement(cartItemQuantity,"value",itemQuantity);
        log.info("Click on the Update button");
        click(updateButton);
        return new CartPage(driver,log);
    }
}
