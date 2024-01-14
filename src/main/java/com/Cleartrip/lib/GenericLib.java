package com.Cleartrip.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.Cleartrip.init.Iconstants;
import com.google.common.io.Files;

public class GenericLib {
	public static String getPropData(String Key) {
		String data = "";
		try {
			FileInputStream finn = new FileInputStream(Iconstants.propData);
			Properties prop = new Properties();
			prop.load(finn);
			data = prop.getProperty(Key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	public static void clickElement(WebDriver driver, WebElement ele, String eleName) {
		try {
			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(ele)).click();
			Reporter.log("Clicked on" + eleName);
		} catch (TimeoutException e) {
			Reporter.log(eleName + "Not dispalyed");
			Assert.fail();
		}
	}

	public static void enterText(WebDriver driver, WebElement ele, String text, String eleName) {
		try {
			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			wait.until(ExpectedConditions.visibilityOf(ele)).sendKeys(text);
			Reporter.log("Entered Text" + text + " In the " + eleName);
		} catch (TimeoutException e) {
			Reporter.log(eleName + "Not dispalyed");
			Assert.fail();
		}
	}


	public static void handleAction(WebDriver driver, WebElement ele, String eleName) {
		Actions ac = new Actions(driver);
		ac.moveToElement(ele).click().build().perform();
		Reporter.log("Clicked on" + eleName);
	}

	public static void hoverAction(WebDriver driver, WebElement ele, String eleName) {
		Actions ac = new Actions(driver);
		ac.moveToElement(ele).perform();
		Reporter.log("Clicked on" + eleName);

	}

	public static void enterText1(WebDriver driver, WebElement ele, CharSequence[] text, String eleName) {
		try {
			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			wait.until(ExpectedConditions.visibilityOf(ele)).sendKeys(text);
			Reporter.log("Entered Text" + text + " In the " + eleName);
		} catch (TimeoutException e) {
			Reporter.log(eleName + "Not dispalyed");
			Assert.fail();
		}

	}

	public static void Sendkey(WebDriver driver, WebElement ele, String text, String eleName) {
		Actions ac = new Actions(driver);
		ac.moveToElement(ele).sendKeys(text).build().perform();
		Reporter.log("Clicked on" + eleName);

	}

	public static void MouseOver(WebDriver driver, WebElement ele, String eleName) {
		Actions action = new Actions(driver);

		// Performing the mouse hover action on the target element.
		action.moveToElement(ele).perform();
		Reporter.log("hover over" + eleName);
	}

	public static void WaitForElement(WebDriver driver, WebElement ele) {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void ScrolltoParticularElement(WebDriver driver, WebElement ele) {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOf(ele));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
	}

}
