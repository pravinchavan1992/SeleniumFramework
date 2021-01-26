package utils;

import driver.DriverManager;
import enums.WaitingStrategy;
import exceptions.FrameworkException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 */
public class WaitingUtility {

    public WebElement waitForElement(By by, WaitingStrategy WaitingStrategy){
        WebElement element;
        switch (WaitingStrategy){
            case VISIBLE:
                element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstant.getExplicitTime())
                        .until(ExpectedConditions.visibilityOfElementLocated(by));
                break;
            case PRESENCE:
                element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstant.getExplicitTime())
                        .until(ExpectedConditions.presenceOfElementLocated(by));
               break;
            case CLICKABLE:
                element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstant.getExplicitTime())
                        .until(ExpectedConditions.elementToBeClickable(by));
                break;
            default:
                throw new FrameworkException("Unexpected value: " + WaitingStrategy);
        }
        return element;
    }


}
