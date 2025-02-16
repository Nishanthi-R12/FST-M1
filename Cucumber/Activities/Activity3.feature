@activity3
Feature: Testing with Tags
  I want to use this template for my feature file

  @SimpleAlert @SmokeTest
  Scenario: Testing with Simple Alert
    Given User is on the page
    When User clicks the simple alert button
    Then Alert opens
    And Read the text from it and print the same
    And Close the alert
    And Read the result text

  @ConfirmAlert
  Scenario: Testing with Confirm Alert
    Given User is on the page
    When User clicks the confirm alert button
    Then Alert opens
    And Read the text from it and print the same
    And Close the alert with cancel
    And Read the result text
    
  @PromptAlert
  Scenario Outline: Testing with Prompt Alert
    Given User is on the page
    When User clicks the prompt alert button
    Then Alert opens
    And Read the text from it and print the same
    And Write a custom message in it
    And Close the alert
    And Read the result text
    

    Examples: 
      | Type  | 
      | Prompt |
