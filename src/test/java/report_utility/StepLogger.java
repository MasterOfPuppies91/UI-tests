package report_utility;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class StepLogger {
    public static void step(String message) {
        message = "Step: " + message;
        ExtentTest currentTest = ExtentTestManager.getTest();
        if (currentTest != null) {
            currentTest.log(Status.INFO, message);
        }
    }
}
