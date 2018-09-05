package com.GimmalMIR.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.GimmalMIR.Utilities.ExcelUtils;
import com.GimmalMIR.core.Testfactory;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class EditMIRPage {

	@FindBy(xpath = "//span[text()='new item']")
	private WebElement newItem;

	@FindBy(xpath = "//input[@id='Title_fa564e0f-0c70-4ab9-b863-0177e6ddd247_$TextField']")
	private WebElement title;

	@FindBy(xpath = "//a[@id='a_carbonfield_ContentTypeInfo']")
	private WebElement targetContentType;

	@FindBy(xpath = "//span[@id='carbonAssetPickerTreeview_5_span']")
	private WebElement CustomContentType;

	@FindBy(xpath = "//span[@id='carbonAssetPickerTreeview_26_span']")
	private WebElement MRAcontentType;

	@FindBy(xpath = "//input[@id='carbonAssetPickerOKButton']")
	private WebElement OKButton;

	@FindBy(xpath = "//a[@id='a_carbonfield_FieldInfo']")
	private WebElement clickHerefield;

	@FindBy(xpath = "//span[@id='carbonAssetPickerTreeview_2_span']")
	private WebElement fields;

	@FindBy(xpath = "//span[@id='carbonAssetPickerTreeview_4_span']")
	private WebElement customColumns;

	@FindBy(xpath = "//span[@id='carbonAssetPickerTreeview_6_span']")
	private WebElement MRAChoice;

	@FindBy(xpath = "//select[@title='Mode Required Field']")
	private WebElement mode;

	@FindBy(xpath = "//select[@id='Force_fb7dec92-0d89-415d-a873-0de60a42b432_$DropDownChoice']")
	private WebElement forceVaue;

	@FindBy(xpath = "//select[@id='gimComSyncType_4ead46cc-f8f7-4814-9b77-e819fc9115c2_$DropDownChoice']")
	private WebElement evaluationPriority;

	@FindBy(xpath = "//select[starts-with(@id,'_x')]")
	private WebElement value;

	@FindBy(xpath = "//input[starts-with(@id,'_x')]")
	private WebElement valueText;

	@FindBy(xpath = "//textarea[starts-with(@id,'_x')]")
	private WebElement ValueMLT;

	@FindBy(xpath = "//*[@id='ctl00_ctl40_g_62b90709_c570_454c_b9fd_bd1bb0356b02_ctl00_toolBarTbl']/tbody/tr/td[2]/table/tbody/tr/td")
	private WebElement saveButton;

	public EditMIRPage() {
		PageFactory.initElements(Testfactory.driver, this);
	}

	public void enterTheRuleForm() {
		try {

			Testfactory.clickAction(newItem);
			Testfactory.editTextBox(title, ExcelUtils.getSheetData(2, 0));
			Testfactory.clickAction(targetContentType);
			Thread.sleep(1000);
			Testfactory.clickAction(CustomContentType);
			Thread.sleep(2000);
			Testfactory.selectWebElement(
					Testfactory.driver.findElements(By.xpath("//ul[@id='carbonAssetPickerTreeview_5_ul']/li/a")),
					ExcelUtils.getSheetData(9, 2));
			Testfactory.clickAction(OKButton);
			Thread.sleep(1000);
			Testfactory.normalclickAction(clickHerefield);
			// Thread.sleep(1000);
			// Testfactory.clickAction(fields);
			Thread.sleep(1000);
			Testfactory.normalclickAction(customColumns);
			Thread.sleep(2000);
			Testfactory.selectWebElement(
					Testfactory.driver.findElements(By.xpath("//ul[@id='carbonAssetPickerTreeview_4_ul']/li/a")),
					ExcelUtils.getSheetData(9, 3));
			Thread.sleep(1000);
			Testfactory.normalclickAction(OKButton);
			Testfactory.dropdownaction(mode, ExcelUtils.getSheetData(2, 1));
			Thread.sleep(1000);
			Testfactory.dropdownaction(forceVaue, ExcelUtils.getSheetData(2, 2));
			Thread.sleep(1000);
			Testfactory.dropdownaction(value, ExcelUtils.getSheetData(2, 3));

			Testfactory.dropdownaction(evaluationPriority, ExcelUtils.getSheetData(2, 4));
			List save = Testfactory.driver.findElements(By.xpath("//input[@value='Save']"));
			Thread.sleep(1000);

			Testfactory.selectWebElement(save, 1);
		
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyCrretedMIRRule() {

		boolean title = true;
		WebElement titleElement = Testfactory.driver
				.findElement(By.xpath("//a[@class and contains(text(),'" + ExcelUtils.getSheetData(2, 0) + "')]"));
		// WebElement titleElement =
		// Testfactory.driver.findElement(By.xpath("//a[@class and
		// contains(text(),'" + ExcelUtils.getSheetData(3, 0) + "')]"));

		title = titleElement.isDisplayed();

		Assert.assertTrue(title);
	}
}
