package tests;

import dataprovider.UserCredentials;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.lang.reflect.Method;


public class LoginPageTest extends BaseTest {

    @Test(dataProvider = "getData1")
    //@Parameters({"LoginName", "Password"})
    public void LoginTest001(UserCredentials UserDetails){
        LoginPage loginPage = new LoginPage();
        loginPage.enterUserName(UserDetails.getUserName())
                .enterPassword(UserDetails.getPassword())
                .clickLoginButton()
                .isMenuDisplayed("Admin");
    }
    @Test(dataProvider = "getData", enabled = false)
    //@Parameters({"LoginName", "Password"})
    public void LoginTest002(String LoginName, String Password){
        LoginPage loginPage = new LoginPage();
        loginPage.enterUserName(LoginName)
                .enterPassword(Password)
                .clickLoginButton()
                .isMenuDisplayed("Admin");
    }

    @DataProvider
    public Object[] getData1(){
       return  new UserCredentials[]{
               new UserCredentials("Admin","admin123")
       };
    }

    @DataProvider
    public Object[] getData(Method m){
        String[][] data = new String[0][];
        if(m.getName().equalsIgnoreCase("LoginTest001")){
            System.out.println("LoginTest001");
         data = new String[][]{{"Admin", "admin123"}};
        }
        if(m.getName().equalsIgnoreCase("LoginTest002")){
            System.out.println("LoginTest002");
            data = new String[][]{{"Admin", "admin123"}};
        }
        return data;
    }

}
