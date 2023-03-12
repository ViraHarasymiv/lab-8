package edu.IFNTUNG.bpbonline.createAccountTests;

import edu.IFNTUNG.bpbonline.application.pages.AccountSuccessPage;
import edu.IFNTUNG.bpbonline.application.pages.HomePage;
import edu.IFNTUNG.bpbonline.asserts.Asserts;
import edu.IFNTUNG.bpbonline.runners.BaseTest;
import edu.IFNTUNG.bpbonline.utils.ConfigReader;
import edu.IFNTUNG.bpbonline.utils.CsvDataProviders;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * This class contains user's automated steps for creating the new account with the valid data.
 *
 * @author Vira Harasymiv
 */
@Epic("Create new Account")
@Story("Positive tests")
public class PositiveCreateAccountTest extends BaseTest {
    private static final String EXPECTED_URL = ConfigReader.get().getAccountSuccessPageUrl();

    @Description("Verify the new account's creating with valid data")
    @Severity(SeverityLevel.CRITICAL)
    @Issue(value = "2")
    @Test(dataProvider = "csvReader",dataProviderClass = CsvDataProviders.class)
    public void positiveCreateAccountTest(Map<String,String> testData) {
        String number = testData.get("number");
        String firstName = testData.get("firstName");
        String lastName = testData.get("lastName");
        String birthDay = testData.get("birthDay");
        String fixLength = testData.get("fixLength");
        String company = testData.get("company");
        String streetAddress = testData.get("streetAddress");
        String postCode = testData.get("postCode");
        String city = testData.get("city");
        String state = testData.get("state");
        String country = testData.get("country");
        String telephoneNumber = testData.get("telephoneNumber");
        String password = testData.get("password");
        String message = testData.get("message");

        log.info("Starting Create Account Test with valid data #" + number);
        AccountSuccessPage accountSuccessPage = new HomePage(driver, log)
                .clickOnMyAccountMenu()
                .clickOnContinueButton()
                .clickOnMaleRadioButton()
                .enterUserFirstAndLastName(firstName,lastName)
                .enterUserBirthDay(birthDay)
                .enterUserEmail(fixLength)
                .enterCompanyName(company)
                .enterStreetAddressAndPostCode(streetAddress, postCode)
                .enterUserCityAndState(city, state)
                .selectCountry(country)
                .enterTelephoneNumber(telephoneNumber)
                .checkNewsLetterCheckBox()
                .createPassword(password)
                .submitEnteredInformationWithValidData();
        String actualMessage = accountSuccessPage.getActualMessage(message);
        String actualUrl = accountSuccessPage.getCurrentUrl();
        Asserts.checkMessageAboutSuccessfulRegistration(actualMessage,message,actualUrl, EXPECTED_URL);
    }
}
