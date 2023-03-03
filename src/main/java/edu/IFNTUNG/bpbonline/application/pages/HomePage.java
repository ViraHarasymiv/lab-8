package edu.IFNTUNG.bpbonline.application.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By hardwareMenu = By.xpath("//a[contains(text(), 'Hardware')]");
    private By softwareMenu = By.xpath("//a[contains(text(), 'Software-')]");
    private By myAccountMenu = By.xpath("//span[contains(text(), 'My Account')]");

    public HomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Open LoginPage by clicking on the My Account Menu
     */
    public LoginPage clickOnMyAccountMenu() {
        log.info("Clicking on the My Account Menu");
        click(myAccountMenu);
        return new LoginPage(driver, log);
    }

    /**
     * Click on the hardware menu
     */
    public ProductsPage clickOnHardwareMenu() {
        log.info("Click on the Hardware menu");
        click(hardwareMenu);
        return new ProductsPage(driver, log);
    }

    /**
     * Click on the software menu
     */
    public ProductsPage clickOnSoftwareMenu() {
        log.info("Click on the Hardware menu");
        click(softwareMenu);
        return new ProductsPage(driver, log);
    }
}
