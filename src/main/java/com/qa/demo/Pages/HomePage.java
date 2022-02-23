package com.qa.demo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.demo.Library.UIMethods;

public class HomePage {
	
	private WebDriver driver = null;
	private UIMethods uiMethods;
	private WebDriverWait wait;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
		uiMethods = new UIMethods(driver);
	}
	
	@FindBy(xpath = "//div[@id='logo']/h1/a")
	private WebElement pageTitle;
	
	@FindBy(xpath = "//a[text()='Components']")
	private WebElement componentsMenuBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Monitors')]")
	private WebElement monitorsSubMenuBtn;
	
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropDownBtn;
	
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registerMenuBtn;
	
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutBtn;
	
	public void verifyPageTitle(String expectedTitle) {
		uiMethods.waitForElement(pageTitle, wait);
		uiMethods.assertValue(pageTitle.getText(), expectedTitle);
	}
	
	public void clickComponentsMenuBtn() {
		componentsMenuBtn.click();
	}
	
	public void clickMonitorsSubMenuBtn() {
		monitorsSubMenuBtn.click();
	}
	
	public void clickMyAccountDropDownBtn() {
		myAccountDropDownBtn.click();
	}
	
	public void clickRegisterMenuBtn() {
		registerMenuBtn.click();
	}
	
	public void clickLogoutBtn() {
		logoutBtn.click();
	}
}
