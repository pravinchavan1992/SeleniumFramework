package pages;

import driver.DriverManager;
import enums.WaitingStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WaitingUtility;

public class BasePage {
    protected BasePage(){

    }
    public static WebElement getWebElement(By by, WaitingStrategy waitingStrategy){
        return new WaitingUtility().waitForElement(by, waitingStrategy);
    }
    public static void click(By by, WaitingStrategy waitingStrategy){
        getWebElement(by, waitingStrategy).click();
    }
    public static void enterText(By by, WaitingStrategy waitingStrategy, String text){
        WebElement element = getWebElement(by, waitingStrategy);
        element.clear();
        element.sendKeys(text);
    }
    public static String getTitleOfthePage(){
        return DriverManager.getDriver().getTitle();
    }
    public static String getText(By by, WaitingStrategy waitingStrategy){
        return getWebElement(by, waitingStrategy).getText();
    }
    public static void clearField(By by, WaitingStrategy waitingStrategy){
        getWebElement(by, waitingStrategy).clear();
    }



}
