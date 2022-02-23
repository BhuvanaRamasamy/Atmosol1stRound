package com.qa.demo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.demo.Library.UIMethods;

public class RegisterPage {

	private WebDriver driver = null;
	private UIMethods uiMethods;
	private WebDriverWait wait;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		uiMethods = new UIMethods(driver);
		wait = new WebDriverWait(driver, 20);
	}
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameTxtBox;
	
	@FindBy(id = "input-lastname")
	private WebElement lastNameTxtBox;
	
	@FindBy(id = "input-email")
	private WebElement emailTxtBox;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneTxtBox;
		
	@FindBy(id = "input-password")
	private WebElement passwordTxtBox;
	
	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordTxtBox;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//div[@id='account-register']/div[1]")
	private WebElement warningTxt;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement privacyPolicyChckBox;
	
	public void enterFirstName(String firstName) {
		firstNameTxtBox.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		lastNameTxtBox.sendKeys(lastName);
	}
	
	public void enterEmail(String email) {
		emailTxtBox.sendKeys(email);
	}
	
	public void enterTelephone(String telephoneNum) {
		telephoneTxtBox.sendKeys(telephoneNum);
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
	
	public void validateWarningTxt() {
		uiMethods.waitForElement(warningTxt, wait);
		String actualText = warningTxt.getText();
		String expectedText = "Warning: You must agree to the Privacy Policy!";
		
		uiMethods.assertValue(actualText, expectedText);
		
	}
	
	public void clickPrivacyPolicyChckBox() {
		privacyPolicyChckBox.click();
	}
	
}
