package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobject.UserProfilePageObject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserProfilePageStepDefinition {
    private final UserProfilePageObject userProfilePageObject;

    public UserProfilePageStepDefinition(UserProfilePageObject userProfilePageObject) {
        this.userProfilePageObject = userProfilePageObject;
    }

    @Then("the user should be on the Preferences page")
    public void theUserShouldBeOnThePreferencesPage() {
        String expectedURL = "https://en.wikipedia.org/wiki/Special:Preferences";
        assertEquals("This is not a Preferences page", expectedURL, userProfilePageObject.getCurrentUrl());
    }

    @And("the user navigates to the Appearance page")
    public void theUserNavigatesToTheAppearancePage() {
        userProfilePageObject.clickAppearanceButton();
    }

    @And("the user choose new date format")
    public void theUserChooseNewDateFormat() {
        userProfilePageObject.chooseNewDataFormat();
    }

    @And("saves the changes")
    public void savesTheChanges() {
        userProfilePageObject.clickSubmitButton();
    }

    @Then("the user should see a notification that the changes are saved")
    public void theUserShouldSeeANotificationThatTheChangesAreSaved() {
        assertTrue("Notification 'Your preferences have been saved.' is not displayed", userProfilePageObject.isNotificationDisplayed());
    }

    @And("the user scrolls down to the Date format")
    public void theUserScrollsDownToTheDateFormat() {
        userProfilePageObject.scrollToDataFormat();
    }

    @And("the user should choose and save old date format")
    public void theUserShouldChooseAndSaveOldDateFormat() {
        userProfilePageObject.scrollToDataFormat();
        userProfilePageObject.chooseOldDataFormat();
        userProfilePageObject.clickSubmitButton();
    }
}
