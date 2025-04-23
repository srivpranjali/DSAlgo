#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Array
Feature: Array

  Background: Steps for each scenario
    Given User is on Login Page of portal
    When User enter valid username "Test_01" and password "Sdet@2025"
    Then User is redirected to Home Page

  @Array_Test01
  Scenario: User is able to navigate to "Array" page
    Given User is logged in to Home Page
    When User clicks Get Started button under Array
    Then User should be redirected to the "Array" page
    
  @Array_Test02
  Scenario Outline: User is able to navigate to page <Options>
  Given User is on the Array page
  When User clicks link from the list of topics covered "<Options>"
  Then User should be redirected to respective page of "<destinationUrl>"
  Examples:
  |Options|                    destinationUrl|
  |Arrays in Python|           https://dsportalapp.herokuapp.com/array/arrays-in-python/|
  |Arrays using List|          https://dsportalapp.herokuapp.com/array/arrays-using-list/|
  |Basic Operations in Lists|  https://dsportalapp.herokuapp.com/array/basic-operations-in-lists/|
  |Applications of Array|      https://dsportalapp.herokuapp.com/array/applications-of-array/|
  
  @Array_Test03
  Scenario Outline: User is able to navigate to TryEditor page of <Options> to verify code in python
  Given User is on the particular page "<Options>"
  When User clicks on Try Here button of page "<Options>"
  Then User should be redirected to TryEditor page having Run button
  Examples:
  |Options|
  |Arrays in Python|
  |Arrays using List|
  |Basic Operations in Lists|
  |Applications of Array|