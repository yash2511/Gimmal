package com.GimmalMIR.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.GimmalMIR.core.Testfactory;

public class GovernanceHubDashboardPage {

	@FindBy(xpath = "//span[@id='DeltaPlaceHolderPageTitleInTitleArea']")
	private WebElement GovernanceHubDashboardName;

	@FindBy(xpath = "//a[text()='Metadata Inheritance Rules']")
	private WebElement MIRApp;

	public GovernanceHubDashboardPage() {
		PageFactory.initElements(Testfactory.driver, this);
	}

	public void clickOnMIRApp() {
		try {
			Testfactory.clickAction(MIRApp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void isDisaplyGovHubDashboard() {

		boolean b = true;
		b = Testfactory.driver.findElement(By.xpath("//span[@id='DeltaPlaceHolderPageTitleInTitleArea']"))
				.isDisplayed();
		Assert.assertTrue(b);

	}

}
