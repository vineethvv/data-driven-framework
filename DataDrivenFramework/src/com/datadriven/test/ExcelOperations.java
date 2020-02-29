package com.datadriven.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) {
		
		
		
        // Get test data from excel
		
	    Xls_Reader reader = new Xls_Reader("C:\\Users\\Vineeth\\git\\data-driven-framework\\DataDrivenFramework\\src\\com\\testdata\\TestAutomationTestData.xlsx");
	    
	   
	    
	    if(!reader.isSheetExist("HomePage")) {
	    reader.addSheet("Homepage");	    

	}
	    
	  int colcount =  reader.getColumnCount("RegTestData");
	  System.out.println("Total columns present in RegTestData sheet:======"  +colcount);
	  
	  System.out.println(reader.getCellRowNum("RegTestData", "firstname", "git"));

}
}
