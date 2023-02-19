package edu.IFNTUNG.bpbonline.application.pages.sections.leftSideBar;

import edu.IFNTUNG.bpbonline.application.locators.homePageLocators.HomePageLocators;
import edu.IFNTUNG.bpbonline.application.pages.BasePage;
import edu.IFNTUNG.bpbonline.application.pages.ProductsPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Categories extends BasePage {
    private By hardwareMenu = HomePageLocators.HARDWARE_MENU.getPath();
    private By softwareMenu = HomePageLocators.SOFTWARE_MENU.getPath();

    public Categories(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Click on the hardware menu
     */
    public ProductsPage clickOnHardwareMenu(){
        log.info("Click on the Hardware menu");
        click(hardwareMenu);
        return new ProductsPage(driver,log);
    }

    /**
     * Click on the software menu
     */
    public ProductsPage clickOnSoftwareMenu(){
        log.info("Click on the Hardware menu");
        click(softwareMenu);
        return new ProductsPage(driver,log);
    }
}
