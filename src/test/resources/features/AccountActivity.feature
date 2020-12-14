Feature:

  Background:
    Given the user  is on the login page
    When user logs in  with valid credentials
    And the user click on "Account Activity"
  Scenario:Page title
    Then page should have the title "Zero – Account activity"

  Scenario: Account dropdown default option
    Then Account dropdown default option should be "Savings"


  Scenario: Account drop down should have the following options: "Savings, Checking, Loan, Credit Card, Brokerage"
    Then Account drop down should have
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  Scenario:Transactions table names should be "Date" "Description" "Deposit" "Withdrawal"
    Then Transactions table should have
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |
