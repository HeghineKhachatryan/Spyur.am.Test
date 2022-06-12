package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getURL() {
        return "https://www.spyur.am/";
    }

    public void get() {
        driver.get(getURL());
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }
}
