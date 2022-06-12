import driverprovider.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    WebDriver driver;

    @Parameters("driverName")
    @BeforeTest
    public void setUpTest(@Optional("chrome") String driverName) {
        WebDriverProvider webDriverProvider = new WebDriverProvider();
        driver = webDriverProvider.getDriver(driverName);
    }

    @AfterTest
    @Parameters("driverName")
    public void tearDown(String driverName) throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
