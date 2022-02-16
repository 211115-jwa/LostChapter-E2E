Feature: WishList

Scenario: User adding item to WishList when logged in
	Given the user is logged in
	And the user is on the front page
	And the user clicks on a book
	When the user clicks the add to wishlist button
	And the user goes to wishlist page
	Then the wishlist contains the book

Scenario: User removing item from WishList when logged in
	Given the user is logged in
	And the user is on the wishlist page
	And the user clicks on a book
	When the user clicks the remove from wishlist button
	Then the wishlist should not contain the book
	
Scenario: User adding item to WishList when not logged in
	Given the user is logged in
	And the user is on the front page
	And the user clicks on a book
	When the user clicks the add to wishlist button
	Then the login page opens
	
	Scenario: Adding an item that is already in users when logged in
	Given the user is logged in
	And the user is on the front page
	And the user clicks on a book
	When the user clicks the add to wishlist button
	Then the page says Book Already on Wishlist