Feature: This feature is for Calculator Functionality

Background:
Given The Calulator application is open

Scenario: Add two numbers
When I add two numbers 2 and 5
Then I should see result as 7

Scenario: Multiple two numbers
When I multiply two numbers 2 and 5
Then I should see result as 10