package helpers;

import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.TestStepFinished;
import io.cucumber.plugin.event.TestStepStarted;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import static helpers.PropertiesOperations.ReadDataFromProperties;

public class ScreenShoot {

    public static void TakeScreenShoot(WebDriver webdriver,Scenario scenario) {
        try {
            //çağrıldığı zaman screen shot çeker
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH mm ss SS");
            String date = simpleDateFormat.format(new Date());
            String imgName = "" + scenario.getName().toLowerCase().replace(" ", "_") + "(" + date + "_" + scenario.getStatus().toString() + ")_Selenium.png";
            BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            takeSnapShot(webdriver,imgName);
            ImageIO.write(image, "png", new File(ReadDataFromProperties("ScreenShootFolderPath") + imgName));
        } catch (IOException | AWTException exception) {
            exception.printStackTrace();
        }
    }

    public static void TakeScreenShoot(TestStepFinished event) {
        try {
            //çağrıldığı zaman screen shot çeker
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH mm ss SS");
            String date = simpleDateFormat.format(new Date());
            String imgName = "" + event.getTestCase().getName().toLowerCase().replace(" ", "_") + "(" + date + "_" + event.getResult().getStatus().toString() + ")_AfterTestCaseFinished.png";
            BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

            ImageIO.write(image, "png", new File(ReadDataFromProperties("ScreenShootFolderPath") + imgName));
        } catch (IOException | AWTException exception) {
            exception.printStackTrace();
        }
    }

    public static void TakeScreenShoot(TestStepStarted event) {
        try {
            //çağrıldığı zaman screen shot çeker
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH mm ss SS");
            String date = simpleDateFormat.format(new Date());
            String imgName = "" + event.getTestCase().getName().toLowerCase().replace(" ", "_") + "(" + date + ")_BeforeTestCaseStarted.png";
            BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            Properties test=System.getProperties();
            ImageIO.write(image, "png", new File(ReadDataFromProperties("ScreenShootFolderPath") + imgName));
        } catch (IOException | AWTException exception) {
            exception.printStackTrace();
        }
    }
    public static void takeSnapShot(WebDriver driver,String imgName){

       try {

           TakesScreenshot scrShot =((TakesScreenshot)driver);
           File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
           File DestFile=new File(ReadDataFromProperties("ScreenShootFolderPath")+imgName);
           FileUtils.copyFile(SrcFile, DestFile);
       }
       catch (Exception e){
           e.printStackTrace();
       }

    }

    public static void DeleteOldScreenShoot() throws IOException {
        //fonksiyon çağrıldığı zaman eski screenshoot kayıtlarını siler.
        File index = new File(ReadDataFromProperties("ScreenShootFolderPath"));
        String[] entries = index.list();
        if (entries.length > 0) {
            for (String s : entries) {
                File currentFile = new File(index.getPath(), s);
                currentFile.delete();
            }
        }
    }
}
