import core.ActionHelper;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.SearchPage;

public class TestSpyurAM extends BaseTest {

    private HomePage homePage;
    private SearchPage searchPage;

    @BeforeMethod
    public void init() {
        homePage = new HomePage();
        searchPage = new SearchPage();
    }

    @Test
    public void testHomePage() {
        homePage.get();
        homePage.doASearch("ալա");
        Assert.assertTrue(homePage.getCurrentURL().contains("search"));
        Assert.assertEquals(20, searchPage.getCurrentPageResultCount());
        System.out.println(searchPage.getAllResultsFromAllPages());
    }

    @Test(groups = "database")
    public void testAddingDataToDB() {
        homePage.get();
        homePage.doASearch("ա");
        searchPage.collectDataFromPageAddToDB();
    }

    @Test(groups = {"func"}, alwaysRun = true)
    public void testScrolling() {
        homePage.get();
        homePage.doASearch("ծրագրավորում");
        WebElement elementByIndex = searchPage.getElementByIndex(6);
        ActionHelper.scrollToMiddle(elementByIndex);
        ActionHelper.highlightElement(elementByIndex);
    }
}
