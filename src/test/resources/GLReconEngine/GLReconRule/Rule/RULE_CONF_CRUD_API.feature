@GLReconEngine @Rule @RULE_CONF_CRUD_API
Feature: RULE_CONF_CRUD_API
Rule configurations using rule CRUD APIs 


@smoke
Scenario: User tries to Create "Ledger to Ledger" type Rules from an API end point
Given I have Selected Reconciliation Type as "Ledger to Ledger"

When I enter Rule Name as "L2L_Rule1", Rule Description as "L2L_Rule1"
And select the Reconciliation Type as "Ledger to Ledger(SRT)", Legal Entity as "Bank Holding Company([HGL008].[LE1].[LE2])" 
And Consolidation Type as "Solo(S)", Balance Type as "End of Period Balance(EOP)"
And GL Hierarchy as "ASSET([HGL009].[00001].[10200])", Target Entity as "Stage Management Ledger"
And GL Reconciliation Column as "Balance" 
And in the  Target Parameters select Threshold Specification as "percentage(PCT)", Negative Threshold as "1", Adjustment Entry Floor as "2", Positive Threshold as "3"
And click on "SAVE"
Then the response should be success (Response Code- 200OK) for these CRUD operations


Scenario: User tries to Create "Management Ledger to Product Processor" type Rules from an API end point
Given I have Selected Reconciliation Type as "Management Ledger to Product Processor"

When I enter Rule Name as "ML2PP_Rule1", Rule Description as "ML2PP_Rule1"
And select the Reconciliation Type as "Management Ledger to Product Processor(SRT)", Legal Entity as "Bank Holding Company([HGL008].[LE1].[LE2])" 
And Consolidation Type as "Solo(S)", Balance Type as "End of Period Balance(EOP)"
And GL Hierarchy as "ASSET([HGL009].[00001].[10200])", Target Entity as "Stage Cards"
And GL Reconciliation Column as "End of Period Balance" 
And in the  Target Parameters select Threshold Specification as "percentage(PCT)", Negative Threshold as "1", Adjustment Entry Floor as "2", Positive Threshold as "3"
And select Adjustment Attributes as "Legal Entity Code"
And click on "SAVE"
Then the response should be success (Response Code- 200OK) for these CRUD operations


Scenario: User tries to Create "General Ledger to Product Processor" type Rules from an API end point
Given I have Selected Reconciliation Type as "General Ledger to Product Processor"

When I enter Rule Name as "GL2PP_Rule1", Rule Description as "GL2PP_Rule1"
And select the Reconciliation Type as "General Ledger to Product Processor(SRT)", Legal Entity as "Bank Holding Company([HGL008].[LE1].[LE2])" 
And Consolidation Type as "Solo(S)", Balance Type as "End of Period Balance(EOP)"
And GL Hierarchy as "ASSET([HGL009].[00001].[10200])", Target Entity as "Stage Cards"
And GL Reconciliation Column as "End of Period Balance" 
And in the  Target Parameters select Threshold Specification as "percentage(PCT)", Negative Threshold as "1", Adjustment Entry Floor as "2", Positive Threshold as "3"
And select Adjustment Attributes as "Account Manager Code"
And click on "SAVE"
Then the response should be success (Response Code- 200OK) for these CRUD operations


Scenario: User tries to Create "General Ledger to Product Processor" type Rules with the Rule name of more than 60 characters field length from an API end point
Given I have Selected Reconciliation Type as "General Ledger to Product Processor" And Rule name with the field length more than 60 characters

When I enter Rule Name as "GL2PPGL2PPGL2PPGL2PPGL2PPGL2PPGL2PPGL2PPGL2PPGL2PPGL2PPGL2PP", Rule Description as "GL2PP_Rule1"
And select the Reconciliation Type as "General Ledger to Product Processor(SRT)", Legal Entity as "Bank Holding Company([HGL008].[LE1].[LE2])" 
And Consolidation Type as "Solo(S)", Balance Type as "End of Period Balance(EOP)"
And GL Hierarchy as "ASSET([HGL009].[00001].[10200])", Target Entity as "Stage Cards"
And GL Reconciliation Column as "End of Period Balance" 
And in the  Target Parameters select Threshold Specification as "percentage(PCT)", Negative Threshold as "1", Adjustment Entry Floor as "2", Positive Threshold as "3"
And select Adjustment Attributes as "Account Manager Code"
And click on "SAVE"
Then the response should be Internal server Error(Response Code- 500) for these CRUD operations


