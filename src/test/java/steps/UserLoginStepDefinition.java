package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.LoginPageObject;
import pageobject.MainPageObject;

import static org.junit.Assert.assertEquals;

public class UserLoginStepDefinition {
    private final LoginPageObject loginPage;
    private final MainPageObject mainPageObject;

    public UserLoginStepDefinition(LoginPageObject loginPage, MainPageObject mainPageObject) {
        this.loginPage = loginPage;
        this.mainPageObject = mainPageObject;
    }

    @Given("the user is  on the Login page")
    public void theUserIsOnTheLoginPage() {
        loginPage.openLoginPage();
    }

    @When("enters valid userName and userPassword")
    public void entersValidUserNameAndUserPassword() {
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
        assertEquals("This is not a Main page", expectedURL, mainPageObject.getCurrentUrl());
    }

    @And("the user should log out")
    public void userShouldLogOut() {
        mainPageObject.clickUserLinkDropdown();
        mainPageObject.clickLogOut();
    }

    @When("enters invalid {string} and {string}")
    public void entersInvalidAnd(String userName, String userPassword) {
        loginPage.enterUserName(userName);
        loginPage.enterPassword(userPassword);
        loginPage.clickLoginButton();
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        String actualErrorText = loginPage.getErrorText();
        assertEquals("Registration was Failed",actualErrorText,
                "Incorrect username or password entered. Please try again.");
    }

}
