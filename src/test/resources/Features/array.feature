@Array
Feature: Array

  Background: Steps for each scenario
    Given User is on Login Page of portal
    When User enter valid username and password
    

  @Array_Test01
  Scenario: User is able to navigate to Array page
    Given User is logged in to Home Page
    When User clicks Get Started button under Array
    Then User should be redirected to the "Array" page
    
  @Array_Test02
  Scenario Outline: User is able to navigate to page of Options and verify code in python
  Given User is on the Array page
  When User clicks link from the list of topics covered "<Options>"
  Then User should be redirected to respective page of "<Options>"
  When User clicks on Try Here button of page "<Options>"
  Then User should be redirected to TryEditor page having Run button
  When User writes the valid code in editor from "dsalgocode" and "Print valid Hello" and click Run button
  Then User should be able to see correct output in the console
  Examples:
  |Options|
  |Arrays in Python|
  |Arrays using List|
  |Basic Operations in Lists|
  |Applications of Array|
  
  
  @Array_Test03
  Scenario Outline: User is able to navigate to page of Options and verify code in python negative test
  Given User is on the Array page
  When User clicks link from the list of topics covered "<Options>"
  Then User should be redirected to respective page of "<Options>"
  When User clicks on Try Here button of page "<Options>"
  Then User should be redirected to TryEditor page having Run button
  When User writes the valid code in editor from "dsalgocode" and "Print invalid Hello" and click Run button
  Then User should be able to see error message in alert window
  Examples:
  |Options|
  |Arrays in Python|
  |Arrays using List|
  |Basic Operations in Lists|
  |Applications of Array|
  
  
  @Array_Test04
  Scenario Outline: User is able to run python code for Practice Questions
  Given User is on Array Practice Questions page
  When User clicks link "<Practice Questions>"
  Then User should be redirected to question page
  When User writes the valid code in practice editor from "dsalgocode" and "<Testname>" and click Run button
  Then User should be able to see correct output in the practice console
  Examples: 
  |Practice Questions |                      Testname|
  |Search the array|                         Run Search Practice|
  |Max Consecutive Ones|                     Run findMaxConsecutiveOnes Practice|
  |Find Numbers with Even Number of Digits|  Run findNumbers Practice|
  |Squares of  a Sorted Array|               Run sortedSquares Practice|
  
  @Array_Test05
  Scenario Outline: User is able to submit python code for Practice Questions
  Given User is on Array Practice Questions page
  When User clicks link "<Practice Questions>"
  Then User should be redirected to question page
  When User writes the valid code in editor from "dsalgocode" and "<Testname>" and click Submit button
  Then User should be able to see correct output on submission
  Examples: 
  |Practice Questions |                            Testname|
  |Search the array|                          Submit Search Practice| 
  |Max Consecutive Ones|                      Submit findMaxConsecutiveOnes Practice|
  |Find Numbers with Even Number of Digits|   Submit findNumbers Practice|
  |Squares of  a Sorted Array|                Submit sortedSquares Practice|
  
    