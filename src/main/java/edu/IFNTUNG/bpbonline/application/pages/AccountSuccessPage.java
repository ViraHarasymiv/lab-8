package edu.IFNTUNG.bpbonline.application.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSuccessPage extends BasePage{

    @FindBy(xpath = "//h1")
    private WebElement actualMessage;

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
