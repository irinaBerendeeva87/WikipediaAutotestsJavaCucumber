package steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pageobject.DriverHolder;

import java.io.File;
import java.io.IOException;

public class Hooks {
    private final WebDriver driver;

    public Hooks(DriverHolder driverHolder) {
        driver = driverHolder.getDriver();
    }

    @After
    public void takeScreenshotOnFailure(Scenario scenario) {

        if (scenario.isFailed()) {

            TakesScreenshot screenshot = (TakesScreenshot) driver;
//Saving the screenshot in desired location
            File source = screenshot.getScreenshotAs(OutputType.FILE);
//Path to the location to save screenshot
            try {
                FileUtils.copyFile(source, new File("./SeleniumScreenshots/Screen.png"));
                System.out.println("Screenshot is captured");
            } catch (IOException e) {
                System.out.println("Screenshot saving is failed");
            }

        }

        driver.quit();
    }
}
