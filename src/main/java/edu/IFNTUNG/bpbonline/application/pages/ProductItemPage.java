package edu.IFNTUNG.bpbonline.application.pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductItemPage extends BasePage{

    @FindBy(xpath = "//span[text()='Add to Cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//form[@name='cart_quantity']//h1[contains(text(),'$')]")
    private WebElement itemPrice;

    public ProductItemPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getProductPrice(){
        log.info("Get the product's price");
        return getItemPrice(itemPrice);
    }

    @Step("Click on the Add to Cart button")
    public CartPage clickOnAddToCartButton(){
        log.info("Click on the Add to Cart button");
        click(addToCartButton);
        return new CartPage(driver,log);
    }
}
