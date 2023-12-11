package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobject.UserProfilePageObject;

import static org.junit.Assert.assertEquals;

public class UserProfilePageStepDefinition {
    private final UserProfilePageObject userProfilePageObject;

    public UserProfilePageStepDefinition(UserProfilePageObject userProfilePageObject) {
        this.userProfilePageObject = userProfilePageObject;
    }

    @And("the user selects the option to change password")
    public void theUserSelectsTheOptionToChangePassword() {
        userProfilePageObject.clickChangePasswordButton();
    }

    @And("set newPassword and  retype newPassword")
    public void setNewPasswordAndRetypeNewPassword() {
        userProfilePageObject.setUserNewPassword("qwerty12a");
        userProfilePageObject.retypeUserPassword("qwerty12a");
    }

    @And("saves the changes")
    public void savesTheChanges() {
        userProfilePageObject.clickChangeCredentialButton();
    }

    @Then("the user should be on the Preferences page")
    public void theUserShouldBeOnThePreferencesPage() {
        String expectedURL = "https://en.wikipedia.org/wiki/Special:Preferences";
        assertEquals("This is not a Preferences page", expectedURL, userProfilePageObject.getCurrentUrl());
    }
}
