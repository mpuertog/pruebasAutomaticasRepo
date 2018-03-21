
Feature: Routines

  Scenario: As a user I want to insert a routine
    Given I swipe left
    When I press "Rutinas"
    And I press "+"
    And I clear "routine_edit_name"
    And I enter text "NuevaRutina" into field with id "routine_edit_name"
    And I press the "add_button" button
    Then I should see "NuevaRutina"


  Scenario: As a user I want to be able to see my routines
    Given I swipe left
    When I press "Rutinas"
    Then I should see "NuevaRutina"


  Scenario: As a user I want to customize a user account
    Given I swipe left
    When I press "Rutinas"
    And I press "NuevaRutina"
    And I press the "button2" button
    And I press image button number 5
    And I press the "Add" button
    And I press "9"
    And I press "2"
    And I press "5"
    And I press "PM"
    And I press "ACEPTAR"
    And I press "add_button" button
    Then I should see "21:25"

    