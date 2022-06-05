package helperclasses;

import driverprovider.WebDriverProvider;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public final class ActionHelper {
    private static WebDriver driver;

    private ActionHelper() {
    }

    public static void scrollPageDown() {
        driver = WebDriverTypeChecker.checkDriverType();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void scrollToMiddle(WebElement element) {
        driver = WebDriverTypeChecker.checkDriverType();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'})", element);
    }

    public static void navigateToNextPage(WebElement element, By by) {
        ActionHelper.scrollPageDown();
        WaitHelper.waitForElementToBePresent(by);
        element.click();
    }

    @SneakyThrows
    public static void highlightElement(WebElement element) {
        driver = WebDriverTypeChecker.checkDriverType();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border-color: red; border-width: 3px;" +
                " background-color: yellow;')", element);
        takeScreenshot();
        Thread.sleep(2000);
    }

    public static void takeScreenshot() {
        driver = WebDriverTypeChecker.checkDriverType();
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File output = screenshot.getScreenshotAs(OutputType.FILE);
        String pathToSaveFile = "src/screenshots/" + System.currentTimeMillis() + ".png";
        File file = new File(pathToSaveFile);
        try {
            FileUtils.copyFile(output, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
