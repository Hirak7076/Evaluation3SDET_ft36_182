
@tag
Feature: EVALUATION3
  

  @tag1
  Scenario: Automating the Advanced Search Feature on eBay using java Cucumber
    Given Open the browser and Enter the eBay url
    And Click the Advanced Link beside Search button
    When Select the appropiate option as displayed in the image
    And Click the Using Advanced search option Link and Switching to the Child window and Assert that the text - Costomer Service - is present and Switch back to the Parent Window
    And Enter the search details as shown in image
    And Enter the Additional Details as shown in image
    And Click on the Search button
    Then Assert the text - No exact matches found - as result
    And Close the browser
    

 