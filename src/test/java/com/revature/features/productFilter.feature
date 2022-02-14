Feature: Filtering Products

Scenerio: Filtering by author (positive)
Given: I have searched for <search> and been taken to the results
And I enter <authorName> in the author field
And I click the search button
Then I see the result


Scenerio: Filtering by author but author is blank (negative)
Given: I have searched for <search> and been taken to the results
And I click the search button
Then I see the result

Scenerio: Filtering by author but name is not an author (negative)
Given: I have searched for <search> and been taken to the results
And I enter <authorName> in the author field
And I click the search button
Then I should see an error message of <error>

Scenario Outline: Genre dropdown menu (positive test)
Given: I have searched for <search> and been taken to the results
When I select the genre of <genre>
Then I should be taken to the search results page and see results with <resultTitle>

Examples:
| genre | 
| "Adventure" | 
| "Novel" | 
| "Mistery" | 
| "Fiction" | 
| "NonFiction" | 
| "Science" | 
| "Technology" | 
| "Self Improvement" | 
| "International" | 
| "Education" | 
| "Action" | 
| "Horro" | 
| "Romance" | 
| "Comedy" | 

Scenario Outline: Filter by published year (positive)
Given: I have searched for <search> and been taken to the results
And I enter a min published year of <min>
And I enter a max published year of <max>
And I click the apply button
Then I should see a search with result <result>

Examples:
| min | max |
| "1980" | "1990" |
| "" | "1990" |
| "1980" | "" |
| "" | "" |


Scenario Outline: Filter by published year but word entered (negative)
Given: I have searched for <search> and been taken to the results
And I enter a min published year of <min>
And I enter a max published year of <max>
And I click the apply button
Then I should see a search with result <result>

Examples:
| min | max |
| "abc" | "xyz" |
| "" | "xyz" |
| "abc" | "" |

#Scenerio: Filtering by publisher (positive)
#Given: I have searched for <search> and been taken to the results
#And I enter <publisherName> in the publisher field
#And I click the search button
#Then I see the result


#Scenerio: Filtering by publisher but publisher is blank (negative)
#Given: I have searched for <search> and been taken to the results
#And I click the search button
#Then I see the result
