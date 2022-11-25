package helper.pages.page;

import org.openqa.selenium.By;

public abstract class Page {

   protected abstract String getTitle();
   protected abstract void sendKeys(By by,String value,String fieldName);
   protected abstract void click(By by,String fieldName);
   protected abstract boolean isDisplay(By by,String fieldName);
   protected abstract void selectByVisibleTest(By by,String visibleText,String fieldName);
   protected abstract void selectMultipleCheckbox(By by, String fieldName, String ...value);
}
