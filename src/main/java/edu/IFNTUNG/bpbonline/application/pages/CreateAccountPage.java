package edu.IFNTUNG.bpbonline.application.pages;

import edu.IFNTUNG.bpbonline.application.locators.createAccountPageLocators.CreateAccountPageLocators;
import edu.IFNTUNG.bpbonline.application.pages.sections.addressDetailsComponent.AddressDetailsComponent;
import edu.IFNTUNG.bpbonline.application.pages.sections.companyDetailsComponent.CompanyDetailsComponent;
import edu.IFNTUNG.bpbonline.application.pages.sections.contactInformationComponent.ContactInformationComponent;
import edu.IFNTUNG.bpbonline.application.pages.sections.createPasswordComponent.CreatePasswordComponent;
import edu.IFNTUNG.bpbonline.application.pages.sections.header.Header;
import edu.IFNTUNG.bpbonline.application.pages.sections.leftSideBar.LeftSideBar;
import edu.IFNTUNG.bpbonline.application.pages.sections.personalDetailsComponent.PersonalDetailsComponent;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage extends BasePage{
    private Header header;
    private LeftSideBar leftSideBar;
    private PersonalDetailsComponent personalDetailsComponent;
    private CompanyDetailsComponent companyDetailsComponent;
    private AddressDetailsComponent addressDetailsComponent;
    private ContactInformationComponent contactInformationComponent;
    private CreatePasswordComponent createPasswordComponent;

    private By submitButton = CreateAccountPageLocators.SUBMIT_BUTTON.getPath();

    public CreateAccountPage(WebDriver driver, Logger log) {
        super(driver, log);
        header = new Header(driver, log);
        leftSideBar = new LeftSideBar(driver, log);
        personalDetailsComponent = new PersonalDetailsComponent(driver, log);
    }

    public PersonalDetailsComponent getPersonalDetailsComponent() {
        return personalDetailsComponent;
    }

    /**
     * Submit entered user's information with valid data
     */
    public AccountSuccessPage submitEnteredInformationWithValidDate() {
        click(submitButton);
        return new AccountSuccessPage(driver, log);
    }
    /**
     * Submit entered user's information with invalid data
     */
    public CreateAccountPage submitEnteredInformationWithInValidDate() {
        click(submitButton);
        return this;
    }

    /** Switch to alert and get it's message */
    public String getAlertText() {
        Alert alert = switchToAlert();
        String alertText = alert.getText();
        log.info("Alert says: " + alertText);
        return alertText;
    }
}
