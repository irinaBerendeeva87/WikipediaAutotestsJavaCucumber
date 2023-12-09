package org.example.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPageObject extends BasePageObject {

    private final static String mainPage = "https://en.wikipedia.org/wiki/Main_Page";

    public MainPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Log in']")
    protected WebElement loginLinkElement;

    @FindBy(id = "pt-logout")
    protected WebElement logOutLinkElement;

//    @FindBy(id = "searchInput")
//    protected WebElement searchInputElement;

    @FindBy(xpath = "//span[text()='Irina.berendeeva']")
    protected WebElement userLinkElement;

    @FindBy(id = "vector-user-links-dropdown")
    protected WebElement userLinkDropdownElement;

    public void openMainPage() {
        getDriver().get(mainPage);
    }

    public void clickLoginPageLink() {
        waitForVisibility(loginLinkElement);
        loginLinkElement.click();
    }

    public void clickUserLinkDropdown() {
        waitForVisibility(userLinkDropdownElement);
        userLinkDropdownElement.click();
    }

    public boolean userLinkIsDisplayed() {
        waitForVisibility(userLinkElement);
        return userLinkElement.isDisplayed();
    }

    public void clickLogOut() {
        waitForVisibility(logOutLinkElement);
        logOutLinkElement.click();
    }
}
