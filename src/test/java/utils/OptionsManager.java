package utils;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;

public final class OptionsManager {
    static ChromeOptions chromeOptions;
    static FirefoxOptions firefoxOptions;
    static InternetExplorerOptions internetExplorerOptions;

    private OptionsManager() {

    }
    
    public static ChromeOptions getChromeOptions() {
        chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.addArguments("start-maximized");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS_AND_NOTIFY);
        return chromeOptions;
    }

    public static FirefoxOptions getFirefoxOptions() {
        firefoxOptions = new FirefoxOptions();
        firefoxOptions.setAcceptInsecureCerts(true);
        firefoxOptions.addArguments("start-maximized");
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        firefoxOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS_AND_NOTIFY);
        return firefoxOptions;
    }

    public static InternetExplorerOptions getInternetExplorerOptions() {
        internetExplorerOptions = new InternetExplorerOptions();
        internetExplorerOptions.setAcceptInsecureCerts(false);
        internetExplorerOptions.ignoreZoomSettings();
        internetExplorerOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        internetExplorerOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS_AND_NOTIFY);
        return internetExplorerOptions;
    }
}