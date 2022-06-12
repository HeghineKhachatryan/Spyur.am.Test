package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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


    public SearchPage(WebDriver driver) {
        super(driver);
    }
}
