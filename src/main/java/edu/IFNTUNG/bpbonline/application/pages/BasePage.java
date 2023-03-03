package edu.IFNTUNG.bpbonline.application.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    private static final long TIME_TO_WAIT = 60;
    protected WebDriver driver;
    protected Logger log;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_TO_WAIT));
    }

    /**
     * Wait for given number of seconds for element becomes visible
     * on the page
     */
    protected void waitForVisibilityOfElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Wait for given number of seconds for the attribute value in the element
     */
    protected void waitForAttributeToBeInElement(By locator, String attribute, String value) {
        wait.until(ExpectedConditions.attributeToBe(locator,attribute,value));
        }

    /**
     * Wait for given number of seconds for the text becomes visible in the element
     */
    protected void waitForTextToBePresentInElement(By locator, String text) {
        wait.until(ExpectedConditions.textToBe(locator,text));
    }

    /** Find element using given locator */
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    /** Find elements using given locator */
    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    /**
     * Click on element when it's visible
     */
    protected void click(By locator) {
        waitForVisibilityOfElement(locator);
        find(locator).click();
    }

    /**
     * Type given text into element
     */
    protected void type(String text, By locator) {
        waitForVisibilityOfElement(locator);
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    /**
     * Get the item's price
     */
    protected String getItemPrice(By locator) {
        waitForVisibilityOfElement(locator);
        return find(locator).getText().replaceAll("[^0-9.]", "");
    }

    /**
     * Select the required data in the calendar
     */
    protected void selectDate(String date, By locator) {
        waitForVisibilityOfElement(locator);
        find(locator).sendKeys(date);
        find(locator).sendKeys(Keys.RETURN);
    }

    /**
     * Get the element's text
     */
    protected String getText(By locator, String text) {
        waitForTextToBePresentInElement(locator, text);
        return find(locator).getText();
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
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }
}

