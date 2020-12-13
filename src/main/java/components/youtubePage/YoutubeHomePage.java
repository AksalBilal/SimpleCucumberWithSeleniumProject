package components.youtubePage;

import helpers.CustomElementWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YoutubeHomePage {
    protected static WebDriver driver;
    By searchInputElementPath = By.xpath("//input[@id='search']");
    By searchButtonElementPath = By.xpath("//button[@id='search-icon-legacy']");
    private WebElement searchInputElement;
    private WebElement searchButtonElement;

    public YoutubeHomePage(WebDriver driver) {
        YoutubeHomePage.driver = driver; //this.driver=driver;
    }

    private WebElement getSearchInputElement() {
        CustomElementWait.waitUntilElementToClickable(driver, searchInputElementPath);
        return driver.findElement(searchInputElementPath);
    }

    private WebElement getSearchButtonElement() {
        CustomElementWait.waitUntilElementToClickable(driver, searchButtonElementPath);
        return driver.findElement(searchButtonElementPath);
    }

    public void clickSearchButton() {
        getSearchButtonElement().click();
    }

    public void searchValue(String value) {
        getSearchInputElement().sendKeys(value);
    }

}
