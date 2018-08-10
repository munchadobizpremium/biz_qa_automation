package com.crm.qa.testcases;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CheckOut;
import com.crm.qa.pages.MicroBizHomePage;
import com.crm.qa.util.MicroBizTestUtilt;
import com.crm.qa.util.MicroBizTestUtil;

public class CheckOutPageTest extends TestBase {
	
	MicroBizTestUtil testUtil;
	CheckOut checkoutpage;

	MicroBizHomePage microbizHomePage;

	String sheetName = "TakeOut";

	public CheckOutPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		checkPageIsReady();
		microbizHomePage = new MicroBizHomePage(test);

	}
//	@Test(priority=1, dataProvider="getCRMTestData")
	
//	public void checkoutTakeoutPageTest() {
//		
//		microbizHomePage.clickMenu();
//		microbizHomePage.clickCheckoutTakeout();
//	}
//	@DataProvider
//	public Object[][] getCRMTestData(){
//		Object data[][] = MicroBizTestUtil.getTestData(sheetName);
//		return data;
//	}
	
	
	
//	public void validateCreateNewContact(String firstname, String lastname, String phone, String email, String specialinstructions, String nameoncard, String cardnumber, String expirymonth, String expiryyear, String ccvcode, String billingzip) throws InterruptedException{
//		Thread.sleep(5000);
//		checkoutpage.createNewCustomer(firstname,lastname,phone, email,specialinstructions, nameoncard, cardnumber, expirymonth, expiryyear, ccvcode, billingzip);
	@Test(priority=1)
	public void validateCreateNewContact() throws InterruptedException {	
//		microbizHomePage.clickCheckout();
		checkoutpage.createNewCustomer();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
	
	}
	

}
	
	



