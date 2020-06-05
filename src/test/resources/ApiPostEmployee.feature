
Feature: Post Api Call

  Scenario Outline:1A-Successful post api call with all the headers and body
    Given user calls the post api by passing correct url with the prerequisite body
    Then user should see the status code as "<statusCode>"
    And user should see posted employee details in the response
    Examples:
      |statusCode|
      |200          |


  Scenario Outline:1B-Successful post api call with all the headers and body as null
    Given user calls the post api by passing correct url and the body as null
    Then user should see the status code as "<statusCode>"
    And user should see null values in the response
    Examples:
      |statusCode|
      |200          |

  Scenario Outline:1C-UnSuccessful post api call due to incorrect end point
    Given user calls the post api by passing incorrect url with the prerequisite body
    Then user should see the status code as "<statusCode>"
    Examples:
      |statusCode   |
      |404          |

  Scenario Outline:1D-UnSuccessful post api call due to incorrect method called
    Given user calls the post api by passing correct url and the prerequisite body but with incorrect method
    Then user should see the status code as "<statusCode>"
    Examples:
      |statusCode|
      |405       |



