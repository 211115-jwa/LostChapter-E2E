Feature: ProductReviews

  Scenario Outline: adding a review
    Given the user is on the front page
    And the user clicks the Log In button
    And the user enters "<username>" and "<password>" to log in
    And the user clicks the submit button
    And the user clicks on a book
    And the user clicks the add review button
    When the user enters "<review>"
    And the user clicks submit review button
    Then the book reviews contain "<review>" and "<username">

    Examples: 
      | username | password  | Review      |
      | ricky23i | 123456789 | Good!!      |
      | user23   | 123456789 | Bad!?       |
      | CDS      | 123456789 | Okay        |
      | ponce    | 123456789 | HoRrIBlE    |
      | carlo    |  12345789 | worst book. |
      | noob1    | noob2     | best book   |

	Scenario: adding a review not logged in
      Given the user is on the front page
      And the user clicks on a book
      When the user clicks the add review button
      Then the login page opens
      
	Scenario Outline: removing a review
		Given the user is logged in
		And the user is on the front page
		And the user clicks on a book
		When the user clicks the remove review button
		And the user clicks the confirm action prompt button
		Then the book reviews no longer contain the review
      
