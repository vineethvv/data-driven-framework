package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest {

	public static void main(String[] args) throws InterruptedException {
		
		// Get test data from excel
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\vineethg\\eclipse-workspace\\DataDrivenFramework\\src\\com\\testdata\\TestAutomationTestData.xlsx");
		
		String firstname = reader.getCellData("RegTestData", "firstname", 2);
		System.out.println(firstname);
		
		String lastname = reader.getCellData("RegTestData", "lastname", 2);
		System.out.println(lastname);
		
		
		String phone = reader.getCellData("RegTestData", "phone", 2);
		System.out.println(phone);
		
		String country = reader.getCellData("RegTestData", "country", 2);
		System.out.println(country);
		
		String city = reader.getCellData("RegTestData", "city", 2);
		System.out.println(city);
		
		String email = reader.getCellData("RegTestData", "email", 2);
		System.out.println(email);
		
		
			
		   System.setProperty("webdriver.chrome.driver", "E:\\selenium jar files\\chrome driver\\chromedriver.exe");
			
			// to launch the browser
			
			WebDriver driver = new ChromeDriver();
			
			// to launch the url
			
			driver.get("https://testautomationpractice.blogspot.com/");
			
			// to maximize the page
			
			driver.manage().window().maximize();
			
			Thread.sleep(2000);
			
			driver.switchTo().frame(0);
			
            driver.findElement(By.xpath("//input[@name='RESULT_TextField-1']")).sendKeys(firstname);
			
			driver.findElement(By.xpath("//input[@name='RESULT_TextField-2']")).sendKeys(lastname);
			
			
			driver.findElement(By.id("RESULT_TextField-3")).sendKeys(phone);
			
			driver.findElement(By.id("RESULT_TextField-4")).sendKeys(country);
			
			
			driver.findElement(By.name("RESULT_TextField-5")).sendKeys(city);
			
			driver.findElement(By.name("RESULT_TextField-6")).sendKeys(email);
			

	}

}
