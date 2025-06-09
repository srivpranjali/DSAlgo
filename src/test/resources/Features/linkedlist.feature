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
    
  @LinkedList_Test02
  Scenario Outline: User is able to navigate to page Options
  Given User is on the Linked List page
  When User clicks link from the list of topics covered "<Options>"
  Then User should be redirected to respective page of "<destinationTitle>"
  Examples:
  |Options|                        destinationTitle|
  |Introduction|                      Introduction|
  |Creating Linked LIst|              Creating Linked LIst|
  |Types of Linked List|              Types of Linked List|
  |Implement Linked List in Python|   Implement Linked List in Python|
  |Traversal|                         Traversal|
  |Insertion|                         Insertion|
  |Deletion|                          Deletion|

  
  @LinkedList_Test03
  Scenario Outline: User is able to navigate to TryEditor page of <Options> to verify code in python
  Given User is on the particular page "<Options>"
  When User clicks on Try Here button of page "<Options>"
  Then User should be redirected to TryEditor page having Run button
  Examples:
  |Options|                        
  |Introduction| 
  |Creating Linked LIst|
  |Types of Linked List|
  |Implement Linked List in Python|
  |Traversal| 
  |Insertion|
  |Deletion|
  
  @LinkedList_Test04
  Scenario Outline: Verify the tryEditor functionality is working in Introduction
  Given User is on the tryEditor page of "Introduction" with Run button
  When User writes the valid code in editor from "<Sheet>" and "<Testname>" and click Run button
  Then User should be able to see correct output in the console
  Examples:
  |Sheet|          Testname|
  |dsalgocode|       Print valid Hello|
  
  @LinkedList_Test05
  Scenario Outline: Verify the tryEditor functionality is working in Creating Linked LIst
  Given User is on the tryEditor page of "Creating Linked LIst" with Run button
  When User writes the valid code in editor from "<Sheet>" and "<Testname>" and click Run button
  Then User should be able to see correct output in the console
  Examples:
  |Sheet|          Testname|
  |dsalgocode|       Print valid Hello|
  
  @LinkedList_Test06
  Scenario Outline: Verify the tryEditor functionality is working in Types of Linked List
  Given User is on the tryEditor page of "Types of Linked List" with Run button
  When User writes the valid code in editor from "<Sheet>" and "<Testname>" and click Run button
  Then User should be able to see correct output in the console
  Examples:
  |Sheet|          Testname|
  |dsalgocode|       Print valid Hello|
  
  @LinkedList_Test07
  Scenario Outline: Verify the tryEditor functionality is working in Implement Linked List in Python
  Given User is on the tryEditor page of "Implement Linked List in Python" with Run button
  When User writes the valid code in editor from "<Sheet>" and "<Testname>" and click Run button
  Then User should be able to see correct output in the console
  Examples:
  |Sheet|          Testname|
  |dsalgocode|       Print valid Hello|

  @LinkedList_Test08
  Scenario Outline: Verify the tryEditor functionality is working in Traversal
  Given User is on the tryEditor page of "Traversal" with Run button
  When User writes the valid code in editor from "<Sheet>" and "<Testname>" and click Run button
  Then User should be able to see correct output in the console
  Examples:
  |Sheet|          Testname|
  |dsalgocode|       Print valid Hello|

  @LinkedList_Test09
  Scenario Outline: Verify the tryEditor functionality is working in Insertion
  Given User is on the tryEditor page of "Insertion" with Run button
  When User writes the valid code in editor from "<Sheet>" and "<Testname>" and click Run button
  Then User should be able to see correct output in the console
  Examples:
  |Sheet|          Testname|
  |dsalgocode|       Print valid Hello|

  @LinkedList_Test10
  Scenario Outline: Verify the tryEditor functionality is working in Deletion
  Given User is on the tryEditor page of "Deletion" with Run button
  When User writes the valid code in editor from "<Sheet>" and "<Testname>" and click Run button
  Then User should be able to see correct output in the console
  Examples:
  |Sheet|          Testname|
  |dsalgocode|       Print valid Hello|

  
  @LinkedList_Test11
  Scenario Outline: Verify the tryEditor functionality is working in Introduction in negative test
  Given User is on the tryEditor page of "Introduction" with Run button
  When User writes the invalid code in editor from "<Sheet>" and "<Testname>" and click Run button
  Then User should be able to see error message in alert window
  Examples:
  |Sheet|          Testname|
  |dsalgocode|       Print invalid Hello|
  
  @LinkedList_Test12
  Scenario Outline: Verify the tryEditor functionality is working in Creating Linked LIst in negative test
  Given User is on the tryEditor page of "Creating Linked LIst" with Run button
  When User writes the invalid code in editor from "<Sheet>" and "<Testname>" and click Run button
  Then User should be able to see error message in alert window
  Examples:
  |Sheet|          Testname|
  |dsalgocode|       Print invalid Hello|
  
  @LinkedList_Test13
  Scenario Outline: Verify the tryEditor functionality is working in Types of Linked List in negative test
  Given User is on the tryEditor page of "Types of Linked List" with Run button
  When User writes the invalid code in editor from "<Sheet>" and "<Testname>" and click Run button
  Then User should be able to see error message in alert window
  Examples:
  |Sheet|          Testname|
  |dsalgocode|       Print invalid Hello|
  
  @LinkedList_Test14
  Scenario Outline: Verify the tryEditor functionality is working in Implement Linked List in Python in negative test
  Given User is on the tryEditor page of "Implement Linked List in Python" with Run button
  When User writes the invalid code in editor from "<Sheet>" and "<Testname>" and click Run button
  Then User should be able to see error message in alert window
  Examples:
  |Sheet|          Testname|
  |dsalgocode|       Print invalid Hello|

  @LinkedList_Test15
  Scenario Outline: Verify the tryEditor functionality is working in Traversal in negative test
  Given User is on the tryEditor page of "Traversal" with Run button
  When User writes the invalid code in editor from "<Sheet>" and "<Testname>" and click Run button
  Then User should be able to see error message in alert window
  Examples:
  |Sheet|          Testname|
  |dsalgocode|       Print invalid Hello|

  @LinkedList_Test16
  Scenario Outline: Verify the tryEditor functionality is working in Insertion in negative test
  Given User is on the tryEditor page of "Insertion" with Run button
  When User writes the invalid code in editor from "<Sheet>" and "<Testname>" and click Run button
  Then User should be able to see error message in alert window
  Examples:
  |Sheet|          Testname|
  |dsalgocode|       Print invalid Hello|

  @LinkedList_Test17
  Scenario Outline: Verify the tryEditor functionality is working in Deletion in negative test
  Given User is on the tryEditor page of "Deletion" with Run button
  When User writes the invalid code in editor from "<Sheet>" and "<Testname>" and click Run button
  Then User should be able to see error message in alert window
  Examples:
  |Sheet|          Testname|
  |dsalgocode|       Print invalid Hello|

 