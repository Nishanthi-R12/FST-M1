@activity5
Feature: Login test
  I want to use this template for my feature file

  
  @tag2
  Scenario Outline: Testing login with example
    Given The user is on the login page
    When the user enters "<Usernames>" and "<Passwords>"
    And clicks the submit button
    Then get the confirmation text and verify message as "<Message>"

    Examples: 
      | Usernames  | Passwords | Message  |
      | admin |password | Welcome Back, Admin! |
      
