package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.GalleryPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.MicroBizTestUtilt;
import com.crm.qa.util.MicroBizTestUtil;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GalleryPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	MicroBizTestUtil testUtil;
	MicroBizTestUtilt microBizTestUtil;
	ContactsPage contactsPage;
	GalleryPage gallerypage;
	 String sheetName = "careerdata";

	public GalleryPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		report = ExtentFactory.getInstance();
		test = report.startTest("GALLERY ONLINE PAGE Sanity Test");
//		checkPageIsReady();
		initialization();
//		checkPageIsReady();
		testUtil = new MicroBizTestUtil();
		microBizTestUtil = new MicroBizTestUtilt();
		gallerypage = new GalleryPage(test);

	}

	 @Test(priority = 1)
	 public void verifyAboutMessageTest() throws InterruptedException {
	
	 gallerypage.verifyAbout();
	 }
	

	@Test(priority = 2)
	public void verifyAboutTest() throws InterruptedException {
		gallerypage.verifyAbout();
	}

	@Test(priority = 3)
	public void verifyGalleryNextLinkTest() throws InterruptedException {
		checkPageIsReady();
		gallerypage.verifyGalleryNextLink();
	}

	@Test(priority = 4)
	public void verifyGalleryPreviousLinkTest() throws InterruptedException {
		checkPageIsReady();
		gallerypage.verifyGalleryPreviousLink();
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		
		Object data[][] = microBizTestUtil.getTestData(sheetName);
		return data;
	}

	 @Test(priority = 1, dataProvider = "getCRMTestData")
	 public void careerClickLinkTest(String name, String email, String website,
	 String message)
	 throws InterruptedException {

	 gallerypage.verifyCareersLink(name, email, website, message);
	
	 }
//
//	@Test(priority = 3)
//	public void verifyHoursTest() throws InterruptedException {
//
//		gallerypage.verifyHours();
//	}
//
//	@Test(priority = 4)
//	public void verifyOpHoursTest() throws InterruptedException {
//		gallerypage.verifyOpHours();
//	}

	// @DataProvider
	// public Object[][] getCRMTestData(){
	// Object data[][] = microBizTestUtil.getTestData(sheetName);
	// return data;
	// }
	//
	// @Test(priority=3, dataProvider="getCRMTestData")
	// public void verifyCareersLinkTest(String name,String email,String
	// website,String message) throws InterruptedException {
	// gallerypage.verifyCareersLink(name,email,website,message);
	//
	// }

//	@Test(priority = 5)
//	public void verifyContactsLinkTest() throws InterruptedException {
//		gallerypage.verifyContactsLink();
//	}
//
//	@Test(priority = 6)
//	public void verifyAddressPresentTest() throws InterruptedException {
//		gallerypage.verifyAddressText();
//
//	}
//
//	@Test(priority = 8)
//	public void verifyPhoneTextTest() throws InterruptedException {
//
//		gallerypage.verifyPhoneText();
//	}
//
//	@Test(priority = 9)
//	public void verifyPhoneNumberTest() throws InterruptedException {
//
//		gallerypage.verifyPhoneNumber();
//	}
//
//	@Test(priority = 10)
//	public void verifyReserveTblTest() throws InterruptedException {
//		gallerypage.verifyReserveTbl();
//	}

	@AfterMethod
	public void tearDown(ITestResult testResult) throws IOException {

		if (testResult.getStatus() == ITestResult.SUCCESS) {
			String path = Screenshots.takeScreenshot(driver, testResult.getName());
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.PASS, testResult.getName(), imagePath);

		}

		if (testResult.getStatus() == ITestResult.FAILURE) {
			String path = Screenshots.takeScreenshot(driver, testResult.getName());
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, testResult.getName(), imagePath);
		}

		report.endTest(test);
		report.flush();
		driver.quit();
	}
}
