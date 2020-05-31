Feature: This feature logs-in the user

  Scenario: Log-in User
    Given App is open
    When  User Clicks on "ALREADY_HAVE_ACCOUNT"
    And User enters following fields
      | EMAIL_INPUT_FIELD    | ashishkumargupta1000@gmail.com |
    And User Clicks on "PASSWORD_HIDE_CHECKBOX"
    And User enters following fields
      | PASSWORD_INPUT_FIELD | jarvis@8010 |
    And User Clicks on "LOG_IN_BUTTON"
    Then   User Navigated to Homescreen
