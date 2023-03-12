package edu.IFNTUNG.bpbonline.runners;

import edu.IFNTUNG.bpbonline.utils.ConfigReader;
import edu.IFNTUNG.bpbonline.utils.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;

@Listeners({TestListener.class})
public class BaseTest {
    private final String PAGE_URL = ConfigReader.get().getHomePageUrl();
    protected WebDriver driver;
    protected Logger log;

    protected String testSuiteName;
    protected String testName;
    protected String testMethodName;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, @Optional("chrome") String browser, ITestContext ctx) {
        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);
        BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
        driver = factory.createDriver();
        driver.get(PAGE_URL);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        this.testSuiteName = ctx.getSuite().getName();
        this.testName = testName;
        this.testMethodName = method.getName();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Close driver");
        // Close browser
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
