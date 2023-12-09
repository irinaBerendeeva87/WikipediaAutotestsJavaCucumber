Feature: User Login
  As a registered user
  I want to log in to Wikipedia
  So that I can access personalized features

  Scenario: Successful login
    Given the user is on the Wikipedia homepage
    When the user navigates to the login page
    And enters valid "<username>" and "<userPassword>"
    And clicks the login button
    Then the user should be on the main page
    Then the user should log out

  Scenario: Unsuccessful login
    Given the user is on the Wikipedia homepage
    When the user navigates to the login page
    And enters invalid "<username>" and "<userPassword>"
    And clicks the login button
    Then an error message should be displayed