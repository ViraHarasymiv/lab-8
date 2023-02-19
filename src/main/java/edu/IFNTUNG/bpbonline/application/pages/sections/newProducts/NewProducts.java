package edu.IFNTUNG.bpbonline.application.pages.sections.newProducts;

import edu.IFNTUNG.bpbonline.application.pages.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class NewProducts extends BasePage {
    private NewProductItem productNewItem;

    public NewProducts(WebDriver driver, Logger log) {
        super(driver, log);
        productNewItem = new NewProductItem(driver, log);
    }

    public NewProductItem getProductNewItem() {
        return productNewItem;
    }
}
