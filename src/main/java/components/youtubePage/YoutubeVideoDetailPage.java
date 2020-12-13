package components.youtubePage;

import helpers.CustomElementWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class YoutubeVideoDetailPage {
    protected static WebDriver driver;
    By videoTitlePath = By.xpath("//h1[contains(@class,'title')]");
    private List<WebElement> videoTitleElement;

    public YoutubeVideoDetailPage(WebDriver driver) {
        YoutubeVideoDetailPage.driver = driver; //this.driver=driver;
    }

    private WebElement getVideoTitleElement() {
        CustomElementWait.waitUntilElementToClickable(driver, videoTitlePath);
        return driver.findElement(videoTitlePath);
    }

    public String getVideoTitle() {
        return getVideoTitleElement().getText();
    }

}
