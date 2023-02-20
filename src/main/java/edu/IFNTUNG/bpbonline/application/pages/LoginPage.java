package edu.IFNTUNG.bpbonline.application.pages;

import edu.IFNTUNG.bpbonline.application.pages.sections.header.Header;
import edu.IFNTUNG.bpbonline.application.pages.sections.leftSideBar.LeftSideBar;
import edu.IFNTUNG.bpbonline.application.pages.sections.newCustomerComponent.NewCustomerComponent;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    private Header header;
    private LeftSideBar leftSideBar;
    private NewCustomerComponent newCustomerComponent;

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
        header = new Header(driver, log);
        leftSideBar = new LeftSideBar(driver, log);
        newCustomerComponent = new NewCustomerComponent(driver, log);
    }

    public NewCustomerComponent getNewCustomerComponent() {
        return newCustomerComponent;
    }
}
