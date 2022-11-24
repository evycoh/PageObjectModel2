package helper.reports;

import helper.reports.ExtentLogger;
import helper.reports.ExtentReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTestNG implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ExtentReporter.initReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        ExtentReporter.createTest(methodName);

    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReporter.flushReport();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " is pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
       ExtentLogger.fail(result.getMethod().getMethodName() + " is fail","yes");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " Skipped");

    }
}
