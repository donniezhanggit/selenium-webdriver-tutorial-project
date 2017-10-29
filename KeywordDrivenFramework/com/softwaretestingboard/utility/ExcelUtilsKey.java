package com.softwaretestingboard.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.softwaretestingboard.config.Constants;
import com.softwaretestingboard.examples.execution.DriverScript;

public class ExcelUtilsKey {
	private static XSSFSheet excelWSheet;
	private static XSSFWorkbook excelWBook;
	private static org.apache.poi.ss.usermodel.Cell cell;
	private static XSSFRow row;
	// private static XSSFRow Row;

	public static void setExcelFile(String Path) throws Exception {
		try {
			FileInputStream ExcelFile = new FileInputStream(Path);
			excelWBook = new XSSFWorkbook(ExcelFile);
		} catch (Exception e) {
			Log.error("Class Utils | Method setExcelFile | Exception desc : " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	public static String getCellData(int RowNum, int ColNum, String SheetName) throws Exception {
		try {
			excelWSheet = excelWBook.getSheet(SheetName);
			cell = excelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			Log.error("Class Utils | Method getCellData | Exception desc : " + e.getMessage());
			DriverScript.bResult = false;
			return "";
		}
	}

	public static int getRowCount(String SheetName) {
		int iNumber = 0;
		try {
			excelWSheet = excelWBook.getSheet(SheetName);
			iNumber = excelWSheet.getLastRowNum() + 1;
		} catch (Exception e) {
			Log.error("Class Utils | Method getRowCount | Exception desc : " + e.getMessage());
			DriverScript.bResult = false;
		}
		return iNumber;
	}

	public static int getRowContains(String sTestCaseName, int colNum, String SheetName) throws Exception {
		int iRowNum = 0;
		try {
			// ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int rowCount = ExcelUtilsKey.getRowCount(SheetName);
			for (; iRowNum < rowCount; iRowNum++) {
				if (ExcelUtilsKey.getCellData(iRowNum, colNum, SheetName).equalsIgnoreCase(sTestCaseName)) {
					break;
				}
			}
		} catch (Exception e) {
			Log.error("Class Utils | Method getRowContains | Exception desc : " + e.getMessage());
			DriverScript.bResult = false;
		}
		return iRowNum;
	}

	public static int getTestStepsCount(String SheetName, String sTestCaseID, int iTestCaseStart) throws Exception {
		try {
			for (int i = iTestCaseStart; i <= ExcelUtilsKey.getRowCount(SheetName); i++) {
				if (!sTestCaseID.equals(ExcelUtilsKey.getCellData(i, Constants.Col_TestCaseID, SheetName))) {
					int number = i;
					return number;
				}
			}
			excelWSheet = excelWBook.getSheet(SheetName);
			int number = excelWSheet.getLastRowNum() + 1;
			return number;
		} catch (Exception e) {
			Log.error("Class Utils | Method getRowContains | Exception desc : " + e.getMessage());
			DriverScript.bResult = false;
			return 0;
		}
	}

	public static void setCellData(String Result, int RowNum, int ColNum, String SheetName) throws Exception {
		try {

			excelWSheet = excelWBook.getSheet(SheetName);
			row = excelWSheet.getRow(RowNum);
			cell = row.getCell(ColNum);
			if (cell == null) {
				cell = row.createCell(ColNum);
				cell.setCellValue(Result);
			} else {
				cell.setCellValue(Result);
			}
			FileOutputStream fileOut = new FileOutputStream(Constants.Path_TestData);
			excelWBook.write(fileOut);
			// fileOut.flush();
			fileOut.close();
			excelWBook = new XSSFWorkbook(new FileInputStream(Constants.Path_TestData));
		} catch (Exception e) {
			DriverScript.bResult = false;

		}
	}

}