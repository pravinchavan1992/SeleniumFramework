package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface page {

    default String getTitleOfthePage() {
        return DriverManager.getDriver().getTitle();
    }

    default WebElement getWebElement(By locator) {
        return DriverManager.getDriver().findElement(locator);
    }

    default void enterText(By locator, String Text) {
        WebElement element = getWebElement(locator);
        element.clear();
        element.sendKeys(Text);
    }
}
