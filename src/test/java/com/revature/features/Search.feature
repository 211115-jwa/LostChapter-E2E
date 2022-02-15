Feature: Search works

# Background: Given I am on the home page

Scenario: Searching for a book that does exist
	Given I am on the home page
	When I enters an correct book on the search bar
	And I click search
	Then I am redirected to the search results page and see results
	
Scenario: Searching for a book that does not exist
	Given I am on the home page
	When I enters an incorrect book on the search bar
	And I click search
	Then the appropriate error message should appear