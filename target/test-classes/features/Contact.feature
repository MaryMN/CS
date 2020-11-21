Feature: Contact Form

  Scenario: Validate that user can submit the contact form
    Given Contact web page is opened
    Then The Contact form is displayed
    When User fill the contact form:
      | username | email                      | subject       | message                 |
      | maria    | munteanu.maria98@gmail.com | SIGN UP error | can't create an account |
    And The SEND button is pressed
    Then Validate that contact form is send succesfully