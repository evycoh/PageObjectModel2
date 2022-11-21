package helper.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private static ThreadLocal<WebDriver> driverInstance =new ThreadLocal<>();

    public static void setDriver(WebDriver driver){
        driverInstance.set(driver);
    }
    public static WebDriver getDriver(){
        return  driverInstance.get();
    }
    public static void unload(){
        driverInstance.remove();
    }
}
