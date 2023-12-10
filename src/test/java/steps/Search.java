package steps;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageobjects.ArticlePageObject;
import org.example.pageobjects.MainPageObject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Search extends BaseTest {
    private MainPageObject mainPageObject;
    private ArticlePageObject articlePageObject;

    @Before
    public void before() {
        setUp();
        mainPageObject = new MainPageObject(driver);
        articlePageObject = new ArticlePageObject(driver);
    }

    @After
    public void after() {
        tearDown();
    }

    @Given("the user is on the Wikipedia homepage")
    public void theUserIsOnTheWikipediaHomepage() {
        mainPageObject.openMainPage();
    }

    @When("the user enters searchText in the search bar")
    public void theUserEntersSearchTextInTheSearchBar() {
        mainPageObject.enterSearchData("Java");
    }

    @And("clicks the search button")
    public void clicksTheSearchButton() {
        mainPageObject.clickSearchButton();
    }

    @Then("the user should see search results related to searchText")
    public void theUserShouldSeeSearchResultsRelatedToSearchText() {
        assertTrue("Search results are not displayed.", mainPageObject.areSearchResultsDisplayed());
        assertTrue("Search results do not contain the keyword 'Java'.",
                mainPageObject.doSearchResultsContainKeyword("Java"));
    }

    @And("the user clicks on the first result")
    public void theUserClicksOnTheFirstResult() {
        mainPageObject.clickFirstSearchResult();
    }

    @Then("the user should be on the searchText article page")
    public void theUserShouldBeOnTheArticlePage() {
        String actualTitle = articlePageObject.getArticleTitle();
        assertEquals("Actual title isn't equal to 'Java'", actualTitle, "Java");
    }
}
