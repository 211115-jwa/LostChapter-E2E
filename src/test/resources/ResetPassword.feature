Feature: ResetPassword

  Scenario Outline: updating password correctly
    Given the user is on the front page
    And the user clicks the Log In button
    And the user enters "<username>" and "<password>" to log in
    And the user clicks the submit button
    And the user clicks the profile button
    And the user clicks the update password button
    When the user enters "<oldpassword>" and "<newpassword>"
    And the user clicks the update password button
    Then the page says Password Updated

    Examples: 
      | oldpassword | newpassword |
      |    23456789 |   123456789 |
      |    23456789 |   123456789 |
      |    23456789 |   123456789 |
      |    23456789 |   123456789 |
      |    23456789 |    12345789 |
      |    23456789 | noob2       |

  Scenario Outline: updating password incorrectly
    Given the user is on the front page
    And the user clicks the Log In button
    And the user enters "<username>" and "<password>" to log in
    And the user clicks the submit button
    And the user clicks the profile button
    And the user clicks the update password button
    When the user enters "<oldpassword>" and "<newpassword>"
    And the user clicks the update password button
    Then the page says Incorrect Credentials

    Examples: 
      | oldpassword | newpassword |
      |   723456789 |   123456789 |
      |   723456789 |   123456789 |
      |   723456789 |   123456789 |
      |   723456789 |   123456789 |
      |   723456789 |    12345789 |
      |   723456789 | noob2       |
