package com.qa.demo.Library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UIMethods {

	
	private WebDriver driver = null;
	
	public UIMethods(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void assertValue(String actualValue, String expectedValue) {
		Assert.assertEquals(actualValue, expectedValue);
	}
	
	public void waitForElement(WebElement element, WebDriverWait wait) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Exception ex) {
			System.out.println("Exception while waiting for element : " + ex);
		}
	}
}
