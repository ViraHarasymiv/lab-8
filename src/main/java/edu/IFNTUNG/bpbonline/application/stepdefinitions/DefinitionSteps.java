package edu.IFNTUNG.bpbonline.application.stepdefinitions;

import edu.IFNTUNG.bpbonline.application.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {
    protected WebDriver driver;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("User opens {string} page")
    public void openUrl(String url){
        new HomePage(driver).openHomePge(url);
    }

    @And("User clicks on the Categories Hardware's menu of the left sidebar")
    public void clickOnHardwareMenu(){
        new HomePage(driver).clickOnHardwareMenu();
    }

    @When("User clicks on the first item of the new products")
    public void clickOnFirstProductItem(){
        new ProductsPage(driver).clickOnFirstProductItem();
    }

    @And("User clicks on the Add to Cart button")
    public void clickOnAddToCartButton(){
        new ProductItemPage(driver).clickOnAddToCartButton();
    }

    @And("User types the value of the item's count equals {string}")
    public void typeItemsQuantity(String itemQuantity){
        new CartPage(driver).typeItemsQuantity(itemQuantity);
    }

    @And("User checks {string} and clicks on the Update button")
    public void clickOnUpdateButton(String itemQuantity){
        new CartPage(driver).clickOnUpdateButton(itemQuantity);
    }

    @Then("User checks that the item's price in the cart is equal to the {string}")
    public void checkPriceInCart(String totalPrice) {
        Assert.assertTrue(new CartPage(driver).getTotalPriceInCart().equals(totalPrice));
    }

    @And("User clicks on the My Account button in the Home page")
    public void clickOnMyAccountMenu(){
        new HomePage(driver).clickOnMyAccountMenu();
    }

    @And("User clicks on the Continue button")
    public void clickOnContinueButton(){
        new LoginPage(driver).clickOnContinueButton();
    }

    @And("User checks the Male radio button")
    public void clickOnMaleRadioButton(){
        new CreateAccountPage(driver).clickOnMaleRadioButton();
    }

    @And("User types the first name {string} in the First Name field and the last name {string} in the Last Name field")
    public void enterUserFirstAndLastName(String firstUserName, String lastName){
        new CreateAccountPage(driver).enterUserFirstAndLastName(firstUserName,lastName);
    }

    @And("User selects the date of birth {string} in the Date of Birth's dropdown list")
    public void enterUserBirthDay(String birthDate){
        new CreateAccountPage(driver).enterUserBirthDay(birthDate);
    }

    @And("User types e-mail address in the E-Mail Address field with length equals {string}")
    public void enterUserEmail(String fix_length){
        new CreateAccountPage(driver).enterUserEmail(fix_length);
    }

    @And("User types company name {string} in the Company Name field")
    public void enterCompanyName(String company){
        new CreateAccountPage(driver).enterCompanyName(company);
    }

    @And("User types street address {string} in the Street Address field and the post code {string} in the Post Code field")
    public void enterStreetAddressAndPostCode(String streetAddress, String postCode){
        new CreateAccountPage(driver).enterStreetAddressAndPostCode(streetAddress,postCode);
    }

    @And("User types city {string} in the City field and the state {string} in the State field")
    public void enterUserCityAndState(String city, String state) {
        new CreateAccountPage(driver).enterUserCityAndState(city,state);
    }

    @And("User selects the country {string} from the Country dropdown list")
    public void selectCountry(String country){
        new CreateAccountPage(driver).selectCountry(country);
    }

    @And("User types the telephone number {string} in the Telephone Number field")
    public void enterTelephoneNumber(String telephoneNumber){
        new CreateAccountPage(driver).enterTelephoneNumber(telephoneNumber);
    }

    @And("User checks the Newsletter checkbox")
    public void checkNewsLetterCheckBox(){
        new CreateAccountPage(driver).checkNewsLetterCheckBox();
    }

    @And("User types the password {string} in the Password field and in the Password Confirmation field")
    public void createPassword(String password){
        new CreateAccountPage(driver).createPassword(password);
    }

    @When("User submits entered valid information")
    public void submitEnteredInformationWithValidData(){
        new CreateAccountPage(driver).submitEnteredInformationWithValidData();
    }

    @Then("User checks the message {string} about successful registration and the URL of Account Success Page {string}")
    public void checkMessageAboutSuccessfulRegistration(String message, String expectedUrl){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new AccountSuccessPage(driver).getActualMessage().contains(message));
        softAssert.assertTrue(new AccountSuccessPage(driver).getCurrentUrl().contains(expectedUrl));
        softAssert.assertAll();
    }

    @When("User submits entered invalid information")
    public void submitEnteredInformationWithInValidDate(){
        new CreateAccountPage(driver).submitEnteredInformationWithInValidDate();
    }

    @Then("User checks the message {string} about error registration")
    public void checkErrorMessage(String errorMessage){
        Assert.assertTrue(new CreateAccountPage(driver).getAlertText().trim().contains(errorMessage),
                "Actual message is "+ new CreateAccountPage(driver).getAlertText() + ", but must be " + errorMessage);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
