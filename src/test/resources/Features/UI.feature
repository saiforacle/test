Feature: ENT_TYPE_UI_EDIT
EDIT  Type Configuration from User Interface for different types "Management Ledger to Product Processor", "Ledger to Ledger" and "General Ledger to Product Processor"

@smokeUI
Scenario: User tries to Update the Type configuration - General Ledger to Product Processor.
Given when User Selected the "General Ledger to Product Processor" Type Configuration 
And chose a new entity "Stage Loan Contracts" 
 
When I press "Save" 
Then the UI should give a success message and the Type configuration summary screen should be displayed

Scenario: User tries to click on "Cancel" button on Type configuration screen.
Given when User Selected the "General Ledger to Product Processor" Type Configuration OR  "Ledger to Ledger" Type configuration OR "Management Ledger to Product Processor" Type Configuration.
  
When User click "Cancel" button
Then Type configuration screen should be closed and user should be navigated back to Type Configuration main screen.

Scenario: User tries to Update the Type configuration - Management Ledger to Product Processor.
Given when User Selected the "Management Ledger to Product Processor" Type Configuration 
And chose a new Dimension "Product for Reconciliation"
 
When I press "Save" 
Then the UI should give a success message and the Type configuration summary screen should be displayed

@UI
Scenario: User tries to Update the Type configuration - Ledger to Ledger
Given when User Selected the "Ledger to Ledger" Type Configuration 
And chose a new Dimension "Product for Reconciliation"
 
When I press "Save" 
Then the UI should give a success message and the Type configuration summary screen should be displayed
