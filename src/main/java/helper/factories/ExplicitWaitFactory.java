package helper.factories;

import helper.constants.FrameworkConstants;
import helper.driver.DriverManager;
import helper.enums.WaitStrategy;
import org.openqa.selenium.By;;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ExplicitWaitFactory {
    private ExplicitWaitFactory() {
    }

    public static WebElement PerformExplicit(By by, WaitStrategy waitStrategy) {
        WebElement element = null;
        if (waitStrategy == WaitStrategy.CLICKABLE) {
            element=getWait().until(ExpectedConditions.elementToBeClickable(by));
        }
        else if(waitStrategy==WaitStrategy.PRESENCE){
            element=getWait().until(ExpectedConditions.presenceOfElementLocated(by));
        }
        else if(waitStrategy==WaitStrategy.VISIBLE){
            element=getWait().until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        else if(waitStrategy==WaitStrategy.NONE){
            element=DriverManager.getDriver().findElement(by);
        }
        return element;
    }
    public static List<WebElement> PerformExplicit(By by){
        List<WebElement>list=getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return list;
    }


    protected  static WebDriverWait getWait(){
        WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()));
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchElementException.class);
        wait.pollingEvery(Duration.ofMillis(FrameworkConstants.getExplicitMilliSecWait()));
        return wait;

    }
}
