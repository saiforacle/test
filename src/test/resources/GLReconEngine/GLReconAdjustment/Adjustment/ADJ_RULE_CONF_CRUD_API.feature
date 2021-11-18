@GLReconEngine @Adjustment @ADJ_RULE_CONF_CRUD_API
Feature: ADJ_RULE_CONF_CRUD_API
  Adjustment Rule configurations using rule CRUD APIs

  #1.create
  @smoke
  Scenario: User tries to create an Adjustment Rule with Adjustment Entity
    Given 1the Entity "Stage Cards1a" and the attribute "Account Branch Code" is present with Adjustment Entity using "Stage Cards1b"
    When 1I chose Entity as "Stage Cards1c" and enter the Name as "Test  Prod1", description as "test 202" and select the attribute as "Account Branch Code" and the Target Expression as "MUM"
    Then 1create the response should be(Response Code- 200OK) for these CRUD operations 

  #2.create
  Scenario: User tries to create an Adjustment Rule with Adjustment Entity 
    Given 2the Entity "Stage Cards2a" and the attribute2 "Application Number" is present with Adjustment Entity using "Stage Cards2b"
    When 2I chose Entity as "Stage Cards2c" and enter the Name as "Test  Prod2", description as "test 202" and select the attribute as "Application Number" and the Target Expression as "25"
    Then 2create the response should be (Response Code- 200OK) for these CRUD operations 

  #3.create
  Scenario: User tries to create an Adjustment Rule with Adjustment Entity 
    Given 3the Entity "Stage Cards3a" and the attribute3 "Account Close Date" is present with Adjustment Entity using "Stage Cards"
    When 3I chose Entity as "Stage Cards3b" and enter the Name as "Test  Prod2", description as "test 202" and select the attribute as "Account Close Date" and the Target Expression as "to_date('12/31/2020','mm/dd/yyyy')"
    Then 3create the response should be (Response Code- 200OK) for these CRUD operations 

  #4.getall
  Scenario: User tries to Get all the Adjustment Rule
    Given 4getall Adjustment Rules exists in the system
    When I select Adjustment Rules and  click on save
    Then 4getall the response should be (Response Code- 200OK) for these CRUD operations 

  #5.get
  Scenario: User tries to Get the specified Adjustment Rule
    Given 5get Adjustment Rules exists in the system
    When I select an Adjustment Rule for Stage Cards  and  click on save
    Then 5get the response should be (Response Code- 200OK) for these CRUD operations 

  #6.delete
  Scenario: User tries to Delete an Adjustment Rule
    Given 6delete Adjustment Rules exists in the system
    When I select an Adjustment Rule with Entity as "Stage Cards6a", attribute "Account Branch Code"  and  click on save
    Then 6delete the response should be (Response Code- 200OK) for these CRUD operations 

  #7.update
  Scenario: User tries to Update an Adjustment Rule with Adjustment Entity using "Stage Cards7a" and ID as "101"
    Given Adjustment Rule with Entity as "Stage Cards7b", attribute "Account Branch Code" ,Request Type as "PUT" and ID as "101" is present
    When I chose a Rule with Entity as "Stage Cards7c",attribute "Account Branch Code" and  request type as "PUT" , ID as "101" and select Account Branch code with an expression as "test"  and select Application Number with an expression as "25"  and click on save
    Then 7update the response should be (Response Code- 200OK) for these CRUD operations
