package pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfilePageObject extends BasePageObject {

    @FindBy(xpath = "//*[@type='submit']")
    protected WebElement submitButton;

    @FindBy(id = "mw-prefsection-rendering-dateformat")
    protected WebElement dateFormatElement;

    @FindBy(id = "ooui-php-497")
    protected WebElement appearanceButton;

    @FindBy(xpath = "//*[@class='mw-notification-content']")
    protected WebElement notificationElement;

    @FindBy(xpath = "//label[@for='ooui-php-84']")
    protected WebElement oldDataFormatElement;

    @FindBy(xpath = "//label[@for='ooui-php-85']")
    protected WebElement newDataFormatElement;

    public UserProfilePageObject(DriverHolder driverHolder) {
        super(driverHolder.getDriver());
    }

    public void clickAppearanceButton() {
        waitForVisibility(appearanceButton).click();
    }

    public void chooseNewDataFormat() {
        waitForVisibility(newDataFormatElement).click();
    }

    public boolean isNotificationDisplayed() {
        return waitForVisibility(notificationElement).isDisplayed();
    }

    public void clickSubmitButton() {
        waitForVisibility(submitButton).click();
    }

    public void scrollToDataFormat() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", dateFormatElement);
    }

    public void chooseOldDataFormat() {
        waitForVisibility(oldDataFormatElement).click();
    }

}
