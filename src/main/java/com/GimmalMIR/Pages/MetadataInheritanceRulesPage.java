package com.GimmalMIR.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GimmalMIR.core.Testfactory;

public class MetadataInheritanceRulesPage {

	List<WebElement> allSitesEllipsis = Testfactory.driver
			.findElements(By.xpath("//a[@class='ms-lstItmLinkAnchor ms-ellipsis-a']"));

	@FindBy(xpath = "//input[@value='Save']")
	private WebElement saveButton;

	@FindBy(xpath = "//span[@class='ms-core-menu-title' and text()='Edit Metadata Inheritance Rules']")
	private WebElement editMetadataInheritanceRules;

	@FindBy(xpath = "//span[@class='ms-core-menu-title' and text()='Publish Global Configuration']")
	private WebElement publishGlobalConfiguration;

	@FindBy(xpath = "//a[@href='https://gimmalqaindia.sharepoint.com/sites/MIR_New']")
	private WebElement siteURL;

	public MetadataInheritanceRulesPage() {
		PageFactory.initElements(Testfactory.driver, this);
	}

	public void clickOnallSitesEllipsis() {
		try {
			Testfactory.selectWebElementUsingAction(allSitesEllipsis, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnallSitesURL() {
		try {
			Testfactory.clickAction(siteURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOneditMetadataInheritanceRules() {
		try {
			Testfactory.clickAction(editMetadataInheritanceRules);
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnPublishGlobalConfiguration() {
		try {
			Testfactory.clickAction(publishGlobalConfiguration);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnallsaveButton() {
		try {
			Testfactory.clickAction(saveButton);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
