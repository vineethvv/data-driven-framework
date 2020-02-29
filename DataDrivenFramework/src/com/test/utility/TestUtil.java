package com.test.utility;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.excel.utility.Xls_Reader;

public class TestUtil {
	
	static Xls_Reader reader;
	
	
	public static ArrayList<Object[]> getdataFromExcel() {
		
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();		
		
		try {
			
			reader = new Xls_Reader("C:\\Users\\Vineeth\\git\\data-driven-framework\\DataDrivenFramework\\src\\com\\testdata\\TestAutomationTestData.xlsx");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		for (int rownum =2; rownum<= reader.getRowCount("RegTestData"); rownum++) {
			
			
			String firstname = reader.getCellData("RegTestData", "firstname", rownum);
			String lastname = reader.getCellData("RegTestData", "lastname", rownum);
			String phone = reader.getCellData("RegTestData", "phone", rownum);
			String country = reader.getCellData("RegTestData", "country", rownum);
			String city = reader.getCellData("RegTestData", "city", rownum);
			String email = reader.getCellData("RegTestData", "email", rownum);
			
			Object ob[] = {firstname, lastname, phone,country, city, email};
			
			myData.add(ob);
			
		}
		
		return myData;
		
		
	}

}
