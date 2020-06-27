package com.intellipaat.selenium.basics.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActiTimeUtils extends DriverUtils
{

	/**
	 * 
	 * @param url
	 */
	public static void launchApp(String url)
	{
		driver.get(url);
		validateTitle("actiTIME - Login");
	}
	
	public static void launchApp()
	{
		driver.get("http://localhost/login.do");
		validateTitle("actiTIME - Login");
	}
	
	public static void login(String un,String pwd)
	{
		ActiTimeUtils.type("id", "username", un);
		ActiTimeUtils.type("name", "pwd", pwd);
		ActiTimeUtils.click("id", "loginButton");
		try 
		{
			Thread.sleep(5000);
		} catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validateTitle("actiTIME - Enter Time-Track");
	}
	
	public static void logout()
	{
		ActiTimeUtils.click("linktext", "Logout");
		validateTitle("actiTIME - Login");
	}

	public static void selectModule(String name)
	{
		System.out.println("Entering to " + name  + " module ");
		//Dynamic Xpath  -> constructing xpath at the run time
						//div[text()='TASKS']/parent::a
		click("xpath", "//div[text()='" + name.toUpperCase() + "']/parent::a");
		
		
	}

	public static void clickOnNewCustomerButton(WebDriver driver) {
		ActiTimeUtils.click("xpath", "//div[@class='addNewContainer']");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ActiTimeUtils.getElement("xpath", "//div[@class='dropdownContainer addNewMenu']")));
	
		ActiTimeUtils.click("xpath", "//div[contains(text(),'New Customer')]");
	}

	public static void createCustomer(String customerName, String customerDesc)
	{
		type("id", "customerLightBox_nameField", customerName);
		type("id", "customerLightBox_descriptionField", customerDesc);
		click("id", "customerLightBox_commitBtn");
		WebDriverWait appearWait = new WebDriverWait(driver, 10);
		WebElement toastEle = appearWait.until(ExpectedConditions.visibilityOf(ActiTimeUtils.getElement("xpath", "//div[@class='toasts']")));
		
		System.out.println("Toast Messasge  - " + toastEle.getText());
		
		System.out.println("waiting for toast to disappear");
		
		WebDriverWait disappearWait = new WebDriverWait(driver, 10);
		disappearWait.until(ExpectedConditions.invisibilityOf(ActiTimeUtils.getElement("xpath", "//div[@class='toasts']")));
		
	}

}
