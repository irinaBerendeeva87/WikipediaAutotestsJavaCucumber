package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class BasePageObject {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final Duration timeout = Duration.ofSeconds(10);

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeout);
        DefaultElementLocatorFactory locatorFactory = new DefaultElementLocatorFactory(driver);
        initElements(new DefaultFieldDecorator(locatorFactory), this);
    }

    WebDriver getDriver() {
        return driver;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected WebElement waitForVisibility(WebElement element) {
        wait.until(visibilityOf(element));
        return element;
    }
}
