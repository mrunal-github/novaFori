User Story: As a user, I want to check that four points in the space are a square

Acceptance Criteria:
•	All the coordinates are mandatory. When the form is submitted, if any coordinate are blank, show error message to the user.
•	Each coordinate will be separated with commas (e.g: ##,##)
•	If the four coordinates do not make a square, show an error message to the user
•	The new page should be the same as the mockup

Feature: Checking Coordinates Functionality

  Scenario: User should get an error message if any of the coordinates are blank
    Given User is on mock up page
    When  User leaves any of the coordinates blank
    And   User clicks on check button
    Then  User should see error message as "The field is required"
    And   User should not be able to check

  Scenario: User should able to separate coordinates with commas
    Given User is on mock up page
    When  User enters comma between the coordinate
    Then  coordinate will be separated

    Scenario: User should see error message when coordinates do not make up square
      Given User is on mock up page
      When  Four coordinates do not make up square
      Then  User should see an error message

    Scenario: User should see new page same as mock up page
      When User goes to the new page
      Then User should see new page same as mock up page


