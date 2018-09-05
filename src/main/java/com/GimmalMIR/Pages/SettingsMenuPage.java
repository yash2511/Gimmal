package com.GimmalMIR.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GimmalMIR.core.Testfactory;

public class SettingsMenuPage {

	@FindBy(xpath = "//a[@id='O365_SubLink_SuiteMenu_zz10_MenuItem_Settings']")
	private WebElement siteSettingsLink;

	@FindBy(xpath = "//button[@id='O365_MainLink_Settings']")
	private WebElement settingsMenu;

	public SettingsMenuPage() {
		PageFactory.initElements(Testfactory.driver, this);
	}

	public void clickOnSeetingsIcon() {
		try {
			Testfactory.clickAction(settingsMenu);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnSiteSettingsLink() {
		try {
			Testfactory.clickAction(siteSettingsLink);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
