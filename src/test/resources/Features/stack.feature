@Stack
Feature: Validation of Stack module

  @Stack_Test01   
  Scenario: User is able to navigate to "Stack" page
  Given User is in the home page after login
  When User clicks Get Started button in Stack card
  Then User should be directed to Stack page

  @Stack_Test02
  Scenario Outline:: User is able to navigate to the page "Topics covered" in the stack page
  Given User is in the Stack page
  When User clicks link from the list of "<Topics covered>" in the stack page
  Then User should be redirected to respective page of "<DestinationUrl>" in the stack page
  Examples:
  |Topics covered|                       DestinationUrl|
  |Operations in Stack|           https://dsportalapp.herokuapp.com/stack/operations-in-stack/|
  |Implementation|       https://dsportalapp.herokuapp.com/stack/implementation/|
  |Applications|         https://dsportalapp.herokuapp.com/stack/stack-applications/|

  @Stack_Test03
  Scenario Outline:: User is able to navigate to TryEditor page of <Topics covered> to verify code in python
  Given User is on the particular page "<Topics covered>" in the stack module
  When User clicks on Try Here button of page "<Topics covered>" in the stack module
  Then User should be redirected to TryEditor page having Run button in the respective links of stack module
  Examples:
  |Topics covered|
  |Operations in Stack|
  |Implementation|
  |Applications|

  @Stack_Test04
  Scenario: Verify the tryEditor functionality is working in "operations in stack" page
  Given User is on the tryEditor page of operations in stack with Run button
  When User writes the valid python code in the editor <print stack1> and click Run button
  Then User should be able to see correct output <stack1> in the console
  
  @Stack_Test05
  Scenario: Verify the tryEditor functionality with invalid python code in "operations in stack" page
  Given User is again on the tryEditor page of operations in stack with Run button 
  When User writes the invalid python code in the editor <print invalid1> and click Run button
  Then User should be able to see error msg pop up in the operations in stack window 
  

  @Stack_Test06
  Scenario: verify the Editor page of "operations in stack" with alert error message
  Given The user is on the editor page in operations in stack with alert error message
  When The user click the ok button in the alert window of operations in stack page
  Then The user should be on the same editor page of operations in stack having Editor and Run button  

  @Stack_Test07
  Scenario: Verify the tryEditor functionality is working in "implementations" page
  Given User is on the tryEditor page of implementations with Run button
  When User writes the valid python code in the editor <print stack2> and click Run button
  Then User should be able to see correct output <stack2> in the console
  
  @Stack_Test08
  Scenario: Verify the tryEditor functionality with invalid python code in "implementations" page
  Given User is again on the tryEditor page of implementations with Run button
  When User writes the invalid python code in the editor <print invalid2> and click Run button
  Then User should be able to see error msg pop up in the implementations window
  
  @Stack_Test09
  Scenario: verify the Editor page of "implementations" with alert error message
  Given The user is on the editor page in implementations with alert error message
  When The user click the ok button in the alert window of implementations page
  Then The user should be on the same editor page of implementations having Editor and Run button  

  @Stack_Test10
  Scenario: Verify the tryEditor functionality is working in "applications" page
  Given User is on the tryEditor page of applications with Run button
  When User writes the valid python code in the editor <print stack3> and click Run button
  Then User should be able to see correct output <stack3>in the console
  
  @Stack_Test11
  Scenario: Verify the tryEditor functionality with invalid python code in "applications" page
  Given User is again on the tryEditor page of applications with Run button
  When User writes the invalid python code in the editor <print invalid3> and click Run button
  Then User should be able to see error msg pop up in the applications window
  
  @Stack_Test12
  Scenario: verify the Editor page of "applications" with alert error message
  Given The user is on the editor page in applications with alert error message
  When The user click the ok button in the alert window of applications
  Then The user should be on the same editor page of applications having Editor and Run button  
 
  @Stack_Test13
  Scenario: verify user is able to navigate to "practice questions" page
  Given The user is again back to the Stack page 
  When The user clicks Practice Questions button in stack module
  Then The user should be able to see a blank page of Practice Questions in stack module
