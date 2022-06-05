package helperclasses;

import driverprovider.WebDriverProvider;
import org.openqa.selenium.WebDriver;

public final class WebDriverTypeChecker {

    private WebDriverTypeChecker() {
    }

    public static WebDriver checkDriverType() {
        if (WebDriverProvider.parameter.equalsIgnoreCase("chrome")) {
           return WebDriverProvider.getDriver("chrome");
        } else if (WebDriverProvider.parameter.equalsIgnoreCase("firefox")) {
            return WebDriverProvider.getDriver("firefox");
        } else {
            throw new IllegalArgumentException("No such driver. Name of the driver is incorrect. Check it");
        }
    }

}
