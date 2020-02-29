package exceltests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class LoginPage {

	public static void main(String[] args) {

		
		
               System.setProperty("webdriver.chrome.driver", "F:\\software\\chromedriver_win32\\chromedriver.exe");
		
		       // to launch the browser
		
				WebDriver driver = new ChromeDriver(); 
				
				// to maximize the page
				
			    driver.manage().window().maximize();
			    
			    // to delete all cache
				
			     driver.manage().deleteAllCookies();
			     
			     driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 								
				// to launch the site
				
				driver.get("https://classic.crmpro.com/");
				
				WebElement userName = driver.findElement(By.name("username"));
				WebElement pwd = driver.findElement(By.name("password"));
				
				
				Xls_Reader reader = new Xls_Reader("C:\\Users\\Vineeth\\git\\data-driven-framework\\DataDrivenFramework\\src\\com\\testdata\\sample.xlsx");
				String sheetName = "login";
				
				int rowCount = reader.getRowCount(sheetName);
				
				for(int rowNum=2; rowNum<=rowCount; rowNum++){
					String loginId = reader.getCellData(sheetName, "username", rowNum);
					String passsword = reader.getCellData(sheetName, "password", rowNum);
					
					System.out.println(loginId + " " + passsword);
					
					userName.clear();
					userName.sendKeys(loginId);
					
					pwd.clear();
					pwd.sendKeys(passsword);
					
					

	}

}
}
