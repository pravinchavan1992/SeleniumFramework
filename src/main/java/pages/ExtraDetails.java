package pages;

import enums.WaitingStrategy;
import org.openqa.selenium.By;

public final class ExtraDetails extends NavigationPage{

    private static By description = By.cssSelector("textarea#description");

    public void enterDescription(String Description){
        enterText(description, WaitingStrategy.VISIBLE, Description, "Description field");
    }
}
