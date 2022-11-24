package tests;

import helper.pages.qdpmPages.*;

import helper.reports.ListenerTestNG;
import helper.utils.DataUtils;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ListenerTestNG.class)
public class TaskPageTest extends TestBase {

    @Test(dataProviderClass = DataUtils.class, dataProvider = "addTask")
    public void addTaskToProject(String pn, String type, String name, String status, String priority, String label
            , String description, String createdBy) {

        DashBoardPage dashBoardPage = new LoginPage().setEmail("administrator@localhost.com").setPassword("administrator").clickLogin();
        dashBoardPage.selectMainMenu("Tasks").selectSubMenu("Add Task");
        AddTaskPage addTaskPage = new AddTaskPage();
        addTaskPage
                .setProjectName(pn)
                .setType(type)
                .setName(name)
                .setStatus(status)
                .setPriority(priority)
                .setLabel(label)
                .setAssignedTo("admin", "client", "developer")
                .setDescription(description)
                .setCreatedBy(createdBy)
                .clickSaveBtn();
    }


}
