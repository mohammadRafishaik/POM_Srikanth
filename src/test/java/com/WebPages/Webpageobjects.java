package com.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Commanmethods.Baseclass;

public class Webpageobjects extends Baseclass {
	
//Apply Leave Test case Page Objects
	
	@FindBy(id="menu_leave_viewLeaveModule")public static  WebElement Leavetab;
	@FindBy(id="menu_leave_applyLeave")public static WebElement Apply;
	@FindBy(id="applyleave_txtLeaveType")public static WebElement Leavetypedropdown;
	@FindBy(xpath="//option[@value='1']")public static WebElement AnualLeavoption;
	@FindBy(id="applyleave_txtFromDate")public static WebElement fromdate;
	@FindBy(id="applyleave_txtToDate")public static WebElement Todate;
	@FindBy(id="applyleave_txtComment") public static WebElement commenttext;
	@FindBy(id="applyBtn")public static WebElement Applybutton;

//==============================================================
	
	
	public static void applyleave() throws Exception{
		Leavetab.click();
		Apply.click();
		Leavetypedropdown.click();
		AnualLeavoption.click();
		fromdate.clear();
		fromdate.sendKeys("2019-07-24");
		Todate.clear();
		Todate.sendKeys("2019-07-26");
		commenttext.sendKeys("personal work");
		Applybutton.click();
		
	}

	
	
}
