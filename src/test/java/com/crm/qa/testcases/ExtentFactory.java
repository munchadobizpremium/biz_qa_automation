package com.crm.qa.testcases;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	public static ExtentReports getInstance() {
		ExtentReports extent;
		String Path = "C:\\MicroBiz Reports Extent\\MicroBizTest.html";
		extent = new ExtentReports(Path,false);
		extent
	     .addSystemInfo("Selenium Version", "2.52")
	     .addSystemInfo("Platform", "Windows");

		return extent;
	}
}