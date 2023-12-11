Feature: User Login
  As a registered user
  I want to log in to Wikipedia
  So that I can access personalized features

  Scenario: Successful login
    Given the user is  on the Login page
    When set valid userName and userPassword
    And clicks the login button
    Then the user should be on the main page
    Then the user should log out

  Scenario Outline: Unsuccessful login
    Given  the user is  on the Login page
    When set invalid "<userName>" and "<userPassword>"
    And clicks the login button
    Then an error message should be displayed
  Examples:
      | userName | userPassword |
      |empty|qwerty12a|
      |Irina.berendeeva|empty|
