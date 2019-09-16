package com.Testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Commanmethods.Baseclass;
import com.WebPages.MyLeavedeatils;

public class HRMTestcase1 extends Baseclass {


public static void testcase2(){
		
		try {
			MyLeavedeatils web=PageFactory.initElements(driver, MyLeavedeatils.class);	
			 web.myleavetest();
		} catch (Exception e) {
			System.out.println("Unable to run test case2"+e.getMessage());
		}
}
}
