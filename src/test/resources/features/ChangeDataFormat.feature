Feature: Change date format in Wikipedia Account

  Scenario: User can change their date format in Wikipedia account
    Given the user is logged in to their account
    When the user opens the account preference
    And the user navigates to the Appearance page
    And the user scrolls down to the Date format
    And the user choose new date format
    And saves the changes
    Then the user should see a notification that the changes are saved
    And the user should choose and save old date format
