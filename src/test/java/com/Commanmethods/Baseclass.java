package com.Commanmethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Baseclass {
	public static XSSFWorkbook xsw;
	public static  WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest logger;
	public static void getbrowser(String Browser) throws Exception
	{
		
		if(Browser.equals("Chrome"))
		{	
			System.setProperty("webdriver.chrome.driver", "E:\\vss\\srivani\\HRM\\BrowserDrivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("http://www.testingmasters.com/hrm/");
			driver.findElement(By.id("txtUsername")).sendKeys("User03");
			driver.findElement(By.id("txtPassword")).sendKeys("pass1234");
			driver.findElement(By.id("btnLogin")).click();
			System.out.println("Successfully launched");
			logger.log(Status.PASS, "Browser Launched Successfully");

		}
		else if(Browser.equals("Firefox"))
		{
		
			System.setProperty("webdriver.firefox.driver", "/HRM/BrowserDrivers/geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("http://www.testingmasters.com/hrm/");
			driver.findElement(By.id("txtUsername")).sendKeys("User03");
			driver.findElement(By.id("txtPassword")).sendKeys("pass1234");
			driver.findElement(By.id("btnLogin")).click();
			System.out.println("Successfully launched");

			
		}
		
		else if(Browser.equals("Ie"))
		{
		
			System.setProperty("webdriver.ie.driver", "/HRM/BrowserDrivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("http://www.testingmasters.com/hrm/");
			driver.findElement(By.id("txtUsername")).sendKeys("User03");
			driver.findElement(By.id("txtPassword")).sendKeys("pass1234");
			driver.findElement(By.id("btnLogin")).click();
			System.out.println("Successfully launched");

			
		}
	
		else {
			logger.log(Status.FAIL, "Browser Launching Problem");
			//logger.log(Status.ERROR, "Browser Launching Problem");
			
		}
	}
	public static String getscreenshots() {
		
			String Screenshotpath="E:\\vss\\srivani\\HRM\\Screenshots\\HRM_"+getsystemdate()+".png";
	
			TakesScreenshot ts=(TakesScreenshot) driver;
			//String Screenshotpath=System.getProperty("user.dir") + "E:\\New folder\\Screenshots_"+getsystemdate()+".png";

		File location=ts.getScreenshotAs(OutputType.FILE);

		try {
			FileHandler.copy(location,new File(Screenshotpath));
		} catch (IOException e) {
			
			System.out.println("Screenshot is not taken : "+e.getMessage());
		}
		return Screenshotpath;
		
	}

	
	public static String getsystemdate() {
		DateFormat dateformet=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date dte=new Date();
		return dateformet.format(dte);
		
	}
	public static void  Testdataread() {
		File filelocation=new File("E:\\vss\\srivani\\HRM\\TestData\\WebTestdata.xlsx");

		try {
			FileInputStream fis=new FileInputStream(filelocation);
		 xsw=new XSSFWorkbook(fis);
		
		} catch (Exception e) {
			
			System.out.println("Data Not Reading:: "+e.getMessage());
		}
		
	}
	public String getstringvalue(String sheetname,int rownum,int columnum)
	{
		System.out.println(xsw.getSheet(sheetname).getRow(rownum).getCell(columnum).getStringCellValue());
		return xsw.getSheet(sheetname).getRow(rownum).getCell(columnum).getStringCellValue();
		
		
	}
	@BeforeSuite
	public void initialeecution() {
		Baseclass	tdr=new Baseclass();
		
		System.out.println("Excel is loaded");
		ExtentHtmlReporter extent=new ExtentHtmlReporter("E:\\vss\\srivani\\HRM\\Reports\\HRM_"+Baseclass.getsystemdate()+".html");

 		 report=new ExtentReports();
		 report.attachReporter(extent);
		
	}

@AfterMethod
public void screenshotattach(ITestResult result) throws IOException {
	Reporter.log("Screenshots are going to attach");
	
	if(result.getStatus()==ITestResult.SUCCESS) {
		logger.pass("Success", MediaEntityBuilder.createScreenCaptureFromPath(getscreenshots()).build());
		
		Reporter.log("All the pass screenshots are attached");
	}

	else if(result.getStatus()==ITestResult.FAILURE) 
	{
		logger.fail("Failure",MediaEntityBuilder.createScreenCaptureFromPath(getscreenshots()).build());
//		logger.fail("Failure",MediaEntityBuilder.createScreenCaptureFromPath(getscreenshots()).build());
	Reporter.log("Failure test case screenshots are attached");
	}
	else
	{
		System.out.println("Unable to load screenshots");
	}
	
	report.flush();
	Reporter.log("HTML REPEORT IS DONE And Check the Repiorts", true);
}
/*
@AfterSuite
public void letspackup() {
	report.flush();
	
}*/
	}


