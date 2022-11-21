package helper.pages.qdpmPages;

import helper.pages.page.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final By email= By.name("login[email]");
    private final By password=By.name("login[password]");
    private final By loginBtn=By.cssSelector("button[type='submit']");

    public LoginPage setEmail(String email){
        sendKeys(this.email,email,"email");
        return this;
    }
    public LoginPage setPassword(String password){
        sendKeys(this.password,password,"password");
        return this;
    }
    public DashBoardPage clickLogin(){
        click(this.loginBtn,"loginBtn");
        return new DashBoardPage();
    }

}
