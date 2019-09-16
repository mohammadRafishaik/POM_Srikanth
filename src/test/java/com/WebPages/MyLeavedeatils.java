package com.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyLeavedeatils extends Webpageobjects {
	@FindBy(xpath="(//a[starts-with(text(),'My Leave')])[1]")public static WebElement Myleavetab;
	@FindBy(xpath="(//img[contains(@class,'ui-datepicker-trigger')])[1]")public static  WebElement fromdate;
	@FindBy(xpath="(//img[contains(@class,'ui-datepicker-trigger')])[2]")public static WebElement todate;
	@FindBy(id="btnSearch")public static WebElement searchbutton;
	
	public static void myleavetest() {
		
		Leavetab.click();
		Myleavetab.click();
		fromdate.clear();
		fromdate.sendKeys("2019-08-16");
		todate.clear();
		todate.sendKeys("2019-08-18");
		searchbutton.click();
		
	}
	
	
	

}
