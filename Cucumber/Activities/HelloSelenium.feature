Feature: Loading the home page
@SmokeTest
Scenario: User should see the title of the page
Given user is on the training support home page
When the user checks the title of the page
Then they should see Training Support
And close the browser