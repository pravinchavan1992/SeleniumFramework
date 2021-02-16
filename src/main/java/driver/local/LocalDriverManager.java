package driver.local;

import common.ReadPropertyFile;
import driver.IDriver;
import enums.Config;
import exceptions.BrowserNotSupportedException;
import exceptions.HeadlessNotSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import utils.OptionsManager;


public class LocalDriverManager implements IDriver {
    @Override
    public WebDriver createInstance(String browser) {
        WebDriver driverInstance;
        DriverManagerType driverManagerType = DriverManagerType.valueOf(browser.toUpperCase());
        WebDriverManager.getInstance(driverManagerType).setup();
        boolean isHeadless =  Boolean.parseBoolean(ReadPropertyFile.getProperty(Config.headless));

        switch (driverManagerType) {
            case CHROME:
                driverInstance =
                        isHeadless ? new ChromeDriver(new ChromeOptions().setHeadless(true)) : new ChromeDriver(OptionsManager.getChromeOptions());
                break;
            case FIREFOX:
                driverInstance =
                        isHeadless ? new FirefoxDriver(new FirefoxOptions().setHeadless(true)) : new FirefoxDriver(OptionsManager.getFirefoxOptions());
                break;
            case OPERA:
                if (isHeadless)  headlessNotSupportedForThisBrowser(driverManagerType);
                driverInstance  = new OperaDriver();
                break;
            case EDGE:
                driverInstance =
                        isHeadless ? new EdgeDriver(new EdgeOptions().setHeadless(true)) : new EdgeDriver();
                break;
            case IEXPLORER:
                if (isHeadless) headlessNotSupportedForThisBrowser(driverManagerType);
                driverInstance = new InternetExplorerDriver(OptionsManager.getInternetExplorerOptions());
                break;
            case SAFARI:
                if (isHeadless) headlessNotSupportedForThisBrowser(driverManagerType);
                driverInstance = new SafariDriver();
                break;
            default:
                throw new BrowserNotSupportedException(driverManagerType.toString());
        }

        return driverInstance;
    }

    private void headlessNotSupportedForThisBrowser(DriverManagerType driverManagerType) {
        throw new HeadlessNotSupportedException(driverManagerType.toString());
    }
}
