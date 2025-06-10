@LinkedList
Feature: LinkedList

  Background: Steps for each scenario
    Given User is on Login Page of portal
    When User enter valid username and password

  @LinkedList_Test01
  Scenario: User is able to navigate to Linked List page
    Given User is logged in to Home Page
    When User clicks Get Started button under Linked List
    Then User should be redirected to the "Linked List" page
    
  @LinkedList_Test020
  Scenario Outline: User is able to navigate to page of Options and verify code in python
  Given User is on the Linked List page
  When User clicks link from the list of topics covered "<Options>"
  Then User should be redirected to respective page of "<Options>"
  When User clicks on Try Here button of page "<Options>"
  Then User should be redirected to TryEditor page having Run button
  When User writes the valid code in editor from "dsalgocode" and "Print valid Hello" and click Run button
  Then User should be able to see correct output in the console
  Examples:
  |Options|                        
  |Introduction| 
  |Creating Linked LIst|
  |Types of Linked List|
  |Implement Linked List in Python|
  |Traversal| 
  |Insertion|
  |Deletion|
  
  @LinkedList_Test021
  Scenario Outline: User is able to navigate to page of Options and verify code in python negative test
  Given User is on the Linked List page
  When User clicks link from the list of topics covered "<Options>"
  Then User should be redirected to respective page of "<Options>"
  When User clicks on Try Here button of page "<Options>"
  Then User should be redirected to TryEditor page having Run button
  When User writes the valid code in editor from "dsalgocode" and "Print invalid Hello" and click Run button
  Then User should be able to see error message in alert window
  Examples:
  |Options|                        
  |Introduction| 
  |Creating Linked LIst|
  |Types of Linked List|
  |Implement Linked List in Python|
  |Traversal| 
  |Insertion|
  |Deletion|
  
  