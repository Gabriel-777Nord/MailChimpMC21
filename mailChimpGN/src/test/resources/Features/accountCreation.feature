Feature: Account creation
  I want to use this template for my feature file

  Scenario Outline: Mailchimp account
  
    Given I want to enter my "<email>"
    And I then need to enter my "<username>" 
    Given I also want to enter my "<password>"
    When I am done entering my info i click Sign Up
    Then I get <status> Lastly I verify with "<check>"
    

    Examples: 
      | email  | username | password  | status | check |
      | Gabbe@gmail.com |    Gabbegabbe | Super_sa:k3rt | succes | Check your email |
