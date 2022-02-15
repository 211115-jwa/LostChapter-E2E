Feature: ViewPreviousOrders

Scenario: User viewing previous orders when logged in
Given the user is logged in
And the user is on the front page
When the user clicks the view previous orders button
Then view previous orders contains previous orders

Scenario: User viewing previous orders when not logged in
Given the user is on the front page
When the user clicks the view previous orders button
Then the login page opens

Scenario: User viewing previous orders when logged in and no previous orders
Given the user is logged in
And the user is on the front page
When the user clicks the view previous orders button
Then view previous orders page says no previous orders