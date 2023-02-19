package edu.IFNTUNG.bpbonline.application.locators.productItemPageLocators;

import org.openqa.selenium.By;

public enum ProductItemPageLocators {
    ITEM_PRICE(By.xpath("//form[@name='cart_quantity']//h1[contains(text(),'$')]")),
    ADD_TO_CART_BUTTON(By.xpath("//span[text()='Add to Cart']"));

    private final By path;

    ProductItemPageLocators(By path) {
        this.path = path;
    }

    public By getPath() {
        return path;
    }
}
