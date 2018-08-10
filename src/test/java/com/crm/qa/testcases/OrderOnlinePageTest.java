package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.OredrOnlinePage;
import com.crm.qa.util.MicroBizTestUtil;
import com.crm.qa.util.MicroBizTestUtilt;
//import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class OrderOnlinePageTest extends TestBase {
	MicroBizTestUtilt microBizTestUtil;
	OredrOnlinePage orderonlinepage;
	public ExtentReports report;
	public static ExtentTest test;
	String msheetName = "TestSuite";
	String sheetName = "TakeOut";

	public OrderOnlinePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		report = ExtentFactory.getInstance();
		test = report.startTest("ORDER ONLINE PAGE Sanity Test");

		initialization();
		Thread.sleep(4000);

		orderonlinepage = new OredrOnlinePage(test);

	}

	@DataProvider
	public Object[][] DeliveryData() {
		Object data[][] = MicroBizTestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 1, dataProvider = "DeliveryData")
	//
	public void verifyDeliveryAvailSlotsTest(String firstname, String lastname, String phone, String email,
			String specialinstructions, String nameoncard, String cardnumber, String expirymonth, String expiryyear,
			String cvvcode, String billingzip) throws Exception {

		orderonlinepage.verifyDeliveryAvailSlots(firstname, lastname, phone, email, specialinstructions, nameoncard,
				cardnumber, expirymonth, expiryyear, cvvcode, billingzip);

	}

	@DataProvider
//	public Object[][] TakeOutData() {
//		Object data[][] = MicroBizTestUtil.getTestData(sheetName);
//		return data;
//	}
//
//	@Test(priority = 2, dataProvider = "TakeOutData")
//
//	public void verifyTakeoutAvailSlotsTest(String firstname, String lastname, String phone, String email,
//			String specialinstructions, String nameoncard, String cardnumber, String expirymonth, String expiryyear,
//			String cvvcode, String billingzip) throws Exception {
//
//		orderonlinepage.verifyTakeoutAvailSlots(firstname, lastname, phone, email, specialinstructions, nameoncard,
//				cardnumber, expirymonth, expiryyear, cvvcode, billingzip);
//
//	}
//
//	@Test(priority = 3)
//	public void verifyAutoSuggestionTest() {
//
//		orderonlinepage.verifyAutoSuggestion();
//	}
//
//	@Test(priority = 4)
//
//	public void verifyZeroMilesAddrTest() throws InterruptedException {
//
//		orderonlinepage.verifyZeroMilesAddr();
//	}
//
//	@Test(priority = 5)
//
//	public void deliveryNoChangeTextTest() throws InterruptedException {
//
//		orderonlinepage.deliveryNoChangeText();
//	}
//
//	@Test(priority = 6)
//	public void verifyDeliveryTakeOutTest() throws InterruptedException {
//
//		orderonlinepage.verifyDeliveryTakeOut();
//
//	}
//
//	@Test(priority = 7)
//	public void verifyDeliveryPopupTest() throws InterruptedException {
//		orderonlinepage.verifyDeliveryPopup();
//	}
//
//	@Test(priority = 8)
//	public void verifyAddrDelNoTest() throws InterruptedException {
//
//		orderonlinepage.verifyRightDeliveryAddr();
//	}
//
//	@Test(priority = 9)
//	public void verifyAddrDelYesTest() throws InterruptedException {
//
//		orderonlinepage.verifyWrongDeliveryAddr();
//	}

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
