import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;

public class TestSpyurAM extends BaseTest {

    private HomePage homePage;
    private SearchPage searchPage;

    @BeforeMethod
    public void init() {
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
    }

    @SneakyThrows
    @Test
    public void searchSomething() {
        homePage.get();
        homePage.doASearch("ալա");
        homePage.doASearch("asdkjkjhasd");
        homePage.doASearch("gashgdhga");
        Assert.assertTrue(homePage.getCurrentURL().contains("search"));

    }

    @SneakyThrows
    @Test
    public void searchSomething1() {
        homePage.get();
        homePage.doASearch("bala");
        homePage.doASearch("asdkjkjhasd");
        homePage.doASearch("gashgdhga");
        Assert.assertTrue(homePage.getCurrentURL().contains("search"));

    }
}
