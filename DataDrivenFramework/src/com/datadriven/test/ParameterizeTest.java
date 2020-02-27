package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class ParameterizeTest {

	public static void main(String[] args) throws InterruptedException {
		
		 System.setProperty("webdriver.chrome.driver", "E:\\selenium jar files\\chrome driver\\chromedriver.exe");
			
			// to launch the browser
			
			WebDriver driver = new ChromeDriver();
			
			// to launch the url
			
			driver.get("https://testautomationpractice.blogspot.com/");
			
			// to maximize the page
			
			driver.manage().window().maximize();
			
			Thread.sleep(2000);
			
			driver.switchTo().frame(0);
		
		// Data Driven Approach is also called parameterization -- It is used to create data driven framework
			
		// Driving the test data from excel file is known as Data Driven Approach	
			
		// Get test data from excel
		
	    Xls_Reader reader = new Xls_Reader("C:\\Users\\vineethg\\eclipse-workspace\\DataDrivenFramework\\src\\com\\testdata\\TestAutomationTestData.xlsx");
	    int rowcount = reader.getRowCount("RegTestData");
	    
	    reader.addColumn("RegTestData", "status");
	    
	    //Parametirization
	    
	    for(int rownum =2; rownum<= rowcount; rownum++) {
	    	
	    	System.out.println("################");
	    	
	    	String firstname = reader.getCellData("RegTestData", "firstname", rownum);
	    	System.out.println(firstname);
	    	
	    	
	    	String lastname = reader.getCellData("RegTestData", "lastname", rownum);
			System.out.println(lastname);
			
			
			String phone = reader.getCellData("RegTestData", "phone", rownum);
			System.out.println(phone);
			
			String country = reader.getCellData("RegTestData", "country", rownum);
			System.out.println(country);
			
			String city = reader.getCellData("RegTestData", "city", rownum);
			System.out.println(city);
			
			String email = reader.getCellData("RegTestData", "email", rownum);
			System.out.println(email);
			
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
				
				// To write the data into excel
				
				reader.setCellData("RegTestData", "status", rownum, "pass");
				
	    	
	    }
				

	}

}
