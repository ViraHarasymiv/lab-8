package edu.IFNTUNG.bpbonline.application.pages;

import edu.IFNTUNG.bpbonline.application.locators.cartPageLocators.CartPageLocators;
import edu.IFNTUNG.bpbonline.application.pages.sections.cartItem.CartItem;
import edu.IFNTUNG.bpbonline.application.pages.sections.header.Header;
import edu.IFNTUNG.bpbonline.application.pages.sections.leftSideBar.LeftSideBar;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    private CartItem cartItem;
    private By cartTotalPrice = CartPageLocators.CART_TOTAL_PRICE.getPath();
    private Header header;
    private LeftSideBar leftSideBar;

    public CartPage(WebDriver driver, Logger log) {
        super(driver, log);
        cartItem = new CartItem(driver,log);
        header = new Header(driver, log);
        leftSideBar = new LeftSideBar(driver, log);
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public String getTotalPriceInCart(){
        return getItemPrice(cartTotalPrice);
    }
}
