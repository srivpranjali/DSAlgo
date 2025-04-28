@Array
Feature: Array

  Background: Steps for each scenario
    Given User is on Login Page of portal
    When User enter valid username and password
    Then User is redirected to Home Page

  @Array_Test01
  Scenario: User is able to navigate to "Array" page
    Given User is logged in to Home Page
    When User clicks Get Started button under Array
    Then User should be redirected to the "Array" page