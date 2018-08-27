Feature: MIR feature
@smoke
Scenario: User is Logged In to the office 365
	Given Offie365 url is launched
	When User Enters valid username and password 
	Then Verify if office365 is opened
	@smoke
Scenario: User is navigated to the GovHub dashboard
	Given User is on govhub dashboard
	When User click on govhublink from site settings 
	Then Verify if govhub dashboard is open

	
Scenario: Craete MIR rule
  Given User is on MIR rules page
	When User click on Edit Metadata Inheritance Rules
	Then Verify MIR rule is creted or not
	And Navigate back to MIR rule page

	@smoke
	Scenario: User is creating the Document Library
	Given User is on MIR installed test site
	When User clicks on the MIR installed test site
	Then Verify document library is created on Testsite
	And Navigate back to MIR rule page
	

  