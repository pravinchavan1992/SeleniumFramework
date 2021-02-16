package tests;

import common.ReadPropertyFile;
import driver.DriverFactory;
import driver.DriverManager;
import enums.Config;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected BaseTest() {
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    protected void LaunchDriver(@Optional("chrome")  String browser)  {
        DriverFactory driverFactory = new DriverFactory();
        WebDriver driver = driverFactory.createInstance(browser);
        DriverManager.setDriver(driver);
        DriverManager.getDriver().get(ReadPropertyFile.getProperty(Config.appurl));
    }

    @AfterMethod(alwaysRun = true)
    protected void closeDriver() {
        DriverManager.quit();
    }
}
