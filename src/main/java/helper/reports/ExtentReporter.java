package helper.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import helper.constants.FrameworkConstants;

import java.util.Objects;

public class ExtentReporter {
    private ExtentReporter(){}

    private static ExtentReports extent;

    public static void initReport(){
        if(Objects.isNull(extent)){
            extent=new ExtentReports();
            ExtentSparkReporter spark=new ExtentSparkReporter(FrameworkConstants.getExtentReportOutput());
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("qdPM");
            spark.config().setReportName("qdPM Report");
            extent.attachReporter(spark);
        }

    }
    public static void flushReport(){
        extent.flush();
   //     ExtentManager.unload();
    }
    public static void createTest(String testName){
        ExtentTest test=extent.createTest(testName);
        ExtentManager.setExtentTest(test);
    }
}
