package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CheckOut;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DeleteOrderPage;
import com.crm.qa.pages.EditOrderPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MicroBizHomePage;
import com.crm.qa.util.MicroBizTestUtilt;
import com.crm.qa.util.MicroBizTestUtil;
import com.relevantcodes.extentreports.LogStatus;

public class DeleteOrderPageTest extends TestBase {

	MicroBizTestUtil testUtil;
	CheckOut checkoutpage;

	DeleteOrderPage deleteorderpage;
	String sheetName = "TakeOut";

	public DeleteOrderPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		report = ExtentFactory.getInstance();
		test = report.startTest(" Delete Oredr Online Page Sanity Test");
		initialization();
		checkPageIsReady();

		deleteorderpage = new DeleteOrderPage(test);

	}

	@Test(priority = 1)
	public void deleteItemTest() throws InterruptedException {
		deleteorderpage.deleteBtnClick();

	}

	@AfterMethod
	public void tearDown(ITestResult testResult) throws IOException {

		if (testResult.getStatus() == ITestResult.SUCCESS) {
			String path = Screenshots.takeScreenshot(driver, testResult.getName());
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.PASS, testResult.getMethod().getMethodName(), imagePath);

		}

		if (testResult.getStatus() == ITestResult.FAILURE) {
			String path = Screenshots.takeScreenshot(driver, testResult.getName());
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, testResult.getMethod().getMethodName(), imagePath);
		}

		report.endTest(test);
		report.flush();
		driver.quit();
	}

}
