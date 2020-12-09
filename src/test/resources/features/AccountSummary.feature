Feature: Account summary
  Background:
    Given the user  is on the login page
    When user logs in  with valid credentials

  Scenario:Page title
    Then  Account summary page should have the title "Zero – Account summary"

 @wip
  Scenario Outline: Account types-Cash Account
    Then Account types should be "<Types>"
   Examples:
   |Types|
   |Cash Accounts|
   |Credit Accounts|
   |Investment Accounts|
   |Loan Accounts      |


