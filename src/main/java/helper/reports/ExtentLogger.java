package helper.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import helper.enums.ConfigProperties;
import helper.utils.PropertyUtils;
import helper.utils.ScreenshotUtils;

public class ExtentLogger {

    private ExtentLogger() {
    }

    public static void pass(String message) {
        ExtentManager.geExtentTest().pass(message);
    }

    public static void fail(String message) {
        ExtentManager.geExtentTest().fail(message);
    }

    public static void skip(String message) {
        ExtentManager.geExtentTest().skip(message);
    }

    public static void fail(String msg, String screenShotNeeded) {
        if (PropertyUtils.getValue(ConfigProperties.FAIL_SCREENSHOT).equals(screenShotNeeded))
            ExtentManager.geExtentTest().fail(msg, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Img()).build());

    }
}



