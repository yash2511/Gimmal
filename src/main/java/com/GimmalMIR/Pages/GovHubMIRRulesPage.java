package com.GimmalMIR.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GimmalMIR.core.Testfactory;

public class GovHubMIRRulesPage {
	
	@FindBy(xpath = "//span[text()='new item']")
	private WebElement newItem;
	
	@FindBy(xpath="//input[@value='Save']")
	private WebElement saveButton;
	
	@FindBy(xpath="//span[@class='ms-core-menu-title' and text()='Edit Metadata Inheritance Rules']")
	private WebElement editEditMetadataInheritanceRules;
	
	@FindBy(xpath="//span[@class='ms-core-menu-title' and text()='Publish Global Configuration']")
	private WebElement publishGlobalConfiguration;
	
	
	
	public GovHubMIRRulesPage() {
		PageFactory.initElements(Testfactory.driver, this);
	}
	
	public void clickOnallSitesEllipsis()
	{
		try{
			Testfactory.clickAction(newItem);
		}catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
	public void clickOnEditSettings()
	{
		try{
			Testfactory.clickAction(editEditMetadataInheritanceRules);
		}catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
	
	public void clickOnPublishGlobalConfiguration()
	{
		try{
			Testfactory.clickAction(publishGlobalConfiguration);
		}catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
	public void clickOnallsaveButton()
	{
		try{
			Testfactory.clickAction(saveButton);
		}catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
}
