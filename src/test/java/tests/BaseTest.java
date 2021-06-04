package tests;

import common.ReadPropertyFile;
import driver.DriverFactory;
import driver.DriverManager;
import enums.Config;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.*;
import utils.FrameworkConstant;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BaseTest {

    protected BaseTest() {
    }

    protected void setUpDocker() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("cmd /c start dockerUp.bat");
            verifyDockerIsUp();
            runtime.exec("cmd /c start scaleChrome.bat");
            Thread.sleep(10000);
            runtime.exec("cmd /c start scaleFirefox.bat");
            Thread.sleep(10000);
            //runtime.exec("taskkill /f /im cmd.exe");
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

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



    protected void tearDownDocker() {
        try {
            String path = FrameworkConstant.getProjectPath();
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("cmd /c start dockerDown.bat");

            File file = new File("output.txt");
            if (file.exists()) {
                System.out.println("file deleted");
                file.delete();
            }
            Thread.sleep(20000);
            runtime.exec("taskkill /f /im cmd.exe");
        } catch (InterruptedException | IOException e) {

        }
    }

    protected void verifyDockerIsUp() {
        try {
            Thread.sleep(10000);
            boolean flag = false;
            String file = "output.txt";
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String currentline = reader.readLine();

            while (currentline != null) {
                if ((currentline.contains("The node is registered to the hub and ready to use")) || (currentline.contains("Zalenium is now ready!"))) {
                    flag = true;
                    break;
                }
                currentline = reader.readLine();
            }
            reader.close();

            if (!flag) {
                throw new SkipException("Docker have not started. Please try again or try manually.");
            }
        } catch (InterruptedException | IOException e) {

        }
    }
}
