import driverprovider.WebDriverProvider;
import helperclasses.WaitHelper;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.annotations.*;

public class BaseTest {

    @Parameters("driverName")
    @BeforeMethod
    public void setUpMethod(@Optional("chrome") String driverName) {
        WebDriverProvider.getDriver(driverName);
    }

    @Parameters("driverName")
    @BeforeMethod()
    public void openNewWindow(String driverName) {
        if (driverName.equalsIgnoreCase("chrome")) {
            openNewWindowForChrome();
        } else if (driverName.equalsIgnoreCase("firefox")) {
            openNewTabForFirefox();
        }
    }

    private void openNewWindowForChrome() {
        WebDriverProvider.getDriver("chrome").switchTo().newWindow(WindowType.WINDOW);
    }

    private void openNewTabForFirefox() {
        WebDriverProvider.getDriver("firefox").switchTo().newWindow(WindowType.TAB);
    }

    @AfterMethod
    @Parameters("driverName")
    public void tearDown(String driverName) throws InterruptedException {
        Thread.sleep(3000);
        WebDriverProvider.quitDriver(driverName);
    }
}
