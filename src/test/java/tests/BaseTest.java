package tests;

import driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected BaseTest() {
    }

    @BeforeMethod
    protected void LaunchDriver()  {
        Driver.invokeBrowser();
    }

    @AfterMethod
    protected void closeDriver() {
        Driver.closeDriver();
    }
}
