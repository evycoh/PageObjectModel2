package helper.pages.qdpmPages;

import helper.driver.Driver;
import helper.driver.DriverManager;
import helper.pages.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddTaskPage extends BasePage {

    private By projectName= By.name("form_projects_id");
    private By type=By.id("tasks_tasks_type_id");
    private By name=By.id("tasks_name");
    private By status=By.id("tasks_tasks_status_id");
    private By priority=By.id("tasks_tasks_priority_id");
    private By label=By.id("tasks_tasks_label_id");
    private By assigned=By.cssSelector(".checkbox_list label");
    private By createdBy=By.id("tasks_created_by");
    private By saveBtn=By.cssSelector("button[type='submit']");

    public AddTaskPage setProjectName(String projectName){
        selectByVisibleTest(this.projectName,projectName,"ProjectName");
        return this;
    }
    public AddTaskPage setType(String taskType){
        selectByVisibleTest(this.type,taskType,"taskType");
        return this;
    }
    public AddTaskPage setName(String taskName){
        sendKeys(this.name,taskName,"taskName");
        return this;
    }
    public AddTaskPage setStatus(String taskStatus){
        selectByVisibleTest(this.status,taskStatus,"taskStatus");
        return this;
    }
    public AddTaskPage setPriority(String priority){
        selectByVisibleTest(this.priority,priority,"taskPriority");
        return this;
    }
    public AddTaskPage setLabel(String label){
        selectByVisibleTest(this.label,label,"taskLabel");
        return this;
    }
    public AddTaskPage setAssignedTo(String ...value){
        selectMultipleCheckbox(this.assigned,"taskAssignedTo",value);
        return this;
    }
    public AddTaskPage setDescription(String description){
        WebElement element=DriverManager.getDriver().findElement(By.cssSelector(".cke_wysiwyg_frame.cke_reset"));
        DriverManager.getDriver().switchTo().frame(element);
        sendKeys(By.tagName("p"),description,"taskDescription");
        DriverManager.getDriver().switchTo().defaultContent();
        return this;


    }
    public AddTaskPage setCreatedBy(String createdBy){
        sendKeys(this.createdBy,createdBy,"createdBy");
        return this;
    }
    public AddTaskPage clickSaveBtn(){
        click(this.saveBtn,"saveButton");
        return this;
    }


}
