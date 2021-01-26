package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class DashboardPage  {

    DashboardPage(){}
    private final static By DashboardFirstLevelMenues = By.cssSelector("ul#mainMenuFirstLevelUnorderedList a.firstLevelMenu");
    private static List<WebElement> getDashboardFirstLevelMenus (){ return DriverManager.getDriver().findElements(DashboardFirstLevelMenues); }
    private static WebElement dashboardMenu (String menuLabel) { return getDashboardFirstLevelMenus().stream().filter(webElement -> webElement.getAttribute("id").contains(menuLabel)).collect(Collectors.toList()).get(0); }

    public DashboardPage isMenuDisplayed(String menuLabel){
        dashboardMenu(menuLabel).isDisplayed();
        return this;
    }

}
