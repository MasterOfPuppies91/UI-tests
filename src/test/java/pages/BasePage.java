package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    @FindBy(xpath="//span/*[text()='Dashboard']")
    protected WebElement dashboardLabel;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    protected WebElement loginButton;
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public BasePage(WebDriver webDriver) {
        initPage(webDriver);
    }

    protected void enterTextToInput(WebElement input, String text) {
        waitUntilClickable(input);
        input.sendKeys(text);
    }

    protected void click(WebElement element) {
        waitUntilClickable(element);
        element.click();
    }

    protected boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    private void waitUntilClickable(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void navigateToOrangeHrm() {
        webDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    private void initPage(WebDriver driver) {
        this.webDriver = driver;
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        PageFactory.initElements(webDriver, this);
    }
}
