package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfilePageObject extends BasePageObject {
    private final static String userProfilePage = "https://en.wikipedia.org/w/index.php?title=Special:Homepage&source=personaltoolslink&namespace=-1";

    @FindBy(xpath = "//a[@data-link-id='email-confirmed']")
    protected WebElement changeElementLink;

    @FindBy(xpath = "//*[@name ='wpNewEmail']")
    protected WebElement emailInput;

    public UserProfilePageObject(WebDriver driver) {
        super(driver);
    }

    public void clickChangeElement() {
        waitForVisibility(changeElementLink);
        changeElementLink.click();
    }
    public void openUserProfilePage(){
        getDriver().get(userProfilePage);
    }
}
