package reportManager.extentReport;


import com.aventstack.extentreports.MediaEntityBuilder;
import utils.CaptureScreenshot;


public final class ExtentLogger {

    private ExtentLogger() {

    }

    public static void pass(String message) {
        ExtentManager.getExtentTest().pass(message);
    }

    public static void pass(String message, boolean captureImage) {
        if (captureImage) {
            ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(CaptureScreenshot.getScreenshot()).build());
        } else pass(message);
    }

    public static void fail(String message) {
        ExtentManager.getExtentTest().fail(message);
    }
    public static void fail(String message, boolean captureImage) {
        if (captureImage) {
            ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(CaptureScreenshot.getScreenshot()).build());
        } else fail(message);
    }

    public static void skip(String message) {
        ExtentManager.getExtentTest().skip(message);
    }
}
