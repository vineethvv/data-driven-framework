package com.datadriven.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtil;

public class TestAutomationTest {
	
	
	WebDriver driver;
	
	
	   @BeforeMethod 
		
		public void setup() {
			
			
			 System.setProperty("webdriver.chrome.driver", "F:\\software\\chromedriver_win32\\chromedriver.exe");
				
				// to launch the browser
				
				driver = new ChromeDriver();
				
	             // to maximize the page
				
			    driver.manage().window().maximize();
			    
			    // to delete all cache
				
			     driver.manage().deleteAllCookies();
			     
			     driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			     
			     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			     
			     driver.get("https://testautomationpractice.blogspot.com/");
			     
			     driver.switchTo().frame(0);
			     

}
	   
	   @DataProvider
	   
	   public Iterator<Object[]> getTestData() {
		   
		   
		   ArrayList<Object[]> testData = TestUtil.getdataFromExcel();
		   return testData.iterator();
	   }
	   
	   
	   @Test(dataProvider= "getTestData")
	   
	   public void TestAutomationRegPageTest(String firstname, String lastname, String phone, String country, String city, String email ) {
		   
		// Enter the data
			
		    driver.findElement(By.xpath("//input[@name='RESULT_TextField-1']")).clear();
           driver.findElement(By.xpath("//input[@name='RESULT_TextField-1']")).sendKeys(firstname);
			
           driver.findElement(By.xpath("//input[@name='RESULT_TextField-2']")).clear();
			driver.findElement(By.xpath("//input[@name='RESULT_TextField-2']")).sendKeys(lastname);
			
			driver.findElement(By.id("RESULT_TextField-3")).clear();
			driver.findElement(By.id("RESULT_TextField-3")).sendKeys(phone);
			
			driver.findElement(By.id("RESULT_TextField-4")).clear();
			driver.findElement(By.id("RESULT_TextField-4")).sendKeys(country);
			
			driver.findElement(By.name("RESULT_TextField-5")).clear();
			driver.findElement(By.name("RESULT_TextField-5")).sendKeys(city);
			
			driver.findElement(By.name("RESULT_TextField-6")).clear();
			driver.findElement(By.name("RESULT_TextField-6")).sendKeys(email);
		   
	   }
	   
	   
	   @AfterMethod
	   
	   public void teardown() {
		   
		   
		   driver.quit();
	   }
	   
}
