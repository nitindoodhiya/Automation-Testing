Feature: This feature logs-in the user, Add multiple products to cart And then Sign out.

  @basics
  Scenario Outline: LogIn->AddItems->SignOut
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
    And User search for these prime products and add them to cart
      | SEARCH_BAR | SEARCH_TAP | Energy Drink   | FIRST_SEARCHED_ELEMENT | ADD_TO_CART |
      | SEARCH_BAR | SEARCH_TAP | Apple iPhone   | FIRST_SEARCHED_ELEMENT | ADD_TO_CART |
      | SEARCH_BAR | SEARCH_TAP | Noodles        | FIRST_SEARCHED_ELEMENT | ADD_TO_CART |
      | SEARCH_BAR | SEARCH_TAP | boAt headphone | FIRST_SEARCHED_ELEMENT | ADD_TO_CART |
    And User Clicks on "CART"
#product_checkout_steps
    And User Clicks on "PROCEED_TO_BUY"
    And User Clicks on "DELIVER_TO_ADDRESS"
    And User Clicks on "CONTINUE"
#payment_steps
    And User Clicks on "PAYMENT_MODE"
    And User Clicks on "ADD_YOUR_CARD"
#sign_out_steps
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
