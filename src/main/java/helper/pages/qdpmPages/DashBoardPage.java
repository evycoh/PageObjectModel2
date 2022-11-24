package helper.pages.qdpmPages;

import helper.pages.page.BasePage;
import helper.utils.DynamicXpathUtils;
import org.openqa.selenium.By;

public class DashBoardPage extends BasePage {
    private final By userIcon= By.cssSelector(".dropdown.user");
    private  String mainMenuBar ="//ul[@class='page-sidebar-menu']/li/a/span[text()='%value%']";
    private  String subMenuBar="//ul[@class='page-sidebar-menu']/li[@class='open']//ul//span[text()='%value%']";

    public boolean userDisplayStatus(){
       return isDisplay(userIcon,"User Info icon");
    }
    public DashBoardPage selectMainMenu(String value){
        String newXpath= DynamicXpathUtils.getXpath(mainMenuBar,value);
        click(By.xpath(newXpath),value);
        return this;
    }
    public DashBoardPage selectSubMenu(String value){
        String newXpath=DynamicXpathUtils.getXpath(subMenuBar,value);
        click(By.xpath(newXpath),value);
        return this;
    }


}
