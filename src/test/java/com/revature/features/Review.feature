Feature: Review
  I want to use this template to view review and add reviews

  Scenario: View Reviews
    Given I am on the home page
	When I click on a product on the front page
    Then the book information popup will show
    And reviews can be viewed below

  Scenario: Add Reviews
   Given I am on the home page
    And I click the login button in the Header
    And I enter username and password to log in
	And I click the login button
	And I click on a product on the front page
    And the book information popup shows
    When I click on the add review button
    Then I can enter a review title
    