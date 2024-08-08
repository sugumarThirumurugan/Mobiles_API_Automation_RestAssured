package mobiles.api.Utilities;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name="ExcelData")
	public String[][]excelData() throws Exception{
		Utilities utilities = new Utilities();
		int row = utilities.getRow();
		int cell = utilities.getCell();
		String data[][] = new String[row][cell];
		for(int i=1; i<=row; i++) {
			for(int j=0; j<cell; j++) {
				data[i-1][j]=utilities.getSheetData(i, j);
			}
		}
		return data;
	}

}
