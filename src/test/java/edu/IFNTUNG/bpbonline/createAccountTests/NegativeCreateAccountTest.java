package edu.IFNTUNG.bpbonline.createAccountTests;

import edu.IFNTUNG.bpbonline.application.pages.HomePage;
import edu.IFNTUNG.bpbonline.asserts.Asserts;
import edu.IFNTUNG.bpbonline.runners.BaseTest;
import edu.IFNTUNG.bpbonline.utils.CsvDataProviders;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.util.Map;
/**
 * This class contains user's automated steps for creating the new account with the invalid data.
 *
 * @author Vira Harasymiv
 */
@Epic("Create new Account")
@Story("Negative test")
public class NegativeCreateAccountTest extends BaseTest {

    @Description("Verify the new account's creating with invalid data")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, dataProvider = "csvReader",dataProviderClass = CsvDataProviders.class)
    public void negativeCreateAccountTest(Map<String,String> testData) {
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
        String description = testData.get("description");

        log.info("Starting Negative Create Account Test #" + number + " for " + description);

        String actualMessage = new HomePage(driver, log)
                .clickOnMyAccountMenu()
                .clickOnContinueButton()
                .clickOnMaleRadioButton()
                .enterUserFirstAndLastName(firstName, lastName)
                .enterUserBirthDay(birthDay)
                .enterUserEmail(fixLength)
                .enterCompanyName(company)
                .enterStreetAddressAndPostCode(streetAddress, postCode)
                .enterUserCityAndState(city, state)
                .selectCountry(country)
                .enterTelephoneNumber(telephoneNumber)
                .checkNewsLetterCheckBox()
                .createPassword(password)
                .submitEnteredInformationWithInValidDate()
                .getAlertText();
        Asserts.checkErrorMessage(actualMessage,message);
    }
}
