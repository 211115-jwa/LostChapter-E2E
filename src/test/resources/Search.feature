Feature: Search

Scenario: Searching for a book that does exist
	Given the user is on the home page
	When the user enters an correct book on the search bar
	And the user clicks search
	Then the user am redirected to the search results page and see results
	
Scenario: Searching for a book that does not exist
	Given the user am on the home page
	When the user enters an incorrect book on the search bar
	And the user clicks search
	Then the appropriate error message should appear