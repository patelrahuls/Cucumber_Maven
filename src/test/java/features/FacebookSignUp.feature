
Feature: Validate FB Sign Up
  Description: This feature will be used to Signup for Facebook Application
  
  	@SignUp
    Scenario Outline: Verify that user is able to create a new FB Account
    Given User has opened Facebook application
      And User click on create new account Link
     When User enters "<FirstName>" & "<LastName>" & "<MobileNo>" & "<Password>"
      And User selects <MOB> & "<DOB>" & "<YOB>"
      And User clicks on SignUp button
     Then User should be able to see the success message
  
  Examples: 
      | FirstName | LastName | MobileNo   | Password | MOB | DOB | YOB  | 
      | Mark      | George   | 9019019090 | abc$2Dfa | 10  | 13  | 1999 | 
      
      
  @DataTable
  Scenario: Verify that user is able to create the new account using cucumber datatable
    Given User has opened Facebook application
    And User click on create new account Link
    And User creates the new account
      | Field      | Value      |
      | FirstNaame | Raj        |
      | LastName   | Sharma     |
      | MobileNum  | 9019019090 |
      | Password   | abc@abc123 |
      | MOB        | Jul        |
      | DOB        | 13         |
      | YOB        | 1998       |
      
    And User clicks on SignUp button
     Then User should be able to see the success message
      