package pages;

import core.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage() {
        driver = WebDriverProvider.getDriver();
        PageFactory.initElements(driver, this);
    }


    public String getURL() {
        return "";
    }


    public void get() {
        driver.get(getURL());
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }
}
