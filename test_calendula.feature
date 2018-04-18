
Feature: Patients

  Scenario: As a user I want init app
      Given I swipe left
      When I swipe left
      Then I should see "Bienvenido"

  Scenario: As a user I want settings in notifications
      Given I swipe left
      When I swipe left
      And I press "Ajustes"
      And I press "Notificaciones"
      And I press "Repetir avisos cada"
      And I press "30 min"
      Then I should see "30 min"

  Scenario: As a user I want create new routine
    Given I swipe left
      When I swipe left
      And I press "Rutinas"
      And I press image button number 5
      And I enter text "NuevaRutina" into field with id "routine_edit_name"
      And I press image button number 2
      Then I should see "NuevaRutina"


  Scenario: As a user I want to do the tour at the beginning of the application
    Given I swipe left
      When I swipe left
      And I press "Recorrido"
      And I press image button number 2
      And I press image button number 2
      And I press image button number 2
      And I press image button number 2
      And I press image button number 2
      And I press image button number 2
      Then I should see "Calendula"


