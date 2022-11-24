package helper.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
    private ExtentManager() {
    }

    private static ThreadLocal<ExtentTest> exTest = new ThreadLocal<>();

    public static ExtentTest geExtentTest() {
        return exTest.get();
    }

    public static void setExtentTest(ExtentTest test) {
        exTest.set(test);
    }

    public static void unload() {
        exTest.remove();
    }

}
