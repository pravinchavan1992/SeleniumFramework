package utils;

import com.aventstack.extentreports.markuputils.MarkupHelper;
import enums.WaitingStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import reportManager.extentReport.ExtentLogger;
import reportManager.extentReport.ExtentManager;

import java.util.List;
import java.util.stream.Collectors;

public class ElementUtils {
    public static WebElement getWebElement(By locator, WaitingStrategy waitingStrategy) {
        return new WaitingUtility().waitForElement(locator, waitingStrategy);
    }

    public static List<WebElement> getListOfWebelements(By locator, WaitingStrategy waitingStrategy) {
        List<WebElement> webElements = new WaitingUtility().waitForElements(locator, waitingStrategy);
        return webElements;
    }
}
