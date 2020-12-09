@login
Feature: User should be able to login
  Background:
    Given the user  is on the login page

  Scenario: Authorized users should be able to login
    When user logs in  with valid credentials
    Then Account summary page should be displayed.

@wip
  Scenario Outline: Users with wrong credentials should not be able to login.
    When user logs in following wrong credential "<Username>" "<Password>"

    Then error message "Login and/or password are wrong." should be displayed.

    Examples:
      |Username     |Password     |
      |wrongUsername|password     |
      |username     |wrongpassword|
      |             |password     |
      |username     |             |





