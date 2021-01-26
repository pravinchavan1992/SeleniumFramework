package reportManager.extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import utils.FrameworkConstant;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentTest {
    private ExtentTest() {

    }

    private static ExtentReports extent;

    public static void setupReport() {
        if (Objects.isNull(ExtentManager.getExtentTest())) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstant.getExtentReportFilePath());
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("Learning Report Setup");
            extent.attachReporter(spark);
        }
    }

    public static void flushReport() {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        ExtentManager.unloadExtentTest();
        try {
            Desktop.getDesktop().browse(new File(FrameworkConstant.getExtentReportFilePath()).toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createTest(String testcasename){
        ExtentManager.setExtentTest(extent.createTest(testcasename));
    }
}