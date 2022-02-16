Feature: Cart

Scenario: User adding item to cart
	Given the user is on the front page
	When the user clicks on a product on the front page
	And the user put a quantity
	And the user clicks add to cart
	Then the user is redirected to my cart page
	And products are visible

Scenario: User removing item from cart
	Given the user is on the home page
	When the user clicks on a product on the front page
	And the user puts a quantity
	And the user click add to cart
	And the user is redirected to my cart page
	And products are visible
	And the user clicks remove item from cart
	Then the user should see thier cart is empty 