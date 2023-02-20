package edu.IFNTUNG.bpbonline.application.pages.sections.newCustomerComponent;

import edu.IFNTUNG.bpbonline.application.locators.loginPageLocators.LoginPageLocators;
import edu.IFNTUNG.bpbonline.application.pages.BasePage;
import edu.IFNTUNG.bpbonline.application.pages.CreateAccountPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewCustomerComponent extends BasePage {
    private By continueButton = LoginPageLocators.CONTINUE_BUTTON.getPath();

    public NewCustomerComponent(WebDriver driver, Logger log) {
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
