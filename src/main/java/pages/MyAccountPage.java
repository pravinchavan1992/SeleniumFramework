package pages;

import enums.WaitingStrategy;
import org.openqa.selenium.By;
public final class MyAccountPage extends BasePage {
    private final By LoggedInUserName = By.cssSelector("div.header_user_info:first-of-type span");

    private final By signOut = By.cssSelector("a[title='Log me out']");

    public String getLoggedInUserName() {
        return getText(LoggedInUserName, WaitingStrategy.VISIBLE);
    }

    public LoginPage signOut() {
        click(signOut, WaitingStrategy.CLICKABLE);
        return new LoginPage();
    }


}
