package helperclasses;

import driverprovider.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class WaitHelper {
    private static WebDriver driver;

    private WaitHelper() {
    }

    public static void waitForElementToBePresent(By element) {
        driver = WebDriverTypeChecker.checkDriverType();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
}
