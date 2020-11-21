Feature: Login

  Scenario: Validate that user can login into the system
    Given The web-shop page is open
    When SIGN IN Button is pressed
    Then The authentication form appears
    And The user type his credentials:
      | username | email                      |
      | maria    | munteanu.maria98@gmail.com |
    And Press button with value 'SIGN IN'
    Then The page with successful authentication appears

