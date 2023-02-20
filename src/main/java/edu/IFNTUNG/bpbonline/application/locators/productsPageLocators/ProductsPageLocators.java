package edu.IFNTUNG.bpbonline.application.locators.productsPageLocators;

import org.openqa.selenium.By;

public enum ProductsPageLocators {
    NEW_PRODUCT_NAME(By.xpath("//td[contains(text(), '$')]/a"));

    private final By path;

    ProductsPageLocators(By path) {
        this.path = path;
    }

    public By getPath() {
        return path;
    }
}

