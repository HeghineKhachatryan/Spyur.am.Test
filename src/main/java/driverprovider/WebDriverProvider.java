package driverprovider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class WebDriverProvider {

    private volatile static WebDriver chromeDriver;
    private volatile static WebDriver firefoxDriver;
    public volatile static String parameter;

    private WebDriverProvider() {
    }

    public static WebDriver getDriver(String driverName) {
            parameter = driverName;
        if (driverName.equalsIgnoreCase("chrome")) {
            if (chromeDriver == null) {
                synchronized (WebDriverProvider.class) {
                    if (chromeDriver == null) {
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--start-maximized");
                        options.addArguments("--incognito");
                        chromeDriver = new ChromeDriver(options);
                    }
                }
            }
            return chromeDriver;
        } else if (driverName.equalsIgnoreCase("firefox") ||
                driverName.equalsIgnoreCase("mozila")) {
            if (firefoxDriver == null) {
                synchronized (WebDriverProvider.class) {
                    if (firefoxDriver == null) {
                        WebDriverManager.firefoxdriver().setup();
                        FirefoxOptions options = new FirefoxOptions();
                        options.addArguments("start-maximized");
                        options.addArguments("incognito");
                        firefoxDriver = new FirefoxDriver();
                    }
                }
            }
            return firefoxDriver;
        } else {
            throw new IllegalArgumentException("No such driver to open. Name of the driver is incorrect. Check it");
        }
    }

    public static void quitDriver(String driverName) {
        if (driverName.equalsIgnoreCase("chrome")) {
            chromeDriver.quit();
            chromeDriver = null;
        } else if (driverName.equalsIgnoreCase("firefox") ||
                driverName.equalsIgnoreCase("mozila")) {
            firefoxDriver.quit();
            firefoxDriver = null;
        } else {
            throw new IllegalArgumentException("No such driver to quit. Name of the driver is incorrect. Check it");
        }
    }
}
