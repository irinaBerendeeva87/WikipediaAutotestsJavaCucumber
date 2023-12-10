package org.example.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArticlePageObject extends BasePageObject {

    @FindBy(xpath = "//span[@class='mw-page-title-main']")
    protected WebElement titleArticle;

    public ArticlePageObject(WebDriver driver) {
        super(driver);
    }

    public String getArticleTitle() {
        WebElement titleElement = waitForVisibility(titleArticle);
        return titleElement.getText();
    }

}

