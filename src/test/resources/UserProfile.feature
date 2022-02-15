	Feature: User Profile

	Scenario: View user profile successfully
		Given the user is on the home page
		And the user clicks the login button in the Header
		And the user enter <username> and <password> to log in
		And the user clicks the login button
		When the user clicks the view profile button
		Then the user should be reidrected to the user profile page
		And the profile should display <username>