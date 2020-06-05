
Feature: Get Api Call
 Scenario Outline:1A-Successful get api call with all the headers and parameters
    Given user calls the get api by passing correct url
    Then user should see the status code as "<statusCode>"
    And user should see response body
    Examples:
   |statusCode   |
   |200          |


  Scenario Outline:1B-Unsuccessful get api response when url passed is not the correct endpoint
    Given user calls the get api by passing incorrect url
    Then user should see the status code as "<statusCode>"
    Examples:
      |statusCode   |
      |404          |

  Scenario Outline:1C-Successful get api call with all the headers and parameters for a specific employee
    Given user calls the get api by passing correct url and a specific id "<id>"
    Then user should see the status code as "<statusCode>"
    And user should see response body
    Examples:
      |id|statusCode    |
      |24|200           |

  Scenario Outline:1D-UnSuccessful get api call with all the headers and parameters due to incorrect method called
    Given user calls the get api by passing url with the incorrect method
    Then user should see the status code as "<statusCode>"
    Examples:
      |statusCode   |
      |405          |

