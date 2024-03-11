package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.BasePage;
import report_utility.ExtentTestManager;

public class BaseTest {
    protected WebDriver webDriver;

    @BeforeSuite
    public void setUpSuite(ITestContext context) {
        ExtentTestManager.setTestSuiteName(context.getSuite().getName());
    }

    @BeforeClass()
    public void beforeClass() {
        initDriver();
        ExtentTestManager.setWebDriver(webDriver);
    }

    @AfterClass
    public void afterClass() {
        webDriver.close();
    }

    protected void initDriver() {
        webDriver = new ChromeDriver(new ChromeOptions());
        webDriver.manage().window().maximize();
    }

    protected void navigateToOrangeHrm() {
        new BasePage(webDriver).navigateToOrangeHrm();
    }
}
