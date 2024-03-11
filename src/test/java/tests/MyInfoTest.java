package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MyInfoPage;

import static report_utility.StepLogger.step;

public class MyInfoTest extends BaseTest {
    private MyInfoPage myInfoPage;
    private String dateOfBirth;

    @BeforeMethod
    public void beforeTest() {
        runPreconditions();
    }

    @Test(description = "My Info")
    public void myInfoTest() {
        step("1. From the admin panel, click on the My Info at the sidebar menu.");
        clickMyInfo();

        step("2. Verify the My Info page is fully loaded.");
        verifyMyInfoPageIsFullyLoaded();

        step("3. Verify “Date of Birth” field is filled in.");
        verifyDateOfBirthIsFilledIn();

        step("4. Update the Date of Birth to any date.");
        updateDateOfBirth();

        step("5. Click on the “Save” button and validate updated Date of birth.");
        clickSaveButtonAndValidateDateOfBirth();

        step("6. Validate date of birth was updated");
        validateDateOfBirthField();
    }

    private void verifyDateOfBirthIsFilledIn() {
        Assert.assertFalse(myInfoPage.getDateOfBirthValue().isEmpty(), "Date of birth field is empty");
    }

    private void updateDateOfBirth() {
        myInfoPage.updateDateOfBirth(dateOfBirth);
    }

    private void clickMyInfo() {
        new DashboardPage(webDriver).clickMyInfo();
    }

    private void clickSaveButtonAndValidateDateOfBirth() {
        myInfoPage.clickPersonalDetailsSaveButton();
    }

    private void validateDateOfBirthField() {
        Assert.assertEquals(myInfoPage.getDateOfBirthValue(), dateOfBirth, "Date of birth was not updated");
    }

    private void runPreconditions() {
        navigateToOrangeHrm();
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.fillCredentials("admin", "admin123");
        loginPage.clickLogin();
        dateOfBirth = "1991-1-9";
    }

    private void verifyMyInfoPageIsFullyLoaded() {
        myInfoPage = new MyInfoPage(webDriver);
        myInfoPage.waitForPageFullyLoaded();
        Assert.assertTrue(myInfoPage.isDateOfBirthVisible(), "My Info page was not fully loaded");
    }
}
