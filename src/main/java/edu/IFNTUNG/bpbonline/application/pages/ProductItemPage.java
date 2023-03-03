package edu.IFNTUNG.bpbonline.application.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductItemPage extends BasePage{

    @FindBy(xpath = "//span[text()='Add to Cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//form[@name='cart_quantity']//h1[contains(text(),'$')]")
    private WebElement itemPrice;

    public ProductItemPage(WebDriver driver) {
        super(driver);
    }

    public String getProductPrice(){
        return getItemPrice(itemPrice);
    }

    public CartPage clickOnAddToCartButton(){
        click(addToCartButton);
        return new CartPage(driver);
    }
}
