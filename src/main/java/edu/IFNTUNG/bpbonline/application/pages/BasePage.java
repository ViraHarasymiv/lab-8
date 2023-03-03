package edu.IFNTUNG.bpbonline.application.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private static final long TIME_TO_WAIT = 60;
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /**
     * Wait for given number of seconds for element becomes visible
     * on the page
     */
    protected void waitForVisibilityOfElement(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(TIME_TO_WAIT)).until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait for given number of seconds for the attribute value in the element
     */
    protected void waitForAttributeToBeInElement(WebElement element, String attribute, String value) {
        new WebDriverWait(driver, Duration.ofSeconds(TIME_TO_WAIT))
                .until(ExpectedConditions.attributeToBe(element,attribute,value));
        }

    /**
     * Wait for given number of seconds for the text becomes visible in the element
     */
    protected void waitForTextToBePresentInElement(WebElement element, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(TIME_TO_WAIT))
                .until(ExpectedConditions.textToBePresentInElement(element,text));
    }

    /**
     * Click on element when it's visible
     */
    protected void click(WebElement element) {
        waitForVisibilityOfElement(element);
        element.click();
    }

    /**
     * Type given text into element
     */
    protected void type(String text, WebElement element) {
        waitForVisibilityOfElement(element);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Get the item's price
     */
    protected String getItemPrice(WebElement element) {
        waitForVisibilityOfElement(element);
        return element.getText().replaceAll("[^0-9.]", "");
    }

    /**
     * Select the required data in the calendar
     */
    protected void selectDate(String date, WebElement element) {
        waitForVisibilityOfElement(element);
        element.sendKeys(date);
        element.sendKeys(Keys.RETURN);
    }

    /**
     * Get the element's text
     */
    protected String getText(WebElement element) {
        return element.getText();
    }
    /**
     * Get URL of current page from browser
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Wait for alert present and then switch to it
     */
    protected Alert switchToAlert() {
        new WebDriverWait(driver, Duration.ofSeconds(TIME_TO_WAIT)).until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }
}

