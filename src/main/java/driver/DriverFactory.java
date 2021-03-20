package driver;

import common.ReadPropertyFile;
import driver.local.LocalDriverManager;
import driver.remote.RemoteDriverManager;
import enums.Config;
import enums.Target;
import org.openqa.selenium.WebDriver;

public class DriverFactory implements IDriver {
    @Override
    public WebDriver createInstance(String browser) {
        Target target = Target.valueOf(ReadPropertyFile.getProperty(Config.target).toUpperCase());
        WebDriver webdriver;
        switch (target) {
            case LOCAL:
                //webdriver= new LocalDriverManager().createInstance(ReadPropertyFile.getProperty(Config.browser));
                webdriver = new LocalDriverManager().createInstance(browser);
                break;
            case REMOTE:
                // getting the browser from the suite file or @Optional on BaseWeb
                webdriver = new RemoteDriverManager().createInstance(browser);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + target);
        }
        return webdriver;
    }


}


