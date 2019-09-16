package com.TestRunner;

import org.testng.annotations.Test;

import com.Commanmethods.Baseclass;
import com.Testcases.HRM_TestCases;
import com.aventstack.extentreports.Status;

import freemarker.log.Logger;

public class TestExecutionwindow extends Baseclass {

	@Test
public static void executionwindow() throws Exception {	
		try {
			logger=report.createTest("Hrm Login");
			logger.info("HRM Login With Valid Credentials");
			logger.log(Status.PASS, "User Able to login Application");
			Baseclass.getbrowser("Chrome");
		} catch (Exception e) {
			logger.log(Status.FAIL, "User Able to login Application");
		}
		
	
		
		
//		HRM_TestCases.testcase2();
		

	}

}
