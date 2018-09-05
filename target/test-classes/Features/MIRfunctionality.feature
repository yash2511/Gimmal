Feature: MIR feature

Scenario: User is Logged In to the office 365
	Given Offie365 url is launched
	When User Enters valid username and password 
	Then Verify if office365 is opened
	
Scenario: User is navigated to the GovHub dashboard
	Given User is on govhub dashboard
	When User click on govhublink from site settings 
	Then Verify if govhub dashboard is open
	

Scenario: Create MIR rule
  Given User is on MIR rules page
	When User click on Edit Metadata Inheritance Rules
	Then Verify MIR rule is creted or not
	And Published global configurations settings

	Scenario: User is uploading the document to verify the Rule
	Given User is on MIR installed test site
	When User clicks on the MIR installed test site
	And User creates the document library
	Then Verify the applied rule on column
	And Navigate back to MIR rule page
	

  