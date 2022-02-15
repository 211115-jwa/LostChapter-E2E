Feature: Logout works

# Background: Given I am on the home page

	Scenario: Logout successfully (positive test)
		Given I am on the home page
		And I click the login button in the Header
		And I enter username and password to log in
		And I click the login button
		When I click the logout button
		Then I should be redirected to the Home page
		