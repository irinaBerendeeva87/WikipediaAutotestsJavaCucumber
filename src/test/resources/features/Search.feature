Feature: Search and Navigate
  As a Wikipedia user
  I want to search for articles
  So that I can find relevant information

  Scenario: Search for an article
    Given the user is on the Wikipedia homepage
    When the user enters "Java" in the search bar
    And clicks the search button
    Then the user should see search results related to "Java"

  Scenario: Navigate to an article
    Given the user is on the Wikipedia homepage
    When the user searches for "Appium" and clicks on the first result
    Then the user should be on the "Appium" article page