package global_utility;

import java.io.File;
import java.util.LinkedHashMap;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;

import reports_utility.ReportsManager;





public class global_variables extends ReportsManager{
	
	public global_variables()
	{
		File Rlog=new File(path_lib_system_log+"Rlog.log");
		File TTCClog1=new File(path_lib_system_log+"TTCClog1.log");
		File web=new File(path_lib_system_log+"Web.html");

		if(Rlog.exists())
		{
			Rlog.delete();
		}
		if(TTCClog1.exists())
		{
			TTCClog1.delete();
		}
		if(web.exists())
		{
			web.delete();
		}		
		
		log_system=Logger.getLogger(this.getClass().getName());
		PropertyConfigurator.configure(SourcePath.getAbsolutePath()+"/lib_properties/log4j.properties");
				
	}
	
	
	
	/*system framework path object*/
	public File SourcePath=new File(System.getProperty("user.dir"));
	public static Logger log_system;	
	public static LinkedHashMap<String, gs_utilities.productdetails> ProductDetails=new LinkedHashMap<String, gs_utilities.productdetails>();
	
	
	/*declaring static variables*/
	public static WebDriver Driver;
	public static String path_lib_screenshotfull=null;
	public static String mainwindow = null;
	
	
	
	/* declaring global variable protected*/
	protected String path_lib_driver=SourcePath.getAbsolutePath()+"/lib_driver/";
	protected String path_lib_properties=SourcePath.getAbsolutePath()+"/lib_properties/";
	protected String path_lib_record=SourcePath.getAbsolutePath()+"/lib_record/";
	protected String path_lib_screenshot=SourcePath.getAbsolutePath()+"/lib_screenshot/";
	protected String path_lib_source=SourcePath.getAbsolutePath()+"/lib_source/";
	protected String path_lib_testcase=SourcePath.getAbsolutePath()+"/lib_testcase/";
	protected String path_lib_runner=SourcePath.getAbsolutePath()+"/lib_template/";
	protected String path_lib_system_log=SourcePath.getAbsolutePath()+"/system_log/";
	protected String path_lib_error_log=SourcePath.getAbsolutePath()+"/error_log/";
	protected String path_lib_download=SourcePath.getAbsolutePath()+"/lib_download/";
	protected String path_reports=SourcePath.getAbsolutePath()+"/reports/";
}
