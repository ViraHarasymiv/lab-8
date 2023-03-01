import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * It's the example of the seventh lab
 *
 * @author Vira Harasymiv
 */
public class Example {

        public static void main(String[] args) {
            // Specify the location of chromedriver
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Harasymiv\\chromedriver.exe");
            // Create a new instance of the ChromeDriver
            WebDriver driver = new ChromeDriver();
            // Open page
            driver.get("https://www.google.com/");
            // Find the Search field by using XPath
            WebElement searchField = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
            // Type the word
            searchField.sendKeys("Студент");
            //Submit
            searchField.submit();
            //Quit this driver
            driver.quit();
        }
    }

