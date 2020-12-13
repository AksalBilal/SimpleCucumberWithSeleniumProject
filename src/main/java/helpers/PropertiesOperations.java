package helpers;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesOperations {

    public static String ReadDataFromProperties(String key) throws IOException {
        try {
            FileReader reader=new FileReader("D:\\SimpleCucumberWithSeleniumProject\\src\\main\\resources\\constant.properties");

            Properties p=new Properties();
            p.load(reader);
            return p.getProperty(key);
        }
        catch (IOException ex ) {
           throw new IOException(ex);
        }
    }
}
