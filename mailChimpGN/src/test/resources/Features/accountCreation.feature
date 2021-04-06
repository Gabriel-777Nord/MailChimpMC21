Feature: Account creation
  I want to use this template for my feature file

  Scenario Outline: Mailchimp account
  
    Given I want to enter my "<email>"
    And I then need to enter my "<username>" 
    Given I also want to enter my "<password>"
    Then Lastly I verify

    Examples: 
      | email  | username | password  |
      | Gabbe |    Gabbegabbe | säkert |
