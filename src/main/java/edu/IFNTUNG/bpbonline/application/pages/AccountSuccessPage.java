package edu.IFNTUNG.bpbonline.application.pages;

import edu.IFNTUNG.bpbonline.application.locators.accountSuccesLocators.AccountSuccessLocators;
import edu.IFNTUNG.bpbonline.application.pages.sections.header.Header;
import edu.IFNTUNG.bpbonline.application.pages.sections.leftSideBar.LeftSideBar;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountSuccessPage extends BasePage{
    private Header header;
    private LeftSideBar leftSideBar;
    private By actualMessage = AccountSuccessLocators.ACTUAL_MESSAGE.getPath();

    public AccountSuccessPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    /**
     * Get the message about successful user's registration
     */
    public String getActualMessage(String message) {
        return getText(actualMessage, message);
    }
}
