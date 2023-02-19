package edu.IFNTUNG.bpbonline.application.pages;

import edu.IFNTUNG.bpbonline.application.pages.sections.header.Header;
import edu.IFNTUNG.bpbonline.application.pages.sections.leftSideBar.LeftSideBar;
import edu.IFNTUNG.bpbonline.application.pages.sections.product.Product;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ProductItemPage extends BasePage{
    private Product product;
    private Header header;
    private LeftSideBar leftSideBar;

    public ProductItemPage(WebDriver driver, Logger log) {
        super(driver, log);
        product = new Product(driver, log);
        header = new Header(driver, log);
        leftSideBar = new LeftSideBar(driver, log);
    }

    public Product getProduct() {
        return product;
    }
}
