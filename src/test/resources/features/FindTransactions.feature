Feature: Find Transactions in Account Activity


  Scenario Outline: Search date range
    Given the user  is on the login page
    And user logs in  with valid credentials
    And the user click on "account activity"
    And the user accesses the Find Transactions tab
    When the user enters date range from "<from>" to "<to>"
    And clicks search
    Then results table should only show transactions dates between "2012-09-01" to "2012-09-06"
    And the results should be sorted by most recent date
    Examples:
      | from       | to         |
      | 2012-09-01 | 2012-09-01 |
      | 2012-09-01 | 2012-09-02 |
      | 2012-09-01 | 2012-09-03 |
      | 2012-09-01 | 2012-09-04 |
      | 2012-09-01 | 2012-09-05 |
      | 2012-09-01 | 2012-09-06 |

  @wip
  Scenario: Search date range
    Given the user  is on the login page
    And user logs in  with valid credentials
    And the user click on "account activity"
    And the user accesses the Find Transactions tab
    When the user enters date range from "2012-09-02" to "2012-09-06"
    And clicks search
    Then results table should only show transactions dates between "2012-09-02" to "2012-09-06"
    And the results table should only not contain transactions dated "2012-09-01"