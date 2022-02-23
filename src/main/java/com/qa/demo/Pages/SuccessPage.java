package com.qa.demo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.demo.Library.UIMethods;

public class SuccessPage {

	private WebDriver driver = null;
	private UIMethods uiMethods;
	private WebDriverWait wait;
	
	public SuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		uiMethods = new UIMethods(driver);
		wait = new WebDriverWait(driver, 20);
	}
	
	
	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement successMsg;
	
	@FindBy(xpath = "//a[text()='Continue']")
	private WebElement continueBtn;
	
	public void validateSuccessMsg() {
		uiMethods.waitForElement(successMsg, wait);
		String actualText = successMsg.getText();
		String expectedText = "Your Account Has Been Created!";
		uiMethods.assertValue(actualText, expectedText);
	}
	
	public void clickContinueBtn() {
		continueBtn.click();
	}
}
