package WriteWebtablevaluesinexcel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class WebTableHandle {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "F:\\software\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		 driver.manage().window().maximize();
		    
		    // to delete all cache
			
		     driver.manage().deleteAllCookies();
		     
		     driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		     
		     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		     
		     // to launch url
				
		     driver.get("https://www.w3schools.com/html/html_tables.asp");
		     
		    //*[@id="customers"]/tbody/tr[2]/td[1]
		     
		   //*[@id="customers"]/tbody/tr[3]/td[1]
		     
		   //*[@id="customers"]/tbody/tr[4]/td[1]
		     
		     
		     String beforeXpath = "//*[@id='customers']/tbody/tr[";
		     
		     String afterXpath = "]/td[1]";
		     
		     
		     List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));  // here tr is written in xpath to get the total no: of rows
		     
		     System.out.println("total no: of rows =" + (rows.size()-1));
		     
		     int rowcount = rows.size();
		     
		     
		     Xls_Reader reader = new Xls_Reader("C:\\Users\\Vineeth\\git\\data-driven-framework\\DataDrivenFramework\\src\\com\\testdata\\TestAutomationTestData.xlsx");
		     
		    
		     if(!reader.isSheetExist("Tabledata")) {
		     
		     reader.addSheet("Tabledata");
		     
		     reader.addColumn("Tabledata", "companyName");
		     
		     }
		     
		     for (int i=2; i<=rowcount; i++) {
		    	 
		    	 
		    	 String actualXpath = beforeXpath+i+afterXpath;
		    	 
		    	String companyname = driver.findElement(By.xpath(actualXpath)).getText();
		    	
		    	System.out.println(companyname);
		    			    	
		    	reader.setCellData("Tabledata", "companyName", i, companyname);
		    	
		     }
				

	}

}
