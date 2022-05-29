import core.WebDriverProvider;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeMethod
    public void setUpMethod() {
        WebDriverProvider.getDriver();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverProvider.quitDriver();
    }
}
