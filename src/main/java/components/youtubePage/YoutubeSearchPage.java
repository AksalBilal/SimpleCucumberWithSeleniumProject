package components.youtubePage;

import helpers.CustomElementWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class YoutubeSearchPage {
    protected static WebDriver driver;
    By videoTitlesPath = By.xpath("//a[@id='video-title']");
    private List<WebElement> videoTitlesElements;

    public YoutubeSearchPage(WebDriver driver) {
        YoutubeSearchPage.driver = driver; //this.driver=driver;
    }

    private List<WebElement> getVideoTitlesElements() {
        CustomElementWait.waitUntilElementToClickable(driver, videoTitlesPath);
        return driver.findElements(videoTitlesPath);
    }

    private WebElement findElementInDesiredVideoLocation(int desiredVideoLocation) {
        return driver.findElements(By.xpath("//a[@id='video-title']")).get(desiredVideoLocation - 1);
    }

    public void ClickDesiredVideo(int desiredVideoLocation) {
        findElementInDesiredVideoLocation(desiredVideoLocation).click();
    }

    public String getDesiredVideoTitle(int desiredVideoLocation) {
        return getVideoTitlesElements().get(desiredVideoLocation - 1).getAttribute("title");
    }


}