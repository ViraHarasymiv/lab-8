package edu.IFNTUNG.bpbonline.application.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSuccessPage extends BasePage{

    @FindBy(xpath = "//h1")
    private WebElement actualMessage;

    public AccountSuccessPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get the message about successful user's registration
     */
    public String getActualMessage() {
        return getText(actualMessage);
    }
}
