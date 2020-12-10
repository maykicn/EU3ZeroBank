Feature:
  @wip
  Scenario:Page title
    Given the user  is on the login page
    When user logs in  with valid credentials
    And the user click on "Account Activity"
    Then page should have the title "Zero – Account activity"
