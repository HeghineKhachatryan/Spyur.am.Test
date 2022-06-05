package pages;

import driverprovider.WebDriverProvider;
import helperclasses.WebDriverTypeChecker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage() {
            driver = WebDriverTypeChecker.checkDriverType();
            PageFactory.initElements(driver, this);
    }

//    @Parameters("driverName")
//    private String getParam(@Optional("chrome") String driverName) {
//        return driverName;
//    }

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
