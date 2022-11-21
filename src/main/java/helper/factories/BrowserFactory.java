package helper.factories;

import helper.enums.ConfigProperties;
import helper.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BrowserFactory {
    private BrowserFactory(){}
    private static WebDriver driver=null;


    public static WebDriver  setBrowser()  {
        String browser= PropertyUtils.getValue(ConfigProperties.BROWSER);
        if(browser.equalsIgnoreCase("chrome")){
            driver=WebDriverManager.chromedriver().create();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            driver=WebDriverManager.firefoxdriver().create();
        }
        else{
            try {
                throw new IllegalAccessException("Driver is not set Properly");
            } catch (IllegalAccessException e) {
                throw new RuntimeException();
            }
        }return driver;
    }


}
