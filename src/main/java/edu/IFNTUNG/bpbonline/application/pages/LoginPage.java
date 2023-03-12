package edu.IFNTUNG.bpbonline.application.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(), 'Continue')]")
    private WebElement continueButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Open Create Account Page by clicking on the Continue button
     */
    public CreateAccountPage clickOnContinueButton() {
        click(continueButton);
        return new CreateAccountPage(driver);
    }
}
