package edu.IFNTUNG.bpbonline.application.pages.sections.addressDetailsComponent;

import edu.IFNTUNG.bpbonline.application.locators.createAccountPageLocators.CreateAccountPageLocators;
import edu.IFNTUNG.bpbonline.application.pages.BasePage;
import edu.IFNTUNG.bpbonline.application.pages.sections.contactInformationComponent.ContactInformationComponent;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddressDetailsComponent extends BasePage {
    private By streetAddressField = CreateAccountPageLocators.STREET_ADDRESS_FIELD.getPath();
    private By postCodeField = CreateAccountPageLocators.POST_CODE_FIELD.getPath();
    private By cityField = CreateAccountPageLocators.CITY_FIELD.getPath();
    private By stateField = CreateAccountPageLocators.STATE_FIELD.getPath();
    private By selectCountryMenu = CreateAccountPageLocators.SELECT_COUNTRY_MENU.getPath();
    public AddressDetailsComponent(WebDriver driver, Logger log) {
        super(driver, log);
    }
    /**
     * Type the user's street address and the post code
     */
    public AddressDetailsComponent enterStreetAddressAndPostCode(String streetAddress, String postCode) {
        type(streetAddress, streetAddressField);
        type(postCode, postCodeField);
        return this;
    }

    /**
     * Type the user's city and state
     */
    public AddressDetailsComponent enterUserCityAndState(String city, String state) {
        type(city, cityField);
        type(state, stateField);
        return this;
    }

    /**
     * Select the user's country
     */
    public ContactInformationComponent selectCountry(String country) {
        WebElement dropdownElement = find(selectCountryMenu);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(country);
        return new ContactInformationComponent(driver,log);
    }
}
