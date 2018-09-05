package com.GimmalMIR.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.GimmalMIR.Utilities.ExcelUtils;
import com.GimmalMIR.core.Testcapture;
import com.GimmalMIR.core.Testexception;
import com.GimmalMIR.core.Testfactory;

public class MIRLibraryPage {

	@FindBy(xpath = "//span[text()='Library']")
	private WebElement library;

	@FindBy(xpath = "//a[@id='ctl00_PlaceHolderMain_ctl09_RptControls_onetidListEdit10']")
	private WebElement advancedSettings;

	@FindBy(xpath = "//input[@id='ctl00_PlaceHolderMain_ContentTypeSection_ctl02_RadEnableContentTypesYes']")
	private WebElement allowManagedContentTypeChkbx;

	@FindBy(xpath = "//input[@id='ctl00_PlaceHolderMain_ctl00_RptControls_BtnSaveAsTemplate']")
	private WebElement okBtn;

	@FindBy(xpath = "//a[@id='LinkAddContentTypeToList']")
	private WebElement addContentType;

	@FindBy(xpath = "//button[@id='ctl00_PlaceHolderMain_ctl00_AddButton']")
	private WebElement addButton;

	@FindBy(xpath = "//input[@id='ctl00_PlaceHolderMain_ctl01_RptControls_btnOK']")
	private WebElement OkButtonOnAddContentType;

	@FindBy(xpath = "//select[@id='ctl00_PlaceHolderMain_ctl00_SelectCandidate']")
	private WebElement switchToContentTypeBox;

	@FindBy(xpath = "//button[@id='QCB1_Button2']")
	private WebElement uploadButton;

	@FindBy(xpath = "//a[contains(text(),'Change new button order and default content type')]")
	private WebElement defaultContentType;

	@FindBy(xpath = "//select[@title='2013 MRA Choice']")
	private WebElement MRAChoiceElement;

	@FindBy(xpath = "//iframe")
	private WebElement iframeset1;

	public MIRLibraryPage() {
		PageFactory.initElements(Testfactory.driver, this);
	}

	public void clickOnLibrary() {
		try {
			Testfactory.normalclickAction(library);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnAdvancedSettings() {
		try {
			Testfactory.clickAction(advancedSettings);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnallowManagedContentTypeChkbx() {
		try {
			Testfactory.clickAction(allowManagedContentTypeChkbx);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnOkButtonOnAddContentType() {
		try {
			Testfactory.clickAction(OkButtonOnAddContentType);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnokBtn() {
		try {
			Testfactory.clickAction(okBtn);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnaddContentType() {
		try {
			Testfactory.clickAction(addContentType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnLibrarySettings() {
		try {
			Testfactory.selectWebElement(
					Testfactory.driver.findElements(By.xpath("//span[@class='ms-cui-ctl-largelabel']")), 14);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnAvialbleSiteContentTypes(String contenttype) {
		try {
			Testfactory.modeldropdownlist(Testfactory.driver.findElements(
					By.xpath("//select[@id='ctl00_PlaceHolderMain_ctl00_SelectCandidate']")), contenttype);
			Testfactory.clickAction(addButton);
			Testfactory.clickAction(OkButtonOnAddContentType);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void uploadDocumnet() throws InterruptedException, IOException {
		try {
			Testfactory.clickAction(uploadButton);
			Actions act = new Actions(Testfactory.driver);
			act.sendKeys(Keys.SPACE).build().perform();
			Thread.sleep(5000);
			Runtime.getRuntime().exec("C:\\Program Files (x86)\\AutoIt3\\FileUpload12.exe");

			Testfactory.driver.switchTo().defaultContent();

			List iframeSet = Testfactory.driver.findElements(By.xpath("//iframe"));

			int iSize = iframeSet.size();

			for (int i = 1; i <= iSize; i++) {

				Testfactory.driver.switchTo().defaultContent();

				Testfactory.driver.switchTo().frame(i);
				List<WebElement> addDocumentOkButton = Testfactory.driver
						.findElements(By.xpath("//input[@class='ms-ButtonHeightWidth']"));

				if (!addDocumentOkButton.isEmpty()) {

					WebElement e = addDocumentOkButton.get(0);
					e.click();
					Thread.sleep(3000);

				}
				Testfactory.driver.switchTo().defaultContent();

			}

			/*
			 * Actions act = new Actions(Testfactory.driver);
			 * act.sendKeys(Keys.SPACE).build().perform(); Thread.sleep(5000);
			 * Runtime.getRuntime().
			 * exec("C:\\Program Files (x86)\\AutoIt3\\FileUpload12.exe");
			 * List<WebElement> iframe =
			 * Testfactory.driver.findElements(By.xpath("//iframe[@class]")); ;
			 * System.out.println(iframe.size());
			 * Testfactory.switchToIframe(iframe, 0);
			 * 
			 * Robot rt = new Robot(); rt.keyPress(KeyEvent.VK_TAB);
			 * 
			 * rt.keyPress(KeyEvent.VK_ENTER); Thread.sleep(20000);
			 */

		} catch (Testexception e) {

			e.printStackTrace();
			// } catch (InterruptedException e) {

			e.printStackTrace();
			// } catch (IOException e) {

			e.printStackTrace();
			// } catch (AWTException e) {

			e.printStackTrace();
		}
	}

	public void verifyElementIsEnabled() throws Testexception {

		Testfactory.driver.switchTo().defaultContent();

		List iframeSet = Testfactory.driver.findElements(By.xpath("//iframe"));

		int iSize = iframeSet.size();

		for (int i = 1; i <= iSize; i++) {

			Testfactory.driver.switchTo().defaultContent();

			Testfactory.driver.switchTo().frame(3);
			// List<WebElement> choice =
			// Testfactory.driver.findElements(By.xpath("//textarea[starts-with(@id,'_x')]"));

			List<WebElement> choice = Testfactory.driver.findElements(By.xpath("//select[@title='2013 MRA Choice']"));

			if (!choice.isEmpty()) {
				WebElement e = choice.get(0);

				boolean b = false;
				WebElement t = choice.get(0);
				b = t.isEnabled();

				Assert.assertFalse(b);
				System.out.println("passs" + b);
			}
		}
		Testfactory.driver.switchTo().defaultContent();

	}
}
