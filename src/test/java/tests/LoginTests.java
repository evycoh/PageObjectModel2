package tests;

import helper.pages.qdpmPages.DashBoardPage;
import helper.pages.qdpmPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginTest(){
        DashBoardPage dashBoardPage=new LoginPage().setEmail("administrator@localhost.com").setPassword("administrator").clickLogin();
        Assert.assertTrue(dashBoardPage.userDisplayStatus());
    }


}
