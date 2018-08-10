package com.crm.qa.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.crm.qa.base.TestBase;
import com.crm.qa.testcases.Screenshots;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GalleryPage extends TestBase {

	@FindBy(xpath = "//a[@data-target='about']")
	WebElement aboutMenu;

	@FindBy(xpath = "//div[contains(text(),'next')]")
	WebElement nextLinkGallery;

	@FindBy(xpath = "//input[@id='c_name']")
	WebElement careersName;

	@FindBy(xpath = "//input[@id='c_email']")
	WebElement careersEmail;

	@FindBy(xpath = "//input[@id='c_website']")
	WebElement careersWebsite;

	@FindBy(xpath = "//textarea[@name='message']")
	WebElement careersMessage;

	@FindBy(xpath = "//a[contains(text(),'submit')]")
	WebElement careersSubmitBtn;

	@FindBy(xpath = "//div[contains(text(),'prev')]")
	WebElement prevLinkGallery;

	@FindBy(xpath = "//a[contains(text(),'Contact')]")
	WebElement contactLink;

	 @FindBy(xpath = "//a[contains(text(),'careers')]")
	 WebElement careersLink;
//	//a[contains(text(),'careers')]
//	@FindBy(xpath = "//a[@data-target='career']")
//	WebElement careersLink;

	@FindBy(xpath = "//div/descendant::div[position()=12]")
	WebElement aboutText;

	@FindBy(xpath = "//div[@id='contact']/div/div[2]/descendant::strong[position()=1]")
	WebElement rightAddressTxt;

	@FindBy(xpath = "//strong[contains(text(),'763 S. Rand Rd., Lake Zurich, IL 60047')]")
	WebElement addrText;

	@FindBy(xpath = "//strong[@class='ng-binding']")
	WebElement actAddress;

	// @FindBy(xpath = "//a[contains(text(),'reserve a table')]")

	@FindBy(xpath = "//a[@data-popup='reserve_a_table']")
	WebElement cReserveTable;

	@FindBy(xpath = "//a[@class='ubtn btn_contactreserve y-reserveTable']")
	WebElement cResTable;

	@FindBy(xpath = "//*[@id='contact']/descendant::strong[position()=3]")
	WebElement cPhone;

	@FindBy(xpath = "//a[@class='contact_resphoneno ng-binding']")
	WebElement aphoneNumber;

	@FindBy(xpath = "//a[contains(text(),'718-275-8000')]")
	WebElement cPhoneNum;

	@FindBy(xpath = "//strong[contains(text(),'Hours')]")
	WebElement cHours;

	@FindBy(xpath = "//div[contains(text(),'Monday')]")
	WebElement cMonday;

	@FindBy(xpath = "//div[contains(text(),'Tuesday')]")
	WebElement cTuesday;

	@FindBy(xpath = "//div[contains(text(),'Wednesday')]")
	WebElement cWednesday;

	@FindBy(xpath = "//div[contains(text(),'Thursday')]")
	WebElement cThursday;

	@FindBy(xpath = "//div[contains(text(),'Friday')]")
	WebElement cFriday;

	@FindBy(xpath = "//div[contains(text(),'Saturday')]")
	WebElement cSaturday;

	@FindBy(xpath = "//div[contains(text(),'Sunday')]")
	WebElement cSunday;

	@FindBy(xpath = "//div[@id='contact']/div/div[2]/div/div/div[1]/descendant::div[position()=2]")
	WebElement cMonHrs;

	@FindBy(xpath = "//div[@id='contact']/div/div[2]/div/div/div[2]/descendant::div[position()=2]")
	WebElement cTuesHrs;

	@FindBy(xpath = "//div[@id='contact']/div/div[2]/div/div/div[3]/descendant::div[position()=2]")
	WebElement cWedHrs;

	@FindBy(xpath = "//div[@id='contact']/div/div[2]/div/div/div[4]/descendant::div[position()=2]")
	WebElement cThursHrs;

	@FindBy(xpath = "//div[@id='contact']/div/div[2]/div/div/div[5]/descendant::div[position()=2]")
	WebElement cFriHrs;

	@FindBy(xpath = "//div[@id='contact']/div/div[2]/div/div/div[6]/descendant::div[position()=2]")
	WebElement cSatHrs;

	@FindBy(xpath = "//div[@id='contact']/div/div[2]/div/div/div[7]/descendant::div[position()=2]")
	WebElement cSunHrs;

	// @FindBy(xpath
	// ="//*[@id='contact']/div/div[2]/div/div/descendant::div[position()=3]")
	// WebElement cMonHrs;

	@FindBy(xpath = "//a[@data-target='gallery']")
	WebElement galleryMenu;

	@FindBy(xpath = "//p[contains(text(),'Sorry, We don't talk to strangers')]")
	WebElement cNameErrMsg;
	ExtentTest test;

	public GalleryPage(ExtentTest test) {

		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
//	public void checkPageIsReady() {
//		  
//		  JavascriptExecutor js = (JavascriptExecutor)driver;
//		  
//		  
//		  //Initially bellow given if condition will check ready state of page.
//		  if (js.executeScript("return document.readyState").toString().equals("complete")){ 
//		   System.out.println("Page Is loaded.");
//		   return; 
//		  } 
//		  
//		  //This loop will rotate for 25 times to check If page Is ready after every 1 second.
//		  //You can replace your value with 25 If you wants to Increase or decrease wait time.
//		  for (int i=0; i<25; i++){ 
//		   try {
//		    Thread.sleep(1000);
//		    }catch (InterruptedException e) {} 
//		   //To check page ready state.
//		   if (js.executeScript("return document.readyState").toString().equals("complete")){ 
//		    break; 
//		   }   
//		  }
		 
		

	public boolean verifyAbout() throws InterruptedException {

		aboutMenu.click();
		Thread.sleep(5000);

		String aboutMessage = aboutText.getText();

		test.log(LogStatus.INFO, "*** about ****** TEXT****** is Verified:  " + aboutMessage);

		System.out.println(" *** about ****** TEXT****** is Verified:   " + aboutMessage);

		return aboutMenu.isDisplayed();
	}

	public boolean verifyGalleryNextLink() throws InterruptedException {

		checkPageIsReady();
		Thread.sleep(5000);
		nextLinkGallery.click();
		Thread.sleep(6000);

		test.log(LogStatus.INFO, " The Functionality of Gallery Next Link:-->>>>> is Validated:   ");

		return galleryMenu.isDisplayed();
	}

	public boolean verifyGalleryPreviousLink() throws InterruptedException {

		checkPageIsReady();
		Thread.sleep(5000);
		prevLinkGallery.click();
		Thread.sleep(6000);

		test.log(LogStatus.INFO, " Pass:The Functionality of Gallery Previous Link:<<<<<------- is Validated:   ");

		return galleryMenu.isDisplayed();
	}

	public void careersClick(String name, String email, String website, String message) throws InterruptedException {

		Thread.sleep(5000);

		careersLink.click();
		careersName.sendKeys(name);
		careersEmail.sendKeys(email);
		careersWebsite.sendKeys(website);
		careersMessage.sendKeys(message);
		careersSubmitBtn.click();

		test.log(LogStatus.INFO, "Validations relating to Carrers Tab Functionality is validated:   ");

	}

	public void verifyCareersLink(String name, String email, String website, String message)
			throws InterruptedException {

		Thread.sleep(5000);
		careersLink.click();
		System.out.println("Careers Link Clicked ---------------");
		careersName.sendKeys(name);
		careersEmail.sendKeys(email);
		careersWebsite.sendKeys(website);
		careersMessage.sendKeys(message);
		Thread.sleep(5000);
		careersSubmitBtn.click();
		test.log(LogStatus.INFO, "Validations relating to Carrers Tab Functionality is validated:   ");

	}

	public boolean verifyContactsLink() throws InterruptedException {

		

		contactLink.click();

		test.log(LogStatus.INFO, "Validations relating to the Contact Link is Done:   ");

		return contactLink.isDisplayed();
	}

	public boolean verifyAddressText() throws InterruptedException {

		Thread.sleep(5000);

		contactLink.click();
		Thread.sleep(6000);

		String expectedAddress = "100-30 QUEENS BLVD (BETWEEN 67TH RD & 67TH AVE.), NEW YORK, NY 11375";

		// String addressText = addrText.getText();
		String srightAddress = rightAddressTxt.getText();

		if (srightAddress.equals(expectedAddress)){
			System.out.println("The Contact Address is Verified--------" + srightAddress);
			test.log(LogStatus.INFO,
					"Pass: Expected Contact Address Matches Actual Contact Address Text:Validations relating to Address is completed and Successful:   "
							+ srightAddress);
		} else {
			test.log(LogStatus.INFO,
					"Fail: Expected Contact Address Match does not Actual Contact Address Text:Validations relating to Address is completed and Successful:   "
							+ srightAddress);
		}
		Actions act = new Actions(driver);
		act.moveToElement(aphoneNumber).build().perform();

		return rightAddressTxt.isDisplayed();
	}

	public boolean verifyReserveTbl() throws InterruptedException {
		contactLink.click();
		Thread.sleep(5000);

		Assert.assertTrue(cReserveTable.isDisplayed(), "Reserve Table is Displayed  ");
		Assert.assertTrue(cReserveTable.isEnabled(), "Reserve Table is Enabled  ");

		if (cReserveTable.isDisplayed() && cReserveTable.isEnabled()) {
			test.log(LogStatus.INFO,
					"Pass: Validations relating to Reserve Table Button Functionality are completed and Successful:   ");
		} else {
			test.log(LogStatus.INFO,
					"Fail: Validations relating to Reserve Table Button Functionality are completed and Successful:   ");
		}

		Actions act = new Actions(driver);
		act.moveToElement(aphoneNumber).build().perform();

		return cReserveTable.isDisplayed();
	}

	public boolean verifyPhoneText() throws InterruptedException {

		contactLink.click();
		Thread.sleep(5000);
		String exptPhoneText = "PHONE";

		String aphoneText = cPhone.getText();

		if (exptPhoneText.equals(aphoneText)) {
			System.out.println("The Phone Number is Verified-----" + aphoneText);
			test.log(LogStatus.INFO,
					"Passed: Expected  Phone Text match the Actual Phone Text: Functionality is validated and completed Succcessful:   "
							+ aphoneText);
		} else {
			test.log(LogStatus.INFO,
					"Fail: Expected  Phone Text does not match the Actual Phone Text: Functionality is validated and completed Succcessful:   "
							+ aphoneText);
		}

		return cPhone.isDisplayed();
	}

	public boolean verifyPhoneNumber() throws InterruptedException {

		contactLink.click();
		Thread.sleep(5000);
		String ExpNumber = "718-275-8000";

		String aphNumber = aphoneNumber.getText();
		if (ExpNumber.equals(aphNumber)) {
			test.log(LogStatus.INFO,
					"Passed: Expected  Phone Number 718-275-8000 Functionality is validated and completed Successful:   "
							+ aphNumber);
		} else {
			test.log(LogStatus.INFO,
					"Failed: Expected Phone Number 718-275-8000 does not match with the Actual Number:    "
							+ aphNumber);
		}

		Actions act = new Actions(driver);
		act.moveToElement(aphoneNumber).build().perform();

		return cPhoneNum.isDisplayed();

	}

	public boolean verifyHours() throws InterruptedException {

		contactLink.click();
		Thread.sleep(6000);
		String exptHoursText = "HOURS";

		Actions act = new Actions(driver);
		act.moveToElement(cSunday).build().perform();

		String ahrsText = cHours.getText();

		if (exptHoursText.equals(ahrsText)) {
			System.out.println("The Hours Text is Verified ------" + ahrsText);
			test.log(LogStatus.INFO,
					"Pass:Expected Hours Text match the Actual Hours Name Text: Functionality are validated and completed Successful   "
							+ ahrsText);
		} else {
			test.log(LogStatus.INFO,
					"Fail: Expected Hours Text does not match the Actual Hours Name Text: Functionality are validated and completed Successful   "
							+ ahrsText);
		}

		return cHours.isDisplayed();

	}

	public void verifyOpHours() throws InterruptedException {

		contactLink.click();
		Thread.sleep(9000);

		String expMon = "Monday";
		String expTues = "Tuesday";
		String expWed = "Wednesday";
		String expThurs = "Thursday";
		String expFri = "Friday";
		String expSat = "Saturday";
		String expSun = "Sunday";

		String actMon = cMonday.getText();
		String actTues = cTuesday.getText();
		String actWed = cWednesday.getText();
		String actThurs = cThursday.getText();
		String actFri = cFriday.getText();
		String actSat = cSaturday.getText();
		String actSun = cSunday.getText();

		Actions act = new Actions(driver);
		act.moveToElement(cSunday).build().perform();

		if (expMon.equals(actMon)) {
			System.out.println("Pass: Expected Monday Text equals to Actual Monday Text   ");
			test.log(LogStatus.INFO, " Passed: Expected Monday Text equals to Actual Monday Text:  " + actMon);
		} else {
			System.out.println("Fail:  Expected Monday Text does not Match  Actual Monday Text  ");
			test.log(LogStatus.INFO, "Failed:  Expected Monday Text does not Match  Actual Monday Text: " + actMon);
		}

		if (expTues.equals(actTues)) {
			System.out.println("Passed: Expected Tuesday Text equals to Actual Tuesday Text   ");
			test.log(LogStatus.INFO, "Passed: Expected Tuesday Text equals to Actual Tuesday Text  " + actTues);
		} else {
			System.out.println("Failed:  Expected Tuesday Text does not Match  Actual Monday Text  ");
			test.log(LogStatus.INFO, "Failed:  Expected Tuesday Text does not Match  Actual Monday Text  " + actTues);
		}

		if (expWed.equals(actWed)) {
			System.out.println("Pass: Expected Wednesday Text equals to Actual Wednesday Text   ");
			test.log(LogStatus.INFO, "Passed: Expected Wednesday Text equals to Actual Wednesday Text   " + actWed);
		} else {
			System.out.println("Fail:  Expected Wednesday Text does not Match  Actual Monday Text  ");
			test.log(LogStatus.INFO, "Failed:  Expected Wednesday Text does not Match  Actual Monday Text  " + actWed);
		}

		if (expThurs.equals(actThurs)) {
			System.out.println("Pass: Expected Thursday Text equals to Actual Thursday Text   ");
			test.log(LogStatus.INFO, "Passed: Expected Thursday Text equals to Actual Thursday Text   " + actThurs);
		} else {
			System.out.println("Fail:  Expected Thursday Text does not Match  Actual Thursday Text  ");
			test.log(LogStatus.INFO,
					"Failed: Expected Thursday Text does not Match  Actual Thursday Text  " + actThurs);
		}

		if (expFri.equals(actFri)) {
			System.out.println("Pass:Expected Friday Text equals to Actual Friday Text   ");
			test.log(LogStatus.INFO, "Passed:Expected Friday Text equals to Actual Friday Text   " + actFri);
		} else {
			System.out.println("Fail:  Expected Friday Text does not Match  Actual Friday Text  ");
			test.log(LogStatus.INFO, "Failed:  Expected Friday Text does not Match  Actual Friday Text  " + actFri);
		}

		if (expSat.equals(actSat)) {
			System.out.println("Pass: Expected Saturday Text equals to Actual Saturday Text   ");
			test.log(LogStatus.INFO, "Passed:Expected Saturday Text equals to Actual Saturday Text   " + actSat);
		} else {
			System.out.println("Fail:  Expected Saturday Text does not Match  Actual Saturday Text  ");
			test.log(LogStatus.INFO, "Failed:Expected Saturday Text does not Match  Actual Saturday Text  " + actSat);
		}

		if (expSun.equals(actSun)) {
			System.out.println("Pass: Expected Sunday Text equals to Actual Sunday Text   ");
			test.log(LogStatus.INFO, "Passed: Expected Sunday Text equals to Actual Sunday Text   " + actSun);
		} else {
			System.out.println("Fail:  Expected Sunday Text does not Match  Actual Sunday Text  ");
			test.log(LogStatus.INFO, "Failed:  Expected Sunday Text does not Match  Actual Sunday Text  " + actSun);
		}
		Assert.assertEquals(actMon, expMon);
		Assert.assertEquals(actTues, expTues);
		Assert.assertEquals(actWed, expWed);
		Assert.assertEquals(actThurs, expThurs);
		Assert.assertEquals(actFri, expFri);
		Assert.assertEquals(actSat, expSat);
		Assert.assertEquals(actSun, expSun);

		String expMonHrs = "11:30 AM to 10:30 PM";
		String expTuesHrs = "11:30 AM to 10:30 PM";
		String expWedHrs = "11:30 AM to 10:30 PM";
		String expThursHrs = "2:00 AM to 10:30 PM";
		String expFriHrs = "11:30 AM to 11:00 PM";
		String expSatHrs = "11:30 AM to 11:00 PM";
		String expSunHrs = "11:30 AM to 10:30 PM";

		String actMonHrs = cMonHrs.getText();

		if (expMonHrs.equals(actMonHrs)) {
			System.out.println("Pass: Expected Monday Hours Text equals to Actual Hours Text   ");
			test.log(LogStatus.INFO, "Pass: Expected Monday Hours Text equals to Actual Hours Text   " + actMonHrs);
		} else {
			test.log(LogStatus.INFO,
					"Fail:  Expected Monday Hours Text does not Match  Actual Monday Hours  " + actMonHrs);
		}

		String actTuesHrs = cTuesHrs.getText();
		

		if (expTuesHrs.equals(actTuesHrs)) {
			System.out.println("Pass: Expected Monday Hours Text equals to Actual Hours Text   ");
			test.log(LogStatus.INFO, "Pass: Expected Monday Hours Text equals to Actual Hours Text   " + actTuesHrs);
		} else {
			test.log(LogStatus.INFO,
					"Fail:  Expected Monday Hours Text does not Match  Actual Monday Hours  " + actTuesHrs);
		}

		String actWedHrs = cWedHrs.getText();
		

		if (expWedHrs.equals(actWedHrs)) {
			System.out.println("Pass: Expected Monday Hours Text equals to Actual Hours Text   ");
			test.log(LogStatus.INFO, "Pass: Expected Monday Hours Text equals to Actual Hours Text   " + actWedHrs);
		} else {
			test.log(LogStatus.INFO,
					"Fail:  Expected Monday Hours Text does not Match  Actual Monday Hours  " + actWedHrs);
		}

		String actThursHrs = cThursHrs.getText();
		

		if (expThursHrs.equals(actThursHrs)) {
			System.out.println("Pass: Expected Monday Hours Text equals to Actual Hours Text   ");
			test.log(LogStatus.INFO, "Pass: Expected Monday Hours Text equals to Actual Hours Text   " + actThursHrs);
		} else {
			test.log(LogStatus.INFO,
					"Fail:  Expected Monday Hours Text does not Match  Actual Monday Hours  " + actThursHrs);
		}

		String actFriHrs = cFriHrs.getText();
		

		if (expFriHrs.equals(actFriHrs)) {
			System.out.println("Pass: Expected Monday Hours Text equals to Actual Hours Text   ");
			test.log(LogStatus.INFO, "Pass: Expected Monday Hours Text equals to Actual Hours Text   " + actFriHrs);
		} else {
			test.log(LogStatus.INFO,
					"Fail:  Expected Monday Hours Text does not Match  Actual Monday Hours  " + actFriHrs);
		}

		String actSatHrs = cSatHrs.getText();
		

		if (expSatHrs.equals(actSatHrs)) {
			System.out.println("Pass: Expected Monday Hours Text equals to Actual Hours Text   ");
			test.log(LogStatus.INFO, "Pass: Expected Monday Hours Text equals to Actual Hours Text   " + actSatHrs);
		} else {
			test.log(LogStatus.INFO,
					"Fail:  Expected Monday Hours Text does not Match  Actual Monday Hours  " + actSatHrs);
		}

		String actSunHrs = cSunHrs.getText();
		

		if (expSunHrs.equals(actSunHrs)) {
			System.out.println("Pass: Expected Sunday Hours Text equals to Actual Hours Text   ");
			test.log(LogStatus.INFO, "Pass: Expected Sunday Hours Text equals to Actual Hours Text   " + actSunHrs);
		} else {
			test.log(LogStatus.INFO,
					"Fail:  Expected Sunday Hours Text does not Match  Actual Sunday Hours  " + actSunHrs);
		}

	}

//	@AfterMethod
//	public void tearDown(ITestResult testResult) throws IOException {
//
//		if (testResult.getStatus() == ITestResult.SUCCESS) {
//			String path = Screenshots.takeScreenshot(driver, testResult.getName());
//			String imagePath = test.addScreenCapture(path);
//			test.log(LogStatus.PASS, testResult.getMethod().getMethodName(), imagePath);
//
//		}
//
//		if (testResult.getStatus() == ITestResult.FAILURE) {
//			String path = Screenshots.takeScreenshot(driver, testResult.getName());
//			String imagePath = test.addScreenCapture(path);
//			test.log(LogStatus.FAIL, testResult.getMethod().getMethodName(), imagePath);
//		}
//
//		report.endTest(test);
//		report.flush();
//		driver.quit();
//	}

}
