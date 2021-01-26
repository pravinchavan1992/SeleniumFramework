package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ThreadGuard;
import utils.OptionsManager;
import utils.Utilities;

import java.util.Objects;

public final class Driver {

    private Driver() {
    }

    public static void invokeBrowser()  {
        String browser = Utilities.getBrowser();

        if (Objects.isNull(DriverManager.getDriver())) {
            switch (browser) {
                case "Firefox":
                    WebDriverManager.firefoxdriver().setup();
                    DriverManager.setDriver(ThreadGuard.protect(new FirefoxDriver(OptionsManager.getFirefoxOptions())));
                    break;
                case "Chrome":
                default:
                    WebDriverManager.chromedriver().setup();
                    DriverManager.setDriver(ThreadGuard.protect(new ChromeDriver(OptionsManager.getChromeOptions())));
                    break;
            }
            DriverManager.getDriver().get(Utilities.getAppUrl());
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
