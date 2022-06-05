package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@name='company_name']")
    private WebElement whatToSearch;

    @FindBy(xpath = "//input[@name='addres']")
    private WebElement location;

    @FindBy(xpath = "//button[@type='submit']")
    private volatile WebElement submit;

    @Override
    public String getURL() {
        return "https://www.spyur.am/am/home";
    }

    public void doASearch(String whatToSearch, String whereToSearch) {
        this.location.sendKeys(whereToSearch);
        searchHelper(whatToSearch);
    }

    public void doASearch(String whatToSearch) {
        searchHelper(whatToSearch);
    }

    private synchronized void searchHelper(String whatToSearch) {
        this.whatToSearch.clear();
        this.whatToSearch.sendKeys(whatToSearch);
        this.submit.click();
    }
}
