package exceltests;

import com.excel.utility.Xls_Reader;

public class ExcelUtilTest {

	public static void main(String[] args) {
		
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Vineeth\\git\\data-driven-framework\\DataDrivenFramework\\src\\com\\testdata\\sample.xlsx");
		
        String sheetName = "login";
		
        
        System.out.println(reader.getCellData(sheetName, "username", 3));
		String data = reader.getCellData(sheetName, 0, 2);
		System.out.println(data);
		
		
		int rowCount = reader.getRowCount(sheetName);
		System.out.println("total rows: "+ rowCount);
		
		if(! reader.isSheetExist("Regsitration")){
			reader.addSheet("Regsitration");
		}
		
		
        reader.setCellData(sheetName, "status", 2, "PASS");
		
		System.out.println(reader.getColumnCount(sheetName));
		
		
		System.out.println(reader.getCellData("Regsitration", "phonenumber", 2));
		System.out.println(reader.getCellData("Regsitration", "age", 2));

	}

}