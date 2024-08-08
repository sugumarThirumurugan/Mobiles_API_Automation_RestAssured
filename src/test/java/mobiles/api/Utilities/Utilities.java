package mobiles.api.Utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities {
	
	FileInputStream fileInputStream;
	XSSFWorkbook xssfWorkbook;
	String sheetPath=System.getProperty("user.dir")+"//TestData//Mobiles Test Data.xlsx";
	
	
	public int getRow() throws Exception{
		fileInputStream = new FileInputStream(sheetPath);
		xssfWorkbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = xssfWorkbook.getSheet("sheet1");
		int lastRowNum = sheet.getLastRowNum();
		return lastRowNum;
	}
	
	public int getCell() throws Exception{
		fileInputStream = new FileInputStream(sheetPath);
		xssfWorkbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = xssfWorkbook.getSheet("sheet1");
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		return lastCellNum;
	}
	
	public String getSheetData(int rowNum,int cellNum) throws Exception{
		fileInputStream = new FileInputStream(sheetPath);
		xssfWorkbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = xssfWorkbook.getSheet("sheet1");
		XSSFRow row = sheet.getRow(rowNum);
		XSSFCell cell = row.getCell(cellNum);
		DataFormatter dataFormatter = new DataFormatter();
		String data = dataFormatter.formatCellValue(cell);
		return data;
	}

}
