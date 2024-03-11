package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {
    @FindBy(xpath = "//span[text()='My Info']/parent::a")
    private WebElement myInfoLink;
    @FindBy(xpath = "//*[@class='oxd-userdropdown']/span")
    private WebElement profileButton;
    @FindBy(linkText = "Logout")
    private WebElement logoutButton;

    public void clickMyInfo() {
        click(myInfoLink);
    }

    public void clickProfile() {
        click(profileButton);
    }

    public void clickLogout() {
        click(logoutButton);
    }

    public boolean isOnDashboardPage() {
        return isElementDisplayed(dashboardLabel);
    }

    public DashboardPage(WebDriver webDriver) {
        super(webDriver);
    }
}
