package driver;

import common.AppDetails;
import common.Apps;
import common.ReadYamlFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.OptionsManager;
import utils.Utilities;

import java.util.Objects;

public final class Driver {

    private Driver() {
    }

    public static void invokeBrowser()  {
        String browser = Utilities.getBrowser();

        Apps appDetails = ReadYamlFile.getSettings().getAppData();

        if (Objects.isNull(DriverManager.getDriver())) {
            switch (appDetails.getBrowserName()) {
                case "Firefox":
                    WebDriverManager.firefoxdriver().setup();
                    DriverManager.setDriver(new FirefoxDriver(OptionsManager.getFirefoxOptions()));
                    break;
                case "Chrome":
                default:
                    WebDriverManager.chromedriver().setup();
                    DriverManager.setDriver(new ChromeDriver(OptionsManager.getChromeOptions()));
                    break;
            }
            DriverManager.getDriver().get(appDetails.getAppUrl());
            DriverManager.getDriver().manage().deleteAllCookies();
            DriverManager.getDriver().manage().window().maximize();
        }
    }


    public static void closeDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }


}
