package com.ExcelrProject_2.AutomationExerciseDemo;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	static FileInputStream fis;
	static XSSFSheet sheet;
	public static XSSFSheet readExcelData(String Sheet) {
		try {
			fis = new FileInputStream(".//ExcelsheetAutomation//automationexercise.xlsx");
		}catch(Exception e) {
			System.out.println("Sorry! File do not exist in the specified path");
		}
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(Sheet);
		}catch(Exception e) {
			System.out.println("Sorry! the specified workbook do not exist");
		}
		return sheet;		
	}
}