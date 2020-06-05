
Feature: Put Api Call

  Scenario Outline:1A-Successful put api call with all the headers and body
    Given user calls the put api by passing correct url with the prerequisite body
    Then user should see the status code as "<statusCode>"
    And user should see updated employee details in the response
    Examples:
      |statusCode|
      |200       |


  Scenario Outline:1B-UnSuccessful put api call because of record not found
    Given user calls the put api by passing correct url with the prerequisite body appending the id which is not in database
    Then user should see the status code as "<statusCode>"
    And user should see message "Record does not found." in the response
    Examples:
      |statusCode|
      |401       |


  Scenario Outline:1C-UnSuccessful put api call because of incorrect end point
    Given user calls the put api by passing incorrect url with the prerequisite body
    Then user should see the status code as "<statusCode>"
    Examples:
      |statusCode|
      |404       |

  Scenario Outline:1C-UnSuccessful put api call because of incorrect method called
    Given user calls the put api by passing correct url with the prerequisite body but the wrong method type
    Then user should see the status code as "<statusCode>"
    Examples:
      |statusCode|
      |405       |


