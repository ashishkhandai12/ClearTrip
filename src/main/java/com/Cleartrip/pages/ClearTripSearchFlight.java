package com.Cleartrip.pages;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Cleartrip.init.Iconstants;
import com.Cleartrip.lib.GenericLib;

public class ClearTripSearchFlight {

	WebDriver driver;
    

    @FindBy(xpath = "//*[contains(@class, 'c-pointer c-neutral') and @fill='none']")
    private WebElement CloseIcon;
    @FindBy(xpath="//*[text()=\"One way\"]")
    private WebElement ClickOneWayDropdowm;
    @FindBy(xpath="//*[text()=\"Round trip\"]")
    private WebElement RoundTrip;
    @FindBy(xpath="(//*[contains(@class,\"fw\") and @style=\"line-height: 24px;\" ])[2]")
    private WebElement SelectEconomyDropDown;
    
    @FindBy(xpath="(//*[@class=\"flex-inline\"])[1]")
    private WebElement SelectAdults;
    @FindBy(xpath="(//*[@class=\"flex-inline\"])[2]")
    private WebElement SelectChildren;
    @FindBy(xpath="(//*[@class=\"flex-inline\"])[3]")
    private WebElement SelectInfants;
    @FindBy(xpath="//*[contains(@class, \"c-neutral\") and @placeholder=\"Where from?\"]")
    private WebElement SelectWhereFrom;
    @FindBy(xpath="//*[contains(@class, \"c-neutral\") and @placeholder=\"Where to?\"]")
    private WebElement SelectWhereTo;
    @FindBy(xpath="//*[text()=\"Goa, IN - Dabolim Airport (GOI)\"]/..")
    private WebElement SelectGoaSouce;
    
    @FindBy(xpath="//*[text()=\"Mumbai, IN - Chatrapati Shivaji Airport (BOM)\"]/..")
    private WebElement SelectMumbaiDestination;
    
    @FindBy(xpath="(//*[contains(@class, \"flex\")])[40]/button[1]")
    private WebElement SelectFromDate;
    
    @FindBy(xpath="(//*[contains(@class, \"flex\")])[40]/button[2]")
    private WebElement SelectToDate;
    @FindBy(xpath="(//*[text()=\"Search flights\"])[2]")
    private WebElement SelectSearchFlightButton;
    
    @FindBy(xpath="(//*[@style=\"max-height: 75px;\"])[2]")
    private WebElement SelectSecondFlightGoa;
    @FindBy(xpath="(//*[contains(@class, \"rt-tuple-new-container\")])[205]")
    private WebElement SelectSecondFlightfromMumbai;
    
    @FindBy(xpath="//*[@class=\"flex flex-middle flex-1 flex-end\"]/div[2]")
    private WebElement SelectBookButton;
    
   
    public ClearTripSearchFlight(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }



   public void clickOnCloseIcon() {
		  GenericLib.clickElement(driver,CloseIcon, "Click in the Username Field");
		 
    }
   public void clickOnoneWayDropDwon() {
		  GenericLib.clickElement(driver,ClickOneWayDropdowm, "Click On the OneWay Dropdown");
		 
 }
   
   // Method to select round trip radio button
   public void selectRoundTrip() {
	   GenericLib.clickElement(driver,RoundTrip, "Click On the RoundTrip from Dropdown");
		 
   }
   public void selectEconomy() {
	   GenericLib.clickElement(driver,SelectEconomyDropDown, "Click On the SelectEconomy from Dropdown");
	   GenericLib.clickElement(driver,SelectAdults, "Click On the Adults + icon");
	   GenericLib.clickElement(driver,SelectChildren, "Click On the Children + icon");
	   GenericLib.clickElement(driver,SelectInfants, "Click On the Infants + icon");
	   GenericLib.clickElement(driver,SelectEconomyDropDown, "Click On the SelectEconomy from Dropdown");
   }
   public void selectSourceDestination(String source, String destination)
   {
	   GenericLib.clickElement(driver, SelectWhereFrom, "Click on text box");
	   GenericLib.enterText(driver, SelectWhereFrom,source , "Enter Source");
	   GenericLib.clickElement(driver, SelectGoaSouce, "Select Goa from drop down");
	   
	   
	   GenericLib.clickElement(driver, SelectWhereTo, "Select Text box"); 
	   GenericLib.enterText(driver, SelectWhereTo, destination, "Enter Destination");
	   GenericLib.clickElement(driver, SelectMumbaiDestination, "Select mumbai from drop down");
   }
   public void selectDate() throws InterruptedException {
	   GenericLib.clickElement(driver, SelectFromDate, "Select from date");
	   LocalDate currentDate = LocalDate.now();
       LocalDate targetDate = currentDate.plusDays(2);
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MMM dd yyyy");
       String formattedDate = targetDate.format(formatter);
       System.out.println(formattedDate);
      driver.findElement(By.xpath("//*[@aria-label='"+formattedDate+"']")).click();
      GenericLib.clickElement(driver, SelectFromDate, "Select from date");
      
	  GenericLib.clickElement(driver, SelectToDate, "Select to date");
	  
      targetDate = currentDate.plusDays(3);
       formatter = DateTimeFormatter.ofPattern("E MMM dd yyyy");
       formattedDate = targetDate.format(formatter);
      System.out.println(formattedDate);
      driver.findElement(By.xpath("//*[@aria-label='"+formattedDate+"']")).click();
      //Thread.sleep(5000);
      //GenericLib.clickElement(driver, SelectToDate, "Select to date");
      
      
   }
   	public void clickOnSearchFlight() {
   		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
   	 GenericLib.clickElement(driver, SelectSearchFlightButton, "Select search flight button");
   		
   	}
   	public void SelectSecondFlight() throws InterruptedException {
   		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
   		GenericLib.clickElement(driver, SelectSecondFlightGoa, "Select second flight");
   		Thread.sleep(3000);
   		GenericLib.clickElement(driver, SelectSecondFlightfromMumbai, "Select second flight");
   	}
   	public void selectBookButton() {
   		GenericLib.clickElement(driver, SelectBookButton, "Select the Book Button");
   	}
   
  
}
