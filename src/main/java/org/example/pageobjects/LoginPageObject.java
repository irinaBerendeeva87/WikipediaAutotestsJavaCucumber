package org.example.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObject extends BasePageObject {

    private final static String loginPage = "https://en.wikipedia.org/w/index.php?title=Special:UserLogin&returnto=Main+Page";

    @FindBy(id = "wpName1")
    protected WebElement userNameElement;

    @FindBy(id = "wpPassword1")
    protected WebElement passwordElement;

    @FindBy(id = "wpLoginAttempt")
    protected WebElement loginButtonElement;

    public LoginPageObject(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage() {
        getDriver().get(loginPage);
    }

    public void enterUserName(String userName) {
        waitForVisibility(userNameElement);
        userNameElement.clear();
        userNameElement.sendKeys(userName);
    }

    public void enterPassword(String userPassword) {
        waitForVisibility(passwordElement);
        passwordElement.clear();
        passwordElement.sendKeys(userPassword);
    }

    public void clickLoginButton() {
        waitForVisibility(loginButtonElement);
        loginButtonElement.click();
    }
}
