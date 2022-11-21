package helper.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Objects;

public class Driver {
    private Driver(){}

    public static void initDriver(){
        if(Objects.isNull(DriverManager.getDriver())){
            WebDriver driver= WebDriverManager.chromedriver().create();
            DriverManager.setDriver(driver);
            DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            DriverManager.getDriver().get("https://qdpm.net/demo/9.2/");

        }
    }
    public static void quitDriver(){
        if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
