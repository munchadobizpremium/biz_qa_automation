package utility_executer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import global_utility.global_variables;
import reader_writer.excelReader;

public class verifyTemplate_executer extends global_variables{
	
	reader_writer.excelWriter writer=new reader_writer.excelWriter();
	@SuppressWarnings("unlikely-arg-type")
	public HashMap<String,gs_utilities.runner> validate_executer(Set<String> t_executer_selector,ArrayList<String> t_exist) throws IOException
	{
		HashMap<String,gs_utilities.runner> unique_testData_append=new HashMap<String, gs_utilities.runner>();
		ArrayList<Integer> sequenceNumber=new ArrayList<Integer>();
		excelReader getExcelSheet=new excelReader();
		if(!t_executer_selector.equals(t_exist))
		{
			for(String templateNumber:t_exist)
			{
				if(!t_executer_selector.contains(templateNumber))
				{
					Properties prop=new Properties();
					InputStream in=new FileInputStream(path_lib_properties+"path_testcase.properties");
					prop.load(in);
					@SuppressWarnings("rawtypes")					
					ArrayList<List> test_data =getExcelSheet.readInputs(path_lib_runner+prop.getProperty("microsite_Runner_FileName"), prop.getProperty("microsite_Runner_SheetName"));
					for(@SuppressWarnings("rawtypes") List TestData:test_data)
					{	
						String TemplateNumber=TestData.get(3).toString();
						if(TemplateNumber.equals(templateNumber))
						{
							sequenceNumber.add(Integer.parseInt(TestData.get(0).toString().replace("\"", "")));
							
						}
					}
					writer.updateFlag(path_lib_runner+prop.getProperty("microsite_Runner_FileName"), prop.getProperty("microsite_Runner_SheetName"), sequenceNumber,false);
					for(@SuppressWarnings("rawtypes") List TestData:test_data)
					{						
						if(TestData.contains(templateNumber))
						{
							gs_utilities.runner runnerObj = new gs_utilities.runner();																												
							String TemplateNumber=TestData.get(3).toString();							
							runnerObj.setSerialNumber(Integer.parseInt(TestData.get(0).toString().replace("\"", "")));
							runnerObj.setClientName(TestData.get(1).toString());
							runnerObj.setTemplateUrl(TestData.get(2).toString());
							runnerObj.setTax(Float.parseFloat(TestData.get(4).toString().replace("\"", "")));
							runnerObj.setEnvironment(TestData.get(5).toString());
							runnerObj.setBrowser(TestData.get(6).toString());						
							runnerObj.setFlag(false);
							runnerObj.setCity(TestData.get(8).toString());
							runnerObj.setAddress(TestData.get(9).toString());
							unique_testData_append.put(TemplateNumber, runnerObj);
							break;
						}
					}
				}
			}
		}
		return unique_testData_append;
	}

}
