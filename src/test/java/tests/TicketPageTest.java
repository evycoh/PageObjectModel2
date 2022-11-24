package tests;

import helper.pages.qdpmPages.AddTicketPage;
import helper.pages.qdpmPages.DashBoardPage;
import helper.pages.qdpmPages.LoginPage;
import helper.reports.ListenerTestNG;
import helper.utils.DataUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerTestNG.class)
public class TicketPageTest extends TestBase{


    @Test(dataProviderClass = DataUtils.class,dataProvider = "addTicket")
    public void addTicketTest(String pn,String dep,String type,String status,String sub,String des,String createdBy){
        DashBoardPage dashBoardPage = new LoginPage().setEmail("administrator@localhost.com").setPassword("administrator").clickLogin();
        dashBoardPage.selectMainMenu("Tickets").selectSubMenu("Add Ticket");
        AddTicketPage addTicketPage=new AddTicketPage();
        addTicketPage
                .setProjectName(pn)
                .setDepartment(dep)
                .setType(type)
                .seTStatus(status)
                .setSubject(sub)
                .setDescription(des)
                .setCreatedBy(createdBy)
                .notifyTo("admin","client")
                .clickSaveBtn();

    }
}
