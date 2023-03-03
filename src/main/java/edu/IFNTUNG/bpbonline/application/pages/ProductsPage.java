package edu.IFNTUNG.bpbonline.application.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage{

    @FindBy(xpath = "//td[contains(text(), '$')]/a")
    private List<WebElement> allNewProducts;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    /**
     * Click on the first new product's item
     */

    public ProductItemPage clickOnFirstProductItem(){
        allNewProducts.get(0).click();
        return new ProductItemPage(driver);
    }
}
