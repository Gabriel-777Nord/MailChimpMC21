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
      | Gabbe@gmail.com |  Gabbe123456789101112131415171819202122234252627282930313233343536373839404142434445464748495051525354 | Super_sa:k3rt | fail | Enter a value less than 100 characters long |
      
