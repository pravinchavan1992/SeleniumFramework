package utils;

import driver.DriverManager;
import enums.WaitingStrategy;
import exceptions.FrameworkException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 *
 */
public class WaitingUtility {

    public WebElement waitForElement(By by, WaitingStrategy waitingStrategy){
        WebElement element;
        switch (waitingStrategy){
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
                throw new FrameworkException("Unexpected value: " + waitingStrategy);
        }
        return element;
    }
    public List<WebElement> waitForElements(By by, WaitingStrategy waitingStrategy){
        List<WebElement> element;
        switch (waitingStrategy){
            case VISIBLE:
                element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstant.getExplicitTime())
                        .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
                break;
            case PRESENCE:
                element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstant.getExplicitTime())
                        .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
                break;
            default:
                throw new FrameworkException("Unexpected value: " + waitingStrategy);
        }
        return element;
    }


}
