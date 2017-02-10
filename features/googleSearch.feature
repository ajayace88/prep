Feature: Test Google search page
  Scenario: Test search results
    Given User open "https://www.google.co.in/" in "Chrome"
    When User performs search with "Shah Rukh Khan"
    Then Search results displayed for "Shah Rukh Khan"
    And Close browser