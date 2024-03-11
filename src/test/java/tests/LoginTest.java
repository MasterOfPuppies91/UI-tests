package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

import static report_utility.StepLogger.step;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void beforeTest() {
        loginPage = new LoginPage(webDriver);
    }

    @Test(description = "Login Page - Authenticate Successfully")
    public void loginTest() {
        step("1. Navigate to https://opensource-demo.orangehrmlive.com/");
        navigateToOrangeHrm();

        step("2. Fill in the account details in the login screen");
        fillCredentials();

        step("3. Click on Login button");
        clickLoginAndValidate();
    }

    private void fillCredentials() {
        loginPage.fillCredentials("admin", "admin123");
    }

    private void clickLoginAndValidate() {
        loginPage.clickLogin();
        Assert.assertTrue(new DashboardPage(webDriver).isOnDashboardPage(), "User was not logged in.");
    }
}
