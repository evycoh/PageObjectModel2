package helper.driver;

import helper.constants.FrameworkConstants;
import helper.enums.ConfigProperties;
import helper.factories.BrowserFactory;
import helper.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Objects;

public class Driver {
    private Driver(){}

    public static void initDriver(){
        if(Objects.isNull(DriverManager.getDriver())){
            DriverManager.setDriver(BrowserFactory.setBrowser());
            DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(FrameworkConstants.getPageLoadTime()));
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.getImplicitWait()));
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));

        }
    }
    public static void quitDriver(){
        if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
