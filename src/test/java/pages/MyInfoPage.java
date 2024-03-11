package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MyInfoPage extends BasePage {
    @FindBy(xpath = "//div[@class='oxd-loading-spinner']")
    private List<WebElement> loadingSpinners;
    @FindBy(xpath = "//label[text()='Date of Birth']/../following-sibling::*//input")
    private WebElement dateOfBirthInput;
    @FindBy(xpath = "//*[text()='Personal Details']/following-sibling::*//button[normalize-space()='Save']")
    private WebElement personalDetailsSaveButton;

    public MyInfoPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isDateOfBirthVisible() {
        return isElementDisplayed(dateOfBirthInput);
    }

    public void waitForPageFullyLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(loadingSpinners));
        webDriverWait.until(ExpectedConditions.invisibilityOfAllElements(loadingSpinners));
    }

    public String getDateOfBirthValue() {
        return dateOfBirthInput.getAttribute("value");
    }

    public void updateDateOfBirth(String value) {
        String jsString = String.format("arguments[0].value='%s';", value);
        ((JavascriptExecutor)webDriver).executeScript(jsString, dateOfBirthInput);
    }

    public void clickPersonalDetailsSaveButton() {
        click(personalDetailsSaveButton);
        waitForPageFullyLoaded();
    }
}
