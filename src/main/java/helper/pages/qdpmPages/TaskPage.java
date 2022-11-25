package helper.pages.qdpmPages;

import helper.pages.page.BasePage;
import org.openqa.selenium.By;

public class TaskPage extends BasePage {

    private By taskFilterDisplay= By.id("filtersMenu");

    public boolean taskFilterStatus(){
        return isDisplay(taskFilterDisplay,"task filter display");
    }
}
