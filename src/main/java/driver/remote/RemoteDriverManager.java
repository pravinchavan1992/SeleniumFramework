package driver.remote;

import driver.IDriver;
import exceptions.BrowserNotSupportedException;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriverManager implements IDriver {



    @Override
    public WebDriver createInstance(String browser) {
        RemoteWebDriver remoteWebDriver = null;

        try {
            // a composition of the target grid address and port
            String gridURL = String.format("http://%s:%s/wd/hub", "localhost", "4444");
            MutableCapabilities cap = getCapability(browser);
            cap.setCapability("version", "79.0.3945.117");
            remoteWebDriver = new RemoteWebDriver(new URL(gridURL), cap);
        } catch (MalformedURLException e) {
//           logger.error("Grid URL is invalid or Grid is not available");
//           logger.error(String.format("Browser: %s", browser), e);"
        } catch (IllegalArgumentException e) {
//            logger.error(String.format("Browser %s is not valid or recognized", browser), e);
        }

        return remoteWebDriver;
    }

    private static MutableCapabilities getCapability(String browser) {
        MutableCapabilities mutableCapabilities;
        DriverManagerType driverManagerType = DriverManagerType.valueOf(browser.toUpperCase());

        switch (driverManagerType) {

            case CHROME:
                mutableCapabilities = defaultChromeOptions();
                break;
            case FIREFOX:
                mutableCapabilities = new FirefoxOptions();
                break;
            case OPERA:
                mutableCapabilities = new OperaOptions();
                break;
            case EDGE:
                mutableCapabilities = new EdgeOptions();
                break;
            case IEXPLORER:
                mutableCapabilities = new InternetExplorerOptions();
                break;
            case SAFARI:
                mutableCapabilities = new SafariOptions();
                break;
            default:
                throw new BrowserNotSupportedException(driverManagerType.toString());
        }

        return mutableCapabilities;
    }

    private static MutableCapabilities defaultChromeOptions() {
        ChromeOptions capabilities = new ChromeOptions();
        capabilities.addArguments("start-maximized");

        return capabilities;
    }

}
