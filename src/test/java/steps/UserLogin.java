package steps;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageobjects.LoginPageObject;
import org.example.pageobjects.MainPageObject;

import static org.junit.Assert.assertEquals;

public class UserLogin extends BaseTest {
    private LoginPageObject loginPage;
    private MainPageObject mainPageObject;

    @Before
    public void before() {
        setUp();
        mainPageObject = new MainPageObject(driver);
        loginPage = new LoginPageObject(driver);
    }

    @After
    public void after() {
        tearDown();
    }

    @Given("the user is on the Wikipedia homepage")
    public void theUserIsOnTheWikipediaHomepage() {
        mainPageObject.openMainPage();
    }

    @When("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {
        mainPageObject.clickLoginPageLink();
    }

    @And("enters valid {string} and {string}")
    public void entersValidUserNameAnd() {
        loginPage.enterUserName("Irina.berendeeva");
        loginPage.enterPassword("(t_Yt6Xm3!V*Ff/");
    }

    @And("clicks the login button")
    public void clicksTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("the user should be on the main page")
    public void userShouldBeOnMainPage() {
        String expectedURL = "https://en.wikipedia.org/wiki/Main_Page";
        assertEquals("This is not a Main page", expectedURL, driver.getCurrentUrl());
    }

    @Then("the user should log out")
    public void userShouldLogOut() {
        mainPageObject.clickUserLinkDropdown();
        mainPageObject
                .clickLogOut();
    }
}
