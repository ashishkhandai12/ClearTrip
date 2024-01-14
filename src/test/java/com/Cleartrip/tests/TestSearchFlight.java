package com.Cleartrip.tests;

import org.testng.annotations.Test;

import com.Cleartrip.init.Iconstants;
import com.Cleartrip.lib.Baselib;
import com.Cleartrip.lib.excelLib;
import com.Cleartrip.pages.ClearTripSearchFlight;

public class TestSearchFlight extends Baselib {
	@Test
	public void searchFlight() throws InterruptedException {
		ClearTripSearchFlight searchflight=new ClearTripSearchFlight(driver);
		searchflight.clickOnCloseIcon();
		searchflight.clickOnoneWayDropDwon();
		searchflight.selectRoundTrip();
		searchflight.selectEconomy();
		String source=excelLib.getData("Sheet1",1,0,Iconstants.clearTrip);
		String Destination=excelLib.getData("Sheet1",1,1,Iconstants.clearTrip);
		searchflight.selectSourceDestination(source,Destination);
		
		searchflight.selectDate();
		searchflight.clickOnSearchFlight();
		//searchflight.SelectSecondFlight();
		//searchflight.selectBookButton();
		
	}

}
