package edu.IFNTUNG.bpbonline.application.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//input[@name='cart_quantity[]']")
    private WebElement cartItemQuantity;

    @FindBy(xpath = "//span[contains(text(),'Update')]")
    private WebElement updateButton;

    @FindBy(xpath = "//strong[contains(text(), 'Sub-Total')]")
    private WebElement cartTotalPrice;

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
