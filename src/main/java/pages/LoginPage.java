package pages;

import driver.DriverManager;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public final class LoginPage {
    private final By userNameField = By.cssSelector("input#txtUsername[type=text]");
    private final By passwordField = By.cssSelector("input#txtPassword[type=password]");
    private final By loginButton = By.cssSelector("input#btnLogin[value=LOGIN]");
    private final By forgotPasswordLink = By.cssSelector("#forgotPasswordLink a");
    private final By invalidErrorMeesage = By.cssSelector("span#spanMessage");

    public LoginPage enterUserName(String uName){
        WebElement uname = DriverManager.getDriver().findElement(userNameField);
        uname.clear();
        uname.sendKeys(uName);
        return this;
    }
    public LoginPage enterPassword(String password){
        //alternative to Thread.sleep()
        //Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        WebElement passwordWebElement = DriverManager.getDriver().findElement(passwordField);
        passwordWebElement.clear();
        passwordWebElement.sendKeys(password);
        return this;
    }

    public DashboardPage clickLoginButton(){
        DriverManager.getDriver().findElement(loginButton).submit();
        return new DashboardPage();
    }

}
