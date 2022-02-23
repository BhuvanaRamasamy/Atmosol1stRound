package com.qa.demo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.demo.Library.UIMethods;

public class PasswordPage {

	private WebDriver driver = null;
	private UIMethods uiMethods;
	private WebDriverWait wait;
	
	public PasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		uiMethods = new UIMethods(driver);
		wait = new WebDriverWait(driver, 20);
	}
	
	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement pageTitle;
	
	@FindBy(id = "input-password")
	private WebElement passwordTxtBox;
	
	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordTxtBox;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continueBtn;
	
	public void validatePagetitle() {
		uiMethods.waitForElement(pageTitle, wait);
		String actualTitle = pageTitle.getText();
		String expectedTitle = "Change Password";
		
		uiMethods.assertValue(actualTitle, expectedTitle);
	}
	
	public void enterPassword(String password) {
		passwordTxtBox.sendKeys(password);
	}
	
	public void enterConfirmPassword(String confirmPassword) {
		confirmPasswordTxtBox.sendKeys(confirmPassword);
	}
	
	public void clickContinueBtn() {
		continueBtn.click();
	}
}
