package base;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static helpers.ScreenShoot.DeleteOldScreenShoot;

public class BaseClass {
    protected static WebDriver seleniumDriver;

    public void beforeMethod() throws IOException {
        DeleteOldScreenShoot();
        System.setProperty("webdriver.chrome.driver", "D:\\SimpleCucumberWithSeleniumProject\\src\\main\\java\\Resources\\driver\\chromedriver.exe");
        seleniumDriver = new ChromeDriver();
        seleniumDriver.manage().window().maximize();
    }

    public void afterMethod() {

        seleniumDriver.quit();
    }

}
