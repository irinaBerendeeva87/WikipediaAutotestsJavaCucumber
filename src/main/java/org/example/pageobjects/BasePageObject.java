package org.example.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class BasePageObject {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final Duration timeout = Duration.ofSeconds(10);

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeout);
        DefaultElementLocatorFactory locatorFactory = new DefaultElementLocatorFactory(driver);
        PageFactory.initElements(new DefaultFieldDecorator(locatorFactory), this);
    }

    WebDriver getDriver() {
        return driver;
    }

    protected void waitForVisibility(WebElement element) {
        wait.until(visibilityOf(element));
    }

    public boolean waitForElementInvisible(WebElement element) {
        return wait.until(invisibilityOf(element));
    }
}
