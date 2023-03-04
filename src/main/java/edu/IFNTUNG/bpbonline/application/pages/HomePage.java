package edu.IFNTUNG.bpbonline.application.pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[contains(text(), 'Hardware')]")
    private WebElement hardwareMenu;

    @FindBy(xpath = "//a[contains(text(), 'Software-')]")
    private WebElement softwareMenu;

    @FindBy(xpath = "//span[contains(text(), 'My Account')]")
    private WebElement myAccountMenu;

    public HomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Open LoginPage by clicking on the My Account Menu
     */
    public LoginPage clickOnMyAccountMenu() {
        log.info("Clicking on the My Account Menu");
        click(myAccountMenu);
        return new LoginPage(driver,log);
    }

    /**
     * Click on the hardware menu
     */
    @Step("Click on the Categories Hardware's menu of the left sidebar")
    public ProductsPage clickOnHardwareMenu() {
        log.info("Click on the Hardware menu");
        click(hardwareMenu);
        return new ProductsPage(driver,log);
    }

    /**
     * Click on the software menu
     */
    public ProductsPage clickOnSoftwareMenu() {
        log.info("Click on the Hardware menu");
        click(softwareMenu);
        return new ProductsPage(driver,log);
    }
}
