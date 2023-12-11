package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.MainPageObject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainPageStepDefinition {
    private final MainPageObject mainPageObject;

    public MainPageStepDefinition(MainPageObject mainPageObject) {
        this.mainPageObject = mainPageObject;
    }

    @Given("the user is on the Wikipedia homepage")
    public void theUserIsOnTheWikipediaHomepage() {
        mainPageObject.openMainPage();
    }

    @When("the user enters searchText in the search bar")
    public void theUserEntersSearchTextInTheSearchBar() {
        mainPageObject.setSearchData("Java");
    }

    @And("clicks the search button")
    public void clicksTheSearchButton() {
        mainPageObject.clickSearchButton();
    }

    @Then("the user should see search results related to searchText")
    public void theUserShouldSeeSearchResultsRelatedToSearchText() {
        assertTrue("Search results are not displayed.", mainPageObject.areSearchResultsDisplayed());
        String searchText = mainPageObject.getSearchText().toLowerCase();
        assertTrue(
                "Search results do not contain the keyword 'Java'.",
                searchText.contains("java")
        );
    }

    @And("the user clicks on the first result")
    public void theUserClicksOnTheFirstResult() {
        mainPageObject.clickFirstSearchResult();
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

    @When("the user opens the account preference")
    public void theUserOpensTheAccountPreference() {
        mainPageObject.openPreferences();

    }
}
