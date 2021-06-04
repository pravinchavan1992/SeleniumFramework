package pages;

import enums.WaitingStrategy;
import org.openqa.selenium.By;

public final class ExtraDetails extends NavigationPage{

    private static By description = By.cssSelector("textarea#description");

    private static By successMessage = By.cssSelector("#message p");

    public void enterDescription(String Description){
        enterText(description, WaitingStrategy.VISIBLE, Description, "Description field");
    }

    public boolean isSuccessMessageDisplayed(){
        return isDisplayed(successMessage, WaitingStrategy.VISIBLE, "Sucess Message");
    }

    public String getSuccessMessage(){
        return getText(successMessage, WaitingStrategy.VISIBLE, "Sucess Message");
    }
}
