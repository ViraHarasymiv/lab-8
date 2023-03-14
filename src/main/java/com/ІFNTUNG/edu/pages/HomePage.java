package com.ІFNTUNG.edu.pages;

import com.ІFNTUNG.edu.utils.ConfigReader;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    private final String PAGE_URL = ConfigReader.get().getHomePageUrl();
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
     * Open HomePage with it's url
     */
    public HomePage openPage() {
        log.info("Opening page: " + PAGE_URL);
        openUrl(PAGE_URL);
        log.info("Page opened!");
        return this;
    }
}
