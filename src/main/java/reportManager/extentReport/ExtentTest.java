package reportManager.extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
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
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstant.getExtentReportFilePath()).viewConfigurer()
                    .viewOrder().as(new ViewName[]{ViewName.DASHBOARD, ViewName.TEST,ViewName.CATEGORY}).apply();
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("Learning Report Setup");
            extent.attachReporter(spark);
            extent.setReportUsesManualConfiguration(true);
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

    public static void createTest(String testcasename) {
        ExtentManager.setExtentTest(extent.createTest(testcasename));
    }


    public static void addAuthor(String [] author){
        for (String creator: author){
            ExtentManager.getExtentTest().assignAuthor(creator);
        }
    }

    public static void addGroups(String [] groups){
        for (String group: groups){
            ExtentManager.getExtentTest().assignCategory(group);
        }
    }
}
