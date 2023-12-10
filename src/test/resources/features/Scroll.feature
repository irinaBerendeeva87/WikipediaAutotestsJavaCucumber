Feature: Scroll to Footer on Open Article

  Scenario: User scrolls to the footer of an open article
    Given the user is on the article page
    When the user scrolls down to the footer
    Then all elements of the article remain visible