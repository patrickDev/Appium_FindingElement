package com.examples;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class FindingElements {
	AndroidDriver driver; 
	File file = new File("C:\\Users\\Patrick\\Documents\\LearnSelenium\\Appium_FindingElements\\apk\\com.davemac327.gesture.tool.apk");
	
  @Test
  public void testApp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Moto G");
		capabilities.setCapability("platformVersion", "5.0.2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", file.getAbsolutePath());
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		//Find an element by id (both methods works fine)
		//driver.findElement(By.id("com.davemac327.gesture.tool:id/addButton")).click();
		//driver.findElementById("com.davemac327.gesture.tool:id/addButton").click();
		
		//Get attributes
		WebElement button = driver.findElementById("com.davemac327.gesture.tool:id/addButton");
		System.out.println("text: " + button.getAttribute("text"));
		System.out.println("checkable: " + button.getAttribute("checkable"));
		System.out.println("checked: " + button.getAttribute("checked"));
		System.out.println("clikable: " + button.getAttribute("clickable"));
		System.out.println("enabled: " + button.getAttribute("enabled"));
		
		
  }
  
  @AfterTest
  public void TearDown() throws InterruptedException{
	  //Thread.sleep(5000);
	  driver.quit();
  }
}
