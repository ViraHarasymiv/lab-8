package edu.IFNTUNG.bpbonline.application.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage{
    private By newProducts = By.xpath("//td[contains(text(), '$')]/a");

    public ProductsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    /**
     * Click on the first new product's item
     */
    public ProductItemPage clickOnFirstProductItem(){
        log.info("Click on the first new product's item");
        List<WebElement> allNewProducts = findAll(newProducts);
        allNewProducts.get(0).click();
        return new ProductItemPage(driver,log);
    }
}
