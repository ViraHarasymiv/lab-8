package edu.IFNTUNG.bpbonline.application.pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage{

    @FindBy(xpath = "//td[contains(text(), '$')]/a")
    private List<WebElement> allNewProducts;

    public ProductsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Click on the first new product's item
     */

    @Step("Click on the first item of the new products")
    public ProductItemPage clickOnFirstProductItem(){
        log.info("Click on the first new product's item");
        allNewProducts.get(0).click();
        return new ProductItemPage(driver,log);
    }
}
