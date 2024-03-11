package report_utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static utility.Utility.FS;
import static utility.Utility.SOURCE_FOLDER;

public class ExtentTestManager {
    private static final String REPORTS_FOLDER = SOURCE_FOLDER + "test_reports" + FS;
    @Getter
    private static ExtentReports report;
    @Getter
    private static ExtentTest test;
    @Setter
    private static String testSuiteName;
    @Setter
    private static WebDriver webDriver;

    public static void initReport() {
        report = new ExtentReports();
        createDirectory(REPORTS_FOLDER);
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(REPORTS_FOLDER + testSuiteName + ".html");
        htmlReporter.config().setDocumentTitle(testSuiteName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(testSuiteName);
        report.attachReporter(htmlReporter);
    }

    public static String getScreenshot(String screenshotName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = REPORTS_FOLDER + screenshotName + ".png";
        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    public static void createTest(String testName) {
        test = report.createTest(testName);
    }

    private static void createDirectory(String path) {
        File reportsDirectory = new File(path);
        if (!reportsDirectory.exists()) {
            if(reportsDirectory.mkdirs()) {
                System.out.println("Reports directory created.");
            } else {
                System.out.println("Failed to create reports directory.");
            }
        }
    }
}
