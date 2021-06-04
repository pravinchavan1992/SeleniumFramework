package listeners;

import org.testng.*;
import org.testng.annotations.Test;
import reportManager.extentReport.ExtentLogger;
import reportManager.extentReport.ExtentTest;

import java.util.Arrays;

public class Listeners implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        ExtentTest.setupReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentTest.flushReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest.createTest(result.getMethod().getConstructorOrMethod().getMethod().getName());
        ExtentTest.addGroups(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).groups());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() +"  is Passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() +"  is failed.");
        ExtentLogger.fail(result.getThrowable().toString());
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));

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
