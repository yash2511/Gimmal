package com.GimmalMIR.StepDefination;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.GimmalMIR.Listeners.Report;
import com.GimmalMIR.Pages.EditMIRPage;
import com.GimmalMIR.Pages.GovernanceHubDashboardPage;
import com.GimmalMIR.Pages.MIRInstalledSiteURLPage;
import com.GimmalMIR.Pages.MIRLibraryPage;
import com.GimmalMIR.Pages.MetadataInheritanceRulesPage;
import com.GimmalMIR.Pages.MicrosoftLoginPage;
import com.GimmalMIR.Pages.SettingsMenuPage;
import com.GimmalMIR.Pages.SiteContentsPage;
import com.GimmalMIR.Pages.SiteSettingsPage;
import com.GimmalMIR.Utilities.ExcelUtils;
import com.GimmalMIR.Utilities.TestConfig;
import com.GimmalMIR.core.Testfactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MIR {

	Report reporter = new Report();

	@Before
	public void beforeScenario(Scenario scenario) {
		reporter.startReport();
		reporter.startTest(scenario.getName());
	}

	@After
	public void afterScenario(Scenario scenario) {
		System.out.println("This will run after the Scenario");
		reporter.endTest(scenario.getName());
	}

	@Given("^Offie365 url is launched$")
	public void Office365_Url_Is_Launched() throws Throwable {
		try {
			Testfactory.launchapplication(TestConfig.getConfigDetails().get("browser"));
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());
		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

		}
	}

	@When("^User Enters valid username and password$")
	public void User_Enters_valid_Username_And_Password() throws Throwable {
		try {
			MicrosoftLoginPage login = new MicrosoftLoginPage();

			login.clickLoginbutton(TestConfig.getConfigDetails().get("Username"),
					TestConfig.getConfigDetails().get("Password"));
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());
		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

		}
	}

	@Then("^Verify if office365 is opened$")
	public void Verify_If_Office365_is_opened() throws Throwable {
		try {
			MicrosoftLoginPage login = new MicrosoftLoginPage();

			login.isOffice365PageOpen("Office 365");
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());

		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));
		}
	}

	@Given("^User is on govhub dashboard$")
	public void User_is_on_govhub_dashboard() throws Throwable {
		try {
			SettingsMenuPage setting = new SettingsMenuPage();
			setting.clickOnSeetingsIcon();
			Thread.sleep(1000);
			setting.clickOnSiteSettingsLink();
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());
		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

		}
	}

	@When("^User click on govhublink from site settings$")
	public void User_click_on_govhublink_from_site_settings() throws Throwable {
		try {
			SiteSettingsPage settingPage = new SiteSettingsPage();
			settingPage.clickOnGovHubLink();
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());
		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

		}
	}

	@Then("^Verify if govhub dashboard is open$")
	public void Verify_if_govhub_dashboard_is_open() throws Throwable {
		try {
			GovernanceHubDashboardPage govHub = new GovernanceHubDashboardPage();
			govHub.isDisaplyGovHubDashboard();	
			
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());

		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));
		}
	}
	
	
	@Given("^User is on MIR rules page$")
	public void User_is_on_MIR_rules_page() throws Throwable {
		try {
			GovernanceHubDashboardPage GovHubDash = new GovernanceHubDashboardPage();
			GovHubDash.clickOnMIRApp();
			MetadataInheritanceRulesPage mir = new MetadataInheritanceRulesPage();
			mir.clickOnallSitesEllipsis();
		
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());
		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

		}
	}

	@When("^User click on Edit Metadata Inheritance Rules$")
	public void User_click_on_Edit_Metadata_Inheritance_Rules() throws Throwable {
		try {
			MetadataInheritanceRulesPage mir = new MetadataInheritanceRulesPage();
			EditMIRPage page = new EditMIRPage();
			mir.clickOneditMetadataInheritanceRules();
			Testfactory.switchToNewTab(1);
			page.enterTheRuleForm();

			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());
		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

		}
	}

	@Then("^Verify MIR rule is creted or not$")
	public void Verify_MIR_rule_is_creted_or_not() throws Throwable {
		try {
			EditMIRPage page = new EditMIRPage();
			page.verifyCrretedMIRRule();
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());

		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));
		}
	}

	@Given("^User is on MIR installed test site$")
	public void User_is_on_MIR_installed_test_site() throws Throwable {
		try {
			GovernanceHubDashboardPage GovHubDash = new GovernanceHubDashboardPage();
			MetadataInheritanceRulesPage page = new MetadataInheritanceRulesPage();
			GovHubDash.clickOnMIRApp();
			page.clickOnallSitesURL();
			Testfactory.switchToNewTab(1);
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());
		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

		}
	}

	@When("^User clicks on the MIR installed test site$")
	public void User_clicks_on_the_MIR_installed_test_site() throws Throwable {
		try {
			MIRInstalledSiteURLPage page = new MIRInstalledSiteURLPage();
			page.clickOnsiteContents();
			SiteContentsPage contents = new SiteContentsPage();
			contents.clickOnclassicView();
			contents.clickOnaddAnApp();
			contents.clickOnDocumentLibrary();
			contents.enterTheLibraryDetails();
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());
		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

		}
	}

	@Then("^Verify document library is created on Testsite$")
	public void Verify_document_library_is_created_on_Testsite() throws Throwable {
		try {
			SiteContentsPage page = new SiteContentsPage();
			page.verifyLibraryName();
			page.clickOnLibrary();
			MIRLibraryPage lib = new MIRLibraryPage();
			lib.clickOnLibrary();
			lib.clickOnLibrarySettings();
			lib.clickOnAdvancedSettings();
			lib.clickOnallowManagedContentTypeChkbx();
			lib.clickOnokBtn();
			lib.clickOnaddContentType();
			lib.clickOnAvialbleSiteContentTypes(ExcelUtils.getSheetData(9, 2 ));
			lib.clickOnaddContentType();
			lib.clickOnAvialbleSiteContentTypes(ExcelUtils.getSheetData(10, 2 ));
			lib.clickOnaddContentType();
			lib.clickOnAvialbleSiteContentTypes(ExcelUtils.getSheetData(9, 2 ));

			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());

		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));
		}
	}

	@Then("^Navigate back to MIR rule page$")
	public void Navigate_back_to_MIR_rule_page() throws Throwable {
		try {
			Testfactory.switchToNewTab(0);
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());

		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));
		}
	}

	
}
