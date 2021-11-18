@GL_Reconciliation_process @ENT_CONFIGURATIONS 
Feature: ENT_CONF_CRUD_API_1
Entity configurations using Entity CRUD APIs 
 
 @smoke 
@Creation1
Scenario: User tries to Create an entity configuration -Account
Given Grain, Entity, Dataset and Measures
 
When I chose Grain as "PP", Entity as "Stage Cards" 
And the equivalent Dataset which is "DSGL012" and Measures "End of Period Balance" are selected
Then the response should be success i.e Response Code =  "200" for these CRUD operations


@Creation2
Scenario: User tries to Create an entity configuration -Management Ledger
Given Grain, Entity, Dataset and Measures
 
When I chose Grain as "Management Ledger", Entity as "Stage Management Ledger" 
And the equivalent Dataset which is "MGMTLEDG" and Measures "End of Period Balance" are selected
Then the response should be success i.e Response Code =  "200" for these CRUD operations

@Creation3
Scenario: User tries to Create an entity configuration -Ledger
Given Grain, Entity, Dataset and Measures
 
When I chose Grain as "Ledger", Entity as "Stage General Ledger Data" 
And the equivalent Dataset which is "DSGL014" and Measures "End of Period Balance" are selected
Then the response should be success i.e Response Code =  "200" for these CRUD operations

@Updation1
Scenario: User tries to Update an entity configuration -Account
Given Grain and Entity fields are disabled and Dataset and Measures can be changed
 
When I chose Grain as "PP", Entity as "Stage Cards" and chose Dataset which is "DSGL012" 
And Measures "Commission Amount" are selected
Then the response should be success i.e Response Code =  "200" for this update operation

@Deletion1
Scenario: User tries to Delete an entity configuration -Account
Given entity configurations exists in the system
 
When I chose Grain as "PP" and Entity configuration for "Stage Cards" and Delete the configuration
Then the response should be success i.e Response Code =  "200" for this delete operation

