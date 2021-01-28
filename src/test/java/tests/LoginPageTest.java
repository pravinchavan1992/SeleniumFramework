package tests;

import dataprovider.UserCredentials;
import enums.CategoryType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import reportManager.extentReport.ExtentLogger;
import utils.SoftAssertion;

import java.lang.reflect.Method;


public class LoginPageTest extends BaseTest {
    @Test(groups = {CategoryType.SANITY})
    public void LoginTest001(){
        SoftAssertion softAssertion = new SoftAssertion();
        LoginPage loginPage = new LoginPage();
        MyAccountPage myAccountPage = loginPage.
                clickOnSignInButton().
                loginToApplication("pravinchavan1992@gmail.com", "Test@123");
        boolean loggedInName = myAccountPage.getLoggedInUserName().equals("Pravin Chava");
        softAssertion.assertEquals(loggedInName, true);
        if(loggedInName){
            ExtentLogger.pass("Correct Logged in name is shown");
        }
        else {
            ExtentLogger.fail("InCorrect Logged in name is shown", true);
        }
        myAccountPage.signOut();
        softAssertion.assertAll();
    }

    @Test(groups = {CategoryType.SANITY})
    public void LoginTest002(){
        SoftAssertion softAssertion = new SoftAssertion();
        LoginPage loginPage = new LoginPage();
        MyAccountPage myAccountPage = loginPage.
                clickOnSignInButton().
                loginToApplication("pravinchavan1992@gmail.com", "Test@123");
        boolean loggedInName = myAccountPage.getLoggedInUserName().equals("Pravin Chavan");
        softAssertion.assertEquals(loggedInName, true);
        if(loggedInName){
            ExtentLogger.pass("Correct Logged in name is shown", true);
        }
        else {
            ExtentLogger.fail("InCorrect Logged in name is shown");
        }
        myAccountPage.signOut();
        softAssertion.assertAll();
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
