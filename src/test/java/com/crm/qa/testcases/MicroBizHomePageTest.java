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
import com.crm.qa.pages.GalleryPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MicroBizHomePage;
import com.crm.qa.pages.OredrOnlinePage;
import com.crm.qa.util.MicroBizTestUtilt;
import com.crm.qa.util.MicroBizTestUtil;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class MicroBizHomePageTest extends TestBase {

	MicroBizTestUtil testUtil;
	MicroBizTestUtilt microBizTestUtil;
	CheckOut checkoutpage;

	MicroBizHomePage microbizHomePage;
	GalleryPage gallerypage;

	// String sheetName = "TakeOut";
	// String msheetName = "TestSuite";
	// String sheetName = "Catering";
	String sheetName = "Careers";

	public MicroBizHomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		report = ExtentFactory.getInstance();
		test = report.startTest("HOME PAGE Sanity Test");
		initialization();
		checkPageIsReady();
		microbizHomePage = new MicroBizHomePage(test);

	}

	//

	// @Test(priority = 1)
	// public void verifyMenuOrderOnlntTest() throws InterruptedException{
	// microbizHomePage.verifyMenuOrderOnln();
	//
	// }

	// @Test(priority = 1)
	// public void verifyTopOrderOnlnTest() {
	// microbizHomePage.verifyTopOrderOnln();
	// }
	@Test(priority = 1)
	public void verifyTopMenuLinksTest() throws InterruptedException {

		microbizHomePage.verifyTopMenuLinks();
	}

	@Test(priority = 2)
	public void verifyMenuTabListTest() throws InterruptedException {
		microbizHomePage.VerifyMenuTabList();

	}
	//
	// @Test(priority = 1)
	// public void verifyMenuOrderOnlnTest() throws InterruptedException {
	//
	// microbizHomePage.verifyMenuOrderOnln();
	// }

	// @DataProvider
	// public Object[][] getTestData() {
	// Object data[][] = MicroBizTestUtil.getTestData(sheetName);
	// return data;
	// }
	//
	// @Test(priority = 2, dataProvider = "getTestData")
	// public void verifyMenuTest(String firstname, String lastname, String phone,
	// String email,
	// String specialinstructions, String nameoncard, String cardnumber, String
	// expirymonth, String expiryyear,
	// String cvvcode, String billingzip) throws InterruptedException {
	// Assert.assertTrue(microbizHomePage.verifyMenu(), "Menu Option is missing on
	// the page");
	//
	// microbizHomePage.clickCheckout(firstname, lastname, phone, email,
	// specialinstructions, nameoncard, cardnumber,
	// expirymonth, expiryyear, cvvcode, billingzip);
	//
	// }
	////
	// @Test(priority = 3)
	// public void verifyGalleryMenuTest() throws InterruptedException {
	// Assert.assertTrue(microbizHomePage.verifyMenu(), "Gallery Menu is missing on
	// the page");
	// microbizHomePage.verifyMenu();
	// }
	//
	//
	//
	// @Test(priority = 4)
	// public void verifyCareersMenuTest()
	// throws InterruptedException {
	//// Assert.assertTrue(microbizHomePage.verifyCareersMenu(), "About Menu is
	// missing on the page");
	// microbizHomePage.verifyCareersMenu();
	// checkPageIsReady();
	//
	// }
	//
	// @Test(priority = 5)
	// public void verifyContactMenuTest() throws InterruptedException {
	// Assert.assertTrue(microbizHomePage.verifyContactText(), "About Contact Menu
	// is missing on the page");
	// microbizHomePage.verifyContactText();
	// }
	////
	// @Test(priority = 6)
	// public void orderOnlineMenuTest() {
	//// Assert.assertTrue(microbizHomePage.verifyContactMenu(), "About Contact Menu
	// is missing on the page");
	// microbizHomePage.verifyOrderOnlineStatic();
	// }

	// @Test(priority = 7)
	// public void reserveTableTest() throws InterruptedException {
	//
	// microbizHomePage.ReserveTbl();
	//
	// }
	//
	// @Test(priority = 8)
	// public void phoneTextTest() throws InterruptedException {
	//
	// microbizHomePage.verifyPhoneText();
	// }
	//
	// @Test(priority = 9)
	// public void phoneNumberTextTest() throws InterruptedException {
	//
	// microbizHomePage.verifyPhoneNumber();
	//
	// }
	//
	// @Test(priority = 10)
	// public void addressTextTest() throws InterruptedException {
	//
	// microbizHomePage.verifyAddressText();
	// }
	//
	// @Test(priority = 11)
	// public void deliveryAreaStaticTextTest() throws InterruptedException {
	//
	// microbizHomePage.verifyDeliveryAreaStaticText();
	//
	// }
	//
	// @Test(priority = 12)
	// public void hoursTextTest() throws InterruptedException {
	//
	// microbizHomePage.verifyHours();
	//
	// }
	//
	// @DataProvider
	// public Object[][] getMbizTestData() {
	// Object data[][] = MicroBizTestUtil.getTestData(sheetName);
	// return data;
	// }
	//
	// @Test(priority = 13, dataProvider = "getMbizTestData")
	// public void verifyAddPaymentCartTest(String firstname, String lastname,
	// String phone, String email,
	// String specialinstructions, String nameoncard, String cardnumber, String
	// expirymonth, String expiryyear,
	// String cvvcode, String billingzip) throws InterruptedException {
	//
	// microbizHomePage.verifyAddPaymentCart(firstname, lastname, phone, email,
	// specialinstructions, nameoncard,
	// cardnumber, expirymonth, expiryyear, cvvcode, billingzip);
	//
	// }
	////
	// @Test(priority = 14)
	// public void operatingHoursTextTest() throws InterruptedException {
	//
	// microbizHomePage.verifyOpHours();
	//
	// }
	//
	// @Test(priority = 15)
	// public void verifyHomePageStaticLinksTest() throws InterruptedException {
	//
	// microbizHomePage.verifyHomePageStaticLinks();
	// }
	//
	// @DataProvider
	// public Object[][] getTestDatas() {
	// Object data[][] = MicroBizTestUtil.getTestData(sheetName);
	// return data;
	// }
	////
	// @Test(priority=16, dataProvider="getTestDatas")
	// public void cateringBookingsTest(String firstname, String phonenumber, String
	// email, String partydate,
	// String partytime, String partytype, String numberofpeople) throws
	// InterruptedException {
	//
	// microbizHomePage.cateringBookings(firstname, phonenumber, email, partydate,
	// partytime, partytype,
	// numberofpeople);
	// }
	////
	//
	// @Test(priority = 1)
	// public void verifyMenuTabClickTests() throws InterruptedException {

	// microbizHomePage.verifyTopMenuLinks();
	// microbizHomePage.verifyMenuOrderOnln();
	// microbizHomePage.VerifyMenuTabList();
	//
	// }
	// //
	// @DataProvider
	// public Object[][] getCRMTestData() {
	// Object data[][] = MicroBizTestUtil.getTestData(sheetName);
	// return data;
	// }
	//
	// @Test(priority = 17, dataProvider = "getCRMTestData")
	// public void verifyMenuItemChkWithBrclClickTest(String firstname, String
	// lastname, String phone, String email,
	// String specialinstructions, String nameoncard, String cardnumber, String
	// expirymonth, String expiryyear,
	// String cvvcode, String billingzip) throws InterruptedException {
	//
	// microbizHomePage.verifyMenuItemChkWithBrclClick(firstname, lastname, phone,
	// email, specialinstructions,
	// nameoncard, cardnumber, expirymonth, expiryyear, cvvcode, billingzip);
	// }
	//
	// @Test(priority = 18, dataProvider = "getCRMTestData")
	// public void verifyMenuItemSesmChknClickTest(String firstname, String
	// lastname, String phone, String email,
	// String specialinstructions, String nameoncard, String cardnumber, String
	// expirymonth, String expiryyear,
	// String cvvcode, String billingzip) throws InterruptedException {
	//
	// microbizHomePage.verifyMenuItemSesmChknClick(firstname, lastname, phone,
	// email, specialinstructions, nameoncard,
	// cardnumber, expirymonth, expiryyear, cvvcode, billingzip);
	// }
	// @Test(priority =19)
	// public void verifyMenuTabClickTest() throws InterruptedException {
	//
	// microbizHomePage.verifyContactText();
	// }
	//

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
