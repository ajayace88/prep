Feature: Test TOI landing page
  Scenario: Test onboarding url
    Given User open "http://timesofindia.indiatimes.com/" in "Chrome"
    Then Redirects to page with title "News: India News, Latest Bollywood News, Sports News, Business & Political News, National & International News | Times of India"
    And Close browser