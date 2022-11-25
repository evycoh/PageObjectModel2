package helper.pages.page;

import helper.driver.DriverManager;
import helper.enums.WaitStrategy;
import helper.factories.ExplicitWaitFactory;
import helper.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class BasePage extends Page{
    @Override
    protected String getTitle() {
        String title = null;
        try{
             title= DriverManager.getDriver().getTitle();
            ExtentLogger.pass("Page Title: "+title);
        }catch (Exception e){
            e.printStackTrace();
            ExtentLogger.fail("Unable To Locate Page Title");
        }return title;
    }

    @Override
    protected void sendKeys(By by, String value, String fieldName) {
        try{
            WebElement element= ExplicitWaitFactory.PerformExplicit(by, WaitStrategy.VISIBLE);
            element.sendKeys(value);
            ExtentLogger.pass("Sent Keys to "+fieldName+":"+value);
        }catch (Exception e){
            e.printStackTrace();
            ExtentLogger.fail("Failed to send Keys to "+fieldName);
        }

    }

    @Override
    protected void click(By by, String fieldName) {
        try{
            WebElement element=ExplicitWaitFactory.PerformExplicit(by,WaitStrategy.CLICKABLE);
            element.click();
            ExtentLogger.pass("Clicked on "+fieldName);

        }catch (Exception e){
            e.printStackTrace();
            ExtentLogger.fail("Failed to click on "+fieldName);

        }

    }

    @Override
    protected boolean isDisplay(By by, String fieldName) {
        try{
            WebElement element=ExplicitWaitFactory.PerformExplicit(by,WaitStrategy.NONE);
            element.isDisplayed();
            ExtentLogger.pass(fieldName+" Is Displayed");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            ExtentLogger.fail(fieldName+" Is Not Displayed");
            return false;
        }
    }

    @Override
    protected void selectByVisibleTest(By by, String visibleText, String fieldName) {
        try{
            WebElement element=ExplicitWaitFactory.PerformExplicit(by,WaitStrategy.CLICKABLE);
            Select select=new Select(element);
            select.selectByVisibleText(visibleText);
            ExtentLogger.pass("Selected "+visibleText+" from "+fieldName+" dropdown");

        }catch (Exception e){
            e.printStackTrace();
            ExtentLogger.fail("Unable to Select "+visibleText+" from "+fieldName +" dropdown");
        }

    }

    @Override
    protected void selectMultipleCheckbox(By by, String fieldName, String... value) {
        try{
            ArrayList<String>arrayList=new ArrayList<>();
            List<WebElement> list=ExplicitWaitFactory.PerformExplicit(by);
            if(!value[0].equalsIgnoreCase("All")){
                for(WebElement element:list){
                    String str=element.getText();
                    for(String val:value){
                        if(val.equalsIgnoreCase(str)){
                            arrayList.add(val);
                            element.click();
                            break;
                        }
                    }
                }
                ExtentLogger.pass("Selected from "+fieldName+" dropdown "+arrayList.toString());

            }else{
                for(WebElement element:list){
                    element.click();
                    ExtentLogger.pass("Select All");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            ExtentLogger.fail("Failed To select");
        }
    }
}
