Feature: Youtube Search Test
  Test case description

  Scenario: Scenarios for Search and title control on Youtube
    Given Go to Youtube homepage
    When Find the input field and enter "selenium cucumber"
    And Click the Search button
    Then Click on 2. video for the results
    And Compare the title of the opened video with the title you expect