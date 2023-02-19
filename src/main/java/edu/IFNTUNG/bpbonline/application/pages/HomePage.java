package edu.IFNTUNG.bpbonline.application.pages;

import edu.IFNTUNG.bpbonline.application.pages.sections.header.Header;
import edu.IFNTUNG.bpbonline.application.pages.sections.leftSideBar.LeftSideBar;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private Header header;
    private LeftSideBar leftSideBar;

    public HomePage(WebDriver driver, Logger log) {
        super(driver, log);
        header = new Header(driver, log);
        leftSideBar = new LeftSideBar(driver, log);
    }

    public Header getHeader() {
        return header;
    }

    public LeftSideBar getLeftSideBar() {
        return leftSideBar;
    }
}
