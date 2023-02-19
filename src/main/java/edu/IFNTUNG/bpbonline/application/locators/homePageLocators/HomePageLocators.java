package edu.IFNTUNG.bpbonline.application.locators.homePageLocators;

import org.openqa.selenium.By;

public enum HomePageLocators {
    HARDWARE_MENU(By.xpath("//a[contains(text(), 'Hardware')]")),
    SOFTWARE_MENU(By.xpath("//a[contains(text(), 'Software-')]"));

    private final By path;

    HomePageLocators(By path) {
        this.path = path;
    }

    public By getPath() {
        return path;
    }
}
