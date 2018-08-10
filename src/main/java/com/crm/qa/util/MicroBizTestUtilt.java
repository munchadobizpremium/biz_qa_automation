package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.WorkbookUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import com.crm.qa.base.TestBase;

public class MicroBizTestUtilt extends TestBase {

	// C:\POM and Data Driver Frame Work\Copy
	// 1\HyBridFramework-master\src\main\java\com\crm\qa\testdata
	public static long PAGE_LOAD_TIMEOUT = 3;
	public static long IMPLICIT_WAIT = 3;

	public static String TESTDATA_SHEET_PATH = "C:\\POM and Data Driver Frame Work\\"
			+ "Copy  1\\HyBridFramework-master\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmTestData.xlsx";

	// "/Users/naveenkhunteta/Documents/workspace"
	// + "/FreeCRMTest/src/main/java/com/crm/qa/testdata/FreeCrmTestData.xlsx";

	static Workbook book;
	static Sheet sheet;

	// public void switchToFrame(){
	// driver.switchTo().frame("mainpanel");
	// }

	
	public static Object[][] getTestData(String sheetName) {

		DataFormatter fmt = new DataFormatter();
		FileInputStream file = null;

		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName.trim());
		// book.getMissingCellPolicy().toString();
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {

				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();

				try {
					if (data[i][k] == null) {
						return data;
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Data is not available");
					test.log(LogStatus.INFO, "Fail:Kindly Input Data as The Data is Unavailable" + data[i][k]);

					return data;
				}

			}

			// fmt.addFormat(sheetName, null);

			// System.out.println(data[i][k]);

		}

		return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");

		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

	}

}
