package edu.IFNTUNG.bpbonline.application.pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import edu.IFNTUNG.bpbonline.utils.StringUtils;

public class CreateAccountPage extends BasePage {

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
    @Step("Check the Male radio button")
    public CreateAccountPage clickOnMaleRadioButton() {
        log.info("Click on the Male radio button");
        click(maleRadioButton);
        return this;
    }

    /**
     * Type the user's First and Last Name
     */
    @Step("Type the first name in the First Name {firstUserName} field and the last name in the Last Name {lastName} field")
    public CreateAccountPage enterUserFirstAndLastName(String firstUserName, String lastName) {
        log.info("enter the user's First and Last Name");
        type(firstUserName, firstNameField);
        type(lastName, lastNameField);
        return this;
    }

    /**
     * Type the user's birthday
     */
    @Step("Select the date of birth in the Date of Birth's {birthDay} dropdown list")
    public CreateAccountPage enterUserBirthDay(String birthDay) {
        selectDate(birthDay, dataPicker);
        return this;
    }

    /**
     * Type the user's email
     */
    @Step("Type e-mail address in the E-Mail Address field")
    public CreateAccountPage enterUserEmail(String fix_length) {
        String email = StringUtils.generateRandomEmail(Integer.parseInt(fix_length));
        type(email, emailField);
        return this;
    }

    /**
     * Submit entered user's information with valid data
     */
    @Step("Click on the Continue button")
    public AccountSuccessPage submitEnteredInformationWithValidData() {
        click(submitButton);
        return new AccountSuccessPage(driver,log);
    }

    /**
     * Type the user's company
     */
    @Step("Type company name in the Company Name {company} field")
    public CreateAccountPage enterCompanyName(String company) {
        type(company, companyNameField);
        return this;
    }

    /**
     * Type the user's street address and the post code
     */
    @Step("Type street address {0} in the Street Address field and the post code {1} in the Post Code field")
    public CreateAccountPage enterStreetAddressAndPostCode(String streetAddress, String postCode) {
        type(streetAddress, streetAddressField);
        type(postCode, postCodeField);
        return this;
    }

    /**
     * Type the user's city and state
     */
    @Step("Type city {0} in the City field and the state {1} in the State/Province field")
    public CreateAccountPage enterUserCityAndState(String city, String state) {
        type(city, cityField);
        type(state, stateField);
        return this;
    }

    /**
     * Select the user's country
     */
    @Step("Select the country from the Country {0} dropdown list")
    public CreateAccountPage selectCountry(String country) {
        Select select = new Select(selectCountryMenu);
        select.selectByVisibleText(country);
        return this;
    }

    /**
     * Type the user's telephone number
     */
    @Step("Type the telephone number {0} in the Telephone Number field")
    public CreateAccountPage enterTelephoneNumber(String telephoneNumber) {
        type(telephoneNumber, telephoneNumberField);
        return this;
    }

    /**
     * Check the News Letter checkbox
     */
    @Step("Check the Newsletter checkbox")
    public CreateAccountPage checkNewsLetterCheckBox() {
        click(newsletterCheckbox);
        return this;
    }

    /**
     * Create and confirm new password
     */
    @Step("Type the password {0} in the Password field and in the Confirmation field")
    public CreateAccountPage createPassword(String password) {
        type(password, passwordField);
        type(password, passwordConfirmationField);
        return this;
    }

    /**
     * Submit entered user's information with invalid data
     */
    @Step("Click on the Continue button")
    public CreateAccountPage submitEnteredInformationWithInValidDate() {
        click(submitButton);
        return this;
    }

    /**
     * Switch to alert and get it's message
     */
    public String getAlertText() {
        Alert alert = switchToAlert();
        String alertText = alert.getText();
        log.info("Alert says: " + alertText);
        return alertText;
    }
}
