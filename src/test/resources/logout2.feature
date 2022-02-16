Feature: Logout works

# Background: Given I am on the home page

	Scenario Outline: Logout successfully
    Given the user is on the home page
    And I click the login button in the Header
    And the user enters "<username>" and "<password>" to log in
		And I click the login button
		When the user click the logout button
		Then the user should be redirected to the Home page
		