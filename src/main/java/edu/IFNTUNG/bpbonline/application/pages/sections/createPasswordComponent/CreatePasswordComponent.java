package edu.IFNTUNG.bpbonline.application.pages.sections.createPasswordComponent;

import edu.IFNTUNG.bpbonline.application.locators.createAccountPageLocators.CreateAccountPageLocators;
import edu.IFNTUNG.bpbonline.application.pages.BasePage;
import edu.IFNTUNG.bpbonline.application.pages.CreateAccountPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreatePasswordComponent extends BasePage {
    private By passwordField = CreateAccountPageLocators.PASSWORD_FIELD.getPath();
    private By passwordConfirmationField = CreateAccountPageLocators.PASSWORD_FIELD_CONFIRMATION.getPath();

    public CreatePasswordComponent(WebDriver driver, Logger log) {
        super(driver, log);
    }
    /**
     * Create and confirm new password
     */
    public CreateAccountPage createPassword(String password) {
        type(password, passwordField);
        type(password, passwordConfirmationField);
        return new CreateAccountPage(driver,log);
    }
}
