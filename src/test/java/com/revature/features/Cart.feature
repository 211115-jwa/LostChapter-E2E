Feature: Cart

Scenario: User adding item to cart
	Given I am on the home page
	When I click on a product on the front page
	And I put a quantity
	And I click add to cart
	Then I am redirected to my cart page
	And products are visible

Scenario: User removing item from cart
	Given I am on the home page
	When I click on a product on the front page
	And I put a quantity
	And I click add to cart
	And I am redirected to my cart page
	And products are visible
	And I click remove item from cart
	Then I should see my cart is empty 
