package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.DynamicLocators;

public class PHPLoginPage {

    private static final By loginField() {
        String locator = DynamicLocators.getLocator("input[name=%s]", "username");
        new By.ByCssSelector(locator);
    }
}
