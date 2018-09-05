package com.GimmalMIR.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GimmalMIR.core.Testfactory;

public class SiteSettingsPage {

	@FindBy(xpath = "//a[@id='ctl00_PlaceHolderMain_SiteAdministration_RptControls_Gimmal_GovernanceHub_Dashboard']")
	private WebElement governanceHub;

	public SiteSettingsPage() {
		PageFactory.initElements(Testfactory.driver, this);
	}

	public void clickOnGovHubLink() {
		try {
			Testfactory.clickAction(governanceHub);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
