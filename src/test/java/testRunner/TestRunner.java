package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "D:\\SimpleCucumberWithSeleniumProject\\src\\main\\java\\features", glue = {"stepDefinition"}, plugin = {"helpers.TestListener", "junit:target/cucumber-reports/Cucumber.xml"}, publish = true)
public class TestRunner {

}
