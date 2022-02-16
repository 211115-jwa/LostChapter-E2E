Feature: View all books by sales,featured, and genre.

  Scenario: Users can view featured books
    Given The user is on the home component
    Then The featured books display

  Scenario: Users can view book on sale
    Given The user is on the home component
    Then The sale books display

  #add ands for every tab
  Scenario: Users can view book by genre
    Given The user is on the home component
    #When The user clicks on the nonfiction tab
    Then The specific books by genre will display
