Feature: Logout works

# Background: Given I am on the home page

	Scenario Outline: Logout successfully
    Given the user is on the front page
    And the user clicks the Log In button
    And the user enters "<username>" and "<password>" to log in
		And the user clicks the login button
		When the user click the logout button
		Then the user should be redirected to the Home page
		