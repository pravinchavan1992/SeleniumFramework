package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import org.testng.*;
import reportManager.extentReport.ExtentTest;

public class Listeners implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        ExtentTest.setupReport();
        System.out.println("Test Automation Started");
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentTest.flushReport();
        System.out.println("Test Automation Started");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest.createTest(result.getMethod().getConstructorOrMethod().getMethod().getName());
        System.out.println("Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Automation Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Automation Failure");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
