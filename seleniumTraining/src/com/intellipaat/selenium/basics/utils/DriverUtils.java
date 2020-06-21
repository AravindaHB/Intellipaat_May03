package com.intellipaat.selenium.basics.utils;

import java.util.concurrent.TimeUnit;

import javax.sound.midi.Soundbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtils {

	public static WebDriver driver = null;
	/**
	 * 
	 * @return
	 */
	public static WebDriver getDriver()
	{
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	/**
	 * 
	 * @param type - id,name,classname,tagname,linktext,partiallinktext,css,xpath
	 * @param value - value corresponding to type
	 * @return WebElement 
	 */
	public static WebElement getElement(String type,String value)
	{
		WebElement element =null;
		System.out.println("finging element using " +type + " and " + value);
		
		switch (type.toLowerCase()) 
		{
		case "id":
			element = driver.findElement(By.id(value));
			break;

		case "name":
			element = driver.findElement(By.name(value));
			break;

		case "classname":
			element = driver.findElement(By.className(value));
			break;

		case "tagname":
			element = driver.findElement(By.tagName(value));
			break;

		case "linktext":
			element = driver.findElement(By.linkText(value));
			break;

		case "partiallinktext":
			element = driver.findElement(By.partialLinkText(value));
			break;

		case "css":
			element = driver.findElement(By.cssSelector(value));
			break;

		case "xpath":
			element = driver.findElement(By.xpath(value));
			break;

		default:
			System.out.println("Please check your type it should be a valid type");
			break;
		}
	
		return element;
	}


	public static void type(String type, String value, String text)
	{
		System.out.println("performing find element and type " + text);
//		WebElement element = getElement(type, value);
//		element.sendKeys(text);
		getElement(type, value).sendKeys(text);
	}
	
	public static void validateAndType(String type, String value, String text)
	{
		WebElement ele = getElement(type, value);
		if(ele.isDisplayed() && ele.isEnabled())
		{
			ele.sendKeys(text);
		}
		else
		{
			System.out.println("Element is not in a state to perform type operation");
		}
		
	}
	
	public static void click(String type,String value)
	{
		System.out.println("Performming Click operation");
		getElement(type, value).click();
	}


	public static void validateTitle(String expecteTitle)
	{
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(expecteTitle)) {
			System.out.println("title Matched- " + actualTitle);
		}
		else
		{
			System.out.println("title Mismatched" + actualTitle);
		}
	}

	public static void selectCheckBox(String type, String value)
	{
		WebElement ele = getElement(type, value);
		
		if(!ele.isSelected())
		{
			ele.click();
		}
		else
		{
			System.out.println("Check box is already selected so not performing click");
		}
	}
	
	public static void unselectCheckBox(String type, String value)
	{
		WebElement ele = getElement(type, value);
		
		if(ele.isSelected())
		{
			ele.click();
		}
		else
		{
			System.out.println("Check box is not selected so not performing click");
		}
	}
	



}












