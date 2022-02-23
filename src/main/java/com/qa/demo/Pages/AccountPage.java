package com.qa.demo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.demo.Library.UIMethods;

public class AccountPage {

	private WebDriver driver = null;
	private UIMethods uiMethods;
	private WebDriverWait wait;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		uiMethods = new UIMethods(driver);
		wait = new WebDriverWait(driver, 20);
	}
	
	@FindBy(xpath = "//a[text()='Change your password']")
	private WebElement changePwdLnk;
	
	@FindBy(xpath = "//div[@id='account-account']/div[1]")
	private WebElement successMsg;
	
	public void clickChangePwdLnk() {
		changePwdLnk.click();
	}
	
	public void validateSuccessMsg() {
		uiMethods.waitForElement(successMsg, wait);
		String actualText = successMsg.getText();
		String expectedText = "Success: Your password has been successfully updated.";
		uiMethods.assertValue(actualText, expectedText);
	}
}
