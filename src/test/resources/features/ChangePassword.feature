Feature: Change password in Wikipedia Account

  Scenario: User can change their password in Wikipedia account
    Given the user is logged in to their account
    When the user opens the account preference
    And the user selects the option to change password
    And set newPassword and  retype newPassword
    And saves the changes
    Then the user should be on the Preferences page
