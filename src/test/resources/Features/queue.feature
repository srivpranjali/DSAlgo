@Queue
Feature: Validation of Queue module

 @Queue_Test01
  Scenario: User is able to navigate to "Queue" page
  Given User is in the home page after login in the portal
  When User clicks Get Started button in Queue card
  Then User should be directed to Queue page
  
  @Queue_Test02
  Scenario Outline:: User is able to navigate to the page "Topics covered" in the queue page
  Given User is in the Queue page
  When User clicks link from the list of "<Topics covered>" in the queue page
  Then User should be redirected to respective page of "<DestinationUrl>" in the queue page
  Examples:
  |Topics covered|                               DestinationUrl|
  |Implementations of Queue in Python|          https://dsportalapp.herokuapp.com/queue/implementation-lists/|
  |Implementation using collections deque|       https://dsportalapp.herokuapp.com/queue/implementation-collections/|
  |Implementation using array|                   https://dsportalapp.herokuapp.com/queue/Implementation-array/|
  |Queue operations|                             https://dsportalapp.herokuapp.com/queue/QueueOp/|
  
  @Queue_Test03
  Scenario Outline:: User is able to navigate to TryEditor page of <Topics covered> to verify code in python
  Given User is on the queue module particular page "<Topics covered>"
  When User clicks on Try Here button of page of queue module on "<Topics covered>"
  Then User should be redirected to TryEditor page having Run button in the respective links of queue module
  Examples:
  |Topics covered|
  |Implementations of Queue in Python|
  |Implementation using collections deque|
  |Implementation using array|
  |Queue operations|  
  
  @Queue_Test04
  Scenario: Verify the tryEditor functionality is working in "Implementations of Queue in Python" page with valid python code
  Given User is on the tryEditor page of Implementations of Queue in Python with Run button
  When User writes the valid python code in the editor <print queue> and click Run button
  Then User should be able to see correct output <queue> in the console
  
  @Queue_Test05
  Scenario: Verify the tryEditor functionality with invalid python code in "Implementations of Queue in Python" page
  Given User is again on the tryEditor page of Implementations of Queue in Python with Run button
  When User writes the invalid python code in the editor <xyz1> and click Run button
  Then User should be able to see error msg pop up in the Implementations of Queue in Python window
  
  @Queue_Test06
  Scenario: verify the Editor page of "Implementations of Queue in Python" with alert error message
  Given The user is on the editor page in Implementations of Queue in Python with alert error message
  When The user click the ok button in the alert window of Implementations of Queue in Python
  Then The user should be on the same editor page of Implementations of Queue in Python having Editor and Run button  
  
  @Queue_Test07
  Scenario: Verify the tryEditor functionality is working in "Implementation using collections deque" page with valid python code
  Given User is again on the tryEditor page of Implementation using collections deque with Run button
  When User writes the valid python code in the editor <print queue1> and click Run button
  Then User should be able to see correct output <queue1>in the console
  
  @Queue_Test08
  Scenario: Verify the tryEditor functionality with invalid python code in "Implementation using collections deque" page
  Given User is on the tryEditor page of Implementation using collections deque with Run button
  When User writes the invalid python code in the editor <xyz2> and click Run button
  Then User should be able to see error msg pop up in the window
  
  @Queue_Test09
  Scenario: verify the Editor page of "Implementation using collections deque" with alert error message
  Given The user is on the editor page in Implementation using collections deque with alert error message
  When The user click the ok button in the alert window of Implementation using collections deque page
  Then The user should be on the same editor page of Implementation using collections deque having Editor and Run button  
  
  @Queue_Test10
  Scenario: Verify the tryEditor functionality is working in "Implementation using array" page with valid python code
  Given User is on the tryEditor page of Implementation using array with Run button
  When User writes the valid python code in the editor <print queue2> and click Run button
  Then User should be able to see correct output <queue2>in the console
  
  @Queue_Test11
  Scenario: Verify the tryEditor functionality with invalid python code in "Implementation using array" page
  Given User is again on the tryEditor page of Implementation using array with Run button
  When User writes the invalid python code in the editor <xyz3> and click Run button
  Then User should be able to see error msg pop up in the window of Implementation using array page
  
  @Queue_Test12
  Scenario: verify the Editor page of "Implementation using array" with alert error message
  Given The user is on the editor page in Implementation using array with alert error message
  When The user click the ok button in the alert window of Implementation using array page
  Then The user should be on the same editor page of Implementation using array having Editor and Run button  
 
  @Queue_Test13
  Scenario: Verify the tryEditor functionality is working in "Queue operations" page with valid python code
  Given User is on the tryEditor page of Queue operations with Run button
  When User writes the valid python code in the editor <print queue3> and click Run button
  Then User should be able to see correct output <queue3>in the console
  
  @Queue_Test14
  Scenario: Verify the tryEditor functionality with invalid python code in "Queue operations" page
  Given User is again on the tryEditor page of Queue operations with Run button
  When User writes the invalid python code in the editor <xyz4> and click Run button
  Then User should be able to see error msg pop up in the window of Queue operations page
  
  @Queue_Test15
  Scenario: verify the Editor page of "Queue operations" with alert error message
  Given The user is on the editor page in Queue operations with alert error message
  When The user click the ok button in the alert window of Queue operations
  Then The user should be on the same editor page of Queue operations having Editor and Run button  
 
 @Queue_Test16
  Scenario: verify user is able to navigate to "practice questions" page 
  Given The user is again back to the queue page 
  When The user clicks Practice Questions button on queue module
  Then The user should be able to see a blank page of Practice Questions in queue module
  