package com.GimmalMIR.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.GimmalMIR.core.Testexception;
import com.GimmalMIR.core.Testfactory;

public class DefaultContentTypeOrderPage {

	@FindBy(xpath = "//select[@title='Position from Top: Document']")
	private WebElement contentTypeOrder;

	@FindBy(xpath = "//a[contains(text(),'Change new button order and default content type')]")
	private WebElement defaultContentType;

	public DefaultContentTypeOrderPage() {
		PageFactory.initElements(Testfactory.driver, this);
	}

	public void okButtonOnButtonOrderPage() {
		try {
			List<WebElement> okButtonOnButtonOrderPage = Testfactory.driver
					.findElements(By.xpath("//input[@class='ms-ButtonHeightWidth']"));

			Testfactory.selectWebElement(okButtonOnButtonOrderPage, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnDefaultContentTypeOrder() {
		try {
			Testfactory.clickAction(defaultContentType);
			Select sel = new Select(contentTypeOrder);
			sel.selectByIndex(1);
		} catch (Testexception e) {

			e.printStackTrace();
		}
	}

}
