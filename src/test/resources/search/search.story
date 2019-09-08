Search

Meta:
@search

Narrative:
  In order to use search functionality
  As a user
  I want to be able to search for keyword

Scenario: Search for keyword
Meta:
@search01
@smoke
Given I open Landing Page
When I click on 'Sign in' button
Then I should be on Login page
When I sign In with '<email>' , '<password>'
Then I should be on Main page
When I search for 'HR' keyword
Then I should see more than 1 result
Then each result contains 'HR' keyword

Examples:
|email                          |password|
|arhiv_@ukr.net                 |Eks,rf321|