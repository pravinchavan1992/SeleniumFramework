package pages;

import com.aventstack.extentreports.markuputils.MarkupHelper;
import enums.WaitingStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import reportManager.extentReport.ExtentLogger;
import reportManager.extentReport.ExtentManager;
import utils.ElementUtils;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BasePage {
    public static void clickOnElement(By locator, WaitingStrategy waitingStrategy, String locatorName) {
        ElementUtils.getWebElement(locator, waitingStrategy).click();
        ExtentLogger.info("Clicked on " + locatorName);
    }

    public static void enterText(By locator, WaitingStrategy waitingStrategy, String text, String fieldName) {
        WebElement element = ElementUtils.getWebElement(locator, waitingStrategy);
        element.clear();
        element.sendKeys(text);
        ExtentLogger.info("Entered text " + text + " in " + fieldName);
    }

    public static String getText(By locator, WaitingStrategy waitingStrategy, String locatorName) {
        String elementText = ElementUtils.getWebElement(locator, waitingStrategy).getText().trim();
        ExtentLogger.info("Text for webelement " + locatorName + " is " + elementText);
        return elementText;
    }

    public static List<WebElement> getAllOptionsFromDropDowm(By locator, WaitingStrategy waitingStrategy, String dropDownName) {
        Select select = new Select(ElementUtils.getWebElement(locator, waitingStrategy));
        List<String> dropDownElements = select
                .getOptions()
                .stream()
                .map(x -> x.getText())
                .collect(Collectors.toList())
                .stream()
                .filter(x->x.length()>0)
                .collect(Collectors.toList());

        ExtentManager.getExtentTest().info("Values of " + dropDownName + MarkupHelper.createOrderedList(dropDownElements).getMarkup());
        return select.getOptions();
    }

    public static List<String> getAllDropdownElement(By locator, WaitingStrategy waitingStrategy, String dropdownName) {
        return getAllOptionsFromDropDowm(locator, waitingStrategy, dropdownName).stream().map(x -> x.getText()).collect(Collectors.toList());
    }

    public static WebElement getDefaultSelectedValue(By locator, WaitingStrategy waitingStrategy) {
        Select select = new Select(ElementUtils.getWebElement(locator, waitingStrategy));
        return select.getFirstSelectedOption();
    }

    public static void selectDropdownValue(By locator, WaitingStrategy waitingStrategy, String value) {
        Select select = new Select(ElementUtils.getWebElement(locator, waitingStrategy));
        select.selectByVisibleText(value);
    }

    public static void deselectDropdownValue(By locator, WaitingStrategy waitingStrategy, String value) {
        Select select = new Select(ElementUtils.getWebElement(locator, waitingStrategy));
        select.deselectByVisibleText(value);
    }
}
