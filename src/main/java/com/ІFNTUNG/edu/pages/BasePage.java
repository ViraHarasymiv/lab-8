package com.ІFNTUNG.edu.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private static final long TIME_TO_WAIT = 60;
    protected WebDriver driver;
    protected Logger log;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver,  Logger log) {
        this.driver = driver;
        this.log = log;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_TO_WAIT));
        PageFactory.initElements(driver,this);
    }

    /**
     * Wait for given number of seconds for element becomes visible
     * on the page
     */
    protected void waitForVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait for given number of seconds for the text becomes visible in the element
     */
    protected void waitForTextToBePresentInElement(WebElement element, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(element,text));
    }

    /**
     * Click on element when it's visible
     */
    protected void click(WebElement element) {
        waitForVisibilityOfElement(element);
        element.click();
    }

    /**
     * Open page with given URL
     */
    protected void openUrl(String url) {
        driver.get(url);
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
    protected String getText(WebElement element, String text) {
        waitForTextToBePresentInElement(element, text);
        return element.getText();
    }
    /**
     * Get URL of current page from browser
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
