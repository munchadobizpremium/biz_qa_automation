package suit;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.Test;
import global_utility.global_variables;
import reader_writer.excelReader;

public class runner extends global_variables{
  
	
	
	utility_executer.executer executer_select= new utility_executer.executer();
	utility_executer.verifyTemplate_executer verify_executer= new utility_executer.verifyTemplate_executer();
	@Test	
	  public void Runner() {				
		
		excelReader getExcelSheet=new excelReader();						
		try
		{						
			Properties prop=new Properties();
			InputStream in=new FileInputStream(path_lib_properties+"path_testcase.properties");
			prop.load(in);
			@SuppressWarnings("rawtypes")
			ArrayList<List> test_data =getExcelSheet.readInputs(path_lib_runner+prop.getProperty("microsite_Runner_FileName"), prop.getProperty("microsite_Runner_SheetName"));
			ArrayList<String> uniqueTemplte=new ArrayList<String>();
			HashMap<String,gs_utilities.runner> unique_testData=new HashMap<String, gs_utilities.runner>();
			
			for(@SuppressWarnings("rawtypes") List TestData:test_data)
			{						
				gs_utilities.runner runnerObj = new gs_utilities.runner();
				boolean TemplateFlag=true;
				
				if(TestData.get(7).toString().contains("null") || TestData.get(7).toString().contains("false"))
					TemplateFlag=String.valueOf(TestData.get(7).toString()) == null;				
				String TemplateNumber=TestData.get(3).toString();
				if(!uniqueTemplte.contains(TemplateNumber))
					uniqueTemplte.add(TemplateNumber);
				if(TemplateFlag!=true)
				{
					if(!unique_testData.keySet().contains(TemplateNumber))
					{						
						runnerObj.setSerialNumber(Integer.parseInt(TestData.get(0).toString().replace("\"", "")));
						runnerObj.setClientName(TestData.get(1).toString());
						runnerObj.setTemplateUrl(TestData.get(2).toString());
						runnerObj.setTax(Float.parseFloat(TestData.get(4).toString().replace("\"", "")));
						runnerObj.setEnvironment(TestData.get(5).toString());
						runnerObj.setBrowser(TestData.get(6).toString());						
						runnerObj.setFlag(false);						
						runnerObj.setCity(TestData.get(8).toString());
						runnerObj.setAddress(TestData.get(9).toString());
						unique_testData.put(TemplateNumber, runnerObj);
					}
				}				
			}			
			unique_testData.putAll(verify_executer.validate_executer(unique_testData.keySet(), uniqueTemplte));
			executer_select.executer_selector(unique_testData);
		}
		catch(Exception e)
		{
			log_system.error("System is not able to execute Script or Exception found in automation script");
			log_system.error(e.getStackTrace().toString());
			log_system.error(e.getMessage());
			try {
				/*recorder.stopRecording();*/
				Driver.quit();				
				System.exit(0);
			} catch (Exception e1) {
				log_system.error(e.getStackTrace().toString());								
				System.exit(0);
			}			
		}
		
	  }
}
