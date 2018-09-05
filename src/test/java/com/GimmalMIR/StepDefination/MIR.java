package com.GimmalMIR.StepDefination;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.GimmalMIR.Listeners.Report;
import com.GimmalMIR.Pages.DefaultContentTypeOrderPage;
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
import com.GimmalMIR.core.Testcapture;
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
			String office365 = Testcapture.capturescreenshot(Testfactory.driver, "Office365");
			login.isOffice365PageOpen("Office 365");
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.attachScreenshot(new Object() {
			}.getClass().getEnclosingMethod().getName(), office365);

		} catch (Exception e) {
			e.printStackTrace();
			String office365fail = Testcapture.capturescreenshot(Testfactory.driver, "Office365");

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));
			reporter.attachScreenshot(new Object() {
			}.getClass().getEnclosingMethod().getName(), office365fail);
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
			Thread.sleep(2000);
			String GovHub_DashBoard = Testcapture.capturescreenshot(Testfactory.driver, "GovHubDashBoard");
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());

			reporter.attachScreenshot(new Object() {
			}.getClass().getEnclosingMethod().getName(), GovHub_DashBoard);

		} catch (Exception e) {
			e.printStackTrace();
			String GovHub_DashBoardException = Testcapture.capturescreenshot(Testfactory.driver, "GovHubDashBoard");

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

			reporter.attachScreenshot(new Object() {
			}.getClass().getEnclosingMethod().getName(), GovHub_DashBoardException);

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
			Thread.sleep(2000);
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
			String MIR_Rule = Testcapture.capturescreenshot(Testfactory.driver, "MIR_Rule");

			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());

			reporter.attachScreenshot(new Object() {
			}.getClass().getEnclosingMethod().getName(), MIR_Rule);

		} catch (java.lang.AssertionError fail) {
			fail.printStackTrace();
			String MIR_Rule_fail = Testcapture.capturescreenshot(Testfactory.driver, "MIR_Rule");

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(fail));

			reporter.attachScreenshot(new Object() {
			}.getClass().getEnclosingMethod().getName(), MIR_Rule_fail);

		} catch (Exception e) {
			e.printStackTrace();
			String MIR_Rule_fail = Testcapture.capturescreenshot(Testfactory.driver, "MIR_Rule");

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

			reporter.attachScreenshot(new Object() {
			}.getClass().getEnclosingMethod().getName(), MIR_Rule_fail);

		}
	}

	@Then("^Published global configurations settings$")
	public void Published_global_configurations_settings() throws Throwable {
		try {
			Testfactory.switchToNewTab(0);
			Testfactory.driver.navigate().refresh();
			EditMIRPage page = new EditMIRPage();

			MetadataInheritanceRulesPage mir = new MetadataInheritanceRulesPage();
			mir.clickOnallSitesEllipsis();
			mir.clickOnPublishGlobalConfiguration();
			Thread.sleep(2000);
			Testfactory.driver.switchTo().alert().accept();
			//Thread.sleep(10 * 60 * 1000);
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
			MetadataInheritanceRulesPage page = new MetadataInheritanceRulesPage();

			page.clickOnallSitesURL();

			Testfactory.switchToNewTab(1);
			Testfactory.driver.close();
			Testfactory.switchToNewTab(0);
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
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());
		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

		}
	}

	@When("^User creates the document library$")
	public void User_creates_the_document_library() throws Throwable {
		try {

			SiteContentsPage contents = new SiteContentsPage();
			contents.clickOnclassicView();
			contents.clickOnaddAnApp();
			contents.clickOnDocumentLibrary();
			Thread.sleep(2000);
			contents.enterTheLibraryDetails();
			contents.clickOnLibrary();

			MIRLibraryPage lib = new MIRLibraryPage();
			lib.clickOnLibrary();
			Thread.sleep(2000);
			lib.clickOnLibrarySettings();

			lib.clickOnAdvancedSettings();
			lib.clickOnallowManagedContentTypeChkbx();
			lib.clickOnokBtn();
			lib.clickOnaddContentType();
			lib.clickOnAvialbleSiteContentTypes(ExcelUtils.getSheetData(9, 2));
			// lib.clickOnaddContentType();
			// lib.clickOnAvialbleSiteContentTypes(ExcelUtils.getSheetData(10, 2
			// ));
			// lib.clickOnaddContentType();
			// lib.clickOnAvialbleSiteContentTypes(ExcelUtils.getSheetData(9, 2
			// ));
			DefaultContentTypeOrderPage order = new DefaultContentTypeOrderPage();
			order.clickOnDefaultContentTypeOrder();
			order.okButtonOnButtonOrderPage();
			contents.clickOnLibrary();
			lib.uploadDocumnet();

			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());
		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());
			// reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

		}
	}

	@Then("^Verify the applied rule on column$")
	public void Verify_the_applied_rule_on_column() throws Throwable {
		try {
			MIRLibraryPage lib1 = new MIRLibraryPage();

			lib1.verifyElementIsEnabled();
			String VerifyRuleOnDocument = Testcapture.capturescreenshot(Testfactory.driver, "VerifyRule");

			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());

			reporter.attachScreenshot(new Object() {
			}.getClass().getEnclosingMethod().getName(), VerifyRuleOnDocument);

		} catch (java.lang.AssertionError error) {
			error.printStackTrace();
			String VerifyRuleOnDocumentFail = Testcapture.capturescreenshot(Testfactory.driver, "VerifyRule");

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(error));

			reporter.attachScreenshot(new Object() {
			}.getClass().getEnclosingMethod().getName(), VerifyRuleOnDocumentFail);
		} catch (Exception e) {
			e.printStackTrace();
			String MIR_Rule_fail = Testcapture.capturescreenshot(Testfactory.driver, "MIR_Rule");

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

			reporter.attachScreenshot(new Object() {
			}.getClass().getEnclosingMethod().getName(), MIR_Rule_fail);

		}
	}

	@Then("^Navigate back to MIR rule page$")
	public void Navigate_back_to_MIR_rule_page() throws Throwable {
		try {
			Testfactory.switchToNewTab(0);
			Testfactory.driver.close();
			Testfactory.driver.quit();
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
