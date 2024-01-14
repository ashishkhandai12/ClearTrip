package com.Cleartrip.lib;


import java.util.HashMap;
import java.util.Map;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Baselib {


	public WebDriver driver;
	
	@BeforeTest
	public void setUp(ITestContext contex) {
		if(GenericLib.getPropData("browsername").equalsIgnoreCase("chrome")) {

			
			 Map<String, Object> prefs = new HashMap<String, Object>();
		        ChromeOptions options = new ChromeOptions();
		   
		        prefs.put("profile.default_content_setting_values.media_stream_mic", 1);
		        prefs.put("profile.default_content_setting_values.media_stream_camera", 1);
		        prefs.put("profile.default_content_setting_values.geolocation", 1);
		        prefs.put("profile.default_content_setting_values.notifications", 1);
		        options.setExperimentalOption("prefs", prefs);

			driver = new ChromeDriver(options); 
		

			}
		
		else if(GenericLib.getPropData("browsername").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();

		
		driver = new FirefoxDriver(options); 

			options.addPreference("dom.webnotifications.enabled", false);
		
			}
		else {
			Assert.fail("browser name not valid");
		}

		contex.setAttribute("driver",driver);	
		Reporter.log("Browser launched successfully ");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		
		driver.get(GenericLib.getPropData("prod.clearTrip"));

		Reporter.log("Application loaded ");
			}
	@AfterClass
	public void tearDown() {
		
		
		
	//	driver.quit();
		
	}
}
