package edu.IFNTUNG.bpbonline.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class BPBOnlineTests {
    private WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod
    private void setUp(@Optional("chrome") String browser) {
        // Create driver
        System.out.println("Create driver: " + browser);

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                System.out.println("Do not know how to start: " + browser + ", starting chrome.");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
    }

    @Parameters({"itemCount"})
    @Test
    public void checkItemPriceInCart(String itemCount) {
        System.out.println("Starting checkItemPriceInCart test");

        // open main page
        String url = "http://practice.bpbonline.com/index.php";
        driver.get(url);
        System.out.println("Home page is opened");

        //click on the hardware menu
        driver.findElement(By.xpath("//a[contains(text(), 'Hardware')]")).click();

        // click on the keyboard
        driver.findElement(By.xpath("//div[@class='contentText']//a[contains(text(), 'Microsoft Internet Keyboard')]")).click();

        //Get the item's price
        String expectedItemPrice = driver.findElement(By.xpath("//form[@name='cart_quantity']//h1[contains(text(),'$')]")).getText().replace("$", "");
        System.out.println("Expected price  is equal to " + expectedItemPrice);

        //put the keyboard to the cart
        driver.findElement(By.xpath("//span[text()='Add to Cart']")).click();

        //Change item's count in the cart
        driver.findElement(By.xpath("//input[@name='cart_quantity[]']")).clear();
        driver.findElement(By.xpath("//input[@name='cart_quantity[]']")).sendKeys(itemCount);

        //Click on the Update button
        driver.findElement(By.xpath("//span[contains(text(),'Update')]")).click();

        //wait to the item's count appeared
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions
                        .attributeToBe(By.xpath("//input[@name='cart_quantity[]']"), "value", itemCount));

        //Get the item's price in the cart
        String actualTotalItemPrice = driver.findElement(By.xpath("//strong[contains(text(), 'Sub-Total')]")).getText().replaceAll("[^0-9.]", "");
        System.out.println("Actual total price in the cart is equal to " + actualTotalItemPrice);

        float actualItemsPrice = Float.parseFloat(actualTotalItemPrice);
        float expectedItemsPrice = Float.parseFloat(expectedItemPrice) * Float.parseFloat(itemCount);

        //Check actual and expected prices
        Assert.assertEquals(actualItemsPrice, expectedItemsPrice);
    }

    @AfterMethod
    private void tearDown() {
        System.out.println("Close driver");
        // Close browser
        if(driver != null){
            driver.quit();
        }
    }
}

