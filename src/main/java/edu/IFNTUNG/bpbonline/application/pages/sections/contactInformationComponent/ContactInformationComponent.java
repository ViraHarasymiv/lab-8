package edu.IFNTUNG.bpbonline.application.pages.sections.contactInformationComponent;

import edu.IFNTUNG.bpbonline.application.locators.createAccountPageLocators.CreateAccountPageLocators;
import edu.IFNTUNG.bpbonline.application.pages.BasePage;
import edu.IFNTUNG.bpbonline.application.pages.sections.createPasswordComponent.CreatePasswordComponent;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactInformationComponent extends BasePage {
    private By telephoneNumberField = CreateAccountPageLocators.TELEPHONE_NUMBER.getPath();
    private By newsletterCheckbox = CreateAccountPageLocators.NEWS_LETTER_CHECKBOX.getPath();

    public ContactInformationComponent(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Type the user's telephone number
     */
    public ContactInformationComponent enterTelephoneNumber(String telephoneNumber) {
        type(telephoneNumber, telephoneNumberField);
        return this;
    }

    /**
     * Check the News Letter checkbox
     */
    public CreatePasswordComponent checkNewsLetterCheckBox() {
        click(newsletterCheckbox);
        return new CreatePasswordComponent(driver,log);
    }
}
