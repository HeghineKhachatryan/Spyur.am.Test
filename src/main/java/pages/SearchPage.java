package pages;

import core.ActionHelper;
import core.WaitHelper;
import jdbc.DatabaseCreator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class SearchPage extends BasePage {

    @FindBy(xpath = "//div[@id='results_list_wrapper']/a")
    private List<WebElement> searchingResultList;

    @FindBy(xpath = "//div[@class='paging']//li//a[@class='next_page']")
    private WebElement nextPageNavigator;

    @FindBy(xpath = "//span[@class='result_info']//span[contains(@class, 'company_name')]")
    private List<WebElement> elementText;

    private final By nextPage = By.xpath("//div[@class='paging']//li//a[@class='next_page']");

    public int getCurrentPageResultCount() {
        return searchingResultList.size();
    }

    public long getAllResultsFromAllPages() {
        long count = 0L;
        while (isElementPresent(nextPage)) {
            count += getCurrentPageResultCount();
            ActionHelper.navigateToNextPage(nextPageNavigator, nextPage);
        }
        count += getCurrentPageResultCount();
        return count;
    }

    public void collectDataFromPageAddToDB() {
        DatabaseCreator db = new DatabaseCreator();
        while (isElementPresent(nextPage)) {
            for (int j = 0; j < getCurrentPageResultCount(); j++) {
                db.insertInto(elementText.get(j).getText(), searchingResultList.get(j).getAttribute("href"));
            }
            ActionHelper.navigateToNextPage(nextPageNavigator, nextPage);
        }
        for (int j = 0; j < getCurrentPageResultCount(); j++) {
            db.insertInto(elementText.get(j).getText(), searchingResultList.get(j).getAttribute("href"));
        }
    }

    public WebElement getElementByIndex(int index) {
        return searchingResultList.get(index);
    }

    private boolean isElementPresent(By element) {
        try {
            driver.findElement(element);
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
}
