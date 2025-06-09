@Login
Feature: Login
  
  
  Background: Steps for each scenario
    Given User is on DSAlgo Home page
    When User clicks Sign in button 
  
  @Login_Test01 
  Scenario: User login with valid username and password
    Given User is on DSAlgo login page
    When User enters valid username, password and clicks Login button
    Then User should be redirected to DSAlgo Home Page with message "You are logged in"
    
  @Login_Test02 
  Scenario: User login with invalid username and password
    Given User is on DSAlgo login page
    When User enters invalid username, password and clicks Login button
    Then Verify the message "Invalid Username and Password"
    
    
  @Login_Test03 
  Scenario: User login with blank username and password
    Given User is on DSAlgo login page
    When User clicks Login button
    Then Verify the message "Please fill out this field." appears for username
    
  @Login_Test04 
  Scenario: User login with blank password
    Given User is on DSAlgo login page
    When User enters username and clicks Login button
    Then Verify the message "Please fill out this field." appears for password
    
  @Login_Test05 
  Scenario: User login with blank username
    Given User is on DSAlgo login page
    When User enters password and clicks Login button
    Then Verify the message "Please fill out this field." appears for username
    
  @Login_Test06 
  Scenario: User login page from Home page
    Given User is on DSAlgo Home page
    When User clicks Sign in button
    Then User should be redirected to DSAlgo Login Page
   
  @Login_Test07 
  Scenario: User logout
    Given User is on DSAlgo login page
    When User enters valid username, password and clicks Login button
    Then User should be redirected to DSAlgo Home Page with message "You are logged in"
    When User clicks Sign out button
    Then User should be redirected to DSAlgo Home Page with message "Logged out successfully" 

    
  
    
 
    
    
  

  