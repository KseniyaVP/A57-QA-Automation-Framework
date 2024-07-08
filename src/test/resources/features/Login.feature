Feature: Login feature

  Scenario: Login Success
    Given I open Login page
    When I enter email "kseniya.potsina@testpro.io"
    And I enter password "testproA57*"
    And I submit
    Then I am logged in