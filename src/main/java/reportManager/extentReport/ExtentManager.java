package reportManager.extentReport;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
    private ExtentManager(){

    }
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static ExtentTest getExtentTest(){
        return extentTest.get();
    }
    public static void setExtentTest(ExtentTest extentTestRef){
        extentTest.set(extentTestRef);
    }
    public static void unloadExtentTest(){
        extentTest.remove();
    }
}
