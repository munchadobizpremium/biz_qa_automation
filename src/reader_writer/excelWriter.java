package reader_writer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import global_utility.global_variables;


public class excelWriter extends global_variables
{
	
	
	
	@SuppressWarnings({ "rawtypes", "deprecation"})
	public void writeResult(String UseCase_ID,String Testcase_ID,String FilePath,String SheetName,List result_log,int RowIndex,String Description,String Expected_result,String TestName) throws IOException
	{
		RowIndex=RowIndex+1;
		InputStream ExcelFileToRead=new FileInputStream(FilePath);		
		XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFileToRead);
		XSSFSheet ExcelWorkSheet=ExcelWorkBook.getSheet(SheetName);
		String Actual=result_log.get(0).toString();
		String Current_Status=result_log.get(1).toString();
		String Comment=result_log.get(2).toString();
		ExcelWorkSheet.getRow(RowIndex).getCell(11).setCellType(Cell.CELL_TYPE_STRING);
		ExcelWorkSheet.getRow(RowIndex).getCell(11).setCellValue(Actual);
		ExcelWorkSheet.getRow(RowIndex).getCell(12).setCellType(Cell.CELL_TYPE_STRING);
		ExcelWorkSheet.getRow(RowIndex).getCell(12).setCellValue(Current_Status);
		ExcelWorkSheet.getRow(RowIndex).getCell(13).setCellType(Cell.CELL_TYPE_STRING);
		ExcelWorkSheet.getRow(RowIndex).getCell(13).setCellValue(Comment);
		FileOutputStream fos=new FileOutputStream(FilePath);
		ExcelWorkBook.write(fos);
		ExcelWorkBook.close();
		fos.close();
		
		switch(Current_Status)
		{
		case "Pass":
		{	
			String url="<img width='100px' src=\""+path_lib_screenshotfull+"\" data-src=\""+path_lib_screenshotfull+"\" data-featherlight=\""+path_lib_screenshotfull+"\">";			
			String[][] desc= {{"Test ID","Descritpion","Expected Result","Actual Result","Screenshot"},{UseCase_ID+"_"+ Testcase_ID,Description,Expected_result,Actual,url}};						
			qc_testinfo.log(Status.PASS, MarkupHelper.createTable(desc));
			break;
		}
		case "Fail":
		{
			String url="<img width='100px' src=\""+path_lib_screenshotfull+"\" data-src=\""+path_lib_screenshotfull+"\" data-featherlight=\""+path_lib_screenshotfull+"\">";			
			String[][] desc= {{"Test ID","Descritpion","Expected Result","Actual Result","Screenshot"},{UseCase_ID+"_"+ Testcase_ID,Description,Expected_result,Actual,url}};						
			testinfo.log(Status.FAIL, MarkupHelper.createTable(desc));
			qc_testinfo.log(Status.FAIL, MarkupHelper.createTable(desc));
			break;
		}
		}
		
	}
	
	
	@SuppressWarnings("deprecation")
	public void updateFlag(String FilePath,String SheetName,ArrayList<Integer> serial_Number,boolean Flag) throws IOException
	{
		
		InputStream ExcelFileToRead=new FileInputStream(FilePath);		
		XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFileToRead);
		XSSFSheet ExcelWorkSheet=ExcelWorkBook.getSheet(SheetName);		
		for(int RowIndex:serial_Number)
		{
			ExcelWorkSheet.getRow(RowIndex).getCell(7).setCellType(Cell.CELL_TYPE_BOOLEAN);
			ExcelWorkSheet.getRow(RowIndex).getCell(7).setCellValue(Flag);
		}
				
		FileOutputStream fos=new FileOutputStream(FilePath);
		ExcelWorkBook.write(fos);
		ExcelWorkBook.close();
		fos.close();
	}
}
