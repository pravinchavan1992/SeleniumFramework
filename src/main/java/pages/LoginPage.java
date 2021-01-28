package pages;


import enums.WaitingStrategy;
import org.openqa.selenium.By;


public final class LoginPage extends BasePage {


    private final By signInButton = By.cssSelector("a.login");
    private final By userNameField = By.cssSelector("input[type=text][id=email]");
    private final By passwordField = By.cssSelector("input[type=password][id=passwd]");
    private final By loginButton = By.cssSelector("button#SubmitLogin");


    public MyAccountPage loginToApplication(String email, String password) {
        enterText(userNameField, email, WaitingStrategy.VISIBLE);
        enterText(passwordField, password, WaitingStrategy.CLICKABLE);
        click(loginButton, WaitingStrategy.CLICKABLE);
        return new MyAccountPage();
    }

    public LoginPage clickOnSignInButton() {
        click(signInButton, WaitingStrategy.CLICKABLE);
        return this;
    }


}
