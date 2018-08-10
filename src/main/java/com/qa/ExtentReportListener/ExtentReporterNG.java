/*
 * @autor : Naveen Khunteta
 * 
 */
package com.qa.ExtentReportListener;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.crm.qa.testcases.Screenshots;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterNG implements IReporter {
	private ExtentReports extent;
	WebDriver driver;

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		 extent = new ExtentReports(outputDirectory + File.separator
		 + "Extent.html", true);
//		 extent= new ExtentReports();
//		extent = new ExtentReports("C:\\Biz Reports\\MicroBizTest.html");

		for (ISuite suite : suites) {
			ExtentTest tests=null;
			Map<String, ISuiteResult> result = suite.getResults();
			
			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();
				// System.out.println("Context is ********* "+context);
				// System.out.println(context.getPassedTests().getAllResults());
				

				try {
					buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// buildTestNodes(context.getSkippedTests(),LogStatus.INFO)
			}
			
		}
        
        extent.flush();
		extent.close();

	}

	private void buildTestNodes(IResultMap tests, LogStatus status) throws IOException{
		ExtentTest test = null;

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.startTest(result.getMethod().getMethodName());

				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));

				for (String group : result.getMethod().getGroups()) {
					test.assignCategory(group);

					if (result.getThrowable() != null) {
						test.log(status, result.getThrowable());

					} else {
						test.log(status, "Test " + status.toString().toLowerCase() + "ed");
					}
					if (result.getStatus() == ITestResult.SUCCESS) {
						String path = Screenshots.takeScreenshot(driver, result.getName());
						String imagePath = test.addScreenCapture(path);
						test.log(LogStatus.PASS, "Verify Welcome PASS", imagePath);
					}
					
					if (result.getStatus() == ITestResult.FAILURE) {
						String path = Screenshots.takeScreenshot(driver, result.getName());
						String imagePath = test.addScreenCapture(path);
						test.log(LogStatus.FAIL, "Test Failed", imagePath);
					}

					extent.endTest(test);
				}
			}
		}
	}

//	public void tearDown(ITestResult testResult) throws IOException {
//		ExtentTest test = null;
//		if (testResult.getStatus() == ITestResult.SUCCESS) {
//			String path = Screenshots.takeScreenshot(driver, testResult.getName());
//			String imagePath = test.addScreenCapture(path);
//			test.log(LogStatus.PASS, "Verify Welcome PASS", imagePath);
//		}
//
//		extent.endTest(test);
//	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}