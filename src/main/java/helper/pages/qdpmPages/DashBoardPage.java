package helper.pages.qdpmPages;

import helper.pages.page.BasePage;
import org.openqa.selenium.By;

public class DashBoardPage extends BasePage {
    private final By userIcon= By.cssSelector(".dropdown.user");

    public boolean userDisplayStatus(){
       return isDisplay(userIcon,"User Info icon");
    }
}
