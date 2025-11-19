package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\testData.xlsx";//taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
	return logindata;//returning two dimension array
				
	}
	
	//DataProvider 2
	@DataProvider(name = "RegisterData")
	public Object[][] getRegisterData() throws IOException 
	{
	    String path = ".\\testData\\Register Test data.xlsx";
	    ExcelUtility xlutil = new ExcelUtility(path);

	    String sheetName = "register";

	    int totalRows = xlutil.getRowCount(sheetName);     // last row index
	    int totalCols = xlutil.getCellCount(sheetName, 1); // count columns from row 1

	    // Create 2D array
	    Object[][] data = new Object[totalRows][totalCols];

	    int actualRow = 0;  // to skip blank rows

	    for (int i = 1; i <= totalRows; i++)  // Start from row 1 (row 0 is header)
	    {
	        // Check if row is empty
	        String firstCell = xlutil.getCellData(sheetName, i, 0);

	        if (firstCell == null || firstCell.trim().equals("")) {
	            continue;  // Skip empty rows
	        }

	        for (int j = 0; j < totalCols; j++) 
	        {
	            String cellValue = xlutil.getCellData(sheetName, i, j);

	            data[actualRow][j] = (cellValue == null) ? "" : cellValue;
	        }

	        actualRow++;
	    }

	    return data;
	}

	//DataProvider 3
	
	//DataProvider 4
}
