package edu.IFNTUNG.bpbonline.application.pages.sections.companyDetailsComponent;

import edu.IFNTUNG.bpbonline.application.locators.createAccountPageLocators.CreateAccountPageLocators;
import edu.IFNTUNG.bpbonline.application.pages.BasePage;
import edu.IFNTUNG.bpbonline.application.pages.sections.addressDetailsComponent.AddressDetailsComponent;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CompanyDetailsComponent extends BasePage {
    private By companyNameField = CreateAccountPageLocators.COMPANY_NAME_FIELD.getPath();
    public CompanyDetailsComponent(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Type the user's company
     */
    public AddressDetailsComponent enterCompanyName(String company) {
        type(company, companyNameField);
        return new AddressDetailsComponent(driver,log);
    }
}
