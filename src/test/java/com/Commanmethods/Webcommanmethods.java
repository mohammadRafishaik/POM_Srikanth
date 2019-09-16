package com.Commanmethods;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webcommanmethods extends Baseclass{
	public  long PAGE_LOAD_TIMEOUT = 30;
	public  long IMPLICIT_WAIT = 30;
	

	public static void getdropdownelement(String xpath,String visibletext) {
		WebElement element=driver.findElement(By.xpath(xpath));
		Select sel=new Select(element);
		sel.selectByVisibleText(visibletext);
		
	}
	public static void mousehover(String xpath) {
		
		WebElement element=driver.findElement(By.xpath(xpath));
	Actions act=new Actions(driver);
	act.moveToElement(element).build().perform();
}
	public static void getalert() {
		
	}
	public  WebElement waitForElementPresent(WebElement elementToBeLoaded) {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			element = wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
			return element;
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return element;
	}
	public String getElementText(String locator) {
		WebElement element;
		String text = null;
		try {
			element = driver.findElement(By.xpath(locator));
			if (element != null)

				text = element.getText();

		} catch (Exception e) {
			e.printStackTrace();
		}
		element = null;

		return text;
	}
	
	public  boolean SwitchAlert() {
		boolean Flag = false;

		try {
			if (driver.switchTo().alert() != null) {
driver.switchTo().alert().accept();
				Flag = true;
			}

		}

		catch (NoAlertPresentException e) {

		}
		return Flag;

	}
	public  boolean isAlertPresent(){
        try{
        	driver.switchTo().alert();
            return true;
        }catch(NoAlertPresentException ex){
            return false;
        }
    }
	public  void handleAlert(){
        if(isAlertPresent()){
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();}
        }

 
	public void closeBrowser() {

		driver.close();
		// driver = null;
		// WindowsUtils.tryToKillByName("IEDriverServer.exe");
		/* taskkill /F /IM IEDriverServer.exe - From Command Prompt */
	}
 
	public static void highlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "border: 2px solid DeepPink;");
	js.executeScript("arguments[0].setAttribute('style',arguments[1]);",element, "border: 2px solid DeepBlue;");
	}
	public void ImplicitWait()
		{
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		}
	 	

	public void JavaScriptexecutorclick(WebElement element)
    {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
         executor.executeScript("arguments[0].click();", element);

    }
}