package com.crm.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CheckOut;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.EditOrderPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MicroBizHomePage;
import com.crm.qa.util.MicroBizTestUtilt;
import com.relevantcodes.extentreports.LogStatus;
import com.crm.qa.util.MicroBizTestUtil;

public class EditOrderPageTest extends TestBase {

	MicroBizTestUtil testUtil;
	CheckOut checkoutpage;
	
	@FindBy(xpath = "//a[@data-target='about']")
    WebElement aboutMenu;


	EditOrderPage editorderpage;

	String sheetName = "TakeOut";

	public EditOrderPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		report = ExtentFactory.getInstance();
		test = report.startTest("Edit Online Page Sanity Test");
		initialization();
		checkPageIsReady();
		editorderpage = new EditOrderPage(test);
		

	}

//	@Test(priority = 1)
//	public void editTakeoutTest() throws InterruptedException {
//
//		editorderpage.etclickCheckout();
//	}

	@Test(priority = 1)
	public void editDeliveryTest() throws InterruptedException {

		editorderpage.edclickCheckout();
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
