
Feature: Delete Api Call
  Scenario Outline:1A-Successful delete api call with correct end point
    Given user calls the get api by passing correct url
    And user should see response body
    Given user calls the delete api by passing correct url and the specific index
    Then user should see the status code as "<statusCode>"
    And user should see message as "successfully! deleted Records"
    When user calls the get api by passing correct url
    And user should see response body
    Then the deleted id should not be in the list
    Examples:
      |statusCode   |
      |200          |

  Scenario Outline:1B-UnSuccessful delete api call with incorrect end point
    Given user calls the delete api by passing incorrect url
    Then user should see the status code as "<statusCode>"
    Examples:
      |statusCode   |
      |404          |


  Scenario Outline:1B-UnSuccessful delete api call with incorrect method called
    Given user calls the get api by passing correct url and incorrect method
    Then user should see the status code as "<statusCode>"
    Examples:
      |statusCode   |
      |405          |
