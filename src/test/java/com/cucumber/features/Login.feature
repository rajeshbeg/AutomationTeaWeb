Feature: Moneycontrol login

  Scenario Outline: login with username and password
  
    Given user is on Moneycontrol homepage
    When user enters the Userid "<UserID>"
    And user enters the Password "<Password>"
    And then hits the Login button
    Then user is displayed login screen
    
Examples:
    | UserID            | Password | 
    | manideep_shriva   | df |
