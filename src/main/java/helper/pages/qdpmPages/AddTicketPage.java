package helper.pages.qdpmPages;

import helper.driver.DriverManager;
import helper.pages.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddTicketPage extends BasePage {
    private final By projectName= By.name("form_projects_id");
    private final By department=By.id("tickets_departments_id");
    private final By type=By.id("tickets_tickets_types_id");
    private final By status=By.id("tickets_tickets_status_id");
    private final By createdBy=By.id("tickets_users_id");
    private final By subject=By.id("tickets_name");
    private final By notifyTo=By.cssSelector(".checkbox_list label");
    private final By saveBtn=By.cssSelector("button[type='submit']");


    public AddTicketPage setProjectName(String projectName){
        sendKeys(this.projectName,projectName,"projectName");
        return this;
    }
    public  AddTicketPage setDepartment(String department){
        selectByVisibleTest(this.department,department,"ticketDepartment");
        return this;
    }
    public AddTicketPage setType(String type){
        selectByVisibleTest(this.type,type,"ticketType");
        return this;
    }
    public AddTicketPage seTStatus(String status){
        selectByVisibleTest(this.status,status,"ticketStatus");
        return this;
    }
    public AddTicketPage setSubject(String subject){
        sendKeys(this.subject,subject,"ticketSubject");
        return this;
    }
    public AddTicketPage setDescription(String description){
        WebElement element= DriverManager.getDriver().findElement(By.cssSelector(".cke_wysiwyg_frame.cke_reset"));
        DriverManager.getDriver().switchTo().frame(element);
        sendKeys(By.tagName("p"),description,"ticketDescription");
        DriverManager.getDriver().switchTo().defaultContent();
        return this;
    }
    public AddTicketPage setCreatedBy(String createdBy){
        selectByVisibleTest(this.createdBy,createdBy,"ticketCreatedBy");
        return this;
    }
    public AddTicketPage notifyTo(String ...value){
        selectMultipleCheckbox(this.notifyTo,"notifyTo",value);
        return this;
    }
    public AddTicketPage clickSaveBtn(){
        click(this.saveBtn,"saveBtn");
        return this;
    }
}
