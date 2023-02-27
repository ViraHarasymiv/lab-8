package edu.IFNTUNG.bpbonline.application.pages.sections.leftSideBar;

import edu.IFNTUNG.bpbonline.application.pages.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class LeftSideBar extends BasePage {
    private Categories categories;

    public LeftSideBar(WebDriver driver, Logger log) {
        super(driver, log);
        categories = new Categories(driver,log);
    }

    public Categories getCategories() {
        return categories;
    }
}
