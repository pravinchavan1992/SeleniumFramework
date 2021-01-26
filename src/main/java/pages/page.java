package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface page {

    default String getTitleOfthePage() {
       return DriverManager.getDriver().getTitle();
    }

    default WebElement getWebElement(By locator){
        return DriverManager.getDriver().findElement(locator);
    }
    default void enterText(By locator, String Text){
        WebElement element = getWebElement(locator);
        element.clear();
        element.sendKeys(Text);
    }
    public abstract void clickOn(By locator);
    public abstract String getText(By locator);
    public abstract void clearField(By locator);
    public abstract boolean isSelected (By locator);
    public abstract boolean isDisPlayed (By locator);
    public abstract boolean isEnabled (By locator);
    public abstract void selectDropDownValueByVisibleText (By locator, String Text);
    public abstract void selectDropDownValueByText (By locator, String Text);
    public abstract void selectDropDownValueByIndex (By locator, int i);
    public abstract List<String> getAllDropDownValues (By locator);
    public abstract List<String> getAllSelectedDropDownValues(By locator);
    public abstract WebElement waitForElementWithFluentWait(By locator, int timeOut, int interval);
    public abstract WebElement waitForElement(By locator);
    public abstract void waitForPageLoaded();
    public abstract List<String> getLinkListText(By locator);
}
