package com.GimmalMIR.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFRow row;
	public static List<String> list = new ArrayList<String>();

	public static void setExcelFile(int sheetnumb) {
		String userdir = System.getProperty("user.dir");
		try {

			File file = new File(userdir + "/src/test/resources/Configuration/TestData.xlsx");

			FileInputStream inputfile = new FileInputStream(file);

			ExcelWBook = new XSSFWorkbook(inputfile);

			ExcelWSheet = ExcelWBook.getSheetAt(sheetnumb);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setExcelFile(String filename) {
		String user = System.getProperty("user.name");
		try {

			File file = new File("C://Users//" + user + "//Downloads//" + filename);

			FileInputStream inputfile = new FileInputStream(file);

			ExcelWBook = new XSSFWorkbook(inputfile);

			ExcelWSheet = ExcelWBook.getSheetAt(0);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int getRowCount() {
		int rowcount = ExcelWSheet.getLastRowNum() + 1;

		return rowcount;

	}

	public static int getColumnCount() {
		row = ExcelWSheet.getRow(0);
		int colcount = row.getLastCellNum();
		return colcount;
	}

	public static String getSheetData(int row, int col) {
		ExcelUtils.setExcelFile(0);
		String value = ExcelWSheet.getRow(row).getCell(col).getStringCellValue();
		return value;
	}

	public static String[][] getExcelData(String fileName, String sheetName) throws IOException {
		String[][] arrayExcelData = null;
		try {
			String userdir = System.getProperty("user.dir");

			File file = new File(userdir + "//src//test//resources//Configuration//" + fileName);
			FileInputStream fs = new FileInputStream(file);
			ExcelWBook = new XSSFWorkbook(fs);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);

			int totalNoOfCols = ExcelUtils.getColumnCount();
			int totalNoOfRows = ExcelUtils.getRowCount();

			arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];

			for (int i = 1; i < totalNoOfRows; i++) {

				for (int j = 0; j < totalNoOfCols; j++) {
					String value = ExcelWSheet.getRow(i).getCell(j).getStringCellValue();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}

	public static List<String> readdata(String fileName) throws IOException {

		String userdir = System.getProperty("user.dir");

		File file = new File(userdir + "//ExportFile//" + fileName);

		FileInputStream fs = new FileInputStream(file);
		ExcelWBook = new XSSFWorkbook(fs);
		ExcelWSheet = ExcelWBook.getSheet("Processes");

		int totalNoOfCols = ExcelUtils.getColumnCount();
		int totalNoOfRows = ExcelUtils.getRowCount();

		for (int i = 1; i < totalNoOfRows; i++) {

			String value = ExcelWSheet.getRow(i).getCell(1).getStringCellValue();
			list.add(value);
		}
		System.out.println(list);

		return list;

	}
}
