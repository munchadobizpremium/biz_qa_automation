package reader_writer;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.io.Files;

import global_utility.global_variables;

public class excelReader extends global_variables
{
	
	
	@SuppressWarnings("rawtypes")
	public ArrayList<List> readInputs(String FilePath,String SheetName) throws IOException
	{
		
		ArrayList<List> DataSet=new ArrayList<List>();
		if(Files.getFileExtension(FilePath).equals("xlsx"))DataSet=readXlsxFile(FilePath,SheetName);
		if(Files.getFileExtension(FilePath).equals("xls"))DataSet=readXlsFile(FilePath,SheetName);
		return DataSet;		
	}
	
	@SuppressWarnings({"rawtypes", "unused", "unchecked", "deprecation" })
	public ArrayList<List> readXlsxFile(String FilePath,String SheetName) throws IOException
	{
		ArrayList<List> DataSet=new ArrayList<List>();
		InputStream ExcelFileToRead=new FileInputStream(FilePath);		
		XSSFWorkbook ExcelWorkBook=new XSSFWorkbook(ExcelFileToRead);
		XSSFSheet ExcelWorkSheet=ExcelWorkBook.getSheet(SheetName);
		Iterator rows = ExcelWorkSheet.rowIterator();
		 int number=ExcelWorkSheet.getLastRowNum();


         int lineNumber = 0;

         while (rows.hasNext())

         {
             XSSFRow row = ((XSSFRow) rows.next());
             lineNumber++;
             if(lineNumber==1){continue;}




             Iterator cells = row.cellIterator();
             List cellTempList = new ArrayList();    
             int current = 0, next =1;
             while(cells.hasNext())
             {

                 XSSFCell cell = (XSSFCell) cells.next();


                 current = cell.getColumnIndex();


                 if(current<next){

                 }
                 else{

                     int loop = current-next;

                     for(int k=0;k<loop+1;k++){
                    	 
                         cellTempList.add("null");
                         next = next + 1;
                     }
                 }
                 switch (cell.getCellType()) {
                             case Cell.CELL_TYPE_STRING:                                 
                                 cellTempList.add(cell.getRichStringCellValue().getString());
                                 break;
                             case Cell.CELL_TYPE_NUMERIC:                                                                                      
                                     cellTempList.add(String.valueOf(cell.getNumericCellValue()));                                                   
                                 break;
                             case Cell.CELL_TYPE_BOOLEAN:                                 
                            	 cellTempList.add(String.valueOf(cell.getBooleanCellValue()));
                                 break;
                             case Cell.CELL_TYPE_FORMULA:                                
                                 cellTempList.add(cell.getCellFormula());
                                 break;                                              

                             default:                            	 
                                 cellTempList.add("null");
                 }
                 next = next + 1;

             }
             DataSet.add(cellTempList);
          }
		ExcelWorkBook.close();
		return DataSet;	
	}
	
	@SuppressWarnings({"rawtypes", "unused", "unchecked", "deprecation" })
	public ArrayList<List> readXlsFile(String FilePath,String SheetName) throws IOException
	{
		ArrayList<List> DataSet=new ArrayList<List>();
		InputStream ExcelFileToRead=new FileInputStream(FilePath);		
		HSSFWorkbook ExcelWorkBook=new HSSFWorkbook(ExcelFileToRead);
		HSSFSheet ExcelWorkSheet=ExcelWorkBook.getSheet(SheetName);
		Iterator rows = ExcelWorkSheet.rowIterator();
		 int number=ExcelWorkSheet.getLastRowNum();


         int lineNumber = 0;

         while (rows.hasNext())

         {
             HSSFRow row = ((HSSFRow) rows.next());
             lineNumber++;
             if(lineNumber==1){continue;}




             Iterator cells = row.cellIterator();
             List cellTempList = new ArrayList();    
             int current = 0, next =1;
             while(cells.hasNext())
             {

                 HSSFCell cell = (HSSFCell) cells.next();


                 current = cell.getColumnIndex();


                 if(current<next){

                 }
                 else{

                     int loop = current-next;

                     for(int k=0;k<loop+1;k++){                    	 
                         cellTempList.add("null");
                         next = next + 1;
                     }
                 }
                 switch (cell.getCellType()) {
                             case Cell.CELL_TYPE_STRING:                                 
                                 cellTempList.add(cell.getRichStringCellValue().getString());
                                 break;
                             case Cell.CELL_TYPE_NUMERIC:                                                                                         
                                     cellTempList.add(String.valueOf(cell.getNumericCellValue()));                                                   
                                 break;
                             case Cell.CELL_TYPE_BOOLEAN:
                            	                                  
                                 break;
                             case Cell.CELL_TYPE_FORMULA:                                 
                                 cellTempList.add(cell.getCellFormula());
                                 break;                                              

                             default:                            	 
                                 cellTempList.add("null");
                 }
                 next = next + 1;

             }
             DataSet.add(cellTempList);
          }
		ExcelWorkBook.close();
		return DataSet;	
	}
}
