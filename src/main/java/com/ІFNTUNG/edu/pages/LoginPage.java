package com.ІFNTUNG.edu.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(xpath = "//span[contains(text(), 'Continue')]")
    private WebElement continueButton;

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Open Create Account Page by clicking on the Continue button
     */
    public CreateAccountPage clickOnContinueButton() {
        click(continueButton);
        return new CreateAccountPage(driver,log);
    }
}
