package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.ArticlePageObject;

import static org.junit.Assert.assertTrue;

public class ScrollStepDefinition {
    private final ArticlePageObject articlePageObject;

    public ScrollStepDefinition(ArticlePageObject articlePageObject) {
        this.articlePageObject = articlePageObject;
    }

    @Given("the user is on the article page")
    public void theUserIsOnTheArticlePage() {
        articlePageObject.openArticlePage();
    }

    @When("the user scrolls down to the footer")
    public void theUserScrollsDownToTheFooter() {
        articlePageObject.scrollArticleToFooter();
    }

    @Then("all elements of the article remain visible")
    public void allElementsOfTheArticleRemainVisible() {
        assertTrue("Article content is not visible after scrolling to the footer.",
                articlePageObject.articleElementsIsVisible());
    }
}
