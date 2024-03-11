package report_utility;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static report_utility.ExtentTestManager.*;

public class TestListener implements ITestListener {
    private static ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        initReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        createTest(result.getMethod().getDescription());
        test = getTest();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, getFailureReason(result));
        try {
            test.addScreenCaptureFromPath(getScreenshot(result.getMethod().getDescription()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        getReport().flush();
    }

    private String getFailureReason(ITestResult result) {
        return result.getThrowable().toString();
    }
}
