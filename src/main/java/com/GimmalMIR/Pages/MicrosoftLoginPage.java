package com.GimmalMIR.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.TestException;

import com.GimmalMIR.core.Testcapture;
import com.GimmalMIR.core.Testexception;
import com.GimmalMIR.core.Testfactory;

public class MicrosoftLoginPage {

	@FindBy(xpath = "//*[@id='otherTile']/div/div[2]")
	private WebElement UseAnotherAccount;

	@FindBy(xpath = "//*[@id='i0116']")
	private WebElement SignIn;

	@FindBy(xpath = "//input[@id='idSIButton9']")
	private WebElement YesButton;

	@FindBy(xpath = "//*[@id='idSIButton9']")
	private WebElement NextButton;

	@FindBy(xpath = "//*[@id='aadTile']")
	private WebElement SelectAccount;

	@FindBy(xpath = "//*[@id='i0118']")
	private WebElement Password;

	@FindBy(xpath = "//input[@id='idSIButton9' and @class='btn btn-block btn-primary']")
	private WebElement SignInButton;

	@FindBy(xpath = "//span[text()='Office 365']")
	private WebElement office365;

	@FindBy(xpath = "//img[@id='ctl00_onetidHeadbnnr2']")
	private WebElement rootSite;

	public MicrosoftLoginPage() {
		PageFactory.initElements(Testfactory.driver, this);
	}

	public void clickLoginbutton(String userName, String passWord) throws InterruptedException {
		try {
			Testfactory.editTextBox(SignIn, userName);
			Thread.sleep(2000);
			Testfactory.clickAction(NextButton);
			Thread.sleep(3000);
			Testfactory.editTextBox(Password, passWord);
			Thread.sleep(3000);
			Testfactory.clickAction(SignInButton);
			Thread.sleep(1000);
			Testfactory.clickAction(YesButton);
			Thread.sleep(2000);
		} catch (Testexception e) {
			e.printStackTrace();
		}

	}

	public void isOffice365PageOpen(String pageName) {

		String text = office365.getText();
		try {
			Assert.assertEquals(pageName, text);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
