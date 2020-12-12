Feature: Navigating to specific accounts in Accounts Activity

  @wip
  Scenario Outline: Savings account redirect
    Given the user is logged in
    When the user clicks on "<link>" link on the Account Summary page
    Then the "<page>" should be displayed
    And Account drop down should have "<option>" selected

Examples:
      | link        | page             | option      |
      | Savings     | Account Activity | Savings     |
      | Brokerage   | Account Activity | Brokerage   |
      | Checking    | Account Activity | Checking    |
      | Credit Card | Account Activity | Credit Card |
      | Loan        | Account Activity | Loan        |

