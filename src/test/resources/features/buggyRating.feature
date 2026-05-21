# Author: Jenny Orozco, Santiago Villegas y Daniel Cetina

Feature: Register into Buggy Cars Rating, login into the platform, select a vehicle and publish comments.
  As a user I want to register into Buggy Cars Rating to access the platform functionalities
  As a user I want to login into Buggy Cars Rating to interact with the available vehicles
  As a user I want to select a vehicle to see its details and ratings
  As a user I want to publish comments about vehicles to share my opinion with other users

  Scenario: Successfully register a new user into Buggy Cars Rating.
    Given I am on the Buggy Cars Rating registration page
    When I enter valid information for a new account
    Then I can see that my account was successfully created

  Scenario: Successfully login into Buggy Cars Rating.
    Given I am registered in Buggy Cars Rating
    When I enter my valid credentials
    Then I can access the Buggy Cars Rating platform

  Scenario: Publish a comment about a vehicle.
    Given I am logged into Buggy Cars Rating
    When I select a vehicle
    And I publish a comment about the vehicle
    Then I can see my comment published in the vehicle section

 # Casos exepcionales

  Scenario: Fail to register due to an existing username.
    Given I am on the Buggy Cars Rating registration page
    When I enter a username that already exists
    Then I can see an error message indicating that the username is already in use

  Scenario: Fail to login due to invalid credentials.
    Given I am on the Buggy Cars Rating login page
    When I enter invalid credentials
    Then I can see an authentication error message

  Scenario: Publish an empty comment successfully
    Given I am logged into Buggy Cars Rating
    When I select another vehicle
    And I try to publish an empty comment
    Then I can see the vote confirmation message