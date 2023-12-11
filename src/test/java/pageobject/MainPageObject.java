package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPageObject extends BasePageObject {

    private final static String mainPage = "https://en.wikipedia.org/wiki/Main_Page";

    @FindBy(id = "pt-logout")
    protected WebElement logOutLinkElement;

    @FindBy(id = "vector-user-links-dropdown")
    protected WebElement userLinkDropdownElement;

    @FindBy(xpath = "//*[@class='cdx-text-input__input']")
    protected WebElement searchInputElement;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    protected WebElement searchButtonElement;

    @FindBy(xpath = "//ul[@aria-label='Search results']")
    protected WebElement searchResultsElement;

    @FindBy(xpath = "//*[@title='Java']")
    protected WebElement firstJavaSearchResult;

    @FindBy(xpath = "//span[text()='Preferences']")
    protected WebElement preferencesElement;

    public MainPageObject(DriverHolder driverHolder) {
        super(driverHolder.getDriver());
    }

    public void openMainPage() {
        getDriver().get(mainPage);
    }

    public void clickUserLinkDropdown() {
        waitForVisibility(userLinkDropdownElement);
        userLinkDropdownElement.click();
    }

    public void clickLogOut() {
        waitForVisibility(logOutLinkElement);
        logOutLinkElement.click();
    }

    public void clickSearchButton() {
        waitForVisibility(searchButtonElement);
        searchButtonElement.click();
    }

    public void setSearchData(String searchText) {
        waitForVisibility(searchInputElement);
        searchInputElement.clear();
        searchInputElement.sendKeys(searchText);
        sleep(1000);
    }

    public boolean areSearchResultsDisplayed() {
        waitForVisibility(searchResultsElement);
        return searchResultsElement.isDisplayed();
    }


    public String getSearchText() {
        waitForVisibility(searchResultsElement);
        return searchResultsElement.getText();
    }

    public void clickFirstSearchResult() {
        waitForVisibility(firstJavaSearchResult);
        firstJavaSearchResult.click();
    }

    public void openPreferences(){
        clickUserLinkDropdown();
        preferencesElement.click();
//        sleep(1000);

    }
}
