package edu.IFNTUNG.bpbonline.application.pages;

import edu.IFNTUNG.bpbonline.application.pages.sections.header.Header;
import edu.IFNTUNG.bpbonline.application.pages.sections.leftSideBar.LeftSideBar;
import edu.IFNTUNG.bpbonline.application.pages.sections.newProducts.NewProducts;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{
    private NewProducts newProducts;
    private Header header;
    private LeftSideBar leftSideBar;

    public ProductsPage(WebDriver driver, Logger log) {
        super(driver, log);
        newProducts = new NewProducts(driver, log);
        header = new Header(driver, log);
        leftSideBar = new LeftSideBar(driver, log);
    }

    public NewProducts getNewProducts() {
        return newProducts;
    }
}
