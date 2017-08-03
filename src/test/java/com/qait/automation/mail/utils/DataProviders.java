package com.qait.automation.mail.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.DataProvider;

public class DataProviders {

	public static String readexcelfile(int r, int c) throws IOException {

		String excelfilepath = "src/test/resources/mailingDetails.xls";
		InputStream ExcelFileToRead = new FileInputStream(excelfilepath);
		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow row = null;
		HSSFCell cell = null;
		int count = 0;
		Iterator rows = sheet.rowIterator();
		String result = "";

		while (rows.hasNext()) {
			count++;
			row = (HSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			cell = sheet.getRow(r).getCell(c);
			result = cell.toString();
			// for (int i = 0; i <= 4; i++) {
			// for (int j = 0; j <= 2; j++) {
			// cell = sheet.getRow(i).getCell(j);
			//
			// if (r == i && c == j) {
			// result = cell.toString();
			// break;
			// }
			//
			// System.out.println(cell.toString());
			//
			// }
			//
			// }
		}
		return result;

	}

	// @DataProvider(name = "mydata")
	// public static Object[][] mydata() throws IOException {
	// Object[][] data
	//
	// return new Object[][] { { readexcelfile(1, 0), readexcelfile(1, 1),
	// readexcelfile(1, 2) } };
	// }

	@DataProvider(name = "mydata" , parallel=true)
	public static Object[][] mydata() throws IOException {
		Object[][] data = new Object[10][3];
		for (int i = 0; i < 10; i++) {
			data[i][0] = readexcelfile(i, 0);
			data[i][1] = readexcelfile(i, 1);
			data[i][2] = readexcelfile(i, 2);
		}
		return data;
	}

}