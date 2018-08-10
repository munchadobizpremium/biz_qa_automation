package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.crm.qa.base.TestBase;
import com.crm.qa.testcases.Screenshots;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EditOrderPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'View Menu')]")
	WebElement viewMenu;

	@FindBy(xpath = "//div[@id='home']/descendant::i[@class='i_downarrow fadeInUp aanimated']")
	WebElement homePageDwnArw;

	@FindBy(xpath = "//div[@class='popup_location _p30']/descendant::a[position()=1]")
	WebElement btnLocation1;

	@FindBy(xpath = "//div[@class='popup_location _p30']/descendant::a[position()=2]")
	WebElement btnLocation2;

	@FindBy(xpath = "//div[@class='popup_location _p30']/descendant::a[position()=3]")
	WebElement btnLocation3;

	@FindBy(xpath = "//div[@class='popup_location _p30']/descendant::a[position()=4]")
	WebElement btnLocation4;
	
	@FindBy(xpath = "//div[@class='popup_location _p30']/descendant::a[position()=5]")
	WebElement btnLocation5;
	
	@FindBy(xpath = "//div[@id='pageload']/div[1]/div/div[1]/descendant::a[position()=1]")
	WebElement orderOnlineTab;

	@FindBy(xpath = "//input[@id='searchTextField']")
	WebElement orderSearchTxtFld;

	@FindBy(xpath = "//a[contains(text(),'verify & proceed to order')]")
	WebElement orderVerifyProceed;

	@FindBy(xpath = "//a[@class='ubtn btn_addtocard add-multiplier']")
	WebElement addMultiplierBtn;

	@FindBy(xpath = "//a[@class='ubtn btn_addtocard decrease subtract-multiplier']")
	WebElement subMultiplierBtn;

	@FindBy(xpath = "html/body/div[3]/div/div/div/div/div[4]/div[1]/descendant::span[position()=1]")
	WebElement addMultiplierTxt;

	// @FindBy(xpath = "//span[@class='sub-total']")
	@FindBy(xpath = "//html/body/div[3]/div/div/div/div/div[4]/div[2]/descendant::span[position()=1]")
	WebElement orderPrice$;

	@FindBy(xpath = "//div[@id='menu_ordersection']/descendant::label[@for='t_takeout']")
	WebElement btnOrderTakeout;

	@FindBy(xpath = "//input[@data-label='White Rice']/following::span[@class='control_indicator']")
	WebElement radioWhiteBtn;

	@FindBy(xpath = "//input[@data-label='Brown Rice']/following::span[@class='control_indicator']")
	WebElement radioBrownBtn;

	@FindBy(xpath = "//a[@class='ubtn blackbtn btn_popupaddtoorder add-to-order']")
	WebElement orderAddToOrderBtn;

	@FindBy(xpath = "//div[@id='menu_ordersection']/div[5]/div/div[5]/descendant::span[position()=1]")
	WebElement orderTaxAmt;

	@FindBy(xpath = "//a[contains(text(),'checkout for takeout')]")
	WebElement chkoutTakeoutBtn;

	@FindBy(xpath = "//select[@class='t-tip-percent']")
	WebElement selectTipAmt;

	@FindBy(xpath = "//div[@id='menu_ordersection']/div[5]/div/descendant::span[last()-4]")
	WebElement subTotalTakeout;

	@FindBy(xpath = "//div[@id='menu_ordersection']/div[5]/div/descendant::span[last()-1]")
	WebElement orderTaxTakeout;

	@FindBy(xpath = "//div[@id='menu_ordersection']/div[5]/div/descendant::span[last()]")
	WebElement orderTotalTakeout;

	@FindBy(xpath = "//div[@id='contact']/div/div[2]/descendant::strong[position()=1]")
	WebElement rightAddressTxt;

	@FindBy(xpath = "//a[@class='ubtn btn_addtocard btn_addtoorder']")
	WebElement orderAddtoCart;

	@FindBy(xpath = "//label[@for='t_delivery']")
	WebElement deliveryButton;

	@FindBy(xpath = "//p[@class='title_bs_order']")
	WebElement textYourOrder;

	@FindBy(xpath = "//a[@data-target='about']")
	WebElement aboutMenu;

	@FindBy(xpath = "//a[@data-target='menu']")
	WebElement Menu;

	@FindBy(xpath = "//p[contains(text(),'$4.99')]")
	WebElement itemPrice;

	@FindBy(xpath = "//p[contains(text(),'$4.99')]")
	WebElement popupItemPrice;

	// @FindBy(xpath = "//span[contains(text(),'Baked French Onion Soup')]")
	@FindBy(xpath = "//span[contains(text(),'Baked French Onion Soup')]")

	WebElement Baked_French_Onion_Soup;

	@FindBy(xpath = "//span[contains(text(),'1')]")
	WebElement itemQtyOrdered;

	// @FindBy(xpath = "//a[contains(text(),'ADD TO ORDER')]")
	@FindBy(xpath = "//div[@class='a_modal-dialog']/descendant::div[position()=14]")
	// @FindBy(xpath ="//span[@class='ubtn blackbtn btn_popupaddtoorder
	// add-to-order']")
	WebElement addToOrder;

	@FindBy(xpath = "//a[contains(text(),'order takeout')]")
	WebElement orderTakeOut;

	@FindBy(xpath = "//a[contains(text(),'checkout for takeout')]")
	WebElement checkoutTakeOut;

	@FindBy(xpath = "//a[contains(text(),'checkout for delivery')]")
	WebElement chkoutDeliveryBtn;

	@FindBy(xpath = "//span[@class='order_total']")
	WebElement totalAmt;
	// Initializing the Page Objects:

	// public boolean verifyAboutMenu() {
	// return aboutMenu.isDisplayed();
	// }
	@FindBy(xpath = "//div[@class='checkoutsection']/descendant::input[position()=1]")
	WebElement firstName;
	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastName;

	@FindBy(xpath = "//input[@name='phone_no']")
	WebElement phone;

	@FindBy(xpath = "//input[@name='email']")
	WebElement email;

	@FindBy(xpath = "//textarea[@name='own_instruction']")
	WebElement splInstrctions;

	@FindBy(xpath = "//div[@class='checkoutDiv']/descendant::p[position()=1]")
	WebElement checkOutTitleText;

	@FindBy(xpath = "//input[@name='card_name']")
	WebElement nameOnCard;

	@FindBy(xpath = "//input[@name='card_number']")
	WebElement cardNumber;

	@FindBy(xpath = "//select[@class='card_expire_month']")
	WebElement expiryMonth;

	@FindBy(xpath = "//select[@class='card_expire_year']")
	WebElement expiryYear;

	@FindBy(xpath = "//input[@name='cvv_code']")
	WebElement cvvCode;

	@FindBy(xpath = "//input[@name='zip']")
	WebElement billZip;

	@FindBy(xpath = "//a[contains(text(),'place my order')]")
	WebElement placeMyOrderBtn;

	@FindBy(xpath = "//div[@class='checkoutsection']/descendant::p[position()=1]")
	WebElement orderThankYouText;

	@FindBy(xpath = "//a[@class='t-edit-order edit_17902088_1 ubtn']")
	WebElement editPencilIcon;

	@FindBy(xpath = "//input[@data-label='White Meat']/following::span[@class='control_indicator']")
	WebElement checkBoxWhiteMeat;
	
	@FindBy(xpath = "//a[contains(text(),'Contact')]")
	WebElement contactLink;


	public String rightAddress;

	@FindBy(xpath = "//a[contains(text(),'Edit Order')]")
	WebElement editOrderBtn;
	ExtentTest test;

	GalleryPage gallerypage;

	public EditOrderPage(ExtentTest test) throws InterruptedException {
		this.test = test;
		gallerypage = new GalleryPage(test);

		PageFactory.initElements(driver, this);

		// Thread.sleep(5000);
		// homePageDwnArw.click();

		// aboutMenu.click();
		// System.out.println("About Menu is Clicked ");
	}

	public void addOrderEditOrder() throws InterruptedException {

		Menu.click();
		Thread.sleep(5000);
		Baked_French_Onion_Soup.click();
		System.out.println("Clicked It");
		Thread.sleep(5000);
		// driver.switchTo().frame(0);
		addToOrder.click();
		System.out.println("Add Order Clicked");
	}

	public void etclickCheckout() throws InterruptedException {

		try {
			if (isElementPresent("//a[contains(text(),'View Menu')]") == true) {

				viewMenu.click();
				Thread.sleep(4000);

				test.log(LogStatus.INFO, "Passed: View Menu is Present ");
				System.out.println("Passed:Passed: View Menu is Present ");

				try {

					if (isElementPresent("//div[@class='popup_location _p30']") == true && isElementPresent(
							"//div[@class='popup_location _p30']/descendant::a[position()=2]") == true) {

						Thread.sleep(3000);
						btnLocation2.click();

						test.log(LogStatus.INFO, "Passed: WebElement Location Window Pop Up is Available ");
						System.out.println("Passed: WebElement Location Window Pop Up is Available ");

						Thread.sleep(4000);

					}

				} catch (Exception e) {

					test.log(LogStatus.INFO,
							"Failed: WebElement Location Window Pop Up is UnAvailable " + e.getMessage());
					System.out.println(" Failed:  WebElement Location Window Pop Up is UnAvailable ");
				}

			}

		} catch (Exception e) {

			System.out.println("WebElement View Menu is unavailable " + e.getMessage());
		}

		try {
			if (isElementPresent("//div[@id='pageload']/div[1]/div/div[1]/descendant::a[position()=1]") == true) {

				orderOnlineTab.click();
				Thread.sleep(4000);
				test.log(LogStatus.INFO, "Passed: Order OnLine is Available in this Restaurtant  ");
				System.out.println("Passed: Order OnLine is is Available in this Restaurtant ");

				try {

					if (isElementPresent("//div[@class='popup_location _p30']") == true && isElementPresent(
							"//div[@class='popup_location _p30']/descendant::a[position()=2]") == true) {

						Thread.sleep(3000);
						btnLocation2.click();

						test.log(LogStatus.INFO, "Passed: WebElement Location Window Pop Up is Available ");
						System.out.println("Passed: WebElement Location Window Pop Up is Available ");

						Thread.sleep(4000);

					}

				} catch (Exception e) {

					test.log(LogStatus.INFO,
							"Failed: Order OnLine is UnAvailable in this Restaurtant  " + e.getMessage());
					System.out.println("Failed: WebElement OrderOnline Tab is UnAvailable " + e.getMessage());

				}
			}
		} catch (Throwable e) {

			test.log(LogStatus.INFO, "Failed: Order OnLine is UnAvailable in this Restaurtant  " + e.getMessage());
			System.out.println("Failed: WebElement OrderOnline Tab is UnAvailable " + e.getMessage());

		}

		try {
			if (isElementPresent("//div[@id='menu_ordersection']/descendant::label[@for='t_takeout']") == true
					&& btnOrderTakeout.isDisplayed()) {

				Thread.sleep(3000);
				btnOrderTakeout.click();

			}
		} catch (Exception e) {

			test.log(LogStatus.INFO,
					"Failed: WebElement  TakeOut Order Button is UnAvailable in this Restaurtant  " + e.getMessage());
			System.out.println("Failed: WebElement TakeOut Order Button is UnAvailable " + e.getMessage());

		}

		orderAddtoCart.click();

		try {
			if (isElementPresent(
					"//input[@data-label='White Rice']/following::span[@class='control_indicator']") == true
					|| isElementPresent(
							"//input[@data-label='Brown Rice']/following::span[@class='control_indicator']") == true) {

				radioWhiteBtn.click();
				Thread.sleep(2000);
			}
		} catch (Exception e) {

			System.out.println("WebElement Radio Button is unavailable " + e.getMessage());
		}

		try {
			if (isElementPresent("//div[@id='pageload']/following::div[@class='custom_checkbox']") == true) {

				checkBoxWhiteMeat.click();
				Thread.sleep(3000);

			}
		} catch (Exception e) {

			System.out.println("WebElement White Meat Check Box is unavailable " + e.getMessage());
		}

		addMultiplierBtn.click();

		String orderQtyTot = addMultiplierTxt.getText();

		int iorderQtyTot = Integer.parseInt(orderQtyTot);
		test.log(LogStatus.INFO, "The Total Quantity is Validated     " + iorderQtyTot);

		String Price = orderPrice$.getText();

		float $Price = Float.parseFloat(Price);
		test.log(LogStatus.INFO, "The Price is Validated     " + $Price);

		float fSubTotAmount = iorderQtyTot * $Price;
		test.log(LogStatus.INFO, "The Sub Total Amount is Validated    " + fSubTotAmount);
		System.out.println("The Sub TotalAmount is:     " + fSubTotAmount);

		Thread.sleep(3000);
		orderAddToOrderBtn.click();

		Thread.sleep(5000);

		Actions act = new Actions(driver);
		act.moveToElement(textYourOrder).build().perform();

		String Tax = orderTaxAmt.getText();
		float $Tax = Float.parseFloat(Tax);
		System.out.println("The Tax for the Total:   " + $Tax);
		test.log(LogStatus.INFO, "The Tax Amount is Validated      " + $Tax);

		// System.out.println(e.getMessage());
		// System.out.println(e.getStackTrace());
		// }

		act.moveToElement(chkoutTakeoutBtn).build().perform();
		Thread.sleep(3000);

		chkoutTakeoutBtn.click();
		Thread.sleep(3000);

		Thread.sleep(4000);

		editOrderBtn.click();

		orderAddtoCart.click();

		try {
			if (isElementPresent(
					"//input[@data-label='White Rice']/following::span[@class='control_indicator']") == true
					|| isElementPresent(
							"//input[@data-label='Brown Rice']/following::span[@class='control_indicator']") == true) {

				radioWhiteBtn.click();
				Thread.sleep(3000);
			}
		} catch (Exception e) {

			System.out.println("WebElement White Rice Radio Button is unavailable " + e.getMessage());
		}

		try {
			if (isElementPresent("//div[@id='pageload']/following::div[@class='custom_checkbox']") == true) {

				checkBoxWhiteMeat.click();
				Thread.sleep(3000);

			}
		} catch (Exception e) {

			System.out.println("WebElement White Meat Check Box is unavailable " + e.getMessage());
		}

		addMultiplierBtn.click();
		addMultiplierBtn.click();

		String eorderQtyTot = addMultiplierTxt.getText();

		int eiorderQtyTot = Integer.parseInt(eorderQtyTot);
		test.log(LogStatus.INFO, "The Total Quantity is Validated     " + eiorderQtyTot);

		String ePrice = orderPrice$.getText();

		float e$Price = Float.parseFloat(ePrice);
		test.log(LogStatus.INFO, "The Price is Validated     " + e$Price);

		float efSubTotAmount = eiorderQtyTot * e$Price;
		test.log(LogStatus.INFO, "The Sub Total Amount is Validated    " + efSubTotAmount);
		System.out.println("The Sub TotalAmount is:     " + efSubTotAmount);

		Thread.sleep(3000);
		orderAddToOrderBtn.click();

		Thread.sleep(5000);

		act.moveToElement(textYourOrder).build().perform();

		float e$Tax = Float.parseFloat(Tax);
		System.out.println("The Tax for the Total:   " + e$Tax);
		test.log(LogStatus.INFO, "The Tax Amount is Validated      " + e$Tax);

		// System.out.println(e.getMessage());
		// System.out.println(e.getStackTrace());
		// }

		act.moveToElement(chkoutTakeoutBtn).build().perform();
		Thread.sleep(3000);

		chkoutTakeoutBtn.click();
		Thread.sleep(3000);

		String sTotAmount = totalAmt.getText();
		System.out.println("The Total Amount displayed is:   " + sTotAmount);

		if (checkOutTitleText.isDisplayed()) {
			System.out.println("Pass:*****" + checkOutTitleText.getText());
			test.log(LogStatus.INFO, "Pass:The Checkout Page is Displayed: " + checkOutTitleText.getText());

		} else {
			test.log(LogStatus.INFO, "Fail:The Checkout Page is Displayed: " + checkOutTitleText.isDisplayed());
			System.out.println("Pass:*****" + checkOutTitleText.isDisplayed());
		}

		System.out.println("The Total Amount of Order to Check Out Payment is: " + sTotAmount);
		test.log(LogStatus.INFO, "The Total Amount of Order to Check Out Payment is Validated: ");
	}

	public void edclickCheckout() throws InterruptedException {
		Thread.sleep(4000);

		    homePageDwnArw.click();
		    Thread.sleep(4000);

		    System.out.println("Mouse Scrolling to About Menu ");
			Thread.sleep(4000);

			contactLink.click();
			rightAddress = rightAddressTxt.getText();

			Thread.sleep(4000);
			aboutMenu.click();
		
		

		rightAddress = rightAddressTxt.getText();

		try {
			if (isElementPresent("//a[contains(text(),'View Menu')]") == true) {

				viewMenu.click();
				Thread.sleep(4000);

				test.log(LogStatus.INFO, "Passed: View Menu is Present ");
				System.out.println("Passed:Passed: View Menu is Present ");

				try {

					if (isElementPresent("//div[@class='popup_location _p30']") == true && isElementPresent(
							"//div[@class='popup_location _p30']/descendant::a[position()=2]") == true) {

						Thread.sleep(3000);
						btnLocation2.click();

						test.log(LogStatus.INFO, "Passed: WebElement Location Window Pop Up is Available ");
						System.out.println("Passed: WebElement Location Window Pop Up is Available ");

						Thread.sleep(4000);

					}

				} catch (Exception e) {

					test.log(LogStatus.INFO, "Failed: WebElement Location Window Pop Up is UnAvailable ");
					System.out.println(" Failed:  WebElement Location Window Pop Up is UnAvailable ");
				}

			}

		} catch (Exception e) {

			System.out.println("WebElement View Menu is unavailable " + e.getMessage());
		}

		try {
			if (isElementPresent("//div[@id='pageload']/div[1]/div/div[1]/descendant::a[position()=1") == true) {

				Thread.sleep(4000);
				aboutMenu.click();
				Thread.sleep(4000);

				orderOnlineTab.click();
				Thread.sleep(4000);
				test.log(LogStatus.INFO, "Passed: Order OnLine is Available in this Restaurtant  ");
				System.out.println("Passed: Order OnLine is is Available in this Restaurtant ");

			}
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: Order OnLine is UnAvailable in this Restaurtant  ");
			System.out.println("Fail: WebElement OrderOnline Tab is UnAvailable " + e.getMessage());

		}

		// act.moveToElement(deliveryButton).build().perform();
		// && isElementPresent("//label[@class='ubtn btn_service hide']") == false

		try {

			if (isElementPresent("//label[@for='t_delivery']/descendant::i[position()=1]") == true

					&& deliveryButton.isDisplayed()) {

				// Actions act = new Actions(driver);

				deliveryButton.click();
				Thread.sleep(4000);

				orderAddtoCart.click();
			}

		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: WebElement Delivery Button is UnAvailable in this Restaurtant  ");
			System.out.println("Fail: WebElement Delivery Button  is unavailable " + e.getMessage());
		}

		try {
			if (isElementPresent("//a[contains(text(),'verify & proceed to order')]") == true
					&& orderVerifyProceed.isDisplayed()) {

				Thread.sleep(2000);
				System.out.println("Pass: Delivery Window Popped Up:   ");
				test.log(LogStatus.INFO, "Pass: Delivery Window Popped Up:   ");
				orderSearchTxtFld.sendKeys(rightAddress);
				orderVerifyProceed.click();
			}
		} catch (Exception e) {
			System.out.println("Fail: Delivery Window has not Popped Up ");
			test.log(LogStatus.INFO, "Fail: Delivery Window has not Popped Up ");

		}

		try {
			if (isElementPresent(
					"//input[@data-label='White Rice']/following::span[@class='control_indicator']") == true
					|| isElementPresent(
							"//input[@data-label='Brown Rice']/following::span[@class='control_indicator']") == true) {

				radioWhiteBtn.click();
				Thread.sleep(3000);
			}
		} catch (Exception e) {

			System.out.println("WebElement White Rice Radio Button is unavailable " + e.getMessage());
		}

		try {
			if (isElementPresent("//div[@id='pageload']/following::div[@class='custom_checkbox']") == true) {

				checkBoxWhiteMeat.click();

			}
		} catch (Exception e) {

			System.out.println("WebElement White Meat Check Box is unavailable " + e.getMessage());
		}

		addMultiplierBtn.click();

		String orderQtyTot = addMultiplierTxt.getText();

		int iorderQtyTot = Integer.parseInt(orderQtyTot);
		test.log(LogStatus.INFO, "The Total Quantity is Validated     " + iorderQtyTot);

		String Price = orderPrice$.getText();

		float $Price = Float.parseFloat(Price);
		test.log(LogStatus.INFO, "The Price is Validated     " + $Price);

		float fSubTotAmount = iorderQtyTot * $Price;
		test.log(LogStatus.INFO, "The Sub Total Amount is Validated    " + fSubTotAmount);
		System.out.println("The Sub TotalAmount is:     " + fSubTotAmount);

		Thread.sleep(3000);
		orderAddToOrderBtn.click();

		Thread.sleep(5000);

		Actions act = new Actions(driver);
		act.moveToElement(textYourOrder).build().perform();

		String Tax = orderTaxAmt.getText();
		float $Tax = Float.parseFloat(Tax);
		System.out.println("The Tax for the Total:   " + $Tax);
		test.log(LogStatus.INFO, "The Tax Amount is Validated      " + $Tax);

		act.moveToElement(chkoutDeliveryBtn).build().perform();
		Thread.sleep(5000);

		Select tsel = new Select(selectTipAmt);

		String text = "20";

		tsel.selectByValue(text);

		Thread.sleep(5000);
		test.log(LogStatus.INFO, "The Tip Amount is: " + text + " For this Order");
		System.out.println("The Selected Tip Amount is 15%:  " + text + " For this Order");

		float fText = Float.parseFloat(text);
		float ftotAmount$ = fSubTotAmount + (fSubTotAmount * (fText / 100)) + $Tax;

		System.out.println("The Tax for the Total:   " + $Tax);
		test.log(LogStatus.INFO, "The Tax Amount is Validated      " + $Tax);

		// double rtotAmount$=Math.nextDown(totAmount$);

		String sTotAmount = totalAmt.getText();
		System.out.println("The Total Amount displayed is:   " + sTotAmount);

		float TotalAmount$ = Float.parseFloat(sTotAmount);

		if (ftotAmount$ == TotalAmount$) {
			System.out.println("Total Amount is Right   " + ftotAmount$);
			test.log(LogStatus.INFO,
					"The Total Amount of Order to Check Out Payment is Right and Validated:     " + ftotAmount$);
		} else {
			System.out.println("The Total Amount is wrong  " + ftotAmount$);
			test.log(LogStatus.INFO,
					"The Total Amount of Order to Check Out Payment is wrong and Validated:   " + ftotAmount$);

		}

		// System.out.println(e.getMessage());
		// System.out.println(e.getStackTrace());
		// }

		Actions act1 = new Actions(driver);
		act.moveToElement(chkoutDeliveryBtn).build().perform();
		Thread.sleep(5000);

		chkoutDeliveryBtn.click();

		Thread.sleep(4000);

		editOrderBtn.click();

		Select tsel2 = new Select(selectTipAmt);
		// tsel.selectByValue("15");

		String text2 = "25";
		tsel2.selectByValue(text2);

		// String[] splitText2=text2.split(" ");
		// String splitText$2=splitText2[0];
		test.log(LogStatus.INFO, "The Tip Amount is: " + text2 + " For this Order");
		System.out.println("The Selected Tip Amount is 15%:  " + text2 + " For this Order");

		float fText2 = Float.parseFloat(text2);
		float ftotAmount$2 = fSubTotAmount + (fSubTotAmount * (fText2 / 100)) + $Tax;

		System.out.println("The Tax for the Total:   " + $Tax);
		test.log(LogStatus.INFO, "The Tax Amount is Validated      " + $Tax);

		// double rtotAmount$=Math.nextDown(totAmount$);

		String sTotAmount2 = totalAmt.getText();
		System.out.println("The Total Amount displayed is:   " + sTotAmount2);

		float TotalAmount$2 = Float.parseFloat(sTotAmount2);

		if (ftotAmount$ == TotalAmount$) {
			System.out.println("Total Amount is Right   " + ftotAmount$2);
			test.log(LogStatus.INFO,
					"The Total Amount of Order to Check Out Payment is Right and Validated:     " + ftotAmount$2);
		} else {
			System.out.println("The Total Amount is wrong  " + ftotAmount$2);
			test.log(LogStatus.INFO,
					"The Total Amount of Order to Check Out Payment is wrong and Validated:   " + ftotAmount$2);

		}

		// Actions act = new Actions(driver);
		act.moveToElement(chkoutDeliveryBtn).build().perform();
		Thread.sleep(5000);

		chkoutDeliveryBtn.click();
		Thread.sleep(3000);

		if (checkOutTitleText.isDisplayed()) {
			System.out.println("Pass:*****" + checkOutTitleText.getText());
			test.log(LogStatus.INFO, "Pass:The Checkout Page is Displayed: " + checkOutTitleText.getText());

		} else {
			test.log(LogStatus.INFO, "Fail:The Checkout Page is Displayed: " + checkOutTitleText.isDisplayed());
			System.out.println("Pass:*****" + checkOutTitleText.isDisplayed());
		}

		System.out.println("The Total Amount of Order to Check Out Payment is: " + sTotAmount);
		test.log(LogStatus.INFO, "The Total Amount of Order to Check Out Payment is Validated: ");
	}

	public void editClickCheckout(String firstname, String lastname, String Phone, String Email,
			String specialinstructions, String nameoncard, String cardnumber, String expirymonth, String expiryyear,
			String cvvcode, String billingzip) throws InterruptedException {
		Thread.sleep(5000);

		checkoutTakeOut.click();
		// firstName.sendKeys("ZZZZ");
		// System.out.println("Found ZZZZ XPath");
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		phone.sendKeys(Phone);
		email.sendKeys(Email);
		splInstrctions.sendKeys(specialinstructions);
		nameOnCard.sendKeys(nameoncard);
		cardNumber.sendKeys(cardnumber);
		expiryMonth.sendKeys(expirymonth);
		expiryYear.sendKeys(expiryyear);
		cvvCode.sendKeys(cvvcode);
		billZip.sendKeys(billingzip);
		placeMyOrderBtn.click();

	}
}

// @AfterMethod
// public void tearDown(ITestResult testResult) throws IOException {
//
// if (testResult.getStatus() == ITestResult.SUCCESS) {
// String path = Screenshots.takeScreenshot(driver, testResult.getName());
// String imagePath = test.addScreenCapture(path);
// test.log(LogStatus.PASS, testResult.getMethod().getMethodName(), imagePath);
//
// }
//
// if (testResult.getStatus() == ITestResult.FAILURE) {
// String path = Screenshots.takeScreenshot(driver, testResult.getName());
// String imagePath = test.addScreenCapture(path);
// test.log(LogStatus.FAIL, testResult.getMethod().getMethodName(), imagePath);
// }
//
// report.endTest(test);
// report.flush();
// driver.quit();
// }
// }