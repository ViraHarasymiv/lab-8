package edu.IFNTUNG.bpbonline.application.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By continueButton = By.xpath("//span[contains(text(), 'Continue')]");

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Open Create Account Page by clicking on the Continue button
     */
    public CreateAccountPage clickOnContinueButton() {
        click(continueButton);
        return new CreateAccountPage(driver, log);
    }
}
