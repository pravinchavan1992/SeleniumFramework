package pages;

import enums.NavigationButton;
import enums.WaitingStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import reportManager.extentReport.ExtentManager;
import utils.DynamicLocators;
import utils.ElementUtils;

import java.util.List;
import java.util.stream.Collectors;

public abstract class NavigationPage extends BasePage{
    private static By getNavigationButton(String buttonName) {
        return By.cssSelector(DynamicLocators.getLocator("input[name=%s]", buttonName));
    }

    private static By pageHeaderText = By.cssSelector("h4.info-text");

    private static By getNavigationButtons = By.cssSelector("ul.nav-pills li a");

    private static By navigationPageTitle = By.cssSelector("h3[class=wizard-title]");

    private static By navigationPageHeader = By.cssSelector("div[class='wizard-header'] h5");

    public List<WebElement> navigationButtons() {
        return ElementUtils.getListOfWebelements(getNavigationButtons, WaitingStrategy.VISIBLE);
    }

    public WebElement navigationButton(NavigationButton button) {
       return navigationButtons().stream().filter(webElement -> webElement.getText().trim().equalsIgnoreCase(button.toString())).collect(Collectors.toList()).get(0);
    }

    public boolean isNavigationButtonVisible(String buttonName) {
        WebElement webElement = ElementUtils.getWebElement(NavigationPage.getNavigationButton(buttonName), WaitingStrategy.VISIBLE);
        return webElement.isDisplayed();
    }

    public void clickOnNextButton() {
        clickOnElement(NavigationPage.getNavigationButton("next"), WaitingStrategy.VISIBLE, "Next Button");
    }

    public void clickOnPreviousButton() {
        clickOnElement(NavigationPage.getNavigationButton("previous"), WaitingStrategy.VISIBLE, "Previous Button");
    }

    public void clickOnFinishButton() {
        clickOnElement(NavigationPage.getNavigationButton("finish"), WaitingStrategy.VISIBLE, "Finish Button");
    }

    public String getNavigationPageTitleText() {
        return getText(navigationPageTitle, WaitingStrategy.VISIBLE, "Navigation Page Title");
    }

    public String getNavigationPageHeaderText() {
        return getText(navigationPageHeader, WaitingStrategy.VISIBLE, "Navigation Page Header Title");
    }

    public String getAccountPageTitle(String pageName) {
        String text = getText(pageHeaderText, WaitingStrategy.VISIBLE, pageName);
        ExtentManager.getExtentTest().info(pageName+ " Page Header Text is :" + text);
        return text;
    }
}
