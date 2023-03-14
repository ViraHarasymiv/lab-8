package com.ІFNTUNG.edu.pages;

import com.ІFNTUNG.edu.utils.StringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends BasePage{
    @FindBy(xpath = "//input[@value='m']")
    private WebElement maleRadioButton;

    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@class='hasDatepicker']")
    private WebElement dataPicker;

    @FindBy(xpath = "//input[@name='email_address']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='company']")
    private WebElement companyNameField;

    @FindBy(xpath = "//input[@name='street_address']")
    private WebElement streetAddressField;

    @FindBy(xpath = "//input[@name='postcode']")
    private WebElement postCodeField;

    @FindBy(xpath = "//input[@name='city']")
    private WebElement cityField;

    @FindBy(xpath = "//input[@name='state']")
    private WebElement stateField;

    @FindBy(xpath = "//select[@name='country']")
    private WebElement selectCountryMenu;

    @FindBy(xpath = "//input[@name='telephone']")
    private WebElement telephoneNumberField;

    @FindBy(xpath = "//input[@name='newsletter']")
    private WebElement newsletterCheckbox;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='confirmation']")
    private WebElement passwordConfirmationField;

    @FindBy(xpath = "//span[contains(text(), 'Continue')]")
    private WebElement submitButton;

    public CreateAccountPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Click on the Male radio button
     */
    public CreateAccountPage clickOnMaleRadioButton() {
        log.info("Click on the Male radio button");
        click(maleRadioButton);
        return this;
    }

    /**
     * Type the user's First and Last Name
     */
    public CreateAccountPage enterUserFirstAndLastName(String firstUserName, String lastName) {
        log.info("enter the user's First and Last Name");
        type(firstUserName, firstNameField);
        type(lastName, lastNameField);
        return this;
    }

    /**
     * Type the user's birthday
     */
    public CreateAccountPage enterUserBirthDay(String birthDay) {
        selectDate(birthDay, dataPicker);
        return this;
    }

    /**
     * Type the user's email
     */
    public CreateAccountPage enterUserEmail(String fix_length) {
        String email = StringUtils.generateRandomEmail(Integer.parseInt(fix_length));
        type(email, emailField);
        return this;
    }

    /**
     * Submit entered user's information with valid data
     */
    public AccountSuccessPage submitEnteredInformationWithValidData() {
        click(submitButton);
        return new AccountSuccessPage(driver,log);
    }

    /**
     * Type the user's company
     */
    public CreateAccountPage enterCompanyName(String company) {
        type(company, companyNameField);
        return this;
    }

    /**
     * Type the user's street address and the post code
     */
    public CreateAccountPage enterStreetAddressAndPostCode(String streetAddress, String postCode) {
        type(streetAddress, streetAddressField);
        type(postCode, postCodeField);
        return this;
    }

    /**
     * Type the user's city and state
     */
    public CreateAccountPage enterUserCityAndState(String city, String state) {
        type(city, cityField);
        type(state, stateField);
        return this;
    }

    /**
     * Select the user's country
     */
    public CreateAccountPage selectCountry(String country) {
        Select select = new Select(selectCountryMenu);
        select.selectByVisibleText(country);
        return this;
    }

    /**
     * Type the user's telephone number
     */
    public CreateAccountPage enterTelephoneNumber(String telephoneNumber) {
        type(telephoneNumber, telephoneNumberField);
        return this;
    }

    /**
     * Check the News Letter checkbox
     */
    public CreateAccountPage checkNewsLetterCheckBox() {
        click(newsletterCheckbox);
        return this;
    }

    /**
     * Create and confirm new password
     */
    public CreateAccountPage createPassword(String password) {
        type(password, passwordField);
        type(password, passwordConfirmationField);
        return this;
    }
}
