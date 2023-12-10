package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.LoginPageObject;

import static org.junit.Assert.assertEquals;

public class UserLoginStepDefinition {
    private final LoginPageObject loginPage;

    public UserLoginStepDefinition(LoginPageObject loginPage) {
        this.loginPage = loginPage;
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

    @When("enters invalid {string} and {string}")
    public void entersInvalidAnd(String userName, String userPassword) {
        loginPage.enterUserName(userName);
        loginPage.enterPassword(userPassword);
        loginPage.clickLoginButton();
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        String actualErrorText = loginPage.getErrorText();
        assertEquals("Registration was Failed", actualErrorText,
                "Incorrect username or password entered. Please try again.");
    }

}
