package edu.IFNTUNG.bpbonline.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class CreateAccountTest {
    private WebDriver driver;
    private static final String MESSAGE = "Your Account Has Been Created";

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

    @Test
    public void createAccountPositiveTest() {
        System.out.println("Starting checkItemPriceInCart test");

        // open main page
        String url = "http://practice.bpbonline.com/index.php";
        driver.get(url);
        System.out.println("Home page is opened");

        //Click on My Account button
        driver.findElement(By.xpath("//span[contains(text(), 'My Account')]")).click();

        //Click on Continue button
        driver.findElement(By.xpath("//span[contains(text(), 'Continue')]")).click();

        //Check the Male radio button
        driver.findElement(By.xpath("//input[@value='m']")).click();

        //Type the first name in the First Name field
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Test User First Name");

        //Type the last name in the Last Name field
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Test User Last Name");

        //Select the date of birth
        driver.findElement(By.xpath("//input[@class='hasDatepicker']")).sendKeys("07/30/1988");
        driver.findElement(By.xpath("//input[@class='hasDatepicker']")).sendKeys(Keys.RETURN);

        //Type e-mail address in the E-Mail Address field
        driver.findElement(By.xpath("//input[@name='email_address']")).sendKeys("user8266879@gmail.com");

        //Type company name in the Company Name field
        driver.findElement(By.xpath("//input[@name='company']")).sendKeys("TestUser Company");

        //Type street address in the Street Address field
        driver.findElement(By.xpath("//input[@name='street_address']")).sendKeys("TestUser street");

        //Type the post code in the Post Code field
        driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("12300");

        //Type city in the City field
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("User City");

        //Type the state in the State/Province field
        driver.findElement(By.xpath("//input[@name='state']")).sendKeys("User state");

        //Select the country from the dropdown list
        driver.findElement(By.xpath("//select[@name='country']")).click();

        driver.findElement(By.xpath("//option[contains(text(), 'Ukraine')]")).click();

        //Type the telephone number in the Telephone Number field
        driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys("+380661234590");

        // Check the Newsletter checkbox
        driver.findElement(By.xpath("//input[@name='newsletter']")).click();

        //Type the password in the Password field
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456789");

        //Type the password in the Password Confirmation field
        driver.findElement(By.xpath("//input[@name='confirmation']")).sendKeys("123456789");

        //Click on the Continue button
        driver.findElement(By.xpath("//span[contains(text(), 'Continue')]")).click();

        //Check the message about successful registration
        WebElement actualMessage = driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(actualMessage.getText().contains(MESSAGE));
    }

    @AfterMethod
    private void tearDown() {
        System.out.println("Close driver");
        // Close browser
        if (driver != null) {
            driver.quit();
        }
    }
}
