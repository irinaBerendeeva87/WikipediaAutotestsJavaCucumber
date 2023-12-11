package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfilePageObject extends BasePageObject {

    @FindBy(xpath = "//*[@id = 'mw-input-wppassword']")
    protected WebElement changePasswordButton;

    @FindBy(xpath = "//*[@name='password']")
    protected WebElement passwordElement;

    @FindBy(xpath = "//*[@name='retype']")
    protected WebElement retypePasswordElement;

    @FindBy(xpath = "//*[@type='submit']")
    protected WebElement changeCredentialButton;

    public UserProfilePageObject(DriverHolder driverHolder) {
        super(driverHolder.getDriver());
    }

    public void setUserNewPassword(String userPassword) {
        waitForVisibility(passwordElement);
        passwordElement.clear();
        passwordElement.sendKeys(userPassword);
    }

    public void retypeUserPassword(String userPassword) {
        waitForVisibility(retypePasswordElement);
        retypePasswordElement.clear();
        retypePasswordElement.sendKeys(userPassword);
    }

    public void clickChangePasswordButton() {
        waitForVisibility(changePasswordButton);
        changePasswordButton.click();
    }

    public void clickChangeCredentialButton() {
        waitForVisibility(changeCredentialButton);
        changeCredentialButton.click();
    }

}
