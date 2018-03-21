
Feature: Patients

  Scenario: As a user I want to insert a user
    Given I swipe left
    When I press "Pacientes"
    And I press "Usuario"
    And I clear "patient_name"
    And I enter text "NuevoUsuario" into field with id "patient_name"
    And I press the "add_button" button
    Then I should see "NuevoUsuario"


  Scenario: As a user I want to be able to see my patients
    Given I swipe left
    When I press "Pacientes"
    Then I should see "NuevoUsuario"


  Scenario: As a user I want to customize a user account
    Given I swipe left
    When I press "Pacientes"
    And I press "NuevoUsuario"
    And I press view wiht id "avatar_chage"
    And I press image button wiht id "imageView"
    And I press the "add_button" button
    Then I should see "NuevoUsuario"

