Feature: Search and Navigate
  As a Wikipedia user
  I want to search for articles
  So that I can find relevant information

  Scenario: Search for an article via search results
    Given the user is on the Wikipedia homepage
    When the user enters searchText in the search bar
    Then the user should see search results related to searchText

  Scenario: Search for an article using the Search button
    Given the user is on the Wikipedia homepage
    When the user enters searchText in the search bar
    And clicks the search button
    Then the user should be on the searchText article page

  Scenario: Navigate to an article
    Given the user is on the Wikipedia homepage
    When the user enters searchText in the search bar
    And the user clicks on the first result
    Then the user should be on the searchText article page