package edu.IFNTUNG.bpbonline.application.locators.cartPageLocators;

import org.openqa.selenium.By;

public enum CartPageLocators {
        CART_QUANTITY(By.xpath("//input[@name='cart_quantity[]']")),
        UPDATE_BUTTON(By.xpath("//span[contains(text(),'Update')]")),
        CART_TOTAL_PRICE(By.xpath("//strong[contains(text(), 'Sub-Total')]"));

        private final By path;

       CartPageLocators(By path) {
            this.path = path;
        }

        public By getPath() {
            return path;
        }
}
