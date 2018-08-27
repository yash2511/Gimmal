package com.GimmalMIR.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GimmalMIR.Utilities.ExcelUtils;
import com.GimmalMIR.core.Testfactory;

public class MIRLibraryPage {
	
	@FindBy(xpath = "//span[text()='Library']")
	private WebElement library ;
	
	@FindBy(xpath="//a[@id='ctl00_PlaceHolderMain_ctl09_RptControls_onetidListEdit10']")
	private WebElement advancedSettings;
	
	@FindBy(xpath="//input[@id='ctl00_PlaceHolderMain_ContentTypeSection_ctl02_RadEnableContentTypesYes']")
	private WebElement allowManagedContentTypeChkbx;
	
	
	@FindBy(xpath="//input[@id='ctl00_PlaceHolderMain_ctl00_RptControls_BtnSaveAsTemplate']")
	private WebElement okBtn;
	
	@FindBy(xpath="//a[@id='LinkAddContentTypeToList']")
	private WebElement addContentType;
	
	
	@FindBy(xpath="//button[@id='ctl00_PlaceHolderMain_ctl00_AddButton']")
	private WebElement addButton;
	
	@FindBy(xpath="//input[@id='ctl00_PlaceHolderMain_ctl01_RptControls_btnOK']")
	private WebElement OkButtonOnAddContentType;
	
	@FindBy(xpath="//select[@id='ctl00_PlaceHolderMain_ctl00_SelectCandidate']")
	private WebElement switchToContentTypeBox;
	
	@FindBy(xpath="//button[@id='QCB1_Button2']")
	private WebElement uploadButton;
	
	public MIRLibraryPage() {
		PageFactory.initElements(Testfactory.driver, this);
	}
	
	public void clickOnLibrary()
	{
		try{
			Testfactory.clickAction(library);
		}catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
	
	public void clickOnAdvancedSettings()
	{
		try{
			Testfactory.clickAction(advancedSettings);
		}catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
	public void clickOnallowManagedContentTypeChkbx()
	{
		try{
			Testfactory.clickAction(allowManagedContentTypeChkbx);
		}catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
	public void clickOnOkButtonOnAddContentType()
	{
		try{
			Testfactory.clickAction(OkButtonOnAddContentType);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
	
	public void clickOnokBtn()
	{
		try{
			Testfactory.clickAction(okBtn);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
	public void clickOnaddContentType()
	{
		try{
			Testfactory.clickAction(addContentType);
		}catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
	public void clickOnLibrarySettings()
	{
		try{
			Testfactory.selectWebElement(Testfactory.driver.findElements(By.xpath("//span[@class='ms-cui-ctl-largelabel']")), 14);
		}catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
	public void clickOnAvialbleSiteContentTypes(String contenttype)
	{
		try{
			Testfactory.modeldropdownlist(Testfactory.driver.findElements(By.xpath("//select[@id='ctl00_PlaceHolderMain_ctl00_SelectCandidate']")), contenttype);
			Testfactory.clickAction(addButton);
			Testfactory.clickAction(OkButtonOnAddContentType);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
	
}
