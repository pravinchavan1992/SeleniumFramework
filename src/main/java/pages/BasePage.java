package pages;

import driver.DriverManager;
import enums.WaitingStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reportManager.extentReport.ExtentLogger;
import utils.WaitingUtility;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    protected BasePage() {

    }

    public static WebElement getWebElement(By by, WaitingStrategy waitingStrategy) {
        return new WaitingUtility().waitForElement(by, waitingStrategy);
    }
    public static List<WebElement> getWebElements(By by, WaitingStrategy waitingStrategy) {
        return new WaitingUtility().waitForElements(by, waitingStrategy);
    }
    public static void click(By by, WaitingStrategy waitingStrategy) {
        getWebElement(by, waitingStrategy).click();
        ExtentLogger.pass("Clicked on : "+by);
    }

    public static void enterText(By by, String text, WaitingStrategy waitingStrategy) {
        WebElement element = getWebElement(by, waitingStrategy);
        element.clear();
        element.sendKeys(text);
        ExtentLogger.pass("Entered Text in : "+by);
    }

    public static String getTitleOfthePage() {
        return DriverManager.getDriver().getTitle();
    }

    public static String getText(By by, WaitingStrategy waitingStrategy) {
        return getWebElement(by, waitingStrategy).getText();
    }

    public static void clearField(By by, WaitingStrategy waitingStrategy) {
        getWebElement(by, waitingStrategy).clear();
    }

    public static void moveToWebElementAndClick(By by, WaitingStrategy waitingStrategy){
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(getWebElement(by, WaitingStrategy.CLICKABLE)).click().build().perform();

    }
    public static void moveToWebElement(By by, WaitingStrategy waitingStrategy){
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(getWebElement(by, WaitingStrategy.CLICKABLE)).build().perform();

    }

    public Boolean isTitle(String title){
       return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.titleIs(title));
    }




}
