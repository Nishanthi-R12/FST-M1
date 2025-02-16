@activity4
Feature: Data driven test without Examples  I want to use this template for my feature file

  @loginPage
  Scenario: Testing login without examples
    Given The user is on the login page
    When the user enters "admin" and "password"
    And clicks the submit button
    Then get the confirmation text and verify message as "Welcome Back, Admin!"
    

  