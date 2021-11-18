Feature: RULE_CONF_CRUD_API
Rule configurations using rule CRUD APIs 



Scenario: User tries to Create "Ledger to Ledger" type Rules from an API end point
Given I have Selected Reconciliation Type as "Ledger to Ledger"

When I enter Rule Name as "L2L_Rule1", Rule Description as "L2L_Rule1"
and select the Reconciliation Type as "Ledger to Ledger(SRT)", Legal Entity as "Bank Holding Company([HGL008].[LE1].[LE2])" 
and Consolidation Type as "Solo(S)", Balance Type as "End of Period Balance(EOP)"
and GL Hierarchy as "ASSET([HGL009].[00001].[10200])", Target Entity as "Stage Management Ledger"
and GL Reconciliation Column as "Balance" 
and in the  Target Parameters select Threshold Specification as "percentage(PCT)", Negative Threshold as "1", Adjustment Entry Floor as "2", Positive Threshold as "3"
and click on "SAVE"
Then the response should be success (Response Code- 200OK) for these CRUD operations


Scenario: User tries to Create "Management Ledger to Product Processor" type Rules from an API end point
Given I have Selected Reconciliation Type as "Management Ledger to Product Processor"

When I enter Rule Name as "ML2PP_Rule1", Rule Description as "ML2PP_Rule1"
and select the Reconciliation Type as "Management Ledger to Product Processor(SRT)", Legal Entity as "Bank Holding Company([HGL008].[LE1].[LE2])" 
and Consolidation Type as "Solo(S)", Balance Type as "End of Period Balance(EOP)"
and GL Hierarchy as "ASSET([HGL009].[00001].[10200])", Target Entity as "Stage Cards"
and GL Reconciliation Column as "End of Period Balance" 
and in the  Target Parameters select Threshold Specification as "percentage(PCT)", Negative Threshold as "1", Adjustment Entry Floor as "2", Positive Threshold as "3"
and select Adjustment Attributes as "Legal Entity Code"
and click on "SAVE"
Then the response should be success (Response Code- 200OK) for these CRUD operations


Scenario: User tries to Create "General Ledger to Product Processor" type Rules from an API end point
Given I have Selected Reconciliation Type as "General Ledger to Product Processor"

When I enter Rule Name as "GL2PP_Rule1", Rule Description as "GL2PP_Rule1"
and select the Reconciliation Type as "General Ledger to Product Processor(SRT)", Legal Entity as "Bank Holding Company([HGL008].[LE1].[LE2])" 
and Consolidation Type as "Solo(S)", Balance Type as "End of Period Balance(EOP)"
and GL Hierarchy as "ASSET([HGL009].[00001].[10200])", Target Entity as "Stage Cards"
and GL Reconciliation Column as "End of Period Balance" 
and in the  Target Parameters select Threshold Specification as "percentage(PCT)", Negative Threshold as "1", Adjustment Entry Floor as "2", Positive Threshold as "3"
and select Adjustment Attributes as "Account Manager Code"
and click on "SAVE"
Then the response should be success (Response Code- 200OK) for these CRUD operations


Scenario: User tries to Create "General Ledger to Product Processor" type Rules with the Rule name of more than 60 characters field length from an API end point
Given I have Selected Reconciliation Type as "General Ledger to Product Processor" and Rule name with the field length more than 60 characters

When I enter Rule Name as "GL2PPGL2PPGL2PPGL2PPGL2PPGL2PPGL2PPGL2PPGL2PPGL2PPGL2PPGL2PP", Rule Description as "GL2PP_Rule1"
and select the Reconciliation Type as "General Ledger to Product Processor(SRT)", Legal Entity as "Bank Holding Company([HGL008].[LE1].[LE2])" 
and Consolidation Type as "Solo(S)", Balance Type as "End of Period Balance(EOP)"
and GL Hierarchy as "ASSET([HGL009].[00001].[10200])", Target Entity as "Stage Cards"
and GL Reconciliation Column as "End of Period Balance" 
and in the  Target Parameters select Threshold Specification as "percentage(PCT)", Negative Threshold as "1", Adjustment Entry Floor as "2", Positive Threshold as "3"
and select Adjustment Attributes as "Account Manager Code"
and click on "SAVE"
Then the response should be Internal server Error(Response Code- 500) for these CRUD operations


