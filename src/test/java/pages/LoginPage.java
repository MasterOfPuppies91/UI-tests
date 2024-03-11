package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameInput;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void fillCredentials(String username, String password) {
        enterTextToInput(usernameInput, username);
        enterTextToInput(passwordInput, password);
    }

    public boolean isOnLoginPage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(loginButton));
        return loginButton.isDisplayed();
    }

    public void clickLogin() {
        click(loginButton);
        webDriverWait.until(ExpectedConditions.visibilityOf(dashboardLabel));
    }
}
