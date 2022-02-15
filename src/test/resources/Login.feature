Feature: logging in as a user

  #Working TM (c)
  Scenario Outline: logging in with correct credentials
    Given the user is on the login page
    When the user enters "<username>" and "<password>" to log in
    And the user clicks the submit button
    Then the navbar says "<username>"

    Examples: 
      | username  | password  |
      | gamalielb | 123456789 |
      | khayes    | pass      |
      | chrisw    | 123456789 |
      | ChistianS | 123456789 |
      | ricky23i  | 123456789 |
      | testing   | 123456789 |
      | carlo     | 123456789 |

  Scenario Outline: logging in with incorrect passwords
    Given the user is on the login page
    When the user enters "<username>" and "<password>" to log in
    And the user clicks the submit button
    Then the page says Incorrect Credentials

    Examples: 
      | username | password   |
      | ricky23i | 1234567899 |
      | ricky23i |   12345789 |
      | ricky23i |       1234 |
      | testing  | 1234567899 |
      | testing  |   12345789 |
      | testing  |       1234 |

  Scenario Outline: logging in with incorrect usernames
    Given the user is on the login page
    When the user enters "<username>" and "<password>" to log in
    And the user clicks the submit button
    Then the page says Incorrect Credentials

    Examples: 
      | username | password  |
      | ricky23  | 123456789 |
      | icky23i  | 123456789 |
      | rickyi   | 123456789 |
      | testin   | 123456789 |
      | esting   | 123456789 |
      | test ing | 123456789 |

  Scenario Outline: logging in without filling fields
    Given the user is on the login page
    When the user enters "<username>" and "<password>" to log in
    And the user clicks the submit button
    Then the page says Incorrect Credentials

    Examples: 
      | username | password  |
      |          | 123456789 |
      | ricky23i |           |
      |          |           |
