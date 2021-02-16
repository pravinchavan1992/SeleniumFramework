package reportManager.extentReport;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import utils.CaptureScreenshot;


public final class ExtentLogger {

    private ExtentLogger() {

    }

    public static void pass(String message) {
        ExtentManager.getExtentTest().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
    }
    public static void info(String message) {
        ExtentManager.getExtentTest().info(message);
    }

    public static void pass(String message, boolean captureImage) {
        if (captureImage) {
            ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(CaptureScreenshot.getScreenshot()).build());
        } else pass(message);
    }

    public static void fail(String message) {
        ExtentManager.getExtentTest().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
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
