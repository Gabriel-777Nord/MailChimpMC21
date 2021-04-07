Feature: Account creation
  I want to use this template for my feature file

  Scenario Outline: Mailchimp account
  
    Given I want to enter my "<email>"
    And I then need to enter my "<username>" 
    Given I also want to enter my "<password>"
    Then Lastly I verify with "<check>"

    Examples: 
      | email  | username | password  | check |
      | Gabbe@gmail.com |    Gabbegabbe | Super_sa:k3rt | a few things could have happened: |
