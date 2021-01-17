@auth
Feature: To test the authentication API

  Scenario: To verify login is working as expected
    Given user calls the login endpoint
    And user gets a success response with correct response code
    Then user should be able to see username in the response

  Scenario: To verify the error code when payload is incorrect
    Given user calls the login endpoint
    And user gets a failure response with incorrect payload like missing username or password
    Then user should be able to see correct error message with correct error code

  Scenario: To verify when the headers are missing
    Given User calls the login endpoint
    And users gets a failure response with missing header
    Then user should be able to see correct error message with correct error code
