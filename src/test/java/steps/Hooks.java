package steps;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import pageobject.DriverHolder;

public class Hooks {
    private final WebDriver driver;

    public Hooks(DriverHolder driverHolder) {
        driver = driverHolder.getDriver();
    }

    @After
    public void after() {
        driver.quit();
    }
}
