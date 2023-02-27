package edu.IFNTUNG.bpbonline.application.pages.sections.personalDetailsComponent;

import edu.IFNTUNG.bpbonline.application.locators.createAccountPageLocators.CreateAccountPageLocators;
import edu.IFNTUNG.bpbonline.application.pages.BasePage;
import edu.IFNTUNG.bpbonline.application.pages.sections.companyDetailsComponent.CompanyDetailsComponent;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.StringUtils;

public class PersonalDetailsComponent extends BasePage {
    private By maleRadioButton = CreateAccountPageLocators.MALE_RADIO_BUTTON.getPath();
    private By firstNameField = CreateAccountPageLocators.FIRST_NAME_FIELD.getPath();
    private By lastNameField = CreateAccountPageLocators.LAST_NAME_FIELD.getPath();
    private By dataPicker = CreateAccountPageLocators.DATAPICKER.getPath();
    private By emailField = CreateAccountPageLocators.EMAIL_FIELD.getPath();

    public PersonalDetailsComponent(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Click on the Male radio button
     */
    public PersonalDetailsComponent clickOnMaleRadioButton(){
        log.info("Click on the Male radio button");
        click(maleRadioButton);
        return this;
    }

    /**
     * Type the user's First and Last Name
     */
    public PersonalDetailsComponent enterUserFirstAndLastName(String firstUserName, String lastName) {
        log.info("enter the user's First and Last Name");
        type(firstUserName, firstNameField);
        type(lastName, lastNameField);
        return this;
    }

    /**
     * Type the user's birthday
     */
    public PersonalDetailsComponent enterUserBirthDay(String birthDay) {
        selectDate(birthDay, dataPicker);
        return this;
    }

    /**
     * Type the user's email
     */
    public CompanyDetailsComponent enterUserEmail(String fix_length) {
        String email = StringUtils.generateRandomEmail(Integer.parseInt(fix_length));
        type(email, emailField);
        return new CompanyDetailsComponent(driver, log);
    }
}
