@GL_Reconciliation_process @TYPE_CONF_CRUD_API
Feature: TYPE_CONF_CRUD_API
Type configurations using Type CRUD APIs 
 
@smoke
@CreationAPI
Scenario: User tries to Create an entity configuration -"General Ledger to Product Processor"
Given Source Grain, Source Entity, Target Entity, Dimensions And the dimension attributes are available to select
 
When I enter a name And description for the type "General Ledger to Product Processor" and code as "SRT1"
And chose Source Grain as "GL", Source Entity as "STG_GL_DATA"
And Target Entity as "STG_CARDS, STG_LOAN_CONTRACTS" and target grain as "PP"
And select the Dimension as "Currency" and attribute as "Currency Code"  and dimension value as "HGL005"
And select the Dimension as "Currency" and attribute as "Currency Code"  and dimension value as "HGL005"
Then the response should be success (Response Code- 200OK) for these CRUD operations

@smoke
@CreationAPI
Scenario: User tries to Create an entity configuration -"Management Ledger to Product Processor"
Given Source Grain, Source Entity, Target Entity, Dimensions And the dimension attributes are available to select
 
When I enter a name And description for the type "Management Ledger to Product Processor" and code as "SRT4"
And chose Source Grain as "MGL", Source Entity as "STG_MANAGEMENT_LEDGER"
And Target Entity as "STG_CARDS, STG_LOAN_CONTRACTS" and target grain as "PP"
And select the Dimension as "Currency" and attribute as "Currency Code"  and dimension value as "HGL005"
And select the Dimension as "Currency" and attribute as "Currency Code"  and dimension value as "HGL005"
Then the response should be success (Response Code- 200OK) for these CRUD operations

@smoke
@CreationAPI
Scenario: User tries to Create an entity configuration -"Ledger to Ledger"
Given Source Grain, Source Entity, Target Entity, Dimensions And the dimension attributes are available to select
 
When I enter a name And description for the type "Ledger to Ledger" and code as "SRT2"
And chose Source Grain as "GL", Source Entity as "STG_GL_DATA"
And Target Entity as "STG_CARDS, STG_LOAN_CONTRACTS" and target grain as "PP"
And select the Dimension as "Currency" and attribute as "Currency Code"  and dimension value as "HGL005"
And select the Dimension as "Currency" and attribute as "Currency Code"  and dimension value as "HGL005"
Then the response should be success (Response Code- 200OK) for these CRUD operations




@smoke
Scenario: EDIT different Type configurations which are available / used in system
Given I have different Type configurations exists in the system
 
When I chose "General Ledger to Product Processor" type and code as "SRT1"
And for Source Grain as "GL", Source Entity as "STG_GL_DATA"
And Update the Description of the Type configuration and select a new target entity as "STG_LOAN_CONTRACTS" and target grain as "PP"
And the selected Dimension is "Currency" and attribute as "Currency Code"  and dimension value is "HGL005"
Then the response should be success (Response Code- 200OK) for this edit operation

@smoke
Scenario: User tries to Delete a Type configuration -Ledger to Ledger
Given entity configurations exists in the system for deletion
 
When I chose the Type configuration for deletion as "Ledger to Ledger" and code is "SRT4"
And Delete the configuration
Then the response should be success (Response Code- 200OK) for this delete operation.



