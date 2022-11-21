package helper.pages.page;

import helper.enums.WaitStrategy;
import helper.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage extends Page{
    @Override
    protected void sendKeys(By by, String value, String fieldName) {
        try{
            WebElement element= ExplicitWaitFactory.PerformExplicit(by, WaitStrategy.VISIBLE);
            element.sendKeys(value);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void click(By by, String fieldName) {
        try{
            WebElement element=ExplicitWaitFactory.PerformExplicit(by,WaitStrategy.CLICKABLE);
            element.click();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected boolean isDisplay(By by, String fieldName) {
        try{
            WebElement element=ExplicitWaitFactory.PerformExplicit(by,WaitStrategy.VISIBLE);
            element.isDisplayed();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
