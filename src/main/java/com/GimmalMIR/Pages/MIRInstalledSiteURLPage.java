package com.GimmalMIR.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GimmalMIR.core.Testfactory;

public class MIRInstalledSiteURLPage {

	@FindBy(xpath = "//span[@class='ms-splinkbutton-text']")
	private WebElement siteContents;

	public MIRInstalledSiteURLPage() {
		PageFactory.initElements(Testfactory.driver, this);
	}

	public void clickOnsiteContents() {
		try {
			Testfactory.normalclickAction(siteContents);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
