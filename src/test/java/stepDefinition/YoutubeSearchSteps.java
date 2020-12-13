package stepDefinition;

import base.BaseClass;
import components.youtubePage.YoutubeHomePage;
import components.youtubePage.YoutubeSearchPage;
import components.youtubePage.YoutubeVideoDetailPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

import static org.hamcrest.Matchers.is;


public class YoutubeSearchSteps extends BaseClass {

    String expectedVideoTitle;
    YoutubeHomePage youtubeHomePage;
    YoutubeSearchPage youtubeSearchPage;
    YoutubeVideoDetailPage youtubeVideoDetailPage;

    @Before
    public void beforeMethod() throws IOException {
        super.beforeMethod();
        youtubeHomePage = new YoutubeHomePage(seleniumDriver);
        youtubeSearchPage = new YoutubeSearchPage(seleniumDriver);
        youtubeVideoDetailPage = new YoutubeVideoDetailPage(seleniumDriver);
        // Test cases run once at the beginning without running
    }

    @After
    public void AfterMethod() {
        //Test cases enter and end hereafter they all run.
        super.afterMethod();

    }

    @Given("Go to Youtube homepage")
    public void goToYoutubeHomepage() {
        seleniumDriver.get("https://www.youtube.com/");
    }

    @When("Find the input field and enter {string}")
    public void findTheInputFieldAndEnter(String searchValue) {
        youtubeHomePage.searchValue(searchValue);
    }

    @And("Click the Search button")
    public void clickTheSearchButton() {
        youtubeHomePage.clickSearchButton();
    }

    @Then("Click on {int}. video for the results")
    public void clickOnVideoForTheResults(int desiredVideoLocation) {
        expectedVideoTitle = youtubeSearchPage.getDesiredVideoTitle(desiredVideoLocation);
        youtubeSearchPage.ClickDesiredVideo(desiredVideoLocation);
    }

    @And("Compare the title of the opened video with the title you expect")
    public void compareTheTitleOfTheOpenedVideoWithTheTitleYouExpect() {
        String actualVideoTitle = youtubeVideoDetailPage.getVideoTitle();
        Assert.assertThat(actualVideoTitle, is(actualVideoTitle));
    }
}
