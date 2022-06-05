import driverprovider.WebDriverProvider;
import helperclasses.ActionHelper;
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
    public void searchSomething() {
        homePage.get();
        homePage.doASearch("ալա");
        Assert.assertTrue(homePage.getCurrentURL().contains("search"));
        System.out.println("searchSomething() method has completed successfully for " + WebDriverProvider.parameter);
    }

    @Test
    public void findCurrentPageResultsNumber() {
        homePage.get();
        homePage.doASearch("ալա");
        Assert.assertEquals(20, searchPage.getCurrentPageResultCount());
        System.out.println("findCurrentPageResultsNumber() method has completed successfully for "
                + WebDriverProvider.parameter);
    }

    @Test
    public void testAddingDataToDB() {
        homePage.get();
        homePage.doASearch("ծրագրավորում","Գյումրի");
        searchPage.collectDataFromPageAddToDB();
    }

    @Test
    public void testElementText() {
        homePage.get();
        homePage.doASearch("ծրագրավորում");
        WebElement elementByIndex = searchPage.getElementByIndex(6);
        Assert.assertTrue(elementByIndex.getText().contains("«ԴԻՄԱՐԿ» ԻՆՏԵՐՆԵՏ-ՄԱՐԿԵՏԻՆԳԱՅԻՆ ԸՆԿԵՐՈՒԹՅՈՒՆ"),
                "Text should contain -> «ԴԻՄԱՐԿ» ԻՆՏԵՐՆԵՏ-ՄԱՐԿԵՏԻՆԳԱՅԻՆ ԸՆԿԵՐՈՒԹՅՈՒՆ");
        System.out.println("testElementText() method has completed successfully for " + WebDriverProvider.parameter);
    }

    @Test
    public void testScrolling() {
        homePage.get();
        homePage.doASearch("ծրագրավորում");
        WebElement elementByIndex = searchPage.getElementByIndex(6);
        ActionHelper.scrollToMiddle(elementByIndex);
        System.out.println("testScrolling() method has completed successfully for " + WebDriverProvider.parameter);
    }

    @Test
    public void testHighlighting() {
        homePage.get();
        homePage.doASearch("ծրագրավորում");
        WebElement elementByIndex = searchPage.getElementByIndex(6);
        ActionHelper.scrollToMiddle(elementByIndex);
        ActionHelper.highlightElement(elementByIndex);
        System.out.println("testHighlighting() method has completed successfully for " + WebDriverProvider.parameter);
    }

}
