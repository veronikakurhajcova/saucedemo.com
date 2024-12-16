package com.saucedemo.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Utils {

	@DataProvider(name="loginData")
	public Object[][] ExcelReader() throws IOException {
		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testData.xlsx";
		
		Object[][] data = null;

		try {
			FileInputStream fis = new FileInputStream(new File(filePath));

			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);

			int rowCount = sheet.getPhysicalNumberOfRows();
			int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

			data = new Object[rowCount - 1][colCount];

			for (int i = 1; i < rowCount; i++) {
				XSSFRow row = sheet.getRow(i);

				for (int j = 0; j < colCount; j++) {
					XSSFCell cell = row.getCell(j);
					if (cell != null) {
                        data[i - 1][j] = cell.getStringCellValue();
                    }
				}
			}
			workbook.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return data;
	}
}
