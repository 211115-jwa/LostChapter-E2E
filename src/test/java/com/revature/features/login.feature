Feature: Login works

# Background: Given I am on the home page

Scenario Outline: Logging in correctly
	Given I am on the home page
	When I enter "<username>" and "<password>" to log in
	And I click the login button
	Then the username link should contain "<username>"
	
	Examples:
		|		username		|		password		|
		|		testpost		| 		123456789		|
		|		chrisw			|		123456789		|
		
		
	Scenario Outline: Logging in incorrectly
		Given I am on the home page
		When I enters an incorrect "<username>" and "<password>"
		And I click the login button
		Then the appropriate error message should appear
		
	Examples:
		|		username		|		password		|
		|		hola			| 		123				|
		|		comida			|		123				|
		
