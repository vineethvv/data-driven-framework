package com.parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameterTest {
	
	
	WebDriver driver;
	
	@Test
	
	@Parameters({"browser", "url", "emailid", "password"})
	
	public void AutomationPracticeLoginTest(String browser, String url, String emailid, String password) {
		
		if(browser.equals("chrome")) {
		
		
		 System.setProperty("webdriver.chrome.driver", "E:\\selenium jar files\\chrome driver\\chromedriver.exe");
			
			// to launch the browser
			
			 driver = new ChromeDriver();
			 
		}else if(browser.equals("firefox")) {
	    	
	    	 System.setProperty("webdriver.chrome.driver", "E:\\selenium jar files\\chrome driver\\geckodriver.exe");
	    	 
	    	 driver = new FirefoxDriver();
	    }
			
			// to launch the url
			
			driver.get(url);
			
			// to maximize the page
			
			driver.manage().window().maximize();
			
			driver.findElement(By.xpath("//input[@id='email']")).clear();
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(emailid);
			
			driver.findElement(By.xpath("//input[@id='passwd']")).clear();
			driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(password);
	

}
	
}
