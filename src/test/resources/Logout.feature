Feature: Logout works

# Background: Given I am on the home page

	Scenario: Logout successfully
		Given the user is on the home page
		And the user clicks the login button in the Header
		And the user enter <username> and <password> to log in
		And the user clicks the login button
		When the user clicks the logout button
		Then the user should be redirected to the Home page