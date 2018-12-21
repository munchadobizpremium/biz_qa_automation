package reports_utility;

import java.io.File;
import java.io.IOException;


import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;






public class ReportsManager{
	
	public static ExtentReports reports;
	public static ExtentTest testinfo;

	public static ExtentHtmlReporter htmlRepoter;
	public static ExtentReports qc_reports;
	public static ExtentTest qc_testinfo;

	public static ExtentHtmlReporter qc_htmlRepoter;
	
	@BeforeSuite
	public void Setup()
	{
		htmlRepoter =new ExtentHtmlReporter(new File(System.getProperty("user.dir") +"/reports/testReport.html"));
		htmlRepoter.loadXMLConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
		reports=new ExtentReports();
		
		reports.attachReporter(htmlRepoter);
		
		qc_htmlRepoter =new ExtentHtmlReporter(new File(System.getProperty("user.dir") +"/reports/qc_testReport.html"));
		qc_htmlRepoter.loadXMLConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
		qc_reports=new ExtentReports();
		
		qc_reports.attachReporter(qc_htmlRepoter);
	}
		
	@AfterMethod
	public void getResult(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
/*			String url="<video controls=\"controls\" width=\"800\" height=\"600\" \r\n" + 
					"       name=\"Video Name\" src='"+global_variables.path_lib_recoderfull+"'></video>";		
			String[][] desc= {{"Screenshot"},{url}};						
			testinfo.log(Status.INFO, MarkupHelper.createTable(desc));			
*/			
			
			testinfo.fail(result.getThrowable());
			qc_testinfo.fail(result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
/*			String url="<video controls=\"controls\" width=\"800\" height=\"600\" \r\n" + 
					"       name=\"Video Name\" src='"+global_variables.path_lib_recoderfull+"'></video>";			
			String[][] desc= {{"Screenshot"},{url}};						
			testinfo.log(Status.INFO, MarkupHelper.createTable(desc));
			//testinfo.pass(MarkupHelper.createLabel("test Execution", ExtentColor.GREEN));
			qc_testinfo.pass(result.getThrowable());*/
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
/*			String url="<video controls=\"controls\" width=\"800\" height=\"600\" \r\n" + 
					"       name=\"Video Name\" src='"+global_variables.path_lib_recoderfull+"'></video>";			
			String[][] desc= {{"Screenshot"},{url}};						
			testinfo.log(Status.INFO, MarkupHelper.createTable(desc));
			//testinfo.skip(MarkupHelper.createLabel("test Execution", ExtentColor.GREEN));
*/			testinfo.skip(result.getThrowable());
			qc_testinfo.skip(result.getThrowable());
		}
	}
	
	@AfterSuite
	public void tearDown()
	{
		
		/*reports.flush();*/
	}
	
	
	
}
