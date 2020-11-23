Feature: Adding a new user account

  Scenario: Validate that user can create a new account
    Given The EliteShop web page is opened
    When SIGN UP Button is pressed
    Then The registration form appears
    And The user fill the form by type name, email, password and confirm password field:
      | username | email                      | password | confirm_password |
      | maria    | munteanu.maria98@gmail.com | AsdL123! | AsdL123!         |
    Then Click on SIGN UP button
    And The page with successful registration appears