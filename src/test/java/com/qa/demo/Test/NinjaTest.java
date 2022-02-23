package com.qa.demo.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.demo.Pages.AccountPage;
import com.qa.demo.Pages.HomePage;
import com.qa.demo.Pages.PasswordPage;
import com.qa.demo.Pages.RegisterPage;
import com.qa.demo.Pages.SuccessPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NinjaTest {

	WebDriver driver;
	HomePage home;
	RegisterPage register;
	SuccessPage success;
	AccountPage account;
	PasswordPage pwd;

	@BeforeTest
	public void setup() {

		WebDriverManager.chromedriver().useLocalVersionsPropertiesFirst().setup();
		driver = new ChromeDriver();

		driver.get("http://tutorialsninja.com/demo/");
		driver.manage().window().maximize();

		home = new HomePage(driver);
		register = new RegisterPage(driver);
		success = new SuccessPage(driver);
		account = new AccountPage(driver);
		pwd = new PasswordPage(driver);
	}

	@Parameters({ "pageTitle", "firstName", "lastName", "email", "telephoneNum", "password", "newPassword" })
	@Test
	public void test(String pageTitle, String firstName, String lastName, String email, String telephoneNum,
			String password, String newPassword) {
		home.verifyPageTitle(pageTitle);
		home.clickComponentsMenuBtn();
		home.clickMonitorsSubMenuBtn();
		home.clickMyAccountDropDownBtn();
		home.clickRegisterMenuBtn();

		register.enterFirstName(firstName);
		register.enterLastName(lastName);
		register.enterEmail(email);
		register.enterTelephone(telephoneNum);
		register.enterPassword(password);
		register.enterConfirmPassword(password);
		register.clickContinueBtn();
		register.validateWarningTxt();
		register.clickPrivacyPolicyChckBox();
		register.clickContinueBtn();
		
		success.validateSuccessMsg();
		success.clickContinueBtn();
		
		account.clickChangePwdLnk();
		
		pwd.validatePagetitle();
		pwd.enterPassword(newPassword);
		pwd.enterConfirmPassword(newPassword);
		pwd.clickContinueBtn();
		
		account.validateSuccessMsg();

		home.clickMyAccountDropDownBtn();
		home.clickLogoutBtn();
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
