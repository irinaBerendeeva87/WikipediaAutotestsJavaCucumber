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
        loginPage.setUserName("Irina.berendeeva");
        loginPage.setPassword("qwerty12a");
    }

    @And("clicks the login button")
    public void clicksTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @When("enters invalid {string} and {string}")
    public void entersInvalidAnd(String userName, String userPassword) {
        loginPage.setUserName(userName);
        loginPage.setPassword(userPassword);
        loginPage.clickLoginButton();
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        String actualErrorText = loginPage.getErrorText();
        assertEquals("Registration was Failed",
                "Incorrect username or password entered. Please try again.",
                actualErrorText);

    }

    @Given("the user is logged in to their account")
    public void theUserIsLoggedInToTheirAccount() {
        loginPage.openLoginPage();
        loginPage.setUserName("Irina.berendeeva");
        loginPage.setPassword("qwerty12aq");
        loginPage.clickLoginButton();
    }
}
