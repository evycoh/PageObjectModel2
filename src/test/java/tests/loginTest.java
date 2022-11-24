package tests;


import helper.pages.qdpmPages.DashBoardPage;
import helper.pages.qdpmPages.LoginPage;
import helper.reports.ListenerTestNG;
import helper.utils.DataUtils;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Listeners(ListenerTestNG.class)
public class loginTest extends TestBase {

    @Test(dataProviderClass = DataUtils.class,dataProvider = "loginData")
    public void tcLogin(String em,String pw){
        DashBoardPage dashBoardPage=new LoginPage().setEmail(em).setPassword(pw).clickLogin();
        Assert.assertTrue(dashBoardPage.userDisplayStatus());
    }



}
