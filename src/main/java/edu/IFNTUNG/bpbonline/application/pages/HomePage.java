package edu.IFNTUNG.bpbonline.application.pages;

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

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Open LoginPage by clicking on the My Account Menu
     */

    public HomePage openHomePge(String url) {
        driver.get(url);
        return this;
    }

    /**
     * Open LoginPage by clicking on the My Account Menu
     */
    public LoginPage clickOnMyAccountMenu() {
        click(myAccountMenu);
        return new LoginPage(driver);
    }

    /**
     * Click on the hardware menu
     */
    public ProductsPage clickOnHardwareMenu() {
        click(hardwareMenu);
        return new ProductsPage(driver);
    }

    /**
     * Click on the software menu
     */
    public ProductsPage clickOnSoftwareMenu() {
        click(softwareMenu);
        return new ProductsPage(driver);
    }
}
