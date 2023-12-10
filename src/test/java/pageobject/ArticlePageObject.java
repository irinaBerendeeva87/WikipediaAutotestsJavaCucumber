package pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ArticlePageObject extends BasePageObject {
    private final static String articlePage = "https://en.wikipedia.org/wiki/Java";

    @FindBy(xpath = "//span[@class='mw-page-title-main']")
    protected WebElement titleArticle;

    @FindBy(id = "footer")
    protected WebElement footerElement;

    @FindBy(id = "content")
    protected WebElement contentElement;

    public ArticlePageObject(DriverHolder driverHolder) {

        super(driverHolder.getDriver());
    }

    public String getArticleTitle() {
        WebElement titleElement = waitForVisibility(titleArticle);
        return titleElement.getText();
    }

    public void openArticlePage() {
        getDriver().get(articlePage);
    }

    public void scrollArticleToFooter() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", footerElement);
    }

    public boolean articleElementsIsVisible() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(contentElement);
        return contentElement.isDisplayed();
    }
}

