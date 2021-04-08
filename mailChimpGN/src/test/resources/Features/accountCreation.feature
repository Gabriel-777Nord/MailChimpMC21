Feature: Account creation
  I want to use this template for my feature file

  Scenario Outline: Mailchimp account
  
    Given I want to enter my "<email>"
    And I then enter my "<username>" 
    And I also enter my "<password>"
    When I am done entering my info I click Sign Up
    Then I decide if test should give error or not with <status> and lastly I verify with <check>
    

    Examples: 
      | email  | username | password  | status | check |
      | Gabbe@gmail.com |  Gabbegabbe | Super_sa:k3rt | succes | "Check your email" |
      | Gabbe@gmail.com |  Gabbe123456789101112131415171819202122234252627282930313233343536373839404142434445464748495051525354 | Super_sa:k3rt | fail |  " characters long"  |
      | Gabbe@gmail.com | generiskanvandare |Super_sa:k3rt | fail | "Another user with this username already exists." |
			| blank | Gabbegabbe | Super_sa:k3rt | fail | "Please enter a "|
      
      
