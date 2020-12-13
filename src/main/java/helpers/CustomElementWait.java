package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomElementWait {
    public static void waitUntilElementFind(WebDriver driver, By path) {
        try {
            WebElement myDynamicElement = (new WebDriverWait(driver, TimeOut.MIDDLE.value))
                    .until(ExpectedConditions.presenceOfElementLocated(path));
        } catch (TimeoutException e) {
            // CAN DO : log
            throw e;
        }
    }

    public static void waitUntilElementToClickable(WebDriver driver, By path) {
        try {
            WebElement myDynamicElement = (new WebDriverWait(driver, TimeOut.MIDDLE.value))
                    .until(ExpectedConditions.elementToBeClickable(path));
        } catch (TimeoutException e) {
            // CAN DO : log
            throw e;
        }
    }

    public void waitElement(WebDriver driver, WebElement element, TimeOut timeOut) {
//CAN USE THIS FOR CASES
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut.value);
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception ignored) {

        }

    }


    public WebElement findElement(WebDriver driver, By path) {
//CAN USE THIS FOR CASES
        try {
            WebDriverWait wait = new WebDriverWait(driver, TimeOut.MIDDLE.value);
            WebElement element = null;
            element = wait.until(ExpectedConditions.presenceOfElementLocated((path)));
            return element;
        } catch (Exception ex) {
            System.out.println("find element method error" + ex.getMessage());
            return null;
        }
    }

    public enum TimeOut {
        LOW(5),
        MIDDLE(10),
        HIGH(15),
        CUSTOM_MAX(60);
        private final int value;

        TimeOut(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }
}
