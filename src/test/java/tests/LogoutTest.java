package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

import static report_utility.StepLogger.step;

public class LogoutTest extends BaseTest {
    private DashboardPage dashboardPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void beforeTest() {
        runPreconditions();
    }

    @Test(description = "Logout")
    public void myInfoTest() {
        step("1. From the admin panel, click on the top right dropdown of Profile.");
        openProfile();

        step("2. Click on the Logout button");
        clickLogout();

        step("3. Validate login page is appeared");
        validateLoginPageAppeared();
    }

    private void validateLoginPageAppeared() {
        Assert.assertTrue(loginPage.isOnLoginPage(), "Login page was not appeared");
    }

    private void runPreconditions() {
        navigateToOrangeHrm();
        loginPage = new LoginPage(webDriver);
        loginPage.fillCredentials("admin", "admin123");
        loginPage.clickLogin();
    }

    private void clickLogout() {
        dashboardPage.clickLogout();
    }

    private void openProfile() {
        dashboardPage = new DashboardPage(webDriver);
        dashboardPage.clickProfile();
    }
}
