package com.Testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Commanmethods.Baseclass;
import com.WebPages.Webpageobjects;
import com.aventstack.extentreports.Status;

public class HRM_TestCases extends Baseclass {

	public static Webpageobjects webpage;

	public static void testcase1() throws Exception{
		
		try {
//			HRM_TestCases.getbrowser("Chrome");
		 webpage=PageFactory.initElements(driver, Webpageobjects.class);	
		 webpage.applyleave();
		 logger.log(Status.PASS, "Test Case executed Successfully");
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.log(Status.FAIL, "Test Case Failed");
		}
		
	}
	
		
	}
	
		

