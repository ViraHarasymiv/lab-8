package edu.IFNTUNG.bpbonline.application.pages.sections.header;

import edu.IFNTUNG.bpbonline.application.locators.headerLocators.HeaderLocators;
import edu.IFNTUNG.bpbonline.application.pages.BasePage;
import edu.IFNTUNG.bpbonline.application.pages.LoginPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends BasePage {
    private By myAccountMenu = HeaderLocators.MY_ACCOUNT_MENU.getPath();

    public Header(WebDriver driver, Logger log) {
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
}
