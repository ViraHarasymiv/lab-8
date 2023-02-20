package edu.IFNTUNG.bpbonline.application.locators.headerLocators;

import org.openqa.selenium.By;

public enum HeaderLocators {
    MY_ACCOUNT_MENU(By.xpath("//span[contains(text(), 'My Account')]"));

    private final By path;

    HeaderLocators(By path) {
        this.path = path;
    }

    public By getPath() {
        return path;
    }
}
