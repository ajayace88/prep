Feature: Test TOI landing page
  Scenario: Test onboarding url
    Given User open "http://timesofindia.indiatimes.com/" in "Chrome"
    Then Redirects to page with title "The Times Of India"
    And Close browser