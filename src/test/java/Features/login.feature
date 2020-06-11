Feature: This feature logs-in the user
  @basics
  Scenario Outline: Log-in User
    Given App is open
    When  User Clicks on "ALREADY_HAVE_ACCOUNT"
    And User Clicks on "EMAIL_INPUT_FIELD"
    And User enters in "EMAIL_INPUT_FIELD" from "<data_set>"
    And User Clicks on "EMAIL_CONTINUE_BUTTON"
    And User Clicks on "PASSWORD_HIDE_CHECKBOX"
    And User Clicks on "PASSWORD_INPUT_FIELD"
    And User enters in "PASSWORD_INPUT_FIELD" from "<data_set>"
    And User Clicks on "LOGIN_BUTTON"
    Then User Navigated to Homescreen
    And User search for another product
#      | SEARCH_BAR | SEARCH_TAP | Redmi note 7   | FIRST_SEARCHED_ELEMENT | ADD_TO_CART | ADDED_SUCCESSFULLY
      | SEARCH_BAR | SEARCH_TAP | Apple iPhone   | FIRST_SEARCHED_ELEMENT | ADD_TO_CART | ADDED_SUCCESSFULLY
      | SEARCH_BAR | SEARCH_TAP | Redgear Mouse  | FIRST_SEARCHED_ELEMENT | ADD_TO_CART | ADDED_SUCCESSFULLY
      | SEARCH_BAR | SEARCH_TAP | boAt headphone | FIRST_SEARCHED_ELEMENT | ADD_TO_CART | ADDED_SUCCESSFULLY
    And User Clicks on "CART"
    And User Clicks on "PROCEED_TO_BUY"

    And User Clicks on "DELIVER_TO_ADDRESS"
    And User Clicks on "CONTINUE"
    And User Clicks on "PAYMENT_MODE"
    And User Clicks on "CARD_NUMBER"
    And User enters "9999888877776666" in "CARD_NUMBER"
    And User Clicks on "EXPIRY_MONTH"
    And User Clicks on "APRIL"
    And User Clicks on "EXPIRY_YEAR"
    And User Clicks on "YEAR2023"
    And User Clicks on "ADD_YOUR_CARD"

    And User Clicks on "ACTION_BAR"
    And User Clicks on "SETTINGS"
    And User Clicks on "SIGN_OUT_BAR"
    And User Clicks on "SIGN_OUT_POPUP"

    Examples:
      | data_set |
      | DataSet1 |
      | DataSet2 |


#Please use your own login id password
#otherwise it will not logged in successfully and failed the assert case of "Then" step.
