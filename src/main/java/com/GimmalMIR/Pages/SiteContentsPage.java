package com.GimmalMIR.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.GimmalMIR.Utilities.ExcelUtils;
import com.GimmalMIR.core.Testfactory;

public class SiteContentsPage {
	@FindBy(xpath = "//a[@aria-label='Click or enter to return to classic SharePoint']")
	private WebElement classicView;
	
	@FindBy(xpath="//div[@id='apptile-appadd']")
	private WebElement addAnApp;
	
	@FindBy(xpath="//iframe[@class='ms-dlgFrame']")
	private WebElement nameTextBox;
	
	@FindBy(xpath="//*[@id='ctl00_PlaceHolderMain_onetidCreateList']")
	private WebElement create;
	
	@FindBy(xpath="//span[@class='ms-core-menu-title' and text()='Publish Global Configuration']")
	private WebElement publishGlobalConfiguration;
	
	//WebElement libraryname= ;
	

	
	@FindBy(xpath="//div[contains(text(),'Document Library')]")
	private WebElement documentLibrary;
	
	
	public SiteContentsPage() {
		PageFactory.initElements(Testfactory.driver, this);
	}
	
	public void clickOnclassicView()
	{
		try{
			Testfactory.clickAction(classicView);
		}catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
	public void clickOnaddAnApp()
	{
		try{
			Testfactory.clickAction(addAnApp);
		}catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
	public void clickOnDocumentLibrary()
	{
		try{
			Testfactory.clickAction(documentLibrary);
		}catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
	
	
	public void switchToFrame()
	{
		try{
			Testfactory.switchToIframe((Testfactory.driver.findElements(By.xpath("//a[contains(text(), '" + ExcelUtils.getSheetData(9, 1) + "')]"))), 0);
		}catch(Exception e){
			
		}
	}
	public void enterTheLibraryDetails()
	{
		try{
			Testfactory.Actions( ExcelUtils.getSheetData(9, 1));
			Actions act = new Actions(Testfactory.driver);
			act.sendKeys(Keys.TAB).build().perform();
			act.sendKeys(Keys.TAB).build().perform();
			act.sendKeys(Keys.ENTER).build().perform();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
	
	public void clickOncreate()
	{
		try{
			Testfactory.clickAction(create);
		}catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
	
	public void clickOnLibrary()
	{
		try{
			Testfactory.clickAction(Testfactory.driver.findElement(By.xpath("//a[contains(text(), '" + ExcelUtils.getSheetData(9, 1) + "')]")));
		}catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
	public void verifyLibraryName()
	{
		try{
			boolean b;
			b = Testfactory.driver.findElement(By.xpath("//a[contains(text(), '" + ExcelUtils.getSheetData(9, 1) + "')]")).isDisplayed();
			Assert.assertTrue(b); 
		}catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
	
}
