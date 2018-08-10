package com.crm.qa.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.MicroBizTestUtilt;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

public class OredrOnlinePage extends TestBase {
	private static final String timeSlots = null;
	Float fltorderTimeDelValue;
	String Time;
	GalleryPage gallerypage;
	OredrOnlinePage orderOnline;
	String sheetName = "TakeOut";
	MicroBizTestUtilt microBizTestUtil;

	// @FindBy(xpath = "//a[contains(text(),'order online')]")
	// WebElement orderOnlineTab;

	@FindBy(xpath = "//div[contains(text(),'Discount')]")
    WebElement disAmtTxt;
	
	
	@FindBy(xpath = "//span[@class='discount_amount']")
	WebElement disAmt;
	
	@FindBy(xpath = "//div[@id='home']/descendant::i[@class='i_downarrow fadeInUp aanimated']")
	WebElement homePageDwnArw;

	@FindBy(xpath = "//a[@data-target='about']")
	WebElement aboutMenu;

	@FindBy(xpath = "//div[@id='viewmap']/descendant::strong[contains(text(),'Corner Stone Cafe')]")
	WebElement addrMapElement;

	@FindBy(xpath = "//strong[@class='txt_delivery_address']")
	WebElement addtocartAddr;

	@FindBy(xpath = "//strong[@class='ng-binding']")
	WebElement addrConElement;

	@FindBy(xpath = "//div[@class='txt_contactdetail y-resCalender']/descendant::div[contains(text(),'7:00 AM to 4:00 PM')]")
	WebElement slotHrs;

	@FindBy(xpath = "//div[@id='menu_ordersection']/descendant::select[@class='t-order-date']/descendant::option[contains(text(),'Tomorrow')]")
	WebElement tSlotTom;

	@FindBy(xpath = "//div[@id='menu_ordersection']/descendant::select[@class='t-order-date']/descendant::option[contains(text(),'Today')]")
	WebElement tSlotToday;

	@FindBy(xpath = "//div[@id='menu_ordersection']/descendant::select[@class='t-order-time']/descendant::option[contains(text(),'07:30 AM')]")
	WebElement tSlot730AM;

	@FindBy(xpath = "//div[@id='menu_ordersection']/descendant::select[@class='t-order-time']/descendant::option[contains(text(),'09:00 AM')]")
	WebElement tSlot900AM;

	@FindBy(xpath = "//div[@id='menu_ordersection']/descendant::select[@class='t-order-time']/descendant::option[contains(text(),'09:30 AM')]")
	WebElement tSlot930AM;

	@FindBy(xpath = "//div[@class='txt_contactdetail y-resCalender']/descendant::div[position()=3]")
	WebElement dlyTmSlotsMon;

	@FindBy(xpath = "//div[@class='txt_contactdetail y-resCalender']/descendant::div[position()=6]")
	WebElement dlyTmSlotsTues;

	@FindBy(xpath = "//div[@class='txt_contactdetail y-resCalender']/descendant::div[position()=9]")
	WebElement dlyTmSlotsWed;

	@FindBy(xpath = "//div[@class='txt_contactdetail y-resCalender']/descendant::div[position()=12]")
	WebElement dlyTmSlotsThur;

	@FindBy(xpath = "//div[@class='txt_contactdetail y-resCalender']/descendant::div[position()=15]")
	WebElement dlyTmSlotsFri;

	// @FindBy(xpath = "//div[@class='txt_contactdetail
	// y-resCalender']/descendant::div[position()=18]")
	@FindBy(xpath = "//div[@class='txt_contactdetail y-resCalender']/descendant::div[contains(text(),'Saturday')]")
	WebElement dlyTmSlotsSat;

	@FindBy(xpath = "//div[@class='txt_contactdetail y-resCalender']/descendant::div[contains(text(),'Sunday')]")
	WebElement dlyTmSlotsSun;

	@FindBy(xpath = "//strong[contains(text(),'Hours')]")
	WebElement cHours;

	// @FindBy(tagName = "div")
	// WebElement tagTimeSlot;

	@FindBy(xpath = "//div[@id='contact']/div/div[2]/descendant::strong[position()=3]")
	WebElement deliveryAreaText;

	@FindBy(xpath = "//a[contains(text(),'View Menu')]")
	WebElement viewMenu;

	@FindBy(xpath = "//div[@class='box_expectedtime _fs14']")
	WebElement expTimeTxt;

	@FindBy(xpath = "//a[contains(text(),'Lake Zurich')]")
	WebElement btnZurich;

	@FindBy(xpath = "//div[@class='popup_location _p30']/descendant::a[position()=1]")
	WebElement btnLocCarp;

	@FindBy(xpath = "//div[@class='popup_location _p30']/descendant::a[position()=2]")
	WebElement btnLocMcHenry;

	@FindBy(xpath = "//div[@class='popup_location _p30']")
	WebElement popupLocWin;

	@FindBy(xpath = "//div[@class='popup_location _p30']/descendant::a[position()=1]")
	WebElement btnLocation1;

	@FindBy(xpath = "//div[@class='popup_location _p30']/descendant::a[position()=2]")
	WebElement btnLocation2;

	@FindBy(xpath = "//div[@class='popup_location _p30']/descendant::a[position()=3]")
	WebElement btnLocation3;

	@FindBy(xpath = "//a[contains(text(),'Highland Park')]")
	WebElement btnHighLandPark;

	@FindBy(xpath = "//p[@class='txt_m_enteryouraddress _fs14']")
	WebElement delWinPopup;

	@FindBy(xpath = "//a[@class='i_close close']")
	WebElement clsPopup;

	@FindBy(xpath = "//div[@class='entrypopup']")
	WebElement entryPopup;

	@FindBy(xpath = "//span[@class='discount_amount']")
	WebElement discAmt;

	@FindBy(xpath = "//p[@class='sectiontitle']")
	WebElement aboutTxt;

	@FindBy(xpath = "//a[contains(text(),'Menu')]")
	WebElement menuTab;

	@FindBy(xpath = "//a[contains(text(),'Contact')]")
	WebElement contactTab;

	@FindBy(xpath = "//p[contains(text(),'menu')]")
	WebElement menuTxt;

	@FindBy(xpath = "//div[@class='checkoutsection']/descendant::input[position()=1]")
	WebElement firstName;
	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastName;

	// @FindBy(xpath = "//input[@name='phone_no']")
	// WebElement phone;

	@FindBy(xpath = "//input[@name='phone_no']")
	WebElement c_Phone;

	@FindBy(xpath = "//input[@name='email']")
	WebElement c_Email;

	@FindBy(xpath = "//textarea[@name='own_instruction']")
	WebElement splInstrctions;

	@FindBy(xpath = "//input[@name='card_name']")
	WebElement nameOnCard;

	@FindBy(xpath = "//div[@id='menu_checkout']/div[1]/div[2]/div/div[2]/descendant::p[position()=3]")
	WebElement mvalidNameOnCard;

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

	@FindBy(xpath = "//span[@class='deliverycharge_amount']")
	WebElement delChargesAmt;

	@FindBy(xpath = "//div[contains(text(),'Delivery')]")
	WebElement delChargesTxt;

	// @FindBy(xpath =
	// "//div[@id='menu_checkout']/descendant::p[contains(text(),'Thank you for your
	// order.')]")
	// @FindBy(xpath = "//p[@class='txt_ordersummary']")

	@FindBy(xpath = "//div[@class='checkoutsection']/descendant::p[position()=1]")
	WebElement orderThankYouText;

	// @FindBy(xpath =
	// "//div[@id='menu_ordersection']/descendant::span[position()=4]")

	// @FindBy(xpath = "//span[@class='t-operation-hours']")
	@FindBy(xpath = "//p[@class='txt_minhours']/descendant::span[position()=1]")
	WebElement takeOutHoursTxt;

	@FindBy(xpath = "//p[@class='txt_upper']")
	WebElement takeOutSelTxt;

	@FindBy(xpath = "//p[@class='txt_receiptid']")
	WebElement receiptNumText;

	@FindBy(xpath = "//a[contains(text(),'Edit Order')]")
	WebElement editOrderBtn;

	@FindBy(xpath = "//a[@class='hl y-reserveTable']")
	WebElement reserveTable;

	@FindBy(xpath = "//input[@id='timepicker1']")
	WebElement tSlot;

	@FindBy(tagName = "ul")
	WebElement selecttSlot;

	@FindBy(xpath = "//input[id='first_name_r']")
	WebElement reqresFirstName;

	@FindBy(xpath = "//input[id='last_name_r']")
	WebElement reqresLastName;

	@FindBy(xpath = "//input[id='phone_no_r']")
	WebElement reqresPhone;

	@FindBy(xpath = "//input[id='email_r']")
	WebElement reqresEmail;

	@FindBy(id = "req_boothID")
	WebElement reqresBooth;

	@FindBy(id = "req_kidplaceID")
	WebElement reqresKidplace;

	@FindBy(id = "req_nocenterpieceID")
	WebElement reqresNoCenterPiece;

	@FindBy(id = "comment")
	WebElement reqresComment;

	@FindBy(id = "btnconfirm")
	WebElement reqresBtn;

	@FindBy(tagName = "li")
	WebElement tSlots;

	@FindBy(xpath = "//input[@value='Reserve it')]")
	WebElement reserveItButton;

	// @FindBy(xpath =
	// "//div[@id='pageload']/div[1]/div/div[1]/descendant::a[position()=1]")

	// @FindBy(xpath = "//div[@id='pageload']/descendant::a[contains(text(),'order
	// online')]")

	@FindBy(xpath = "//a[contains(text(),'order online')]")
	WebElement orderOnlineTab;

	@FindBy(xpath = "//div[@id='menu_ordersection']/descendant::p[position()=2]")
	WebElement expTime;

	// @FindBy(xpath = "//span[@class='t-operation-hours']")
	// WebElement expTakeOutTime;

	@FindBy(xpath = "//label[contains(text(),'Delivery')]")
	WebElement orderDelivery;
	// div[@id='menu_ordersection']/descendant::p[position()=5]

	@FindBy(xpath = "//a[contains(text(),'checkout for delivery')]")
	WebElement chkoutDeliveryBtn;

	@FindBy(xpath = "//a[contains(text(),'checkout for takeout')]")
	WebElement chkoutTakeoutBtn;

	@FindBy(xpath = "//div[@id='menu_ordersection']/descendant::span[position()=1]")
	WebElement orderDeliveryBtn;

	@FindBy(xpath = "//label[@for='t_delivery']/descendant::i[position()=1]")
	WebElement deliveryBtn;

	@FindBy(xpath = "//label[@for='t_delivery']")
	WebElement deliveryButton;

	@FindBy(xpath = "//div[@class='box_expectedtime _fs14']")
	WebElement deliveryNoChangeTxt;

	// @FindBy(xpath="//div[@id='menu']/descendant::span[position()=3]")

	@FindBy(xpath = "//a[@class='ubtn btn_addtocard btn_addtoorder']")
	WebElement orderAddtoCart;

	@FindBy(xpath = "//input[@id='searchTextField']")
	WebElement orderSearchTxtFld;

	@FindBy(xpath = "//span[@class='pac-matched']")
	WebElement autosugList;

	@FindBy(xpath = "//div[@class='pac-container pac-logo']")
	WebElement autosugWin;

	@FindBy(xpath = "//a[contains(text(),'verify & proceed to order')]")
	WebElement orderVerifyProceed;

	@FindBy(xpath = "//a[contains(text(),'order takeout')]")
	WebElement orderTakeOut;

	@FindBy(xpath = "//div[@id='menu_ordersection']/descendant::label[@for='t_takeout']")
	WebElement btnOrderTakeout;

	@FindBy(xpath = "//div[@id='menu_ordersection']/descendant::label[@for='t_delivery']")
	WebElement btnOrderDelivery;

	@FindBy(xpath = "//p[contains(text(),'Catering Booking')]")
	WebElement cateringStaticTxt;

	@FindBy(xpath = "//div[@id='catering']/descendant::p[position()=2]")
	WebElement mandatoryFieldsStaticTxt;

	@FindBy(xpath = "//div[@id='contact']/div/div[2]/descendant::p[position()=4]")
	WebElement oredrTopText;

//	@FindBy(xpath = "//div[@id='contact']/div/div[2]/descendant::strong[position()=1]")
	
	@FindBy(xpath = "//p[@class='contact_resaddress ng-binding']")
	WebElement rightAddressTxt;

	@FindBy(xpath = "//a[@class='i_close close']")
	WebElement addOrderCloseSymbol;

	@FindBy(xpath = "//div[@id='menu_ordersection']/descendant::label[position()=2]")
	WebElement orderTakeout;

	@FindBy(xpath = "//p[@class='but_order_type txt_order_onlytakeout']")
	WebElement onlyTakeout;

	@FindBy(xpath = "//input[@data-label='White Meat']/following::span[@class='control_indicator']")
	WebElement checkBoxWhiteMeat;

	@FindBy(xpath = "//a[@class='ubtn btn_addtocard add-multiplier']")
	WebElement addMultiplierBtn;

	@FindBy(xpath = "//a[@class='ubtn btn_addtocard decrease subtract-multiplier']")
	WebElement subMultiplierBtn;

	// @FindBy(xpath =
	// "html/body/div[3]/div/div/div/div/div[4]/div[1]/descendant::span[position()=1]")
	@FindBy(xpath = "//span[@class='multiplier']")
	WebElement addMultiplierTxt;

	@FindBy(xpath = "//span[@class='sub-total']")
	// @FindBy(xpath =
	// "//html/body/div[3]/div/div/div/div/div[4]/div[2]/descendant::span[position()=1]")
	WebElement orderPrice$;

	@FindBy(xpath = "//input[@data-label='White Rice']/following::span[@class='control_indicator']")
	WebElement radioWhiteBtn;

	@FindBy(xpath = "//input[@data-label='Brown Rice']/following::span[@class='control_indicator']")
	WebElement radioBrownBtn;

	@FindBy(xpath = "//a[@class='ubtn blackbtn btn_popupaddtoorder add-to-order']")
	WebElement orderAddToOrderBtn;

	@FindBy(xpath = "//div[@id='menu_ordersection']/div[5]/div/div[5]/descendant::span[position()=1]")
	WebElement orderTaxAmt;

	@FindBy(xpath = "//select[@class='t-tip-percent']")
	WebElement selectTipAmt;

	@FindBy(xpath = "//div[@id='menu_ordersection']/div[5]/div/descendant::span[last()-4]")
	WebElement subTotalTakeout;

	@FindBy(xpath = "//div[@id='menu_ordersection']/div[5]/div/descendant::span[last()-1]")
	WebElement orderTaxTakeout;

	@FindBy(xpath = "//div[@id='menu_ordersection']/div[5]/div/descendant::span[last()]")
	WebElement orderTotalTakeout;

	// *[@id='menu_ordersection']/div[5]/div/descendant::span[last()-4]

	@FindBy(xpath = "//select[@class='t-order-date']")
	WebElement dateTakeout;

	@FindBy(xpath = "//span[@class='order_total']")
	WebElement totalAmt;

	@FindBy(xpath = "//div[contains(text(),'Tip Amount')]")
	WebElement tipAmtText;

	@FindBy(xpath = "//div[contains(text(),'Total')]")
	WebElement totalAmountTxt;
	// div[@id='menu_ordersection']/div[5]/div/div[1]/descendant::p[position()=2]

	@FindBy(xpath = "///span[@class='order_subtotal']")
	WebElement subtotTakeout;

	@FindBy(xpath = "//span[@class='order_tax']")
	WebElement taxTakeout;

	@FindBy(xpath = "//span[@class='order_total']")
	WebElement totTakeout;

	@FindBy(xpath = "//a[@class='ubtn blackbtn y-checkoutBtn']")
	WebElement checkoutTakeOut;

	@FindBy(xpath = "//select[@class='t-order-time']/descendant::option[contains(text(),'09:00 AM')]")
	WebElement tSlot9AM;

	@FindBy(xpath = "//select[@class='t-order-time']/descendant::option[contains(text(),'10:00 AM')]")
	WebElement tSlot10AM;

	@FindBy(xpath = "//select[@class='t-order-time']/descendant::option[contains(text(),'10:30 AM')]")
	WebElement tSlot1030AM;

	@FindBy(xpath = "//select[@class='t-order-time']/descendant::option[contains(text(),'11:00 AM')]")
	WebElement tSlot11AM;

	@FindBy(xpath = "//select[@class='t-order-time']/descendant::option[contains(text(),'11:30 AM')]")
	WebElement tSlot1130AM;

	@FindBy(xpath = "//select[@class='t-order-time']/descendant::option[contains(text(),'12:00 PM')]")
	WebElement tSlot12PM;

	@FindBy(xpath = "//select[@class='t-order-time']/descendant::option[contains(text(),'12:30 PM')]")
	WebElement tSlot1230PM;

	@FindBy(xpath = "//select[@class='t-order-time']/descendant::option[contains(text(),'01:00 PM')]")
	WebElement tSlot1PM;

	@FindBy(xpath = "//select[@class='t-order-time']/descendant::option[contains(text(),'01:30 PM')]")
	WebElement tSlot130PM;

	@FindBy(xpath = "//select[@class='t-order-time']/descendant::option[contains(text(),'02:00 PM')]")
	WebElement tSlot2PM;

	@FindBy(xpath = "//select[@class='t-order-time']/descendant::option[contains(text(),'02:30 PM')]")
	WebElement tSlot230PM;

	@FindBy(xpath = "//select[@class='t-order-time']/descendant::option[contains(text(),'03:00 PM')]")
	WebElement tSlot3PM;

	@FindBy(xpath = "//select[@class='t-order-time']/descendant::option[contains(text(),'03:30 PM')]")
	WebElement tSlot330PM;

	@FindBy(xpath = "//select[@class='t-order-time']/descendant::option[contains(text(),'04:00 PM')]")
	WebElement tSlot4PM;

	@FindBy(xpath = "//select[@class='t-order-time']/descendant::option[contains(text(),'04:30 PM')]")
	WebElement tSlotP430M;
	@FindBy(xpath = "//select[@class='t-order-time']/descendant::option[contains(text(),'05:00 PM')]")
	WebElement tSlot5PM;

	@FindBy(xpath = "//select[@class='t-order-time']/descendant::option[contains(text(),'05:30 PM')]")
	WebElement tSlot530PM;

	@FindBy(xpath = "//select[@class='t-order-time']/descendant::option[contains(text(),'06:00 PM')]")
	WebElement tSlot6PM;

	@FindBy(xpath = "//select[@class='t-order-time']/descendant::option[contains(text(),'06:30 PM')]")
	WebElement tSlot630PM;

	@FindBy(xpath = "//select[@class='t-order-time']/descendant::option[contains(text(),'07:00 PM')]")
	WebElement tSlot7PM;

	@FindBy(xpath = "//select[@class='t-order-time']/descendant::option[contains(text(),'07:30 PM')]")
	WebElement tSlot730PM;

	@FindBy(xpath = "//select[@class='t-order-time']/descendant::option[contains(text(),'08:00 PM')]")
	WebElement tSlot8PM;

	@FindBy(xpath = "//select[@class='t-order-time']/descendant::option[contains(text(),'08:30 PM')]")
	WebElement tSlot830PM;

	@FindBy(xpath = "//select[@class='t-order-time']/descendant::option[contains(text(),'09:00 PM')]")
	WebElement tSlot9PM;

	@FindBy(xpath = "//a[contains(text(),'Change')]")
	WebElement changeBtn;

	// @FindBy(xpath = "//select[@class='t-order-date']")
	@FindBy(xpath = "//div[@id='menu_ordersection']/descendant::select[@class='t-order-date']")
	WebElement daySelect;

	@FindBy(xpath = "//div[@id='menu_ordersection']/descendant::option[contains(text(),'Today')]")
	WebElement todayTxt;

	@FindBy(xpath = "//select[@class='t-order-time']")
	WebElement timeSelect;

	// @FindBy(xpath = "//select[@class='t-order-date']")
	// WebElement dateSelect;

	// @FindBy(xpath =
	// "//div[@id='menu_ordersection']/descendant::select[position()=2]")
	// WebElement orderTimeDelivery;

	@FindBy(xpath = "//div[@id='menu_ordersection']/div[2]/descendant::p[position()=1]")
	WebElement zeroMilesText;

	@FindBy(xpath = "//div[@id='menu_ordersection']/div[2]/descendant::p[position()=2]")
	WebElement orderDeliveryAddrText;

	@FindBy(xpath = "//div[@class='checkoutDiv']/descendant::p[position()=1]")
	WebElement checkOutTitleText;

	@FindBy(xpath = "//a[@class='t-edit-order edit_17902088_1 ubtn']")
	WebElement editPencilIcon;

	@FindBy(xpath = "//span[@class='close_for_today']")
	WebElement resClosed;

	@FindBy(xpath = "//a[contains(text(),'Contact')]")
	WebElement contactLink;

	public String rightAddress=" 2794 Broadway ";
	
	public String wrongAddress = "2830 Drwin Dr,Fremont,CA, USA";
	ExtentTest test;
	private String expiryyear;
	private String cvvcode;

	public OredrOnlinePage(ExtentTest test) {

		this.test = test;
		gallerypage = new GalleryPage(test);
		PageFactory.initElements(driver, this);

	}

	private Object tagName(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public void verifyDeliveryAvailSlots(String firstname, String lastname, String phone, String email,
			String specialinstructions, String nameoncard, String cardnumber, String expirymonth, String expiryyear,
			String cvvcode, String billingzip) throws InterruptedException {

		String text = null;

		Thread.sleep(5000);
		
		homePageDwnArw.click();

		aboutMenu.click();
		Thread.sleep(3000);

		// gallerypage.verifyContactsLink();
		// Thread.sleep(3000);
		contactTab.click();
		Thread.sleep(3000);

//		rightAddress = rightAddressTxt.getText();

		Thread.sleep(3000);
		try {
			if (isElementPresent("//a[contains(text(),'View Menu')]") == true && viewMenu.isDisplayed()){

				viewMenu.click();
				Thread.sleep(3000);

				try {

					if (isElementPresent("//div[@class='popup_location _p30']") == true && isElementPresent(
							"//div[@class='popup_location _p30']/descendant::a[position()=2]") == true &&btnLocation2.isDisplayed()) {

						Thread.sleep(3000);
						btnLocation2.click();

						Thread.sleep(4000);

					}

				} catch (Exception e) {

					System.out.println("Web Element not Available");
				}

			}
		} catch (Exception e) {

			System.out.println("WebElement View Menu is unavailable " + e.getMessage());
		}

		try {
			if (isElementPresent("//a[contains(text(),'order online')]") == true
					&& isElementPresent("//label[@class='ubtn btn_service hide']") == false &&orderOnlineTab.isDisplayed()) {

				orderOnlineTab.click();
				try {

					if (isElementPresent("//div[@class='popup_location _p30']") == true && isElementPresent(
							"//div[@class='popup_location _p30']/descendant::a[position()=2]") == true && btnLocation2.isDisplayed()) {

						Thread.sleep(3000);
						btnLocation2.click();

						Thread.sleep(3000);

					}

				} catch (Exception e) {

					System.out.println("Web Element not Available");
				}
			}

		} catch (Exception e) {

			System.out.println("WebElement Order Online Tab  is unavailable " + e.getMessage());
		}

		try {

			if (isElementPresent("//div[@id='menu_ordersection']/descendant::label[@for='t_delivery']") == true
					&& isElementPresent("//label[@class='ubtn btn_service hide']") == false
					&& deliveryButton.isDisplayed()) {

				Actions act = new Actions(driver);

				act.moveToElement(deliveryButton).build().perform();

				btnOrderDelivery.click();
				Thread.sleep(2000);

				try {
					if (isElementPresent("//a[contains(text(),'Change')]") == true && changeBtn.isEnabled()
							&& changeBtn.isDisplayed()) {

						changeBtn.click();
						Thread.sleep(5000);
						daySelect.click();
						Thread.sleep(5000);

					}
				} catch (Exception e) {

					System.out.println("Web Element Time is not Available" + e.getMessage());
				}

				Select daySel = new Select(daySelect);

				try {

					if (isElementPresent(
							"//div[@id='menu_ordersection']/descendant::option[contains(text(),'Today')]") == true) {

						Thread.sleep(3000);
						daySel.selectByValue("Today");
						Thread.sleep(4000);
						try {

							if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'12:00 AM')]") == true) {
								text = "12:00 AM";
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'12:30 AM')]") == true) {
								text = "12:30 AM";
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'01:00 AM')]") == true) {
								text = "1:00 AM";
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'01:30 AM')]") == true) {
								text = "01:30 AM";

							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'02:00 AM')]") == true) {
								text = "02:00 AM";

								System.out.println(
										"The Slot:  " + tSlot10AM.getText() + " is Available for Reservation......");
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'02:30 AM')]") == true) {
								text = "02:30 AM";

								System.out.println(
										"The Slot:  " + tSlot1030AM.getText() + " is Available for Reservation......");
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'03:00 AM')]") == true) {
								text = "03:00 AM";

								System.out.println(
										"The Slot:  " + tSlot11AM.getText() + " is Available for Reservation......");
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'03:30 AM')]") == true) {
								text = "03:30 AM";
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'04:00 AM')]") == true) {
								text = "04:00 AM";
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'04:30 AM')]") == true) {
								text = "04:30 AM";
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'05:00 AM')]") == true) {
								text = "05:00 AM";
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'05:30 AM')]") == true) {
								text = "05:30 AM";

							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'06:00 AM')]") == true) {
								text = "06:00 AM";

								System.out.println(
										"The Slot:  " + tSlot10AM.getText() + " is Available for Reservation......");
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'06:30 AM')]") == true) {
								text = "06:30 AM";

								System.out.println(
										"The Slot:  " + tSlot1030AM.getText() + " is Available for Reservation......");
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'07:00 AM')]") == true) {
								text = "07:00 AM";

								System.out.println(
										"The Slot:  " + tSlot11AM.getText() + " is Available for Reservation......");
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'07:30 AM')]") == true) {
								text = "07:30 AM";
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'08:00 AM')]") == true) {
								text = "08:00 AM";
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'08:30 AM')]") == true) {
								text = "08:30 AM";
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'09:00 AM')]") == true) {
								text = "09:00 AM";

								System.out.println(
										"The Slot:  " + tSlot9AM.getText() + " is Available for Reservation......");
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'09:30 AM')]") == true) {
								text = "09:30 AM";

							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'10:00 AM')]") == true) {
								text = "10:00 AM";

								System.out.println(
										"The Slot:  " + tSlot10AM.getText() + " is Available for Reservation......");
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'10:30 AM')]") == true) {
								text = "10:30 AM";

								System.out.println(
										"The Slot:  " + tSlot1030AM.getText() + " is Available for Reservation......");
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'11:00 AM')]") == true) {
								text = "11:00 AM";

								System.out.println(
										"The Slot:  " + tSlot11AM.getText() + " is Available for Reservation......");
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'11:30 AM')]") == true) {
								text = "11:30 AM";
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'12:00 PM')]") == true) {
								text = "12:00 PM";
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'12:30 PM')]") == true) {
								text = "12:30 PM";
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'01:00 PM')]") == true) {
								text = "1:00 PM";
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'01:30 PM')]") == true) {
								text = "01:30 PM";

							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'02:00 PM')]") == true) {
								text = "02:00 PM";

							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'02:30 PM')]") == true) {
								text = "02:30 PM";

							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'03:00 PM')]") == true) {
								text = "03:00 PM";

								System.out.println(
										"The Slot:  " + tSlot11AM.getText() + " is Available for Reservation......");
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'03:30 PM')]") == true) {
								text = "03:30 PM";
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'04:00 PM')]") == true) {
								text = "04:00 PM";
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'04:30 PM')]") == true) {
								text = "04:30 PM";
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'05:00 PM')]") == true) {
								text = "05:00 PM";
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'05:30 PM')]") == true) {
								text = "05:30 PM";

							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'06:00 PM')]") == true) {
								text = "06:00 PM";

								System.out.println(
										"The Slot:  " + tSlot10AM.getText() + " is Available for Reservation......");
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'06:30 PM')]") == true) {
								text = "06:30 PM";

								System.out.println(
										"The Slot:  " + tSlot1030AM.getText() + " is Available for Reservation......");
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'07:00 PM')]") == true) {
								text = "07:00 PM";

								System.out.println(
										"The Slot:  " + tSlot11AM.getText() + " is Available for Reservation......");
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'07:30 PM')]") == true) {
								text = "07:30 PM";
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'08:00 PM')]") == true) {
								text = "08:00 PM";
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'08:30 PM')]") == true) {
								text = "08:30 PM";
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'09:00 PM')]") == true) {
								text = "09:00 PM";
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'09:30 PM')]") == true) {
								text = "09:30 PM";

							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'10:00 PM')]") == true) {
								text = "10:00 PM";

								System.out.println(
										"The Slot:  " + tSlot10AM.getText() + " is Available for Reservation......");
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'10:30 PM')]") == true) {
								text = "10:30 PM";

								System.out.println(
										"The Slot:  " + tSlot1030AM.getText() + " is Available for Reservation......");
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'11:00 PM')]") == true) {
								text = "11:00 PM";

								System.out.println(
										"The Slot:  " + tSlot11AM.getText() + " is Available for Reservation......");
							}

							else if (isElementPresent(
									"//select[@class='t-order-time']/descendant::option[contains(text(),'11:30 PM')]") == true) {
								text = "11:30 PM";
							}
							
							

						} catch (Exception e) {

							System.out.println(" Web Element Time is notavailable");

						}

//						timeSelect.click();
//						
//						Select timeSel = new Select(timeSelect);
//						Thread.sleep(2000);
//
//						timeSel.selectByVisibleText(text);

						// homePageDwnArw.click();
						//
                      
						
						timeSelect.click();
						Thread.sleep(4000);
						
						Select timeSel = new Select(timeSelect);
						Thread.sleep(4000);

						timeSel.selectByVisibleText(text);
						orderAddtoCart.click();

						try {

							if (isElementPresent("//a[contains(text(),'verify & proceed to order')]") == true
									&& orderVerifyProceed.isDisplayed()) {

								Thread.sleep(2000);
								System.out.println("Pass: Delivery Window has Popped Up:   ");
								test.log(LogStatus.INFO, "Pass: Delivery has Window Popped Up:   ");
								orderSearchTxtFld.sendKeys(rightAddress);
								orderVerifyProceed.click();
								Thread.sleep(4000);


//								try {
//									if(isElementPresent("//strong[@class='txt_delivery_address']")==true && addtocartAddr.isDisplayed()) {
//
//										Thread.sleep(1000);
//										test.log(LogStatus.INFO, "This Address  " + rightAddress+ "  within the Delivery Boundary......   ");
//										addOrderCloseSymbol.click();
//										Thread.sleep(4000);
//									} else {
//
//										test.log(LogStatus.INFO, " Address is Unavailable  ");
//										addOrderCloseSymbol.click();
//										Thread.sleep(4000);
//									}
//								} catch (Exception e) {
//
//									System.out.println("WebElement Verify & Proceed is unavailable " + e.getMessage());
//								}
							}

						} catch (Exception e) {
							System.out.println("Fail: Delivery Window has not Popped Up ");
							test.log(LogStatus.INFO, "Fail: Delivery Window has not Popped Up ");

						}

						
						try {
							if (isElementPresent(
									"//input[@data-label='White Rice']/following::span[@class='control_indicator']") == true
								&&radioWhiteBtn.isDisplayed()	|| isElementPresent(
											"//input[@data-label='Brown Rice']/following::span[@class='control_indicator']") == true &&radioBrownBtn.isDisplayed()){

								radioWhiteBtn.click();
								Thread.sleep(2000);
							}
						} catch (Exception e) {

							System.out.println("WebElement White Rice Radio Button is unavailable " + e.getMessage());
						}

						try {
							if (isElementPresent(
									"//input[@data-label='White Meat']/following::span[@class='control_indicator']") == true && checkBoxWhiteMeat.isDisplayed()) {

								checkBoxWhiteMeat.click();

							}
						} catch (Exception e) {

							System.out.println("WebElement White Meat Check Box is unavailable " + e.getMessage());
						}

						addMultiplierBtn.click();
						Thread.sleep(2000);

						String orderQtyTot = addMultiplierTxt.getText();

						int iorderQtyTot = Integer.parseInt(orderQtyTot);
						test.log(LogStatus.INFO, "The Total Quantity is Validated     " + iorderQtyTot);

						String Price = orderPrice$.getText();

						float $Price = Float.parseFloat(Price);
						test.log(LogStatus.INFO, "The Price is Validated     " + $Price);

						float fSubTotAmount = iorderQtyTot * $Price;

						test.log(LogStatus.INFO, "The Sub Total Amount is Validated    " + fSubTotAmount);
						System.out.println("The Sub TotalAmount is:     " + fSubTotAmount);

						Thread.sleep(2000);
						orderAddToOrderBtn.click();
						Thread.sleep(4000);

						// act.moveToElement(orderTaxAmt).build().perform();

						String Tax = orderTaxAmt.getText();
						float $Tax = Float.parseFloat(Tax);

						System.out.println("The Tax for the Total:   " + $Tax);
						test.log(LogStatus.INFO, "The Tax Amount is Validated      " + $Tax);

						Thread.sleep(3000);

						try {
							if (isElementPresent("//a[contains(text(),'Delivery')]")==true && delChargesTxt.isDisplayed()){

								String DelAmt = delChargesTxt.getText();
								float $DelAmt = Float.parseFloat(DelAmt);
								System.out.println("Delivery Charges is:    " + $DelAmt);

								Select tsel = new Select(selectTipAmt);

								String tipText = "20";

								tsel.selectByValue(tipText);

								Thread.sleep(5000);
								test.log(LogStatus.INFO, "The Tip Percentage is: " + tipText + "% For this Order");
								System.out.println("The Selected Tip Percentage is :  " + tipText + "% For this Order");

								float fText = Float.parseFloat(tipText);
								float ftotAmount$ = fSubTotAmount + $DelAmt + (fSubTotAmount * (fText / 100)) + $Tax;
								
								try {
									if (isElementPresent("//span[@class='discount_amount']")==true && disAmtTxt.isDisplayed()) {
                                
										String disAmount= disAmtTxt.getText();
										float disAmount$=Float.parseFloat(disAmount);
										float netTotAmt$=ftotAmount$-disAmount$;
										
										System.out.println(" The Discount is:   "+disAmount$+" For this Order");
										test.log(LogStatus.INFO," The Discount is:   "+ disAmount$+ " For this Order ");
									
									
								

								System.out.println("The Tax for the Total:   " + $Tax);
								test.log(LogStatus.INFO, "The Tax Amount is Validated      " + $Tax);

								// double rtotAmount$=Math.nextDown(totAmount$);

								String sTotAmount = totalAmt.getText();
								System.out.println("The Total Amount displayed is:   " + sTotAmount);

								float TotalAmount$ = Float.parseFloat(sTotAmount);

								if(netTotAmt$ == TotalAmount$) {
									System.out.println("Total Amount is Right   " + ftotAmount$);
									test.log(LogStatus.INFO,
											"The Total Amount of Order to Check Out Payment is Right and Validated:     "
													+ ftotAmount$);
								} else {
									System.out.println("The Total Amount is wrong  " + ftotAmount$);
									test.log(LogStatus.INFO,
											"The Total Amount of Order to Check Out Payment is wrong and Validated:   "
													+ ftotAmount$);

								}
									}
								}catch (Exception e) {

									System.out.println(
											"The Discount WebElement WebElement is Unavailable and there was no Delivery Charges");
								}
							
								

							}else {

							

								Select tsel = new Select(selectTipAmt);

								String tipText = "20";

								tsel.selectByValue(tipText);

								Thread.sleep(5000);
								test.log(LogStatus.INFO, "The Tip Amount is: " + tipText + "% For this Order");
								System.out.println("The Selected Tip Amount is:  " + tipText + "% For this Order");

								float fText = Float.parseFloat(tipText);
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
											"The Total Amount of Order to Check Out Payment is Right and Validated:     "
													+ ftotAmount$);
								} else {
									System.out.println("The Total Amount is wrong  " + ftotAmount$);
									test.log(LogStatus.INFO,
											"The Total Amount of Order to Check Out Payment is wrong and Validated:   "
													+ ftotAmount$);

								}
								}

									
								} catch (Exception e) {

									System.out.println(
											"The Discount WebElement WebElement is Unavailable and there was no Delivery Charges");
								}
							

					}
					}catch (Exception e) {

							System.out.println(
									"The Delivery Charges WebElement is Unavailable and there was no Delivery Charges");
						}
			
				catch (Throwable e) {

					System.out.println(
							"The Delivery Charges WebElement is Unavailable and there was no Delivery Charges");
				}


						//

						// Actions act2 = new Actions(driver);
						// act.moveToElement(chkoutDeliveryBtn).build().perform();
						Thread.sleep(3000);

						String sTotAmount = totalAmt.getText();
						System.out.println("The Total Amount displayed is:   " + sTotAmount);

						chkoutDeliveryBtn.click();
						Thread.sleep(3000);

						if (checkOutTitleText.isDisplayed()) {
							System.out
									.println("Pass: The Checkout Page is Displayed*****" + checkOutTitleText.getText());
							test.log(LogStatus.INFO,
									"Pass:The Checkout Page is Displayed " + checkOutTitleText.getText());

						} else {
							test.log(LogStatus.INFO,
									"Fail:The Checkout Page is not Displayed " + checkOutTitleText.isDisplayed());
							System.out.println(
									"Fail: The Checkout Page is not Displayed:*****" + checkOutTitleText.isDisplayed());
						}

						System.out.println("The Total Amount of Order to Check Out Payment is: " + sTotAmount);
						test.log(LogStatus.INFO, "The Total Amount of Order to Check Out Payment is Validated: ");

						firstName.sendKeys(firstname);
						lastName.sendKeys(lastname);
						splInstrctions.sendKeys(specialinstructions);
						nameOnCard.sendKeys(nameoncard);
						cardNumber.sendKeys(cardnumber);
						expiryMonth.sendKeys(expirymonth);
						expiryYear.sendKeys(expiryyear);
						cvvCode.sendKeys(cvvcode);
						billZip.sendKeys(billingzip);
						c_Phone.sendKeys(phone);
						c_Email.sendKeys(email);
						Thread.sleep(3000);

						Actions action = new Actions(driver);
						action.moveToElement(placeMyOrderBtn).build().perform();

						Thread.sleep(4000);
						placeMyOrderBtn.click();

						Thread.sleep(12000);

						if (orderThankYouText.isEnabled() && (orderThankYouText.isDisplayed())) {

							// Actions act = new Actions(driver);
							action.moveToElement(orderThankYouText).build().perform();
							Thread.sleep(3000);

							System.out.println("Pass:***** The: The Thank You Page     " + orderThankYouText.getText()
									+ " ********");
							System.out.println("Pass:***** The: The Receipt Number     " + receiptNumText.getText()
									+ "************");

							Thread.sleep(2000);

							test.log(LogStatus.INFO, "Pass:The Thank You Page    " + orderThankYouText.getText()
									+ " is Enabled & Displayed ");
							test.log(LogStatus.INFO,
									"Pass: Receipt Number   " + receiptNumText.getText() + "   for the Order    ");
						} else {

							Thread.sleep(2000);
							test.log(LogStatus.INFO, "Fail:The Checkout Page is not Displayed ");
							System.out.println("Fail:The Checkout Page is not Displayed  *****   ");
						}

					}

				} catch (Exception e) {

					System.out.println("Web Element Time is not Available" + e.getMessage());
				}
			
		
			try{
			if(isElementPresent("//div[@id='menu_ordersection']/descendant::option[contains(text(),'Tomorrow')]") == true) {

						 Select daySel = new Select(daySelect);
						daySel.selectByValue("Tomorrow");
					
				
				
				try {

					if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'12:00 AM')]") == true) {
						text = "12:00 AM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'12:30 AM')]") == true) {
						text = "12:30 AM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'01:00 AM')]") == true) {
						text = "1:00 AM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'01:30 AM')]") == true) {
						text = "01:30 AM";

					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'02:00 AM')]") == true) {
						text = "02:00 AM";

						System.out.println("The Slot:  " + tSlot10AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'02:30 AM')]") == true) {
						text = "02:30 AM";

						System.out
								.println("The Slot:  " + tSlot1030AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'03:00 AM')]") == true) {
						text = "03:00 AM";

						System.out.println("The Slot:  " + tSlot11AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'03:30 AM')]") == true) {
						text = "03:30 AM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'04:00 AM')]") == true) {
						text = "04:00 AM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'04:30 AM')]") == true) {
						text = "04:30 AM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'05:00 AM')]") == true) {
						text = "05:00 AM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'05:30 AM')]") == true) {
						text = "05:30 AM";

					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'06:00 AM')]") == true) {
						text = "06:00 AM";

						System.out.println("The Slot:  " + tSlot10AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'06:30 AM')]") == true) {
						text = "06:30 AM";

						System.out
								.println("The Slot:  " + tSlot1030AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'07:00 AM')]") == true) {
						text = "07:00 AM";

						System.out.println("The Slot:  " + tSlot11AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'07:30 AM')]") == true) {
						text = "07:30 AM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'08:00 AM')]") == true) {
						text = "08:00 AM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'08:30 AM')]") == true) {
						text = "08:30 AM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'09:00 AM')]") == true) {
						text = "09:00 AM";

						System.out.println("The Slot:  " + tSlot9AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'09:30 AM')]") == true) {
						text = "09:30 AM";

					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'10:00 AM')]") == true) {
						text = "10:00 AM";

						System.out.println("The Slot:  " + tSlot10AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'10:30 AM')]") == true) {
						text = "10:30 AM";

						System.out
								.println("The Slot:  " + tSlot1030AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'11:00 AM')]") == true) {
						text = "11:00 AM";

						System.out.println("The Slot:  " + tSlot11AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'11:30 AM')]") == true) {
						text = "11:30 AM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'12:00 PM')]") == true) {
						text = "12:00 PM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'12:30 PM')]") == true) {
						text = "12:30 PM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'01:00 PM')]") == true) {
						text = "1:00 PM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'01:30 PM')]") == true) {
						text = "01:30 PM";

					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'02:00 PM')]") == true) {
						text = "02:00 PM";

					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'02:30 PM')]") == true) {
						text = "02:30 PM";

					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'03:00 PM')]") == true) {
						text = "03:00 PM";

						System.out.println("The Slot:  " + tSlot11AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'03:30 PM')]") == true) {
						text = "03:30 PM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'04:00 PM')]") == true) {
						text = "04:00 PM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'04:30 PM')]") == true) {
						text = "04:30 PM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'05:00 PM')]") == true) {
						text = "05:00 PM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'05:30 PM')]") == true) {
						text = "05:30 PM";

					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'06:00 PM')]") == true) {
						text = "06:00 PM";

					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'06:30 AM')]") == true) {
						text = "06:30 PM";

					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'07:00 PM')]") == true) {
						text = "07:00 PM";

					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'07:30 PM')]") == true) {
						text = "07:30 PM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'08:00 PM')]") == true) {
						text = "08:00 PM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'08:30 PM')]") == true) {
						text = "08:30 PM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'09:00 AM')]") == true) {
						text = "09:00 PM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'09:30 AM')]") == true) {
						text = "09:30 PM";

					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'10:00 AM')]") == true) {
						text = "10:00 PM";

					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'10:30 AM')]") == true) {
						text = "10:30 PM";

					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'11:00 AM')]") == true) {
						text = "11:00 PM";

					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'11:30 AM')]") == true) {
						text = "11:30 PM";
					}

					else {
						System.out.println(" Web Element notavailable");
					}
					
				

				} catch (Exception e) {

					System.out.println(" Web Element Time is notavailable");

				
				}
		
		
		}
	
		
		

		timeSelect.click();
		Thread.sleep(4000);
		
		Select timeSel2 = new Select(timeSelect);
		Thread.sleep(4000);
		

//		homePageDwnArw.click();
		// Thread.sleep(4000);

//		aboutMenu.click();
		Thread.sleep(3000);

//		timeSel2.selectByVisibleText(text);

		// gallerypage.verifyContactsLink();

//		contactTab.click();
//		Thread.sleep(3000);
//
//		rightAddress = rightAddressTxt.getText();
//		orderOnlineTab.click();
		Thread.sleep(3000);

		orderAddtoCart.click();
		try {
			if (isElementPresent("//a[contains(text(),'verify & proceed to order')]") == true
					&& orderVerifyProceed.isDisplayed()) {

				Thread.sleep(3000);

				System.out.println("Pass: Delivery Window has Popped Up:   ");
				test.log(LogStatus.INFO, "Pass: Delivery Window has Popped Up:   ");

				orderSearchTxtFld.sendKeys(rightAddress);
				orderVerifyProceed.click();
				Thread.sleep(4000);

//				try {
//					if (addtocartAddr.isDisplayed()) {
//
//						Thread.sleep(1000);
//						test.log(LogStatus.INFO,
//								"This Address  " + rightAddress + "  within the Delivery Boundary......   ");
//						addOrderCloseSymbol.click();
//					} else {
//
//						test.log(LogStatus.INFO, " Address is Unavailable  ");
//						addOrderCloseSymbol.click();
//					}
//				} catch (Exception e) {
//
//					System.out.println("WebElement Verify & Proceed is unavailable " + e.getMessage());
//				}
			}
		} catch (Exception e) {

			System.out.println("Fail: Delivery Window has not Popped Up ");
			test.log(LogStatus.INFO, "Fail: Delivery Window has not Popped Up ");

		}

		// orderSearchTxtFld.sendKeys(rightAddress);

	

		try {
			if (isElementPresent(
					"//input[@data-label='White Rice']/following::span[@class='control_indicator']") == true
					&& radioWhiteBtn.isDisplayed()|| isElementPresent(
							"//input[@data-label='Brown Rice']/following::span[@class='control_indicator']") == true && radioBrownBtn.isDisplayed()) {

				radioWhiteBtn.click();
				Thread.sleep(2000);
			}
		} catch (Exception e) {

			System.out.println("WebElementn White Rice Radio Button is unavailable " + e.getMessage());
		}

		try {
			if (isElementPresent("//input[@data-label='White Meat']/following::span[@class='control_indicator']") == true &&checkBoxWhiteMeat.isDisplayed()) {

				checkBoxWhiteMeat.click();
				Thread.sleep(2000);

			}
		} catch (Exception e) {

			System.out.println("WebElement White Meat Check Box is unavailable " + e.getMessage());
		}

		addMultiplierBtn.click();
		Thread.sleep(2000);

		String orderQtyTot = addMultiplierTxt.getText();

		int iorderQtyTot = Integer.parseInt(orderQtyTot);
		test.log(LogStatus.INFO, "The Total Quantity is Validated     " + iorderQtyTot);

		String Price = orderPrice$.getText();

		float $Price = Float.parseFloat(Price);
		test.log(LogStatus.INFO, "The Price is Validated     " + $Price);

		float fSubTotAmount = iorderQtyTot * $Price;
		test.log(LogStatus.INFO, "The Sub Total Amount is Validated    " + fSubTotAmount);
		System.out.println("The Sub TotalAmount is:     " + fSubTotAmount);

		Thread.sleep(2000);
		orderAddToOrderBtn.click();
		Thread.sleep(4000);

		// act.moveToElement(orderTaxAmt).build().perform();

		String Tax = orderTaxAmt.getText();
		float $Tax = Float.parseFloat(Tax);
		System.out.println("The Tax for the Total:   " + $Tax);
		test.log(LogStatus.INFO, "The Tax Amount is Validated      " + $Tax);

		Thread.sleep(3000);

		try {
			if (isElementPresent("//a[contains(text(),'Delivery')]")==true && delChargesTxt.isDisplayed()) {

				String DelAmt = delChargesTxt.getText();
				float $DelAmt = Float.parseFloat(DelAmt);
				System.out.println("Delivery Charges is:    " + $DelAmt);

				Select tsel = new Select(selectTipAmt);
				String tipText = "20";

				tsel.selectByValue(tipText);

				Thread.sleep(5000);
				test.log(LogStatus.INFO, "The Tip Percentage is: " + tipText + "% For this Order");
				System.out.println("The Selected Tip Percentage is :  " +tipText + "% For this Order");
				
				Float fText = Float.parseFloat(tipText);
				float ftotAmount$ = fSubTotAmount + $DelAmt + (fSubTotAmount * (fText / 100)) + $Tax;

				System.out.println("The Tax for the Total:   " + $Tax);
				test.log(LogStatus.INFO, "The Tax Amount is Validated      " + $Tax);

				// double rtotAmount$=Math.nextDown(totAmount$);

				String sTotAmount = totalAmt.getText();
				System.out.println("The Total Amount displayed is:   " + sTotAmount);

				float TotalAmount$ = Float.parseFloat(sTotAmount);

				if (ftotAmount$ == TotalAmount$) {
					System.out.println("Total Amount is Right   " + ftotAmount$);
					test.log(LogStatus.INFO,
							"The Total Amount of Order to Check Out Payment is Right and Validated:     "
									+ ftotAmount$);
				} else {
					System.out.println("The Total Amount is wrong  " + ftotAmount$);
					test.log(LogStatus.INFO,
							"The Total Amount of Order to Check Out Payment is wrong and Validated:   " + ftotAmount$);

				}
			
			}
		}catch (Exception e) {

				System.out.println(" Web Element Time is notavailable");
				}
			
		
	       
	       

	

				Select tsel = new Select(selectTipAmt);

				String tipText = "20";

				tsel.selectByValue(tipText);

				Thread.sleep(5000);
				test.log(LogStatus.INFO, "The Tip Percentage is: " + tipText + "% For this Order");
				System.out.println("The Selected Tip Amount is   " + tipText + "% For this Order");

				float fText = Float.parseFloat(tipText);
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
							"The Total Amount of Order to Check Out Payment is Right and Validated:     "
									+ ftotAmount$);
				} else {
					System.out.println("The Total Amount is wrong  " + ftotAmount$);
					test.log(LogStatus.INFO,
							"The Total Amount of Order to Check Out Payment is wrong and Validated:   " + ftotAmount$);

				}

	

			//

			Actions act = new Actions(driver);
			act.moveToElement(chkoutDeliveryBtn).build().perform();
			Thread.sleep(3000);

			chkoutDeliveryBtn.click();
			Thread.sleep(3000);

			String sTotalAmount = totalAmt.getText();
			System.out.println("The Total Amount displayed is:   " + sTotalAmount);

			if (checkOutTitleText.isDisplayed()) {
				System.out.println("Pass: The Checkout Page is Displayed   ******" + checkOutTitleText.getText());
				test.log(LogStatus.INFO, "Pass:The Checkout Page is Displayed " + checkOutTitleText.getText());

			} else {
				test.log(LogStatus.INFO, "Fail:The Checkout Page is Displayed   " + checkOutTitleText.isDisplayed());
				System.out.println("Fail:The Checkout Page is Displayed *****   " + checkOutTitleText.isDisplayed());
			}

			System.out.println("The Total Amount of Order to Check Out Payment is: " + sTotAmount);
			test.log(LogStatus.INFO, "The Total Amount of Order to Check Out Payment is Validated: ");
			firstName.sendKeys(firstname);
			lastName.sendKeys(lastname);
			splInstrctions.sendKeys(specialinstructions);
			nameOnCard.sendKeys(nameoncard);
			cardNumber.sendKeys(cardnumber);
			expiryMonth.sendKeys(expirymonth);
			expiryYear.sendKeys(expiryyear);
			cvvCode.sendKeys(cvvcode);
			billZip.sendKeys(billingzip);
			c_Phone.sendKeys(phone);
			c_Email.sendKeys(email);
			Thread.sleep(3000);

			Actions action = new Actions(driver);
			action.moveToElement(placeMyOrderBtn).build().perform();

			Thread.sleep(4000);
			placeMyOrderBtn.click();

		

			if (orderThankYouText.isEnabled() && (orderThankYouText.isDisplayed())) {

				// Actions act = new Actions(driver);
				action.moveToElement(orderThankYouText).build().perform();
				Thread.sleep(3000);

				System.out.println("Pass:***** The:Thank You Page    " + orderThankYouText.getText() + " ********");
				System.out.println("Pass:***** The:Receipt Number     " + receiptNumText.getText() + "************");

				Thread.sleep(2000);

				test.log(LogStatus.INFO,
						" Pass:The Thank You Page:    " + orderThankYouText.getText() + " is Enabled & Displayed: ");
				test.log(LogStatus.INFO,
						" Pass: Receipt Number   " + receiptNumText.getText() + "   for the Order    ");
			} else {

				Thread.sleep(2000);
				test.log(LogStatus.INFO, "Fail:The Checkout Page is not Displayed ");
				System.out.println("Fail:The Checkout Page is not Displayed *****   ");
			}
			
			
		
		}catch (Exception e) {

			System.out.println("Web Element Time is not Available" + e.getMessage());
		}
	}


	


					
			
	       
		
	
	

	public void verifyTakeoutAvailSlots(String firstname, String lastname, String phone, String email,
			String specialinstructions, String nameoncard, String cardnumber, String expirymonth, String expiryyear,
			String cvvcode, String billingzip) throws InterruptedException, Exception {

		String text = null;

		Thread.sleep(4000);
		
		homePageDwnArw.click();


		try {
			if (isElementPresent("//a[contains(text(),'View Menu')]") == true && viewMenu.isDisplayed()) {

				viewMenu.click();
				Thread.sleep(3000);

				try {

					if (isElementPresent("//div[@class='popup_location _p30']") == true && isElementPresent(
							"//div[@class='popup_location _p30']/descendant::a[position()=2]") == true) {

						Thread.sleep(3000);
						btnLocation2.click();

						Thread.sleep(4000);

					}

				} catch (Exception e) {

					System.out.println("Web Element not Available");
				}

			}
		} catch (Exception e) {

			System.out.println("WebElement View Menu is unavailable " + e.getMessage());
		}

		try {
			if (isElementPresent("//a[contains(text(),'order online')]") == true
					&& isElementPresent("//label[@class='ubtn btn_service hide']") == false&&orderOnlineTab.isDisplayed()) {

				orderOnlineTab.click();
				try {

					if (isElementPresent("//div[@class='popup_location _p30']") == true && isElementPresent(
							"//div[@class='popup_location _p30']/descendant::a[position()=2]") == true &&btnLocation2.isDisplayed()){

						Thread.sleep(3000);
						btnLocation2.click();

						Thread.sleep(4000);

					}

				} catch (Exception e) {

					System.out.println("Web Element not Available");
				}
			}

		} catch (Exception e) {

			System.out.println("WebElement Order Online Tab  is unavailable " + e.getMessage());
		}

		Thread.sleep(3000);
		Actions act = new Actions(driver);
		try {

			if (isElementPresent("//div[@id='menu_ordersection']/descendant::label[position()=2]") == true
					&& isElementPresent("//div[@id='menu_ordersection']/descendant::label[@for='t_takeout']") == true){

				act.moveToElement(btnOrderTakeout).build().perform();

				btnOrderTakeout.click();
				Thread.sleep(4000);

				changeBtn.click();
				Thread.sleep(6000);

				daySelect.click();

				Thread.sleep(4000);
			}
		} catch (Exception e) {

			System.out.println("Take Out Button is not Available.......");
		}

		try {

			if (isElementPresent("//p[@class='but_order_type txt_order_onlytakeout']") == true
					&& isElementPresent("//a[contains(text(),'Change')]") == true) {

				Thread.sleep(4000);
				changeBtn.click();
				Thread.sleep(4000);
				daySelect.click();
				Thread.sleep(4000);

			}

		} catch (Exception e) {

			System.out.println("Restaurant is Closed.........." + e.getMessage());

			String resClosedTxt = resClosed.getText();

			System.out.println("The Restuarant is Closed:    " + resClosedTxt);

			test.log(LogStatus.INFO, "The Restuarant is Closed:    " + resClosedTxt);
		}

		Select daySel = new Select(daySelect);

		try {

			if (isElementPresent(
					"//div[@id='menu_ordersection']/descendant::option[contains(text(),'Today')]") == true) {

				daySel.selectByValue("Today");

				try {

					if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'12:00 AM')]") == true) {
						text = "12:00 AM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'12:30 AM')]") == true) {
						text = "12:30 AM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'01:00 AM')]") == true) {
						text = "1:00 AM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'01:30 AM')]") == true) {
						text = "01:30 AM";

					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'02:00 AM')]") == true) {
						text = "02:00 AM";

						System.out.println("The Slot:  " + tSlot10AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'02:30 AM')]") == true) {
						text = "02:30 AM";

						System.out
								.println("The Slot:  " + tSlot1030AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'03:00 AM')]") == true) {
						text = "03:00 AM";

						System.out.println("The Slot:  " + tSlot11AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'03:30 AM')]") == true) {
						text = "03:30 AM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'04:00 AM')]") == true) {
						text = "04:00 AM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'04:30 AM')]") == true) {
						text = "04:30 AM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'05:00 AM')]") == true) {
						text = "05:00 AM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'05:30 AM')]") == true) {
						text = "05:30 AM";

					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'06:00 AM')]") == true) {
						text = "06:00 AM";

						System.out.println("The Slot:  " + tSlot10AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'06:30 AM')]") == true) {
						text = "06:30 AM";

						System.out
								.println("The Slot:  " + tSlot1030AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'07:00 AM')]") == true) {
						text = "07:00 AM";

						System.out.println("The Slot:  " + tSlot11AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'07:30 AM')]") == true) {
						text = "07:30 AM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'08:00 AM')]") == true) {
						text = "08:00 AM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'08:30 AM')]") == true) {
						text = "08:30 AM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'09:00 AM')]") == true) {
						text = "09:00 AM";

						System.out.println("The Slot:  " + tSlot9AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'09:30 AM')]") == true) {
						text = "09:30 AM";

					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'10:00 AM')]") == true) {
						text = "10:00 AM";

						System.out.println("The Slot:  " + tSlot10AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'10:30 AM')]") == true) {
						text = "10:30 AM";

						System.out
								.println("The Slot:  " + tSlot1030AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'11:00 AM')]") == true) {
						text = "11:00 AM";

						System.out.println("The Slot:  " + tSlot11AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'11:30 AM')]") == true) {
						text = "11:30 AM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'12:00 PM')]") == true) {
						text = "12:00 PM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'12:30 PM')]") == true) {
						text = "12:30 PM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'01:00 PM')]") == true) {
						text = "1:00 PM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'01:30 PM')]") == true) {
						text = "01:30 PM";

					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'02:00 PM')]") == true) {
						text = "02:00 PM";

					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'02:30 PM')]") == true) {
						text = "02:30 PM";

					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'03:00 PM')]") == true) {
						text = "03:00 PM";

						System.out.println("The Slot:  " + tSlot11AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'03:30 PM')]") == true) {
						text = "03:30 PM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'04:00 PM')]") == true) {
						text = "04:00 PM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'04:30 PM')]") == true) {
						text = "04:30 PM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'05:00 PM')]") == true) {
						text = "05:00 PM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'05:30 PM')]") == true) {
						text = "05:30 PM";

					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'06:00 PM')]") == true) {
						text = "06:00 PM";

						System.out.println("The Slot:  " + tSlot10AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'06:30 AM')]") == true) {
						text = "06:30 PM";

						System.out
								.println("The Slot:  " + tSlot1030AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'07:00 PM')]") == true) {
						text = "07:00 PM";

						System.out.println("The Slot:  " + tSlot11AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'07:30 PM')]") == true) {
						text = "07:30 PM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'08:00 PM')]") == true) {
						text = "08:00 PM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'08:30 PM')]") == true) {
						text = "08:30 PM";
					}

					if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'09:00 AM')]") == true) {
						text = "09:00 PM";
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'09:30 AM')]") == true) {
						text = "09:30 PM";

					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'10:00 AM')]") == true) {
						text = "10:00 PM";

						System.out.println("The Slot:  " + tSlot10AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'10:30 AM')]") == true) {
						text = "10:30 PM";

						System.out
								.println("The Slot:  " + tSlot1030AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'11:00 AM')]") == true) {
						text = "11:00 PM";

						System.out.println("The Slot:  " + tSlot11AM.getText() + " is Available for Reservation......");
					}

					else if (isElementPresent(
							"//select[@class='t-order-time']/descendant::option[contains(text(),'11:30 AM')]") == true) {
						text = "11:30 PM";

						timeSelect.click();
						Thread.sleep(2000);
						Select timeSel = new Select(timeSelect);
						Thread.sleep(2000);

						timeSel.selectByVisibleText(text);
					}

				} catch (Exception e) {

					System.out.println("WebElement is unavailable " + e.getMessage());

				}
			}

			else if (isElementPresent(
					"//div[@id='menu_ordersection']/descendant::option[contains(text(),'Tomorrow')]") == true) {

				daySel.selectByValue("Tomorrow");

			}

			try {

				if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'12:00 AM')]") == true) {
					text = "12:00 AM";
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'12:30 AM')]") == true) {
					text = "12:30 AM";
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'01:00 AM')]") == true) {
					text = "1:00 AM";
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'01:30 AM')]") == true) {
					text = "01:30 AM";

				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'02:00 AM')]") == true) {
					text = "02:00 AM";

					System.out.println("The Slot:  " + tSlot10AM.getText() + " is Available for Reservation......");
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'02:30 AM')]") == true) {
					text = "02:30 AM";

					System.out.println("The Slot:  " + tSlot1030AM.getText() + " is Available for Reservation......");
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'03:00 AM')]") == true) {
					text = "03:00 AM";

					System.out.println("The Slot:  " + tSlot11AM.getText() + " is Available for Reservation......");
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'03:30 AM')]") == true) {
					text = "03:30 AM";
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'04:00 AM')]") == true) {
					text = "04:00 AM";
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'04:30 AM')]") == true) {
					text = "04:30 AM";
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'05:00 AM')]") == true) {
					text = "05:00 AM";
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'05:30 AM')]") == true) {
					text = "05:30 AM";

				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'06:00 AM')]") == true) {
					text = "06:00 AM";

					System.out.println("The Slot:  " + tSlot10AM.getText() + " is Available for Reservation......");
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'06:30 AM')]") == true) {
					text = "06:30 AM";

					System.out.println("The Slot:  " + tSlot1030AM.getText() + " is Available for Reservation......");
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'07:00 AM')]") == true) {
					text = "07:00 AM";

					System.out.println("The Slot:  " + tSlot11AM.getText() + " is Available for Reservation......");
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'07:30 AM')]") == true) {
					text = "07:30 AM";
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'08:00 AM')]") == true) {
					text = "08:00 AM";
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'08:30 AM')]") == true) {
					text = "08:30 AM";
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'09:00 AM')]") == true) {
					text = "09:00 AM";

					System.out.println("The Slot:  " + tSlot9AM.getText() + " is Available for Reservation......");
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'09:30 AM')]") == true) {
					text = "09:30 AM";

				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'10:00 AM')]") == true) {
					text = "10:00 AM";

					System.out.println("The Slot:  " + tSlot10AM.getText() + " is Available for Reservation......");
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'10:30 AM')]") == true) {
					text = "10:30 AM";

					System.out.println("The Slot:  " + tSlot1030AM.getText() + " is Available for Reservation......");
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'11:00 AM')]") == true) {
					text = "11:00 AM";

					System.out.println("The Slot:  " + tSlot11AM.getText() + " is Available for Reservation......");
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'11:30 AM')]") == true) {
					text = "11:30 AM";
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'12:00 PM')]") == true) {
					text = "12:00 PM";
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'12:30 PM')]") == true) {
					text = "12:30 PM";
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'01:00 PM')]") == true) {
					text = "1:00 PM";
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'01:30 PM')]") == true) {
					text = "01:30 PM";

				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'02:00 PM')]") == true) {
					text = "02:00 PM";

				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'02:30 PM')]") == true) {
					text = "02:30 PM";

				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'03:00 PM')]") == true) {
					text = "03:00 PM";

					System.out.println("The Slot:  " + tSlot11AM.getText() + " is Available for Reservation......");
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'03:30 PM')]") == true) {
					text = "03:30 PM";
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'04:00 PM')]") == true) {
					text = "04:00 PM";
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'04:30 PM')]") == true) {
					text = "04:30 PM";
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'05:00 PM')]") == true) {
					text = "05:00 PM";
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'05:30 PM')]") == true) {
					text = "05:30 PM";

				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'06:00 PM')]") == true) {
					text = "06:00 PM";

				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'06:30 AM')]") == true) {
					text = "06:30 PM";

				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'07:00 PM')]") == true) {
					text = "07:00 PM";

				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'07:30 PM')]") == true) {
					text = "07:30 PM";
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'08:00 PM')]") == true) {
					text = "08:00 PM";
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'08:30 PM')]") == true) {
					text = "08:30 PM";
				}

				if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'09:00 AM')]") == true) {
					text = "09:00 PM";
				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'09:30 AM')]") == true) {
					text = "09:30 PM";

				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'10:00 AM')]") == true) {
					text = "10:00 PM";

				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'10:30 AM')]") == true) {
					text = "10:30 PM";

				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'11:00 AM')]") == true) {
					text = "11:00 PM";

				}

				else if (isElementPresent(
						"//select[@class='t-order-time']/descendant::option[contains(text(),'11:30 AM')]") == true) {
					text = "11:30 PM";

					
				}

			} catch (Exception e) {

				System.out.println("WebElement is unavailable " + e.getMessage());

			}
		}

		catch (Throwable e) {

			System.out.println("WebElement is unavailable " + e.getMessage());

		}

		try {

			if (isElementPresent("//div[@id='menu_ordersection']/descendant::label[position()=2]") == true
					&& isElementPresent("//label[@class='ubtn btn_service hide']") == false
					&& orderTakeout.isEnabled()) {

				orderTakeout.click();
				Thread.sleep(2000);
			}
		} catch (Exception e) {

			System.out.println("WebElement TakeOut Button is unavailable " + e.getMessage());
		}

		
		timeSelect.click();
		Thread.sleep(4000);
		Select timeSel = new Select(timeSelect);
		Thread.sleep(4000);

		timeSel.selectByVisibleText(text);
		orderAddtoCart.click();

		Thread.sleep(3000);

		try {
			if (isElementPresent(
					"//input[@data-label='White Rice']/following::span[@class='control_indicator']") == true
					|| isElementPresent(
							"//input[@data-label='Brown Rice']/following::span[@class='control_indicator']") == true) {

				radioWhiteBtn.click();
				Thread.sleep(2000);
			}
		} catch (Exception e) {

			System.out.println("WebElement White Rice Radio Button is unavailable " + e.getMessage());
		}

		try {
			if (isElementPresent("//input[@data-label='White Meat']/following::span[@class='control_indicator']") == true) {

				checkBoxWhiteMeat.click();

			}
		} catch (Exception e) {

			System.out.println("WebElement White Meat Check Box is unavailable " + e.getMessage());
		}

		
		
		addMultiplierBtn.click();
		Thread.sleep(2000);

		String orderQtyTot = addMultiplierTxt.getText();

		int iorderQtyTot = Integer.parseInt(orderQtyTot);
		test.log(LogStatus.INFO, "The Total Quantity is Validated     " + iorderQtyTot);

		String Price = orderPrice$.getText();

		float $Price = Float.parseFloat(Price);
		test.log(LogStatus.INFO, "The Price is Validated     " + $Price);

		float fSubTotAmount = iorderQtyTot * $Price;
		test.log(LogStatus.INFO, "The Sub Total Amount is Validated    " + fSubTotAmount);
		System.out.println("The Sub TotalAmount is:     " + fSubTotAmount);

		Thread.sleep(2000);
		orderAddToOrderBtn.click();

		Thread.sleep(3000);

		String Tax = orderTaxAmt.getText();
		float $Tax = Float.parseFloat(Tax);
		System.out.println("The Tax for the Total:   " + $Tax);
		test.log(LogStatus.INFO, "The Tax Amount is Validated      " + $Tax);

		Thread.sleep(3000);

		float ftotAmount$ = fSubTotAmount + $Tax;
		// double rtotAmount$=Math.nextDown(totAmount$);

		String sTotAmount = totalAmt.getText();
		System.out.println("The Total Amount displayed is:   " + sTotAmount);

		float TotoalAmount$ = Float.parseFloat(sTotAmount);

		if (ftotAmount$ == TotoalAmount$) {
			System.out.println("Total Amount is Right   " + ftotAmount$);
			test.log(LogStatus.INFO,
					"The Total Amount of Order to Check Out Payment is Right and Validated:     " + ftotAmount$);
		} else {
			System.out.println("The Total Amount is wrong  " + ftotAmount$);
			test.log(LogStatus.INFO,
					"The Total Amount of Order to Check Out Payment is wrong and Validated:   " + ftotAmount$);

		}

		act.moveToElement(chkoutTakeoutBtn).build().perform();
		Thread.sleep(3000);

		chkoutTakeoutBtn.click();
		Thread.sleep(3000);

		if (checkOutTitleText.isDisplayed()) {
			System.out.println("Pass:*****" + checkOutTitleText.getText());
			test.log(LogStatus.INFO, "Pass:The Checkout Page is Displayed: " + checkOutTitleText.getText());

		} else {
			test.log(LogStatus.INFO, "Fail:The Checkout Page is Displayed: " + checkOutTitleText.isDisplayed());
			System.out.println("Fail:*****" + checkOutTitleText.isDisplayed());
		}

		System.out.println("The Total Amount of Order to Check Out Payment is: " + sTotAmount);
		test.log(LogStatus.INFO, "The Total Amount of Order to Check Out Payment is Validated: ");

		act.moveToElement(firstName).build().perform();
		Thread.sleep(3000);

		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		splInstrctions.sendKeys(specialinstructions);
		nameOnCard.sendKeys(nameoncard);
		cardNumber.sendKeys(cardnumber);
		expiryMonth.sendKeys(expirymonth);
		expiryYear.sendKeys(expiryyear);
		cvvCode.sendKeys(cvvcode);
		billZip.sendKeys(billingzip);
		c_Phone.sendKeys(phone);
		c_Email.sendKeys(email);

		Thread.sleep(3000);

		act.moveToElement(placeMyOrderBtn).build().perform();

		Thread.sleep(4000);
		placeMyOrderBtn.click();

		Thread.sleep(12000);

		if (orderThankYouText.isEnabled() && (orderThankYouText.isDisplayed())) {

			Actions action = new Actions(driver);
			action.moveToElement(orderThankYouText).build().perform();
			Thread.sleep(3000);

			System.out.println("Pass:***** The:     " + orderThankYouText.getText() + " ********");
			System.out.println("Pass:***** The:     " + receiptNumText.getText() + "************");

			Thread.sleep(2000);

			test.log(LogStatus.INFO,
					"Pass:The Thank You Page:    " + orderThankYouText.getText() + " is Enabled & Displayed: ");
			test.log(LogStatus.INFO, "Pass: Receipt Number   " + receiptNumText.getText() + "   for the Order    ");
		} else {

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Fail:The Checkout Page is not Displayed ****** ");
			System.out.println("Fail: The Checkout Page is not Displayed ******   ");
		}

	}

	public void verifyDeliveryTakeOut() throws InterruptedException {
		
		homePageDwnArw.click();
		Thread.sleep(4000);

		aboutMenu.click();
		Thread.sleep(3000);

		contactTab.click();
		Thread.sleep(4000);
//		rightAddress = rightAddressTxt.getText();


		try {
			if (isElementPresent("//a[contains(text(),'View Menu')]") == true) {

				viewMenu.click();
				Thread.sleep(4000);

				test.log(LogStatus.INFO, " View Menu is Present ");
				System.out.println(" View Menu is Present ");

				try {

					if (isElementPresent("//div[@class='popup_location _p30']") == true && isElementPresent(
							"//div[@class='popup_location _p30']/descendant::a[position()=2]") == true) {

						Thread.sleep(3000);
						btnLocation2.click();

						test.log(LogStatus.INFO, " WebElement Location Window Pop Up is Available ");
						System.out.println(" WebElement Location Window Pop Up is Available ");

						Thread.sleep(4000);

					}

				} catch (Exception e) {

					test.log(LogStatus.INFO, " WebElement Location Window Pop Up is UnAvailable ");
					System.out.println(" WebElement Location Window Pop Up is UnAvailable ");
				}

			}

		} catch (Exception e) {

			System.out.println("WebElement View Menu is unavailable " + e.getMessage());
		}

		
		try {
			if (isElementPresent("//a[contains(text(),'order online')]") == true
					&& isElementPresent("//label[@class='ubtn btn_service hide']") == false) {

				orderOnlineTab.click();
				try {

					if (isElementPresent("//div[@class='popup_location _p30']") == true && isElementPresent(
							"//div[@class='popup_location _p30']/descendant::a[position()=2]") == true) {

						Thread.sleep(3000);
						btnLocation2.click();

						Thread.sleep(4000);

					}

				} catch (Exception e) {

					System.out.println("Web Element not Available");
				}
			}

		} catch (Exception e) {

			System.out.println("WebElement Order Online Tab  is unavailable " + e.getMessage());
		}


		Thread.sleep(2000);

		try {
			if (isElementPresent("//div[@id='menu_ordersection']/descendant::label[@for='t_delivery']") == true) {

				if (btnOrderDelivery.isDisplayed()) {

					test.log(LogStatus.INFO, "Pass: Delivery is Supported in this Restaurant");
					System.out.println("Pass: Delivery is Supported in this Restaurant");

					btnOrderDelivery.click();
					orderAddtoCart.click();

					Thread.sleep(4000);
				}
				if (!btnOrderDelivery.isDisplayed()) {

					System.out.println(
							" Delivery is not Supported in this Restaurant and Hence Delivery Button is not Displayed ");

					test.log(LogStatus.INFO,
							" Delivery is not Supported in this Restaurant and Hence Delivery Button is not Displayed ");
				}
			}
		}

		catch (Exception e) {
			System.out.println(
					" Delivery is not Supported in this Restaurant and Hence Delivery Button is not Displayeded ");

			test.log(LogStatus.INFO,
					" Delivery is not Supported in this Restaurant and Hence Delivery Button is not Displayeded ");

		}

		//
		// try {
		// if
		// (isElementPresent("//div[@id='menu_ordersection']/descendant::label[@for='t_delivery']")
		// == true) {
		//
		// btnOrderDelivery.click();
		//
		// }
		// } catch (Exception e) {
		// System.out.println("WebElement Delivery Button is unavailable " +
		// e.getMessage());
		// }

		// if
		// (isElementPresent("//label[@for='t_delivery']/descendant::i[position()=1]")
		// == true
		// &&
		// isElementPresent("//div[@id='menu_ordersection']/descendant::label[position()=2]")
		// == true
		// && isElementPresent("//label[@class='ubtn btn_service hide']") == false) {
		//
		// try {
		// if
		// (isElementPresent("//div[@id='menu_ordersection']/descendant::label[@for='t_delivery']")
		// == true
		// &&
		// isElementPresent("//div[@id='menu_ordersection']/descendant::label[@for='t_takeout']")
		// == true) {
		// btnOrderTakeout.click();
		//
		// Thread.sleep(4000);
		//
		// btnOrderDelivery.click();
		// }
		// } catch (Exception e) {
		// System.out.println("WebElement Delivery Button or Takeout Button is
		// unavailable " + e.getMessage());
		// }

		try {
			if (isElementPresent("//a[contains(text(),'verify & proceed to order')]") == true

					&& orderVerifyProceed.isDisplayed()) {

				orderSearchTxtFld.sendKeys(rightAddress);
				Thread.sleep(4000);

				orderVerifyProceed.click();
				Thread.sleep(3000);

				try {
					if (addtocartAddr.isDisplayed()) {

						Thread.sleep(1000);
						test.log(LogStatus.INFO,
								"This Address  " + rightAddress + "  within the Delivery Boundary......   ");
						addOrderCloseSymbol.click();
					} else {

						test.log(LogStatus.INFO, " Address is Unavailable  ");
						addOrderCloseSymbol.click();
					}
				} catch (Exception e) {

					System.out.println("WebElement Verify & Proceed is unavailable " + e.getMessage());
				}

				test.log(LogStatus.INFO, "This Address  " + rightAddress + "  within the Delivery Boundary......   ");
				addOrderCloseSymbol.click();

				Thread.sleep(3000);

				System.out.println(
						"Pass: Delivery Window Popped Up (Condition: Delivery Button is Clicked from TakeOut Order Button / Add to Cart Button is Clicked ");
				test.log(LogStatus.INFO,
						"Pass: Delivery Window Popped Up (Condition: Delivery Button is Clicked from TakeOut Order Button / Cart is Button Clicked )");

			}

		} catch (Exception e) {

			System.out.println(
					"Fail: Delivery Window has not Popped Up (Condition: Delivery Button is Clicked from TakeOut Order Button / Add to Cart Button is Clicked ");
			test.log(LogStatus.INFO,
					"Fail: Delivery Window has not Popped Up (Condition: Delivery Button is Clicked from TakeOut Order Button / Add to Cart Button is Clicked ");

		}

		// Mode: Delivery

		if (btnOrderDelivery.isDisplayed()) {

			if (orderDeliveryAddrText.isDisplayed()) {

				test.log(LogStatus.INFO, "Pass: Address Text is available.........");
				System.out.println("Pass: Address Text is available......... ");

			} else {
				test.log(LogStatus.INFO, "Fail: Address Text is not available.........");
				System.out.println("Fail: Address Text is not available......... ");

			}
		}

		if (btnOrderDelivery.isDisplayed()) {

			if (isElementPresent("//div[@id='menu_ordersection']/div[2]/descendant::p[position()=1]") == true) {

				if (zeroMilesText.isDisplayed()) {

					test.log(LogStatus.INFO, "Pass: Zero Miles Text is available.........");
					System.out.println("Pass: Zero Miles Text is available......... ");

				}

				else {
					test.log(LogStatus.INFO, "Fail: Zero Miles Text is available.........");
					System.out.println("Fail: Zero Miles Text is available......... ");

				}
			}
		}

		if (isElementPresent("//div[@class='box_expectedtime _fs14']") == true) {

			String ExpTimeTxt = expTimeTxt.getText();
			System.out.println("Pass: Order Summary Expected Time of Delivery " + ExpTimeTxt + " is Displayed");
			test.log(LogStatus.INFO, "Pass:  Order Summary Expected Time of Delivery  " + ExpTimeTxt + " is Displayed");

		} else {
			String ExpTimeTxt = expTimeTxt.getText();
			System.out.println("Fail: Order Summary Expected Time of Delivery    " + ExpTimeTxt + " is not Displayed ");
			test.log(LogStatus.INFO,
					"Fail:  Order Summary Expected Time of Delivery " + ExpTimeTxt + " is not Displayed ");
		}

		Actions act = new Actions(driver);
		act.moveToElement(delChargesTxt).build().perform();

		if (btnOrderDelivery.isDisplayed()) {
			try {
				if (isElementPresent("//div[contains(text(),'Delivery')]") == true) {

					if (delChargesTxt.isDisplayed()) {

						act.moveToElement(delChargesTxt).build().perform();
						test.log(LogStatus.INFO,
								"Pass: As Mode is Delivery - Delivery Charges are available before Check Out   ");
						System.out.println(
								"Pass: As Mode is Delivery - Delivery Charges are available before Check Out  ");

					} else {

						test.log(LogStatus.INFO,
								"Fail: As Mode is Delivery - Delivery Charges is not available before for Check Out ");
						System.out.println(
								"Fail: As Mode is Delivery - Delivery Charges is not available before Check Out  ");

					}

				}

			} catch (Exception e) {

				test.log(LogStatus.INFO,
						"Fail: As Mode is Delivery - Delivery Charges is not available before for Check Out ");
				System.out.println("Fail: As Mode is Delivery - Delivery Charges is not available before Check Out  ");

			}
		}

		Thread.sleep(4000);
		if (btnOrderDelivery.isDisplayed()) {
			try {
				if (isElementPresent("//div[contains(text(),'Tip Amount')]") == true) {

					if (tipAmtText.isDisplayed()) {

						test.log(LogStatus.INFO,
								"Pass: As Mode is Delivery - Tip Amount is available before Check Out   ");
						System.out.println("Pass: As Mode is Delivery - Tip Amount is available before Check Out  ");

					} else {

						test.log(LogStatus.INFO,
								"Fail: As Mode is Delivery - Tip Amount is not available before for Check Out ");
						System.out
								.println("Fail: As Mode is Delivery - Tip Amount is not available before Check Out  ");

					}

				}
			} catch (Exception e) {

				test.log(LogStatus.INFO,
						"Fail: As Mode is Delivery - Tip Amount is not available before for Check Out ");
				System.out.println("Fail: As Mode is Delivery - Tip Amount is not available before Check Out  ");

			}
		}

		if (btnOrderDelivery.isEnabled() && btnOrderDelivery.isDisplayed()) {

			test.log(LogStatus.INFO, "Passed: Delivery is selected by Default  ");
			System.out.println("Pass: Delivery is selected by Default  ");

		} else {

			test.log(LogStatus.INFO, " Delivery is not selected by Default  ");
			System.out.println(" Delivery is not selected by Default  ");

		}

		// Mode: Take Out

		act.moveToElement(menuTab).build().perform();

		try {
			if (isElementPresent("//div[@id='menu_ordersection']/descendant::label[@for='t_takeout']") == true) {

				if (btnOrderTakeout.isDisplayed()) {

					test.log(LogStatus.INFO, "Pass: Take Out Button is  Available....");
					System.out.println("Pass: Take Out Button is Available....");

					act.moveToElement(menuTab).build().perform();
					Thread.sleep(4000);

					btnOrderTakeout.click();

					Thread.sleep(4000);
				} else {

					test.log(LogStatus.INFO, "Fail: Take Out Button is not Available....");
					System.out.println(" Take Out Button is not Available....");

				}

				try {
					if (isElementPresent("//div[contains(text(),'Delivery')]")) {

						if (!delChargesTxt.isDisplayed()) {

							test.log(LogStatus.INFO,
									"Pass: As Mode is Take Out - Delivery Charges are not available before Check Out   ");
							System.out.println(
									"Pass: As Mode is Take Out - Delivery Charges are not available before Check Out  ");

						}
					}
				} catch (Exception e) {

					test.log(LogStatus.INFO,
							"Fail: Though Mode is Take Out - Delivery Charges are available before for Check Out ");
					System.out.println(
							"Fail: Though Mode is Take Out - Delivery Charges are available before Check Out  ");

				}

				try {
					if (isElementPresent("//div[contains(text(),'Tip Amount')]")) {

						if (!tipAmtText.isDisplayed()) {

							test.log(LogStatus.INFO,
									"Pass: As Mode is Take Out - Tip Amount is not available before Check Out   ");
							System.out.println(
									"Pass: As Mode is Take Out - Tip Amount is not available before Check Out  ");

						}
					}
				} catch (Exception e) {

					test.log(LogStatus.INFO,
							"Fail: Though Mode is Take Out - Tip Amount is available before for Check Out ");
					System.out.println("Fail: Though Mode is Take Out - Tip Amount is available before Check Out  ");

				}

				Thread.sleep(4000);

				act.moveToElement(btnOrderDelivery).build().perform();
				Thread.sleep(4000);

				try {
					if (isElementPresent("//div[@id='menu_ordersection']/div[2]/descendant::p[position()=2]")) {

						if (!orderDeliveryAddrText.isDisplayed()) {

							test.log(LogStatus.INFO,
									"Pass: As Mode is Take Out Address Text is not available.........");
							System.out.println("Pass: As Mode is Take Out Address Text is not available......... ");

						}
					}

				} catch (Exception e) {

					test.log(LogStatus.INFO, "Fail : Though Mode is Take Out Address Text is available   .........");
					System.out.println("Fail:Though Mode is Take Out Address Text is available  ......... ");

				}
			}

		} catch (Exception e) {

			test.log(LogStatus.INFO, " Take Out Button Web Element is not Available....");
			System.out.println(" Take Out Button Web Element is not Available....");
		}

		// String orderTakeOutText=onlyTakeout.getText();

		Thread.sleep(3000);

		if (isElementPresent("//p[@class='but_order_type txt_order_onlytakeout']") == true) {

			test.log(LogStatus.INFO, "Pass: TakeOut is Supported in this Restaurant");
			System.out.println("Pass: TakeOut is Supported in this Restaurant");

			Thread.sleep(4000);
			String orderTakeOutText = onlyTakeout.getText();

			if (orderTakeOutText.equals(orderTakeOutText)) {

				System.out.println(
						"Pass: TakeOut Text is rightly Showing  when Delivery is not supported as only Take Out is Supported ");
				test.log(LogStatus.INFO,
						"Pass: TakeOut Text is rightly Showing  when Delivery is not supported as only Take Out is Supported ");

			} else {

				System.out.println(
						"Fail: TakeOut Text is not rightly Showing when Delivery is not supported as only Take Out is Supported ");
				test.log(LogStatus.INFO,
						"Fail: TakeOut Text is not rightly Showing when Delivery is not supported as only Take Out is Supported ");
			}
		}

		// if (deliveryButton.isEnabled()) {
		//
		// test.log(LogStatus.INFO, "Passed: Delivery is selected by Default ");
		// System.out.println("Passed: Delivery is selected by Default ");
		//
		// } else {
		//
		// test.log(LogStatus.INFO, "Fail: Delivery is not selected by Default ");
		// System.out.println("Fail: Delivery is not selected by Default ");
		//

		if (isElementPresent("//div[@id='menu_ordersection']/descendant::label[@for='t_delivery']") == true
				&& isElementPresent("//div[@id='menu_ordersection']/descendant::label[@for='t_takeout']") == true) {

			if (btnOrderDelivery.isDisplayed() && btnOrderTakeout.isDisplayed()) {
				System.out.println(" Both Delivery and Take Out is supported in this Restaurant ");

				test.log(LogStatus.INFO, " Both Delivery and Take Out is supported in this Restaurant");
			}
			if (btnOrderDelivery.isDisplayed() && btnOrderDelivery.isEnabled()) {

				test.log(LogStatus.INFO, "Pass: Delivery is selected by Default  ");
				System.out.println("Pass: Delivery is selected by Default  ");

			} else {

				test.log(LogStatus.INFO, " Delivery is not selected by Default  ");
				System.out.println("Delivery is not selected by Default  ");

			}

			if (!btnOrderDelivery.isDisplayed() && !btnOrderTakeout.isDisplayed() && !onlyTakeout.isDisplayed()) {

				System.out.println(" Both Delivery and Take Out is not supported in this Restaurant ");
				test.log(LogStatus.INFO, "Both Delivery and Take Out is not supported in this Restaurant ");
			}

		}

		// System.out.println("Failed: Both Delivery and Take Out is not supported in
		// this Restaurant ");

	}

	public boolean verifyDeliveryPopup() throws InterruptedException {
		try {
			if (isElementPresent("//a[contains(text(),'View Menu')]") == true) {

				viewMenu.click();
				Thread.sleep(4000);

				test.log(LogStatus.INFO, " View Menu is Present...");

				System.out.println(" View Menu is Present ");

				try {

					if (isElementPresent("//div[@class='popup_location _p30']") == true && isElementPresent(
							"//div[@class='popup_location _p30']/descendant::a[position()=2]") == true) {

						Thread.sleep(3000);
						btnLocation2.click();

						test.log(LogStatus.INFO, " WebElement Location Window Pop Up is Available ");
						System.out.println(" WebElement Location Window Pop Up is Available ");

						Thread.sleep(4000);

					}

				} catch (Exception e) {

					test.log(LogStatus.INFO, " WebElement Location Window Pop Up is UnAvailable ");
					System.out.println("  WebElement Location Window Pop Up is UnAvailable ");
				}

			}

		} catch (Exception e) {

			System.out.println("WebElement View Menu is unavailable " + e.getMessage());
		}

		try {
			if (isElementPresent("//a[contains(text(),'order online')]") == true
					&& isElementPresent("//label[@class='ubtn btn_service hide']") == false) {

				orderOnlineTab.click();
				try {

					if (isElementPresent("//div[@class='popup_location _p30']") == true && isElementPresent(
							"//div[@class='popup_location _p30']/descendant::a[position()=2]") == true) {

						Thread.sleep(3000);
						btnLocation2.click();

						Thread.sleep(4000);

					}

				} catch (Exception e) {

					System.out.println("Web Element not Available");
				}
			}

		} catch (Exception e) {

			System.out.println("WebElement Order Online Tab  is unavailable " + e.getMessage());
		}

		Thread.sleep(2000);

	
		try {
			if (isElementPresent("//div[@id='menu_ordersection']/descendant::label[@for='t_delivery']") == true) {

				btnOrderDelivery.click();
				orderAddtoCart.click();
			}
		} catch (Exception e) {
			System.out.println("Fail: WebElement Delivery Button is unavailable " + e.getMessage());
		}

		

		Thread.sleep(2000);

		if (isElementPresent("//a[contains(text(),'verify & proceed to order')]") == true
				&& orderVerifyProceed.isDisplayed()) {

			Thread.sleep(2000);
			System.out.println(
					"Pass: Delivery Window Popped Up When the Delivery Button is Clicked from TakeOut Order Button (Condition: When TakeOut was checked");
			test.log(LogStatus.INFO,
					"Pass: Delivery Window Popped Up When the Delivery Button is Clicked from TakeOut Order Button (Condition: When TakeOut was checked)");

		} else {
			System.out.println(
					"Fail: Delivery Window has notPopped Up When the Delivery Button is Clicked from TakeOut Order Button (Condition: When TakeOut was checked)");
			test.log(LogStatus.INFO,
					"Fail: Delivery Window has notPopped Up When the Delivery Button is Clicked from TakeOut Order Button (Condition: When TakeOut was checked)");

		}

		System.out.println(orderVerifyProceed.isDisplayed());
		return isElementPresent("//a[contains(text(),'verify & proceed to order')]");
	}

	public static boolean isElementPresent(String locator) {

		try {
			driver.findElement(By.xpath(locator));
			return true;

		} catch (Throwable t) {

			return false;

		}

	}

	public void verifyAutoSuggestion() {

		try {
			if (isElementPresent("//a[contains(text(),'View Menu')]") == true) {

				viewMenu.click();
				Thread.sleep(4000);

				test.log(LogStatus.INFO, "Pass: View Menu is Present ");
				System.out.println("Passed:Pass: View Menu is Present ");

				try {

					if (isElementPresent("//div[@class='popup_location _p30']") == true && isElementPresent(
							"//div[@class='popup_location _p30']/descendant::a[position()=2]") == true) {

						Thread.sleep(3000);
						btnLocation2.click();

						test.log(LogStatus.INFO, "Pass: WebElement Location Window Pop Up is Available ");
						System.out.println("Pass: WebElement Location Window Pop Up is Available ");

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
			if (isElementPresent("//a[contains(text(),'order online')]") == true
					&& isElementPresent("//label[@class='ubtn btn_service hide']") == false) {

				orderOnlineTab.click();
				try {

					if (isElementPresent("//div[@class='popup_location _p30']") == true && isElementPresent(
							"//div[@class='popup_location _p30']/descendant::a[position()=2]") == true) {

						Thread.sleep(3000);
						btnLocation2.click();

						Thread.sleep(4000);

					}

				} catch (Exception e) {

					System.out.println("Web Element not Available");
				}
			}

		} catch (Exception e) {

			System.out.println("WebElement Order Online Tab  is unavailable " + e.getMessage());
		}


		try {
			if (isElementPresent("//div[@id='menu_ordersection']/descendant::label[@for='t_delivery']") == true) {

				btnOrderDelivery.click();
				orderAddtoCart.click();
			}
		} catch (Exception e) {
			System.out.println("WebElement Delivery Button is unavailable " + e.getMessage());
		}

		try {
			if (isElementPresent("//a[contains(text(),'verify & proceed to order')]") == true
					&& orderVerifyProceed.isDisplayed()) {

				Thread.sleep(4000);
				orderSearchTxtFld.sendKeys("1");
				orderSearchTxtFld.sendKeys("");
				orderSearchTxtFld.sendKeys("19");
				Thread.sleep(3000);

				orderSearchTxtFld.sendKeys(Keys.ENTER);
				Thread.sleep(4000);

				// try {
				if (isElementPresent("//span[@class='pac-matched']") == true) {

					Thread.sleep(5000);
					System.out.println(
							"Pass: Delivery Address Auto Suggestion List has Displayed when Address got entered");
					test.log(LogStatus.INFO,
							"Pass: Delivery Address Auto Suggestion List has Displayed when Address got entered");
				} else {

					System.out.println("Fail: WebElement Auto Suggestion is unavailable ");
					test.log(LogStatus.INFO,
							"Fail: Delivery Address Auto Suggestion List has not Displayed when Address got entered");

				}
				// } catch (Exception e) {
				//
				// System.out.println("Failed: WebElement Auto Suggestion is unavailable " +
				// e.getMessage());
				// }
			}
		} catch (Exception e) {

			System.out.println("WebElement Verify and Proceed Order is unavailable " + e.getMessage());
		}

	}

	public boolean verifyTakeoutBtn() throws InterruptedException {

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
			if (isElementPresent("//a[contains(text(),'order online')]") == true
					&& isElementPresent("//label[@class='ubtn btn_service hide']") == false) {

				orderOnlineTab.click();
				try {

					if (isElementPresent("//div[@class='popup_location _p30']") == true && isElementPresent(
							"//div[@class='popup_location _p30']/descendant::a[position()=2]") == true) {

						Thread.sleep(3000);
						btnLocation2.click();

						Thread.sleep(4000);

					}

				} catch (Exception e) {

					System.out.println("Web Element not Available");
				}
			}

		} catch (Exception e) {

			System.out.println("WebElement Order Online Tab  is unavailable " + e.getMessage());
		}

		try {
			if (isElementPresent("//div[@id='menu_ordersection']/descendant::label[@for='t_takeout']") == true

					&& isElementPresent("//div[@id='menu_ordersection']/descendant::label[@for='t_delivery']") == true
					&& isElementPresent("//label[@class='ubtn btn_service hide']") == false) {

				btnOrderTakeout.click();
			}
		} catch (Exception e) {

			System.out.println("WebElement Order Online Tab is unavailable " + e.getMessage());
		}
		try {

			if (isElementPresent("//div[@class='box_expectedtime _fs14']") == true) {

				String ExpTimeTxt = expTimeTxt.getText();
				System.out.println("Pass: Order Summary Changed to Take Out Mode " + ExpTimeTxt + " is Displayed");
				test.log(LogStatus.INFO,
						"Pass:  Order Summary Changed to Take Out Mode  " + ExpTimeTxt + " is Displayed");

			} else {
				String ExpTimeTxt = expTimeTxt.getText();
				System.out.println(
						"Fail: Order Summary is not Changed to Take Out Mode    " + ExpTimeTxt + " is not Displayed ");
				test.log(LogStatus.INFO,
						"Fail:  Order Summary Changed is not to Take Out Mode   " + ExpTimeTxt + " is not Displayed ");
			}

		} catch (Exception e) {

			System.out.println("WebElement Order Online Tab is unavailable " + e.getMessage());
		}

		// gallerypage.verifyContactsLink();
		Thread.sleep(4000);

		// String restAddressText = rightAddressTxt.getText();

		// rightAddress = rightAddressTxt.getText();
		// orderOnlineTab.click();

		Thread.sleep(3000);

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
		Thread.sleep(5000);

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
		Thread.sleep(6000);

		System.out.println("Pass: Final Add To Order is Clicked ");
		test.log(LogStatus.INFO, "Pass: Final Add To Order is Clicked ");

		if (orderDeliveryBtn.isEnabled()) {
			System.out.println("Pass......" + orderDeliveryBtn.isEnabled());
			test.log(LogStatus.INFO, "Passed Delivery Button is Enabled" + orderDeliveryBtn
					+ " as Default, when Take Out Button is Enabled");
		} else {
			System.out.println("Fail....." + orderTakeout.isSelected());
			test.log(LogStatus.INFO, "Failed TakeOut Button is Disabled though Take Out Button is Enabled");
		}
		return orderTakeout.isEnabled();

	}

	public void deliveryNoChangeText() throws InterruptedException {
		
		homePageDwnArw.click();
		Thread.sleep(4000);

		aboutMenu.click();
		Thread.sleep(3000);

		contactTab.click();
		Thread.sleep(4000);

//		rightAddress = rightAddressTxt.getText();
		

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
			if (isElementPresent("//a[contains(text(),'order online')]") == true
					&& isElementPresent("//label[@class='ubtn btn_service hide']") == false) {

				orderOnlineTab.click();
				try {

					if (isElementPresent("//div[@class='popup_location _p30']") == true && isElementPresent(
							"//div[@class='popup_location _p30']/descendant::a[position()=2]") == true) {

						Thread.sleep(3000);
						btnLocation2.click();

						Thread.sleep(4000);

					}

				} catch (Exception e) {

					System.out.println("Web Element not Available");
				}
			}

		} catch (Exception e) {

			System.out.println("WebElement Order Online Tab  is unavailable " + e.getMessage());
		}

		// && isElementPresent("//label[@class='ubtn btn_service hide']") == false
		try {
			if (isElementPresent("//div[@id='menu_ordersection']/descendant::label[@for='t_delivery']") == true
					&& isElementPresent(
							"//div[@id='menu_ordersection']/descendant::label[@for='t_delivery']") == true) {

				Actions act = new Actions(driver);
				act.moveToElement(changeBtn).build().perform();

				Thread.sleep(3000);

				btnOrderDelivery.click();
				Thread.sleep(4000);

				act.moveToElement(changeBtn).build().perform();
				Thread.sleep(5000);
				String expTxt = deliveryNoChangeTxt.getText();

				System.out.println(" Delivery Text Before Clicking Take Out Button " + expTxt);
				test.log(LogStatus.INFO, " Delivery Text Before Clicking Take Out Button " + expTxt);

				act.moveToElement(changeBtn).build().perform();
				Thread.sleep(3000);

				btnOrderTakeout.click();

				btnOrderDelivery.click();
				Thread.sleep(4000);
			}

		}

		catch (Exception e) {

			test.log(LogStatus.INFO,
					"Fail: WebElement Delivery and Take Out Button is UnAvailable in this Restaurtant  ");
			System.out.println("Fail: WebElement Delivery and Take Out Button is UnAvailable " + e.getMessage());

		}

		try {
			if (isElementPresent("//a[contains(text(),'verify & proceed to order')]") == true) {
				orderSearchTxtFld.sendKeys(rightAddress);
				orderVerifyProceed.click();
				Thread.sleep(1000);
				test.log(LogStatus.INFO, "This Address  " + rightAddress + "  within the Delivery Boundary......   ");
				addOrderCloseSymbol.click();
			}
		} catch (Exception e) {
			System.out.println("WebElement Verify & Proceed is unavailable " + e.getMessage());
		}

		Thread.sleep(5000);

		Actions act = new Actions(driver);
		act.moveToElement(changeBtn).build().perform();

		Thread.sleep(5000);

		String expTxt = deliveryNoChangeTxt.getText();

		if (expTxt.contains(expTxt)) {

			System.out.println(
					"Pass: Delivery Text are Same After Clicking Take Out Button and Back delivery Button " + expTxt);
			test.log(LogStatus.INFO,
					"Pass: Delivery Text are Same After Clicking Take Out Button and Back delivery Button " + expTxt);
		} else {

			System.out
					.println("Fail: Delivery Text are not Same After Clicking Take Out Button and Back delivery Button "
							+ expTxt);
			test.log(LogStatus.INFO,
					"Pass: Delivery Text are not Same After Clicking Take Out Button and Backdelivery Button "
							+ expTxt);

		}

	}

	public void verifyZeroMilesAddr() throws InterruptedException {

		homePageDwnArw.click();
		Thread.sleep(4000);

		aboutMenu.click();
		Thread.sleep(3000);

		contactTab.click();
		Thread.sleep(4000);

//		rightAddress = rightAddressTxt.getText();

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
			if (isElementPresent("//a[contains(text(),'order online')]") == true
					&& isElementPresent("//label[@class='ubtn btn_service hide']") == false) {

				orderOnlineTab.click();
				try {

					if (isElementPresent("//div[@class='popup_location _p30']") == true && isElementPresent(
							"//div[@class='popup_location _p30']/descendant::a[position()=2]") == true) {

						Thread.sleep(3000);
						btnLocation2.click();

						Thread.sleep(4000);

					}

				} catch (Exception e) {

					System.out.println("Web Element not Available");
				}
			}

		} catch (Exception e) {

			System.out.println("WebElement Order Online Tab  is unavailable " + e.getMessage());
		}


		// && isElementPresent("//label[@class='ubtn btn_service hide']") == false
		try {
			if (isElementPresent("//div[@id='menu_ordersection']/descendant::label[@for='t_delivery']") == true) {

				Actions act = new Actions(driver);
				act.moveToElement(btnOrderDelivery).build().perform();
				Thread.sleep(3000);

				btnOrderDelivery.click();
				Thread.sleep(4000);

				orderAddtoCart.click();
			}
		} catch (Exception e) {
			System.out.println("WebElement Delivery Button is unavailable " + e.getMessage());
		}

		try {
			if (isElementPresent("//a[contains(text(),'verify & proceed to order')]") == true) {
				orderSearchTxtFld.sendKeys(rightAddress);
				orderVerifyProceed.click();
				try {
					if (addtocartAddr.isDisplayed()) {

						Thread.sleep(1000);
						test.log(LogStatus.INFO,
								"This Address  " + rightAddress + "  within the Delivery Boundary......   ");
						addOrderCloseSymbol.click();
					} else {

						test.log(LogStatus.INFO, " Address is Unavailable  ");
						addOrderCloseSymbol.click();
					}
				} catch (Exception e) {

					System.out.println("WebElement Verify & Proceed is unavailable " + e.getMessage());
				}
			}

		} catch (Exception e) {
			System.out.println("WebElement Verify & Proceed is unavailable " + e.getMessage());
		}

		if (isElementPresent("//div[@id='menu_ordersection']/div[2]/descendant::p[position()=1]") == true) {

			String zeroMilesTxt = zeroMilesText.getText();

			test.log(LogStatus.INFO, "Passed: Zero Miles Text  " + zeroMilesTxt + " is available.........");
			System.out.println("Pass: Zero Miles Text  " + zeroMilesTxt + " is available......... ");

		}

		else {

			test.log(LogStatus.INFO,
					"Fail : Zero Miles Text is not available though Delivery is supported in this Restaurant  .........");
			System.out.println(
					"Fail:Zero Miles Text is not available though Delivery is supported in this Restaurant  ......... ");

		}
	}

	public void verifyRightDeliveryAddr() throws InterruptedException {

		homePageDwnArw.click();
		Thread.sleep(4000);

		aboutMenu.click();
		Thread.sleep(3000);

		contactTab.click();
		Thread.sleep(4000);

//		rightAddress = rightAddressTxt.getText();

		try {
			if (isElementPresent("//a[contains(text(),'View Menu')]") == true) {

				viewMenu.click();
				Thread.sleep(4000);

				test.log(LogStatus.INFO, "Pass: View Menu is Present ");
				System.out.println("Passed:Passed: View Menu is Present ");

				try {

					if (isElementPresent("//div[@class='popup_location _p30']") == true && isElementPresent(
							"//div[@class='popup_location _p30']/descendant::a[position()=2]") == true) {

						Thread.sleep(3000);
						btnLocation2.click();

						test.log(LogStatus.INFO, "Pass: WebElement Location Window Pop Up is Available ");
						System.out.println("Passed: WebElement Location Window Pop Up is Available ");

						Thread.sleep(4000);

					}

				} catch (Exception e) {

					test.log(LogStatus.INFO, "Fail: WebElement Location Window Pop Up is UnAvailable ");
					System.out.println(" Fail:  WebElement Location Window Pop Up is UnAvailable ");
				}

			}

		} catch (Exception e) {

			System.out.println("WebElement View Menu is unavailable " + e.getMessage());
		}
		try {
			if (isElementPresent("//a[contains(text(),'order online')]") == true
					&& isElementPresent("//label[@class='ubtn btn_service hide']") == false) {

				orderOnlineTab.click();
				try {

					if (isElementPresent("//div[@class='popup_location _p30']") == true && isElementPresent(
							"//div[@class='popup_location _p30']/descendant::a[position()=2]") == true) {

						Thread.sleep(3000);
						btnLocation2.click();

						Thread.sleep(4000);

					}

				} catch (Exception e) {

					System.out.println("Web Element not Available");
				}
			}

		} catch (Exception e) {

			System.out.println("WebElement Order Online Tab  is unavailable " + e.getMessage());
		}


		try {
			if (isElementPresent("//div[@id='menu_ordersection']/descendant::label[@for='t_delivery']") == true) {

				Actions act = new Actions(driver);
				act.moveToElement(btnOrderDelivery).build().perform();
				Thread.sleep(3000);

				btnOrderDelivery.click();
				Thread.sleep(4000);

				orderAddtoCart.click();
			}
		} catch (Exception e) {
			System.out.println("WebElement Delivery Button is unavailable " + e.getMessage());
		}

		try {
			if (isElementPresent("//a[contains(text(),'verify & proceed to order')]") == true) {
				orderSearchTxtFld.sendKeys(rightAddress);
				orderVerifyProceed.click();

				try {

					if (addtocartAddr.isDisplayed()) {

						Thread.sleep(1000);
						test.log(LogStatus.INFO,
								"This Address  " + rightAddress + "  within the Delivery Boundary......   ");
						addOrderCloseSymbol.click();
					} else {
						Thread.sleep(1000);
						test.log(LogStatus.INFO, "This Address  not Available");
					}
				} catch (Exception e) {
					System.out.println("WebElement Verify & Proceed is unavailable " + e.getMessage());
				}
			}
		} catch (Exception e) {
			System.out.println("WebElement Verify & Proceed is unavailable " + e.getMessage());
		}
	}

	public void verifyWrongDeliveryAddr() throws InterruptedException {

		

		try {
			if (isElementPresent("//a[contains(text(),'View Menu')]") == true) {

				viewMenu.click();
				Thread.sleep(4000);

				test.log(LogStatus.INFO, "Pass: View Menu is Present ");
				System.out.println("Passed:Passed: View Menu is Present ");

				try {

					if (isElementPresent("//div[@class='popup_location _p30']") == true && isElementPresent(
							"//div[@class='popup_location _p30']/descendant::a[position()=2]") == true) {

						Thread.sleep(3000);
						btnLocation2.click();

						test.log(LogStatus.INFO, "Pass: WebElement Location Window Pop Up is Available ");
						System.out.println("Passed: WebElement Location Window Pop Up is Available ");

						Thread.sleep(4000);

					}

				} catch (Exception e) {

					test.log(LogStatus.INFO, "Fail: WebElement Location Window Pop Up is UnAvailable ");
					System.out.println(" Fail:  WebElement Location Window Pop Up is UnAvailable ");
				}

			}

		} catch (Exception e) {

			System.out.println("WebElement View Menu is unavailable " + e.getMessage());
		}

		try {
			if (isElementPresent("//a[contains(text(),'order online')]") == true
					&& isElementPresent("//label[@class='ubtn btn_service hide']") == false) {

				orderOnlineTab.click();
				try {

					if (isElementPresent("//div[@class='popup_location _p30']") == true && isElementPresent(
							"//div[@class='popup_location _p30']/descendant::a[position()=2]") == true) {

						Thread.sleep(3000);
						btnLocation2.click();

						Thread.sleep(4000);

					}

				} catch (Exception e) {

					System.out.println("Web Element not Available");
				}
			}

		} catch (Exception e) {

			System.out.println("WebElement Order Online Tab  is unavailable " + e.getMessage());
		}


		try {
			if (isElementPresent("//div[@id='menu_ordersection']/descendant::label[@for='t_delivery']") == true) {

				Actions act = new Actions(driver);
				act.moveToElement(btnOrderDelivery).build().perform();
				Thread.sleep(3000);

				btnOrderDelivery.click();
				Thread.sleep(4000);

				orderAddtoCart.click();
			}
		} catch (Exception e) {
			System.out.println("WebElement Delivery Button is unavailable " + e.getMessage());
		}

		Thread.sleep(3000);

		try {
			if (isElementPresent("//a[contains(text(),'verify & proceed to order')]") == true
					&& orderVerifyProceed.isDisplayed()) {

				orderSearchTxtFld.sendKeys(wrongAddress);
				orderVerifyProceed.click();
				Thread.sleep(5000);

				System.out.println("This Address  " + wrongAddress + "  is not within the Delivery Boundary......   ");
				test.log(LogStatus.INFO,
						"This Address  " + wrongAddress + "  is not within the Delivery Boundary......   ");
				clsPopup.click();

				// addOrderCloseSymbol.click();
				// orderOnlineTab.click();
				// Thread.sleep(3000);

				// orderAddtoCart.click();
			}
		} catch (Exception e) {
			System.out.println("WebElement verify & proceed to order is unavailable " + e.getMessage());
		}
	}

	public void swapDeliveryTakeout(String Email, String specialInstructions, String nameoncard, String cardnumber,
			String expirymonth, String firstname, String lastname, String phone, String email, String expiryyear,
			String cvvcod, String billingzip) throws InterruptedException {

		Thread.sleep(3000);
		orderOnlineTab.click();

		if (isElementPresent("//a[contains(text(),'Change')]") == false && (!changeBtn.isDisplayed())) {

			String resClosedTxt = resClosed.getText();

			System.out.println("The Restuarant is Closed:    " + resClosedTxt);

			test.log(LogStatus.INFO, "The Restuarant is Closed:    " + resClosedTxt);

		} else {

			Thread.sleep(5000);
			orderTakeout.click();
			Thread.sleep(3000);
			ZonedDateTime zdt = ZonedDateTime.now();
			Thread.sleep(3000);
			System.out.println("The India Zoned Date/Time:   " + zdt);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:hh:mm a");
			String formatzdtDateTime = zdt.format(formatter);

			ZoneId anewYokZoneId = ZoneId.of("America/New_York");

			DateTimeFormatter aformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:hh:mm a");
			ZonedDateTime anyDateTime = zdt.withZoneSameInstant(anewYokZoneId);
			String aformatnyDateTime = anyDateTime.format(aformatter);

			System.out.println("The Time Now at NewYork is:     " + aformatnyDateTime);
			System.out.println("The Time Now at NY is:   " + anyDateTime);

			String[] asplitnyDateTime = aformatnyDateTime.split("AM");
			String astrsplitnyDateTime = asplitnyDateTime[0];

			String[] amsplitNyDateTime = astrsplitnyDateTime.split(":");

			// System.out.println("The String Split is: " + asplitnyDateTime[0]);
			String aStrsplitnyDateTime = amsplitNyDateTime[1] + "." + amsplitNyDateTime[2];
			// String samsplitnyDateTimeAM= aStrsplitnyDateTime.replace(":",".");

			System.out.println("The AM Split is: " + aStrsplitnyDateTime);
			// String[] pmsplitnyDateTime = astrsplitnyDateTime.split(":");
			// String[] amsplitnyDateTime=astrsplitnyDateTime
			// String samsplitnyDateTime=pmsplitnyDateTime[1]+pmsplitnyDateTime[2];

			// System.out.println("The String Split: "+samsplitnyDateTimeAM);

			//

			Double dblccatamsplitnyDateTime = Double.parseDouble(aStrsplitnyDateTime);
			System.out.println("The Double for Date Time:    " + dblccatamsplitnyDateTime);

			System.out.println();
			System.out.println();
			System.out.println();

			// System.out.println("The Final PM Time is: "+ ccatamsplitnyDateTime);

			// System.out.println("The Final AM Split is : "+ amsplitnyDateTime[1]);

			LocalDate lcldate = anyDateTime.toLocalDate();
			System.out.println("The Date Now at NYis:   " + lcldate);

			String sLclDate = lcldate.toString();

			// ZonedDateTime newYorkTime = ZonedDateTime.of(timePoint, newYokZoneId);
			DayOfWeek dayOfWeek = anyDateTime.getDayOfWeek();

			System.out.println("The Value of the Day of the Week is:   " + dayOfWeek.getValue());
			String dow = dayOfWeek.toString();
			Thread.sleep(3000);

			// String dow = dayOfWeek.toString();
			System.out.println("The Day of the Week:   " + dayOfWeek);

			Thread.sleep(4000);
			changeBtn.click();

			Thread.sleep(5000);
			daySelect.click();
			Thread.sleep(4000);
			Select daySel = new Select(daySelect);
			Thread.sleep(3000);
			daySel.selectByVisibleText("Today");

		}

	}

	public void tclickCheckout(String firstname, String lastname, String phone, String email,
			String specialinstructions, String nameoncard, String cardnumber, String expirymonth, String expiryyear,
			String cvvcode, String billingzip) throws InterruptedException {

		// &&entryPopup.isSelected()) {

		// clsPopup= driver.findElement(By.xpath("//html/body/div[3]/div/a"));
		// Point loc= clsPopup.getLocation();
		// System.out.println("Location is: "+loc);

		Thread.sleep(4000);

		Actions act = new Actions(driver);
		act.moveToElement(aboutTxt).build().perform();

		// Thread.sleep(6000);
		// gallerypage.verifyContactsLink();
		// Thread.sleep(4000);

//		rightAddress = rightAddressTxt.getText();
		Thread.sleep(5000);

		act.moveToElement(menuTxt).build().perform();
		Thread.sleep(5000);

		orderOnlineTab.click();

		if (!changeBtn.isDisplayed()) {

			String resClosedTxt = resClosed.getText();

			System.out.println("The Restuarant is Closed:    " + resClosedTxt);

			test.log(LogStatus.INFO, "The Restuarant is Closed:    " + resClosedTxt);

		} else {

			Thread.sleep(5000);
			orderTakeout.click();
			Thread.sleep(3000);

			orderAddtoCart.click();

			// radioWhiteBtn.click();

			addMultiplierBtn.click();
			Thread.sleep(5000);

			String orderQtyTot = addMultiplierTxt.getText();

			int iorderQtyTot = Integer.parseInt(orderQtyTot);
			test.log(LogStatus.INFO, "The Total Quantity is Validated     " + iorderQtyTot);

			String Price = orderPrice$.getText();

			Double $Price = Double.parseDouble(Price);
			test.log(LogStatus.INFO, "The Price is Validated     " + $Price);

			Double dblSubTotAmount = iorderQtyTot * $Price;
			test.log(LogStatus.INFO, "The Sub Total Amount is Validated    " + dblSubTotAmount);
			System.out.println("The Sub TotalAmount is:     " + dblSubTotAmount);

			Thread.sleep(6000);
			orderAddToOrderBtn.click();
			Thread.sleep(6000);
		}

		ZonedDateTime zdt = ZonedDateTime.now();
		Thread.sleep(3000);
		System.out.println("The India Zoned Date/Time:   " + zdt);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:hh:mm a");
		String formatzdtDateTime = zdt.format(formatter);

		ZoneId anewYokZoneId = ZoneId.of("America/New_York");

		DateTimeFormatter aformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:hh:mm a");
		ZonedDateTime anyDateTime = zdt.withZoneSameInstant(anewYokZoneId);
		String aformatnyDateTime = anyDateTime.format(aformatter);

		System.out.println("The Time Now at NewYork is:     " + aformatnyDateTime);
		System.out.println("The Time Now at NY is:   " + anyDateTime);

		String[] asplitnyDateTime = aformatnyDateTime.split("AM");
		String astrsplitnyDateTime = asplitnyDateTime[0];

		String[] amsplitNyDateTime = astrsplitnyDateTime.split(":");

		// System.out.println("The String Split is: " + asplitnyDateTime[0]);
		String aStrsplitnyDateTime = amsplitNyDateTime[1] + "." + amsplitNyDateTime[2];
		// String samsplitnyDateTimeAM= aStrsplitnyDateTime.replace(":",".");

		System.out.println("The AM Split is: " + aStrsplitnyDateTime);
		// String[] pmsplitnyDateTime = astrsplitnyDateTime.split(":");
		// String[] amsplitnyDateTime=astrsplitnyDateTime
		// String samsplitnyDateTime=pmsplitnyDateTime[1]+pmsplitnyDateTime[2];

		// System.out.println("The String Split: "+samsplitnyDateTimeAM);

		//

		Double dblccatamsplitnyDateTime = Double.parseDouble(aStrsplitnyDateTime);
		System.out.println("The Double for Date Time:    " + dblccatamsplitnyDateTime);

		System.out.println();
		System.out.println();
		System.out.println();

		// System.out.println("The Final PM Time is: "+ ccatamsplitnyDateTime);

		// System.out.println("The Final AM Split is : "+ amsplitnyDateTime[1]);

		LocalDate lcldate = anyDateTime.toLocalDate();
		System.out.println("The Date Now at NYis:   " + lcldate);

		String sLclDate = lcldate.toString();

		// ZonedDateTime newYorkTime = ZonedDateTime.of(timePoint, newYokZoneId);
		DayOfWeek dayOfWeek = anyDateTime.getDayOfWeek();

		System.out.println("The Value of the Day of the Week is:   " + dayOfWeek.getValue());
		String dow = dayOfWeek.toString();
		Thread.sleep(3000);

		// String dow = dayOfWeek.toString();
		System.out.println("The Day of the Week:   " + dayOfWeek);

		Thread.sleep(6000);
		changeBtn.click();

		Thread.sleep(5000);
		daySelect.click();
		Thread.sleep(5000);
		Select daySel = new Select(daySelect);
		Thread.sleep(4000);
		daySel.selectByVisibleText("Today");

		// WebElement curToday = dateTakeout.findElement(By.tagName("option"));

		//
		// if (curToday.getAttribute("value").contains(sLclDate) &&
		// txtToday.contains("Tomorrow")) {

		// String timeSlotsTxt=tSlot900AM.getText()
		try {
			if (dow.contains("SATURDAY") && isElementPresent(
					"//div[@class='txt_contactdetail y-resCalender']/descendant::div[contains(text(),'9:00 AM to 9:00 PM')]") == true) {
			}
		} catch (Exception e) {
			System.out.println("Web Element Not Found:   " + e.getMessage());
		}

		if (aformatnyDateTime.endsWith("PM") && dblccatamsplitnyDateTime >= 8.30 && dblccatamsplitnyDateTime < 12.00) {

			String timeSlotsTomTxt = tSlotTom.getText();
			String timeSlots930Txt = tSlot930AM.getText();

			if (timeSlotsTomTxt.contains("Tomorrow") && timeSlots930Txt.contains("09:30 AM")) {

				System.out.println("Pass: The Selected Option Displayed as Tomorrow is Right:    " + timeSlotsTomTxt);
				System.out.println("Pass: The Selected Option Displayed For Expected Time of Delivery  is Right:    "
						+ timeSlots930Txt);
			}
		}

		if (dow.contains("SUNDAY") && isElementPresent(
				"//div[@class='txt_contactdetail y-resCalender']/descendant::div[contains(text(),'7:00 AM to 4:00 PM')]") == true) {
			if (aformatnyDateTime.endsWith("AM") && dblccatamsplitnyDateTime <= 12.00
					&& dblccatamsplitnyDateTime <= 7.00) {
				String timeSlotsTomTxt = tSlotTom.getText();
				String timeSlots730Txt = tSlot730AM.getText();
				if (timeSlotsTomTxt.contains("Tomorrow") && timeSlots730Txt.contains("07:30 AM")) {
					System.out
							.println("Pass: The Selected Option Displayed as Tomorrow is Right:    " + timeSlotsTomTxt);
					System.out
							.println("Pass: The Selected Option Displayed For Expected Time of Delivery  is Right:    "
									+ timeSlots730Txt);
				}
			}

			if (dow.contains("SUNDAY")) {
				if (aformatnyDateTime.endsWith("AM") && dblccatamsplitnyDateTime <= 12.00
						&& dblccatamsplitnyDateTime <= 11.59) {
					String timeSlotsTomTxt = tSlotTom.getText();
					String timeSlots930Txt = tSlot930AM.getText();
					if (timeSlotsTomTxt.contains("Tomorrow") && timeSlots930Txt.contains("09:30 AM")) {
						System.out.println(
								"Pass: The Selected Option Displayed as Tomorrow is Right:    " + timeSlotsTomTxt);
						System.out.println(
								"Pass: The Selected Option Displayed For Expected Time of Delivery  is Right:    "
										+ timeSlots930Txt);
					}
				}
			}

			if (dow.contains("SUNDAY") && isElementPresent(
					"//div[@class='txt_contactdetail y-resCalender']/descendant::div[contains(text(),'7:00 AM to 4:00 PM')]") == true) {
				if (aformatnyDateTime.endsWith("PM") && dblccatamsplitnyDateTime >= 3.30
						&& dblccatamsplitnyDateTime <= 11.59) {
					String timeSlotsTomTxt = tSlotTom.getText();
					String timeSlots730Txt = tSlot730AM.getText();
					if (timeSlotsTomTxt.contains("Tomorrow") && timeSlots730Txt.contains("07:30 AM")) {

						System.out.println(
								"Pass: The Selected Option Displayed as Tomorrow is Right:    " + timeSlotsTomTxt);
						System.out.println(
								"Pass: The Selected Option Displayed For Expected Time of Delivery  is Right:    "
										+ timeSlots730Txt);
					}
				}
			}

			if (dow.contains("MONDAY") && isElementPresent(
					"//div[@class='txt_contactdetail y-resCalender']/descendant::div[contains(text(),'7:00 AM to 4:00 PM')]") == true) {

				if (aformatnyDateTime.endsWith("AM") && dblccatamsplitnyDateTime <= 12.00
						&& dblccatamsplitnyDateTime < 7.00) {
					String curTodaytTxt = tSlotToday.getText();
					String timeSlots730Txt = tSlot730AM.getText();

					if (curTodaytTxt.contains("Today") && timeSlots730Txt.contains("07:30 AM")) {

						System.out.println("Pass: The Selected Option Displayed as Today is Right:    " + curTodaytTxt);
						System.out.println(
								"Pass: The Selected Option Displayed For Expected Time of Delivery  is Right:    "
										+ timeSlots730Txt);
					}
				}
			}

			try {
				if (dow.contains("MONDAY") && isElementPresent(
						"//div[@class='txt_contactdetail y-resCalender']/descendant::div[contains(text(),'9:00 AM to 9:00 PM')]") == true) {
				}
			} catch (Exception e) {
				System.out.println("Web Element Not Found:   " + e.getMessage());
			}

			if (aformatnyDateTime.endsWith("AM") && dblccatamsplitnyDateTime <= 12.00
					&& dblccatamsplitnyDateTime < 9.00) {
				String curTodaytTxt = tSlotToday.getText();
				String timeSlots930Txt = tSlot930AM.getText();

				if (curTodaytTxt.contains("Today") && timeSlots930Txt.contains("09:30 AM")) {

					System.out.println("Pass: The Selected Option Displayed as Today is Right:    " + curTodaytTxt);
					System.out
							.println("Pass: The Selected Option Displayed For Expected Time of Delivery  is Right:    "
									+ timeSlots930Txt);
				}
			}
		}

	}
}

// String expTimeTxt = expTakeOutTime.getText();
// String[] expTimeSplt1 = expTimeTxt.split(" ");
// String expTimeSplt2 = expTimeSplt1[0] + expTimeSplt1[1] + expTimeSplt1[2];
// System.out.println("The Concat String after First Split: " + expTimeSplt2);
// String[] expTimeSplitPart1 = expTimeSplt2.split("-");
// System.out.println("The First Part1: " + expTimeSplitPart1[0]);
// System.out.println("The First Part2: " + expTimeSplitPart1[1]);
//
// String rpexpTimeSplitPart1 = expTimeSplitPart1[0].replaceFirst("8:00AM",
// "8.00");
// String rpexpTimeSplitPart2 = expTimeSplitPart1[1].replaceFirst("9:00PM",
// "9.00");
// System.out.println("The Text after Replaced String is for Part 1: " +
// rpexpTimeSplitPart1);
// System.out.println("The Text after Replaced String is for Part 2: " +
// rpexpTimeSplitPart2);
//
// Double dblrpexpTimeSplitPart1 = Double.parseDouble(rpexpTimeSplitPart1);
// Double dblrpexpTimeSplitPart2 = Double.parseDouble(rpexpTimeSplitPart2);
// String[] expTimeSpltAM=expTimeSplitPart1[1].split("AM");
// System.out.println("The Split of Part1 after AM: "+expTimeSpltAM[0]);
// System.out.println("The Split of Part2 after AM: "+expTimeSpltAM[1]);

// String expTimeSplit1 = expTimeSplitPart1[1].replaceAll(":", ".");
// String expTimeSplit2 = expTimeSplitPart1[3].replace(":", ".");
// double dblexpTimeSplitPart1 = Double.parseDouble(expTimeSplit1 );
// double dblexpTimeSplitPart2 = Double.parseDouble(expTimeSplit2 );
// System.out.println("The Time Split Part1: " + dblexpTimeSplitPart1);
// System.out.println("The Time Split Part2: " + dblexpTimeSplitPart2);
// Thread.sleep(5000);
// changeBtn.click();
// Thread.sleep(4000);
// daySelect.click();
// Thread.sleep(2000);
// Select daySel = new Select(daySelect);
// Thread.sleep(2000);
// daySel.selectByIndex(0);
// test.log(LogStatus.INFO, "The Day Selected : ");
//
// // orderTimeDelivery.click();
// // WebElement ordertXpath =
// // orderTime.findElement(By.xpath("//select[@class='t-order-time']"));
// // List<WebElement> optTimeList =
// // ordertXpath.findElements(By.tagName("option"));
//
// // for (int i = 0; i < optTimeList.size(); i++) {
//
// timeSelect.click();
// Thread.sleep(1000);
// Select orderTimes = new Select(timeSelect);
// orderTimes.selectByIndex(0);
// driver.navigate().refresh();
// Thread.sleep(4000);
// String takeOutSelText = takeOutSelTxt.getText();
// System.out.println(" The Selected Hour is-----:" + takeOutSelText);
//
// Thread.sleep(3000);
//
// String[] takeOutSelTextSplit = takeOutSelText.split(" ");
// String takeOutSelSplitPart1Txt = takeOutSelTextSplit[1];
// System.out.println(" The Take Out Hours Selected Text Part1: " +
// takeOutSelSplitPart1Txt);
//
// String takeOutSelSubSplitPart1Txt = takeOutSelSplitPart1Txt.replaceAll(":",
// ".");
// // String takeOutSelSubSplitPart1Txt=takeOutSelTextSubSplitPart1[0];
//
// System.out.println(" The Take Out Hours Selected Sub Split Text Part1: " +
// takeOutSelSubSplitPart1Txt);
// Thread.sleep(4000);
// // Double
// // dbltakeOutSelSplitPart1Txt=Double.parseDouble(takeOutSelSplitPart1Txt);
// Double dbltakeOutSelSubSplitPart1Txt =
// Double.parseDouble(takeOutSelSubSplitPart1Txt);
//
// String takeOutHrsText = takeOutHoursTxt.getText();
// System.out.println(" The Operating Hours are: " + takeOutHrsText);
// Thread.sleep(5000);
// String[] takeOutHrsSplit = takeOutHrsText.split(" ");
// String takeoutHrsAmSplit = takeOutHrsSplit[0];
// String takeoutHrsAmSplitTxt = takeoutHrsAmSplit.replaceAll(":", ".");
//
// String[] takeoutHrsSplitPart1 = takeOutHrsText.split("AM-");
// String[] takeoutHrsPmSplit = takeoutHrsSplitPart1[1].split("PM");
// String takeoutHrsPmSplitTxt = takeoutHrsPmSplit[0].replaceAll(":", ".");
//
// // String takeoutHrsPMSplitTxt=takeoutHrsAmSplitTxt.replaceAll(":", ".");
//
// // String[] takeoutHrsSplitPart2 = takeoutHrsSplitPart1Txt.split("AM-");
// // String takeoutHrsSplitPart2Txt = takeoutHrsSplitPart2[1];
//
// System.out.println(" The Take Out Hours Part of AM Split is: " +
// takeoutHrsAmSplitTxt);
// System.out.println(" The Take Out Hours Part of PM Split is: " +
// takeoutHrsPmSplitTxt);
//
// Thread.sleep(5000);
//
// Double dbltakeoutHrsAmSplitTxt = Double.parseDouble(takeoutHrsAmSplitTxt);
// System.out.println("The Double Value of Part1 Text is: " +
// dbltakeoutHrsAmSplitTxt);
//
// Double dbltakeoutHrsPmSplitTxt = Double.parseDouble(takeoutHrsPmSplitTxt);
// System.out.println("The Double Value of Part2 Text is: " +
// dbltakeoutHrsPmSplitTxt);
//
// if ((takeOutSelText).endsWith("AM")) {
//
// Thread.sleep(6000);
//
// if ((dbltakeOutSelSubSplitPart1Txt) >= (dbltakeoutHrsAmSplitTxt)) {
// System.out.println("Pass: Take Out Delivery Time is within the Operating
// Hours of Business: "
// + takeOutSelText);
// test.log(LogStatus.INFO,
// "Pass: Take Out Delivery Time is within the Operating Hours of Business: "
// + takeOutSelText);
// } else {
//
// System.out.println("Fail: Take Out Delivery Time is outside the Operating
// Hours of Business: "
// + takeOutSelText);
// test.log(LogStatus.INFO,
// "Fail: Take Out Delivery Time is outside the Operating Hours of Business: "
// + takeOutSelText);
//
// }
//
// }
//
//// if ((takeOutSelText).endsWith("PM")) {
////
//// if ((dbltakeOutSelSubSplitPart1Txt) <= (dbltakeoutHrsPmSplitTxt)) {
////
//// System.out.println("Pass: Take Out Delivery Time is within the Operating
// Hours of Business: "
//// + takeOutSelText);
////
//// test.log(LogStatus.INFO,
//// "Pass: Take Out Delivery Time is within the Operating Hours of Business: "
//// + takeOutSelText);
//// } else {
////
//// System.out.println("Fail: Take Out Delivery Time is outside the Operating
// Hours of Business: "
//// + takeOutSelText);
//// test.log(LogStatus.INFO,
//// "Fail: Take Out Delivery Time is outside the Operating Hours of Business: "
//// + takeOutSelText);
////
//// }
////
//// }
//
// // String[] takeOutHrsPart1SubSplit=takeoutHrsSplitPart1.split(":");
// // String takeOutHrsPart1SubSplitTxt=takeOutHrsPart1SubSplit[0];
// // String[] takeOutHrsPart2SubSplit=takeoutHrsSplitPart2.split(":");
// // String takeOutHrsPart2SubSplitTxt=takeOutHrsPart2SubSplit[0];
//
// // System.out.println(" The Take Out Hours Part1 Sub Split is:
// // "+takeOutHrsPart1SubSplitTxt);
// // System.out.println(" The Take Out Hours Part2 Sub Split is:
// // "+takeOutHrsPart2SubSplitTxt);
//
// //
// // Time = optTimeList.get(i).getAttribute("value");
// // orderTimes.selectByVisibleText("05:00 PM");
// // String takeOutSelText=takeOutSelTxt.getText();
// // String[] takeOutSelSplit=takeOutSelText.split(" ");
// // String takeOutHrsPart1=takeOutSelSplit[1];
// // // String
// orderTimeDelSelTxt=orderTimeDel.getFirstSelectedOption().getText();
// //
// // String newTime = Time.replaceAll(":", ".");
// // Double dblOrderTimeValue = Double.parseDouble(newTime);
// //
// // Integer lstrowVal = optTimeList.size() - 1;
// // String lstRowTimeVal = optTimeList.get(lstrowVal).getAttribute("value");
// // String rplstRowTimeVal = lstRowTimeVal.replaceAll(":", ".");
// // Double dbllstRowTimeVal = Double.parseDouble(rplstRowTimeVal);
// //
// // System.out.println("The Time Values are: " + newTime);
// // System.out.println("The Last Row of Time Value: " + dbllstRowTimeVal);
// //
// // // if(Time.equals("09:30")) {
// // // orderTimeDel.selectByValue(Time);
// // // break;
// // // }
// //
// // // orderTimeDel.selectByValue("09:30");
// // Thread.sleep(5000);
// //
// // System.out.println("The Selected Option: " + Time);
// //
// // // String[] amorderTimeDelValueSplit = orderTimeDelValue.split("AM");
// // // String amorderTimeDelValueNumPart1 =
// // amorderTimeDelValueSplit[0].replace(":",
// // // ".");
// // // float amfltorderTimeDelValueSplit =
// // // Float.parseFloat(amorderTimeDelValueNumPart1);
// // //
// // // String[] pmorderTimeDelValueSplit = orderTimeDelValue.split("PM");
// // // String pmorderTimeDelValueNumPart1 =
// // pmorderTimeDelValueSplit[0].replace(":",
// // // ".");
// // // float pmfltorderTimeDelValueSplit =
// // // Float.parseFloat(pmorderTimeDelValueNumPart1);
// //
// // if (dblOrderTimeValue >= dblrpexpTimeSplitPart1 && dblOrderTimeValue <
// // dbllstRowTimeVal) {
// // System.out.println("Time Selected is within the TakeOut Service Window: "
// +
// // expTimeTxt);
// // System.out.println("Pass: The Time Selected is: " + Time);
// // test.log(LogStatus.INFO, "Time SelectedTime is within the Take Out Service
// // Window: " + expTimeTxt);
// // test.log(LogStatus.INFO, "Pass: The Time Selected is: " + Time);
// // } else {
// // test.log(LogStatus.INFO, "Fail:The Time Selected is out of Take Out
// Service
// // Window: " + Time);
// // test.log(LogStatus.INFO, "The Expected TakeOut Service Time is: " +
// // expTimeTxt);
// // }

// if (discAmt.isDisplayed()) {
//
// String discAmount = discAmt.getText();
// Double dblDiscAmt$ = Double.parseDouble(discAmount);
// System.out.println("The Discount Amount is: " + dblDiscAmt$);
// String orderTakeoutTax = taxTakeout.getText();
// Double dblorderTakeoutTax$ = Double.parseDouble(orderTakeoutTax);
// System.out.println("The TakeOut Tax Amount is:$$$$$$$" +
// dblorderTakeoutTax$);
//
// Double dbltotAmount$ = dblSubTotAmount + dblorderTakeoutTax$ - dblDiscAmt$;
// System.out.println("The Total after Adding Sub-Total with Discount is: " +
// dbltotAmount$);
//
// String totAmountOrderTakeout = totTakeout.getText();
//
// Double dbltotAmountOrderTakeout$ = Double.parseDouble(totAmountOrderTakeout);
// System.out
// .println("The Total Amount Got from the Displayed Tax in UI: " +
// dbltotAmountOrderTakeout$);
//
// if (dbltotAmountOrderTakeout$.equals(dbltotAmount$)) {
// System.out.println("Total Amount is Right " + dbltotAmount$);
// test.log(LogStatus.INFO,
// "The Total Amount of Order to Check Out Payment is Right and Validated: "
// + dbltotAmount$);
// } else {
// System.out.println("The Total Amount is wrong " + dbltotAmount$);
// test.log(LogStatus.INFO, "The Total Amount of Order to Check Out Payment is
// wrong and Validated: "
// + dbltotAmount$);
//
// }
//
// } else {
//
// System.out.println("There is no Discount: ");
// String orderTakeoutTax = taxTakeout.getText();
// Double dblorderTakeoutTax$ = Double.parseDouble(orderTakeoutTax);
// System.out.println("The TakeOut Tax Amount is:$$$$$$$" +
// dblorderTakeoutTax$);
// Double dbltotAmount$ = dblSubTotAmount + dblorderTakeoutTax$;
//
// System.out.println("The Total after Adding Sub-Total is: " + dbltotAmount$);
//
// String totAmountOrderTakeout = totTakeout.getText();
//
// Double dbltotAmountOrderTakeout$ = Double.parseDouble(totAmountOrderTakeout);
// System.out
// .println("The Total Amount Got from the Displayed Tax in UI: " +
// dbltotAmountOrderTakeout$);
//
// if (dbltotAmountOrderTakeout$.equals(dbltotAmount$)) {
// System.out.println("Total Amount is Right " + dbltotAmount$);
// test.log(LogStatus.INFO,
// "The Total Amount of Order to Check Out Payment is Right and Validated: "
// + dbltotAmount$);
// } else {
// System.out.println("The Total Amount is wrong " + dbltotAmount$);
// test.log(LogStatus.INFO, "The Total Amount of Order to Check Out Payment is
// wrong and Validated: "
// + dbltotAmount$);
//
// }
//
// }
//
// // String orderTakeoutTax = taxTakeout.getText();
// // Double dblorderTakeoutTax$ = Double.parseDouble(orderTakeoutTax);
// // System.out.println("The TakeOut Tax Amount is:$$$$$$$" +
// // dblorderTakeoutTax$);
// // Double dbltotAmount$ = dblSubTotAmount + dblorderTakeoutTax$;
//
// // System.out.println("The Total after Adding Sub-Total is: " +
// dbltotAmount$);
//
// Actions action = new Actions(driver);
// action.moveToElement(checkoutTakeOut).build().perform();
//
// checkoutTakeOut.click();
//
// if (checkOutTitleText.isDisplayed()) {
//
// System.out.println("Pass:The Checkout Page is Displayed:!!!!" +
// checkOutTitleText.getText());
//
// test.log(LogStatus.INFO, "Pass:The Checkout Page is Displayed: " +
// checkOutTitleText.getText());
//
// } else {
//
// System.out.println("Fail:The Checkout Page is not Displayed:?????? " +
// checkOutTitleText.isDisplayed());
// test.log(LogStatus.INFO, "Fail:The Checkout Page is Displayed: " +
// checkOutTitleText.isDisplayed());
//
// }
//
// firstName.sendKeys(firstname);
// lastName.sendKeys(lastname);
//
// splInstrctions.sendKeys(specialinstructions);
//
// nameOnCard.sendKeys(nameoncard);
// cardNumber.sendKeys(cardnumber);
// expiryMonth.sendKeys(expirymonth);
// expiryYear.sendKeys(expiryyear);
// cvvCode.sendKeys(cvvcode);
// billZip.sendKeys(billingzip);
// c_Phone.sendKeys(phone);
// c_Email.sendKeys(email);
//
// Thread.sleep(7000);
// placeMyOrderBtn.click();
// Thread.sleep(10000);
//
// if (orderThankYouText.isEnabled())
//
// {
// Thread.sleep(9000);
// Actions thkaction = new Actions(driver);
// thkaction.moveToElement(orderThankYouText).build().perform();
// Thread.sleep(9000);
// System.out.println("Pass:*****" + orderThankYouText.getText());
// System.out.println("Pass:*****" + receiptNumText.getText());
// Thread.sleep(5000);
// test.log(LogStatus.INFO, "Pass:The Thank You Page is Displayed: " +
// orderThankYouText.getText());
// test.log(LogStatus.INFO, "Receipt Number for the Order is: " +
// receiptNumText.getText());
// } else {
//
// Thread.sleep(7000);
// test.log(LogStatus.INFO, "Fail:The Checkout Page is not Displayed: " +
// orderThankYouText.isEnabled());
// System.out.println("Fail:*****" + orderThankYouText.isEnabled());
// }
// }
// }
//
// public void verifyEditOrder() throws InterruptedException {
//
// Thread.sleep(5000);
// gallerypage.verifyContactsLink();
// Thread.sleep(4000);
//
// rightAddress = rightAddressTxt.getText();
// Thread.sleep(5000);
//
// orderOnlineTab.click();
// Thread.sleep(3000);
//
// Thread.sleep(5000);
// orderTakeout.click();
// Thread.sleep(3000);
//
// orderAddtoCart.click();
//
// radioWhiteBtn.click();
//
// addMultiplierBtn.click();
// Thread.sleep(5000);
//
// String orderQtyTot = addMultiplierTxt.getText();
//
// int iorderQtyTot = Integer.parseInt(orderQtyTot);
// test.log(LogStatus.INFO, "The Total Quantity is Validated " + iorderQtyTot);
//
// String Price = orderPrice$.getText();
//
// float $Price = Float.parseFloat(Price);
// test.log(LogStatus.INFO, "The Price is Validated " + $Price);
//
// float fSubTotAmount = iorderQtyTot * $Price;
// test.log(LogStatus.INFO, "The Sub Total Amount is Validated " +
// fSubTotAmount);
// System.out.println("The Sub TotalAmount is: " + fSubTotAmount);
//
// Thread.sleep(3000);
// orderAddToOrderBtn.click();
// Thread.sleep(7000);
//
// Actions act = new Actions(driver);
// act.moveToElement(checkoutTakeOut).build().perform();
// Thread.sleep(3000);
//
// checkoutTakeOut.click();
// if (checkOutTitleText.isDisplayed()) {
//
// test.log(LogStatus.INFO, "Pass:The Checkout Page is Displayed: " +
// checkOutTitleText.getText());
//
// } else {
// test.log(LogStatus.INFO, "Fail:The Checkout Page is Displayed: " +
// checkOutTitleText.isDisplayed());
//
// }
//
// editOrderBtn.click();
//
// editPencilIcon.click();
//
// Thread.sleep(6000);
//
// radioWhiteBtn.click();
//
// addMultiplierBtn.click();
// Thread.sleep(5000);
//
// String eorderQtyTot = addMultiplierTxt.getText();
//
// int eiorderQtyTot = Integer.parseInt(eorderQtyTot);
// test.log(LogStatus.INFO, "The Total Quantity is Validated " + iorderQtyTot);
//
// String ePrice = orderPrice$.getText();
//
// float e$Price = Float.parseFloat(ePrice);
// test.log(LogStatus.INFO, "The Price is Validated " + e$Price);
//
// float efSubTotAmount = eiorderQtyTot * e$Price;
// test.log(LogStatus.INFO, "The Sub Total Amount is Validated " +
// efSubTotAmount);
// System.out.println("The Sub TotalAmount is: " + efSubTotAmount);
//
// Thread.sleep(3000);
// orderAddToOrderBtn.click();
// Thread.sleep(7000);
//
// Thread.sleep(3000);
//
// String eTax = orderTaxAmt.getText();
// float e$Tax = Float.parseFloat(eTax);
// System.out.println("The Tax for the Total: " + e$Tax);
// test.log(LogStatus.INFO, "The Tax Amount is Validated " + e$Tax);
//
// float eftotAmount$ = efSubTotAmount + e$Tax;
// // double rtotAmount$=Math.nextDown(totAmount$);
//
// String esTotAmount = totalAmt.getText();
// System.out.println("The Total Amount displayed is: " + esTotAmount);
//
// float eTotalAmount$ = Float.parseFloat(esTotAmount);
//
// if (eftotAmount$ == eTotalAmount$) {
// System.out.println("Total Amount is Right " + eftotAmount$);
// test.log(LogStatus.INFO,
// "Pass:The Total Amount of Order to Check Out Payment is Right and Validated:
// " + eftotAmount$);
// } else {
// System.out.println("The Total Amount is wrong " + eftotAmount$);
// test.log(LogStatus.INFO,
// "Fail:The Total Amount of Order to Check Out Payment is wrong and Validated:
// " + eftotAmount$);
//
// }
// }

// public void verifyAddToOrder() throws InterruptedException {
//
// gallerypage.verifyContactsLink();
// Thread.sleep(4000);
//
// String restAddressText = rightAddressTxt.getText();
//
// rightAddress = rightAddressTxt.getText();
// orderOnlineTab.click();
//
// Thread.sleep(3000);
//
// orderAddtoCart.click();
// orderSearchTxtFld.sendKeys(rightAddress);
// Thread.sleep(3000);
//
// orderVerifyProceed.click();
// Thread.sleep(6000);
//
// radioWhiteBtn.click();
//
// addMultiplierBtn.click();
// Thread.sleep(5000);
//
// String orderQtyTot = addMultiplierTxt.getText();
//
// int iorderQtyTot = Integer.parseInt(orderQtyTot);
// test.log(LogStatus.INFO, "The Total Quantity is Validated " + iorderQtyTot);
//
// String Price = orderPrice$.getText();
//
// float $Price = Float.parseFloat(Price);
// test.log(LogStatus.INFO, "The Price is Validated " + $Price);
//
// float fSubTotAmount = iorderQtyTot * $Price;
// test.log(LogStatus.INFO, "The Sub Total Amount is Validated " +
// fSubTotAmount);
// System.out.println("The Sub TotalAmount is: " + fSubTotAmount);
//
// Thread.sleep(3000);
// orderAddToOrderBtn.click();
// Thread.sleep(3000);
//
// String Tax = orderTaxAmt.getText();
// float $Tax = Float.parseFloat(Tax);
// System.out.println("The Tax for the Total: " + $Tax);
// test.log(LogStatus.INFO, "The Tax Amount is Validated " + $Tax);
// // } catch (Exception e) {
// // test.log(LogStatus.INFO, "Tax Amount not Validated");
// // System.out.println(e.getMessage());
// // System.out.println(e.getStackTrace());
// // }
//
// Thread.sleep(4000);
//
// // changeBtn.click();
// // daySelect.click();
// // Select daySel = new Select(daySelect);
// // daySel.selectByVisibleText("Today");
// // test.log(LogStatus.INFO, "Day Selected is: Today ");
// //
// // Select orderTimeDel = new Select(timeSelect);
// // orderTimeDel.selectByVisibleText("12:30 PM");
// // System.out.println(" Time Selected is: 12:30");
// // test.log(LogStatus.INFO, "Time Selected is: 12:00 PM ");
// //
// // String delAddrTxt = orderDeliveryAddrText.getText();
// // String zeroMilesTxt = zeroMilesText.getText();
// //
// // if (delAddrTxt.contains(restAddressText) && zeroMilesText.isDisplayed()) {
// // System.out.println(
// // "Pass: This Restaurant Address is about 0 mile from the Restaurant Current
// // Address Location"
// // + restAddressText);
// // test.log(LogStatus.INFO,
// // "Pass: This Restaurant Address is about 0 mile from the Restaurant Current
// // Address Location "
// // + zeroMilesTxt);
// //
// // } else {
// // System.out.println(
// // "Fail: Though the Delivery Address and Restaurant Address are same, about
// 0
// // mile from the Restaurant Current Address Location Text is not Displayed
// // Properly"
// // + restAddressText);
// // test.log(LogStatus.INFO,
// // "Fail: Though the Delivery Address and Restaurant Address are same, about
// 0
// // mile from the Restaurant Current Address Location Text is not Displayed
// // Properly"
// // + zeroMilesTxt);
// // }
//
// Select tsel = new Select(selectTipAmt);
//
// String text = "15%";
// tsel.selectByVisibleText(text);
// test.log(LogStatus.INFO, "The Tip Amount is: " + text + " For this Order");
// System.out.println("The Selected Tip Amount is 15%: " + text + " For this
// Order");
//
// float fText = Float.parseFloat(text);
// float ftotAmount$ = fSubTotAmount + (fSubTotAmount * (fText / 100)) + $Tax;
//
// // float ftotAmount$ = fSubTotAmount + (fSubTotAmount * 15 / 100) + $Tax;
// // double rtotAmount$=Math.nextDown(totAmount$);
//
// String sTotAmount = totalAmt.getText();
// System.out.println("The Total Amount displayed is: " + sTotAmount);
//
// float TotoalAmount$ = Float.parseFloat(sTotAmount);
//
// if (ftotAmount$ == TotoalAmount$) {
// System.out.println("Total Amount is Right " + ftotAmount$);
// test.log(LogStatus.INFO,
// "The Total Amount of Order to Check Out Payment is Right and Validated: " +
// ftotAmount$);
// } else {
// System.out.println("The Total Amount is wrong " + ftotAmount$);
// test.log(LogStatus.INFO,
// "The Total Amount of Order to Check Out Payment is wrong and Validated: " +
// ftotAmount$);
//
// }
//
// Actions act = new Actions(driver);
// act.moveToElement(chkoutDeliveryBtn).build().perform();
// Thread.sleep(5000);
//
// chkoutDeliveryBtn.click();
// Thread.sleep(3000);
//
// if (checkOutTitleText.isDisplayed()) {
// System.out.println("Pass:*****" + checkOutTitleText.getText());
// test.log(LogStatus.INFO, "Pass:The Checkout Page is Displayed: " +
// checkOutTitleText.getText());
//
// } else {
// test.log(LogStatus.INFO, "Fail:The Checkout Page is Displayed: " +
// checkOutTitleText.isDisplayed());
// System.out.println("Pass:*****" + checkOutTitleText.isDisplayed());
// }
//
// System.out.println("The Total Amount of Order to Check Out Payment is: " +
// sTotAmount);
// test.log(LogStatus.INFO, "The Total Amount of Order to Check Out Payment is
// Validated: ");
// }

// public void dclickCheckout(String firstname, String lastname, String phone,
// String email,
// String specialinstructions, String nameoncard, String cardnumber, String
// expirymonth, String expiryyear,
// String cvvcode, String billingzip) throws InterruptedException {
// // Thread.sleep(5000);
// // gallerypage.verifyContactsLink();
// // Thread.sleep(4000);
// //
// // String restAddressText = rightAddressTxt.getText();
// //
// // rightAddress = rightAddressTxt.getText();
// // orderOnlineTab.click();
// //
// // Thread.sleep(3000);
// //
// // orderAddtoCart.click();
// // orderSearchTxtFld.sendKeys(rightAddress);
// // Thread.sleep(3000);
// //
// // orderVerifyProceed.click();
// // Thread.sleep(6000);
// //
// // radioWhiteBtn.click();
// //
// // addMultiplierBtn.click();
// // Thread.sleep(5000);
// //
// // String orderQtyTot = addMultiplierTxt.getText();
// //
// // int iorderQtyTot = Integer.parseInt(orderQtyTot);
// // test.log(LogStatus.INFO, "The Total Quantity is Validated " +
// iorderQtyTot);
// //
// // String Price = orderPrice$.getText();
// //
// // float $Price = Float.parseFloat(Price);
// // test.log(LogStatus.INFO, "The Price is Validated " + $Price);
// //
// // float fSubTotAmount = iorderQtyTot * $Price;
// // test.log(LogStatus.INFO, "The Sub Total Amount is Validated " +
// // fSubTotAmount);
// // System.out.println("The Sub TotalAmount is: " + fSubTotAmount);
// //
// // Thread.sleep(3000);
// // orderAddToOrderBtn.click();
// // Thread.sleep(3000);
// //
// // String Tax = orderTaxAmt.getText();
// // float $Tax = Float.parseFloat(Tax);
// // System.out.println("The Tax for the Total: " + $Tax);
// // test.log(LogStatus.INFO, "The Tax Amount is Validated " + $Tax);
// // } catch (Exception e) {
// // test.log(LogStatus.INFO, "Tax Amount not Validated");
// // System.out.println(e.getMessage());
// // System.out.println(e.getStackTrace());
// // }
// // changeBtn.click();
// // daySelect.click();
// //
// // Select daySel = new Select(daySelect);
// // daySel.selectByVisibleText("Today");
// //
// // timeSelect.click();
// // Select timeSel = new Select(timeSelect);
// // timeSel.selectByVisibleText("07:30 PM");
// //
// // String expTimeTxt = expTime.getText();
// // Thread.sleep(5000);
// // System.out.println("The Expected Time is: "+expTimeTxt);
// //
// // String[] expTimeSplt1 = expTimeTxt.split(" ");
// //
// // String expTimeSplitPartDay = expTimeSplt1[0];
// // String expTimeSplitPart1 = expTimeSplt1[1].replace(":", ".");
// // String expTimeSplitPart2 = expTimeSplt1[2].replace(":", ".");
// // double dblexpTimeSplitPart1 = Double.parseDouble(expTimeSplitPart1);
// // double dblexpTimeSplitPart2 = Double.parseDouble(expTimeSplitPart2);
// // Thread.sleep(3000);
// // System.out.println("The Time Split Part1: " + dblexpTimeSplitPart1);
// // System.out.println("The Time Split Part2: " + dblexpTimeSplitPart2);
//
// ZonedDateTime zdt = ZonedDateTime.now();
// Thread.sleep(3000);
// System.out.println("The India Zoned Date/Time: " + zdt);
// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:hh:mm
// a");
// String formatzdtDateTime = zdt.format(formatter);
//
// ZoneId anewYokZoneId = ZoneId.of("America/New_York");
//
// DateTimeFormatter aformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:hh:mm
// a");
// ZonedDateTime anyDateTime = zdt.withZoneSameInstant(anewYokZoneId);
// String aformatnyDateTime = anyDateTime.format(aformatter);
//
// System.out.println("The Time Now at NewYork is: " + aformatnyDateTime);
// System.out.println("The Time Now at NY is: " + anyDateTime);
//
// String[] asplitnyDateTime = aformatnyDateTime.split("AM");
// String astrsplitnyDateTime = asplitnyDateTime[0];
//
// String[] amsplitNyDateTime = astrsplitnyDateTime.split(":");
//
// // System.out.println("The String Split is: " + asplitnyDateTime[0]);
// String aStrsplitnyDateTime = amsplitNyDateTime[1] + "." +
// amsplitNyDateTime[2];
// // String samsplitnyDateTimeAM= aStrsplitnyDateTime.replace(":",".");
//
// System.out.println("The AM Split is: " + aStrsplitnyDateTime);
// // String[] pmsplitnyDateTime = astrsplitnyDateTime.split(":");
// // String[] amsplitnyDateTime=astrsplitnyDateTime
// // String samsplitnyDateTime=pmsplitnyDateTime[1]+pmsplitnyDateTime[2];
//
// // System.out.println("The String Split: "+samsplitnyDateTimeAM);
//
// //
//
// Double dblccatamsplitnyDateTime = Double.parseDouble(aStrsplitnyDateTime);
// System.out.println("The Double for Date Time: " + dblccatamsplitnyDateTime);
//
// System.out.println();
// System.out.println();
// System.out.println();
//
// // System.out.println("The Final PM Time is: "+ ccatamsplitnyDateTime);
//
// // System.out.println("The Final AM Split is : "+ amsplitnyDateTime[1]);
//
// LocalDate lcldate = anyDateTime.toLocalDate();
// System.out.println("The Date Now at NYis: " + lcldate);
//
// String sLclDate = lcldate.toString();
//
// // ZonedDateTime newYorkTime = ZonedDateTime.of(timePoint, newYokZoneId);
// DayOfWeek dayOfWeek = anyDateTime.getDayOfWeek();
//
// System.out.println("The Value of the Day of the Week is: " +
// dayOfWeek.getValue());
// String dow = dayOfWeek.toString();
// Thread.sleep(3000);
//
// // String dow = dayOfWeek.toString();
// System.out.println("The Day of the Week: " + dayOfWeek);
// changeBtn.click();
// daySelect.click();
// //// Thread.sleep(2000);
// Select daySel = new Select(daySelect);
// // Thread.sleep(3000);
// //
// //
// //
// // daySelect.click();
// String txtToday = todayTxt.getText();
// // daySel.selectByIndex(0);
//
// // Actions act = new Actions(driver);
// // act.moveToElement(cHours).build().perform();
// //
// Thread.sleep(6000);
//
// // for (int i=0; i<curDateSize;i++){
// //
// //// String curDateTxt=curDate.get(i).getText();
// // String[] txtTodaySplt=txtToday.split(txtToday);
// // String textToday=txtTodaySplt[0];
//
// WebElement curToday = dateTakeout.findElement(By.tagName("option"));
// String curTodaytTxt = curToday.getText();
//
// String timeSlotsTomTxt = tSlotTom.getText();
// String timeSlots9Txt = tSlot900AM.getText();
// //
// // if (curToday.getAttribute("value").contains(sLclDate) &&
// // txtToday.contains("Tomorrow")) {
//
// // String timeSlotsTxt=tSlot900AM.getText()
// if (aformatnyDateTime.endsWith("PM") && dow.contains("SATURDAY") &&
// dblccatamsplitnyDateTime >= 8.30
// && dblccatamsplitnyDateTime < 12.00 && timeSlotsTomTxt.contains("Tomorrow")
// && timeSlots9Txt.contains("09:00 AM")) {
//
// System.out.println("Pass: The Selected Option Displayed as Tomorrow is Right:
// " + timeSlotsTomTxt);
// System.out.println(
// "Pass: The Selected Option Displayed For Expected Time of Delivery is Right:
// " + timeSlots9Txt);
// timeSelect.click();
//
// }
// if (dow.contains("SUNDAY") && aformatnyDateTime.endsWith("AM") &&
// dblccatamsplitnyDateTime <= 12.00
// && dblccatamsplitnyDateTime <= 11.59 && timeSlotsTomTxt.contains("Tomorrow"))
// {
// System.out.println("Pass: The Selected Option Displayed as Tomorrow is Right:
// " + timeSlotsTomTxt);
// System.out.println(
// "Pass: The Selected Option Displayed For Expected Time of Delivery is Right:
// " + timeSlots9Txt);
// }
//
// if (dow.contains("SUNDAY") && aformatnyDateTime.endsWith("PM") &&
// dblccatamsplitnyDateTime <= 12.00
// && dblccatamsplitnyDateTime <= 11.59 && timeSlotsTomTxt.contains("Tomorrow"))
// {
//
// System.out.println("Pass: The Selected Option Displayed as Tomorrow is Right:
// " + timeSlotsTomTxt);
// System.out.println(
// "Pass: The Selected Option Displayed For Expected Time of Delivery is Right:
// " + timeSlots9Txt);
// }
//
// if (dow.contains("MONDAY") && aformatnyDateTime.endsWith("AM") &&
// dblccatamsplitnyDateTime <= 12.00
// && dblccatamsplitnyDateTime < 8.30 && timeSlots9Txt.contains("09:00 AM")) {
//
// System.out.println("Pass: The Selected Option Displayed as Today is Right: "
// + timeSlotsTomTxt);
// System.out.println(
// "Pass: The Selected Option Displayed For Expected Time of Delivery is Right:
// " + timeSlots9Txt);
// }
//
// else {
// System.out.println("Fail: The Selected Option Displayed as is Wrong: " +
// timeSlotsTomTxt);
// System.out.println(
// "Fail: The Selected Option Displayed For Expected Time of Delivery is Wrong:
// " + timeSlots9Txt);
//
// }
//
// // String day="Today";
// //
// // System.out.println("The Current/Present Day for the Date is "+day);
// //
// // WebElement curToday=dateTakeout.findElement(By.tagName("option"));
// // String curTodaytTxt=curToday.getText();
// //
// // if(day.contains(curTodaytTxt)) {
// //
//
// WebElement firstSlotTimeTdy = timeSelect.findElement(By.tagName("option"));
// String firstSlotTdyValue = firstSlotTimeTdy.getAttribute("value");
//
// String firstSlotTimeTdyTxt = firstSlotTimeTdy.getText();
//
// // if(aformatnyDateTime.endsWith("AM") &&
// //
//
// // WebElement dlyTimeSlot1= dlyTimeSlots.findElement(By.tagName("div"));
// // List<WebElement>
// // dlyTimeSlotList=dlyTimeSlot1.findElements(By.tagName("div"));
// // contactLink.click();
// //
// // Actions act = new Actions(driver);
// // act.moveToElement(cHours).build().perform();
//
// String dlyTmSlotsMonTxt = dlyTmSlotsMon.getText();
// String dlyTmSlotsTuesTxt = dlyTmSlotsTues.getText();
// String dlyTmSlotsWedTxt = dlyTmSlotsWed.getText();
// String dlyTmSlotsThurTxt = dlyTmSlotsThur.getText();
// String dlyTmSlotsFriTxt = dlyTmSlotsFri.getText();
// String dlyTmSlotsSatTxt = dlyTmSlotsSat.getText();
//
// String[] dlyTmSlotsMonSplt = dlyTmSlotsMonTxt.split("to");
// String[] dlyTmSlotsTuesSplt = dlyTmSlotsTuesTxt.split("to");
// String[] dlyTmSlotsWedSplt = dlyTmSlotsWedTxt.split("to");
// String[] dlyTmSlotsThurSplt = dlyTmSlotsThurTxt.split("to");
// String[] dlyTmSlotsFriSplt = dlyTmSlotsFriTxt.split("to");
// String[] dlyTmSlotsSatSplt = dlyTmSlotsSatTxt.split("to");
//
// String[] dlyTmSlotsMonSpltAM = dlyTmSlotsMonSplt[0].split("AM");
// String[] dlyTmSlotsTuesSpltAM = dlyTmSlotsTuesSplt[0].split("AM");
// String[] dlyTmSlotsWedSpltAM = dlyTmSlotsWedSplt[0].split("AM");
// String[] dlyTmSlotsThurSpltAM = dlyTmSlotsThurSplt[0].split("AM");
// String[] dlyTmSlotsFriSpltAM = dlyTmSlotsFriSplt[0].split("AM");
// String[] dlyTmSlotsSatSpltAM = dlyTmSlotsSatSplt[0].split("AM");
//
// String dlyTmSlotsMonAM = dlyTmSlotsMonSpltAM[0].replaceAll(":", ".");
// String dlyTmSlotsTuesAM = dlyTmSlotsTuesSpltAM[0].replaceAll(":", ".");
// String dlyTmSlotsWedAM = dlyTmSlotsWedSpltAM[0].replaceAll(":", ".");
// String dlyTmSlotsThurAM = dlyTmSlotsThurSpltAM[0].replaceAll(":", ".");
// String dlyTmSlotsFriAM = dlyTmSlotsFriSpltAM[0].replaceAll(":", ".");
// String dlyTmSlotsSatAM = dlyTmSlotsSatSpltAM[0].replaceAll(":", ".");
//
// Double dblTmSlotsMonAM = Double.parseDouble(dlyTmSlotsMonAM);
//
// Double dblTmSlotsTuesAM = Double.parseDouble(dlyTmSlotsTuesAM);
//
// Double dbldlyTmSlotsWedAM = Double.parseDouble(dlyTmSlotsWedAM);
//
// Double dbldlyTmSlotsThurAM = Double.parseDouble(dlyTmSlotsThurAM);
//
// Double dbldlyTmSlotsFriAM = Double.parseDouble(dlyTmSlotsFriAM);
//
// Double dbldlyTmSlotsSatAM = Double.parseDouble(dlyTmSlotsSatAM);
//
// System.out.println("The Monday AM Part: " + dlyTmSlotsMonAM);
// System.out.println("The Tuesday AM Part: " + dlyTmSlotsTuesAM);
// System.out.println("The Wednesday AM Part: " + dlyTmSlotsWedAM);
// System.out.println("The Thursday AM Part: " + dlyTmSlotsThurAM);
// System.out.println("The Thursday AM Part: " + dlyTmSlotsFriAM);
// System.out.println("The Friday AM Part: " + dlyTmSlotsSatAM);
// System.out.println();
// System.out.println();
// System.out.println();
//
// System.out.println("The Daily Time Slots for the Week is: " +
// dlyTmSlotsMonTxt);
//
// System.out.println("The Split for Monday AM: " + dlyTmSlotsMonSplt[0]);
// System.out.println("The Split for Monday AM: " + dlyTmSlotsMonSpltAM[0]);
//
// System.out.println("The Daily Time Slots for the Week is: " +
// dlyTmSlotsTuesTxt);
// System.out.println("The Split for Tuesday AM: " + dlyTmSlotsTuesSplt[0]);
// System.out.println("The Split for Monday AM: " + dlyTmSlotsTuesSpltAM[0]);
//
// System.out.println("The Daily Time Slots for the Week is: " +
// dlyTmSlotsWedTxt);
// System.out.println("The Split for Wednesday AM: " + dlyTmSlotsWedSplt[0]);
// System.out.println("The Split for Wednesday AM: " + dlyTmSlotsWedSpltAM[0]);
//
// System.out.println("The Daily Time Slots for the Week is: " +
// dlyTmSlotsThurTxt);
// System.out.println("The Split for Thursday AM: " + dlyTmSlotsThurSplt[0]);
// System.out.println("The Split for Thursday AM: " + dlyTmSlotsThurSpltAM[0]);
//
// System.out.println("The Daily Time Slots for the Week is: " +
// dlyTmSlotsFriTxt);
// System.out.println("The Split for Friday AM: " + dlyTmSlotsFriSplt[0]);
// System.out.println("The Split for Friday AM: " + dlyTmSlotsFriSpltAM[0]);
//
// System.out.println("The Daily Time Slots for the Week is: " +
// dlyTmSlotsSatTxt);
// System.out.println("The Split for Saturday AM: " + dlyTmSlotsSatSplt[0]);
// System.out.println("The Split for Saturday AM: " + dlyTmSlotsSatSpltAM[0]);
//
// // List<WebElement>
// // LfirstSlotTimeTdy=timeSelect.findElements(By.tagName("option"));
// //
// // for(int i=0;i<LfirstSlotTimeTdy.size();i++) {
//
// // System.out.println("The Option Atrribute Value is:
// // "+LfirstSlotTimeTdy.get(i).getAttribute("value"));
// //
// //// String LfirstSlotTimeTdyTxt=LfirstSlotTimeTdy.get(i).getText();
// // System.out.println("The Option text: "+LfirstSlotTimeTdyTxt);
// //
//
//// }
//
// // System.out.println("The Today Time and Date is: "+aformatnyDateTime);
// //
// //
// //
// // if(dblccatamsplitnyDateTime>=3.00 && dblccatamsplitnyDateTime<3.30) {
// //
// // System.out.println("The Today Conversion in Double Time and Date is:
// // "+dblccatamsplitnyDateTime);
// //
// //
// //
// //
// // System.out.println("Pass: The Selected Option Displayed for First Slot
// Time
// // for Select Time of Booking is Right: " + firstSlotTimeTdyTxt);
// //
// //
// //
// //
//
// // if(aformatnyDateTime.endsWith("AM") && dblccatamsplitnyDateTime>=8.30 &&
// // dblccatamsplitnyDateTime<9.00 &&
// // LfirstSlotTimeTdy.get(i).getAttribute("value").contains("09:30")){
// //
// // System.out.println("Pass: The Selected Option Displayed for the Selected
// Time
// // of Booking is Right: " +firstSlotTdyValue+"AM");
// //
// //
// //
// //
// // if(aformatnyDateTime.endsWith("AM") && dblccatamsplitnyDateTime>=9.00 &&
// // dblccatamsplitnyDateTime<9.30
// // &&LfirstSlotTimeTdy.get(i).getAttribute("value").contains("10:00")){
// //
// // System.out.println("Pass: The Selected Option Displayed for the Selected
// Time
// // of Booking is Right: " +firstSlotTdyValue+"AM");
//
// // Thread.sleep(5000);
// //
// // int dlySlotsListSize =dlyTimeSlotsList.size();
// //
// // for (int i = 0; i<dlySlotsListSize; i++) {
// //
// // String dlyTimeSlotTxt = dlyTimeSlotsList.get(i).getText();
// // System.out.println("The Daily Time Slots for the Week is: " +
// // dlyTimeSlotTxt);
// //
// // int dlyTimeSlotSize = dlyTimeSlotList.size();
//
// // for (int i = 0; i < dlyTimeSlotSize; i++) {
// //
// // String dlyTimeSlotTxt = dlyTimeSlotList.get(i).getText();
// // System.out.println("The Daily Time Slots for the Week is: " +
// // dlyTimeSlotTxt);
//
// // if(dlyTimeSlotTxt.contains("Monday"));
// // String[] dlyTimeSlotTxtSplit = dlyTimeSlotTxt.split("Monday");
// // System.out.println("The Split 1 is: "+dlyTimeSlotTxtSplit[1]);
// //// System.out.println("The Split 4 is: "+dlyTimeSlotTxtSplit[4]);
// //
// // if(dlyTimeSlotTxt.contains("Tuesday"));
// // String[] dlyTimeSlotTxtSplitT = dlyTimeSlotTxt.split("Tuesday");
// // System.out.println("The Split 1 is: "+dlyTimeSlotTxtSplitT[1]);
//
// // String[] dlyTimeSlotTxtSplit1 = dlyTimeSlotTxt.split("y");
// // System.out.println("The Split is: "+dlyTimeSlotTxtSplit1[0]);
// // System.out.println("The Split is: "+dlyTimeSlotTxtSplit1[1]);
// // String dlyTimeSlotTxtSpltday = dlyTimeSlotTxtSplit[0];
// // String dlyTimeSlotTxtSpltAM = dlyTimeSlotTxtSplit[1].replace(":", ".");
// // String dlyTimeSlotTxtSplt4 = dlyTimeSlotTxtSplit[3];
// // String dlyTimeSlotTxtSpltPM = dlyTimeSlotTxtSplit[4].replace(":", ".");
// // String dlyTimeSlotTxtSplt5 = dlyTimeSlotTxtSplit[5];
// //
// // System.out.println(" The AM Split is: "+dlyTimeSlotTxtSpltAM);
// //
// // System.out.println("The PM Split is: "+dlyTimeSlotTxtSpltPM);
// //
//
// // int idow = Integer.parseInt(dow);
// // System.out.println("The Day of the Week: " + idow);
// // String formatnyDateTime = nyDateTime.format(formatter);
//
// // if (aformatnyDateTime.endsWith("AM")) {
// // System.out.println("Ends With AM");
// // // LocalDateTime atimePoint = LocalDateTime.parse("2014-04-28T21:45:50");
// // // ZoneId anewYokZoneId = ZoneId.of("America/New_York");
// // //
// // // DateTimeFormatter aformatter =
// // DateTimeFormatter.ofPattern("yyyy-MM-dd:hh:mm
// // // a");
// // // ZonedDateTime anyDateTime = zdt.withZoneSameInstant(anewYokZoneId);
// // // String aformatnyDateTime = anyDateTime.format(aformatter);
// // String[] asplitnyDateTime = aformatnyDateTime.split("AM");
// // Thread.sleep(3000);
// // System.out.println("The String Split is: " + asplitnyDateTime[0]);
// // String astrsplitnyDateTime = asplitnyDateTime[0];
// // Thread.sleep(3000);
// // System.out.println("The AM Split is: " + astrsplitnyDateTime);
// // String[] amsplitnyDateTime = astrsplitnyDateTime.split(":");
// //
// // Thread.sleep(3000);
// // System.out.println("The String after the Split is: " +
// amsplitnyDateTime[0]);
// // System.out.println("The String after the Split is: " +
// amsplitnyDateTime[1]);
// // System.out.println("The String after the Split is: " +
// amsplitnyDateTime[2]);
// // String aintg1splitnyDateTime = amsplitnyDateTime[1];
// // String aintg2splitnyDateTime = amsplitnyDateTime[2];
// // Double dstr1 = Double.valueOf(aintg1splitnyDateTime);
// // Double dstr2 = Double.valueOf(aintg2splitnyDateTime);
// // Integer istr1= Integer.parseInt(aintg1splitnyDateTime);
// // Integer istr2= Integer.parseInt(aintg2splitnyDateTime);
// // Long lstr1=Long.parseLong(aintg1splitnyDateTime);
// // Long lstr2=Long.parseLong(aintg2splitnyDateTime);
// // Float fstr1=Float.parseFloat(aintg1splitnyDateTime);
// // Float fstr2=Float.parseFloat(aintg2splitnyDateTime);
//
// // int aint1splitnyDateTime =Integer.parseInt(aintg1splitnyDateTime);
// // int aint2splitnyDateTime = Integer.parseInt(aintg2splitnyDateTime);
// // Thread.sleep(3000);
// // System.out.println("The First Number Part: " + dstr1);
// // System.out.println("The Second Number Part: " + dstr2);
// // }
// //
// // ZoneId pnewYokZoneId = ZoneId.of("America/New_York");
// //
// // DateTimeFormatter pformatter =
// DateTimeFormatter.ofPattern("yyyy-MM-dd:hh:mm
// // a");
// // ZonedDateTime pnyDateTime = zdt.withZoneSameInstant(pnewYokZoneId);
// // String pformatnyDateTime = pnyDateTime.format(pformatter);
// //
// // if (pformatnyDateTime.endsWith("PM")) {
// // Thread.sleep(3000);
// // System.out.println("Ends With PM");
// // // LocalDateTime atimePoint = LocalDateTime.parse("2014-04-28T21:45:50");
// //
// // String[] psplitnyDateTime = pformatnyDateTime.split("PM");
// //
// // Thread.sleep(3000);
// // System.out.println("The String Split is: " + psplitnyDateTime[0]);
// // String pstrsplitnyDateTime = psplitnyDateTime[0];
// //
// // Thread.sleep(3000);
// // System.out.println("The PM Split is: " + pstrsplitnyDateTime);
// // String[] pmsplitnyDateTime = pstrsplitnyDateTime.split(":");
// //
// // Thread.sleep(3000);
// // System.out.println("The String after the Split is: " +
// pmsplitnyDateTime[0]);
// // System.out.println("The String after the Split is: " +
// pmsplitnyDateTime[1]);
// // System.out.println("The String after the Split is: " +
// pmsplitnyDateTime[2]);
// // String pintg1splitnyDateTime = pmsplitnyDateTime[1];
// // String pintg2splitnyDateTime = pmsplitnyDateTime[2];
// // Double pdstr1 = Double.valueOf(pintg1splitnyDateTime);
// // Double pdstr2 = Double.valueOf(pintg2splitnyDateTime);
// // Integer istr1= Integer.parseInt(aintg1splitnyDateTime);
// // Integer istr2= Integer.parseInt(aintg2splitnyDateTime);
// // Long lstr1=Long.parseLong(aintg1splitnyDateTime);
// // Long lstr2=Long.parseLong(aintg2splitnyDateTime);
// // Float fstr1=Float.parseFloat(aintg1splitnyDateTime);
// // Float fstr2=Float.parseFloat(aintg2splitnyDateTime);
//
// // int aint1splitnyDateTime =Integer.parseInt(aintg1splitnyDateTime);
// // int aint2splitnyDateTime = Integer.parseInt(aintg2splitnyDateTime);
// // Thread.sleep(3000);
// // System.out.println("The First Number Part: " + pdstr1);
// // System.out.println("The Second Number Part: " + pdstr2);
// //
// // //
// // // changeBtn.click();
// // // WebElement ordertXpath =
// // // timeSelect.findElement(By.xpath("//select[@class='t-order-time']"));
// // // WebElement optTime = ordertXpath.findElement(By.tagName("option"));
// // // String orderTimeText = optTime.getText();
// // // ZoneId pnewYokZoneId = ZoneId.of("America/New_York");
// // //
// // // DateTimeFormatter pformatter =
// // DateTimeFormatter.ofPattern("yyyy-MM-dd:hh:mm
// // // a");
// // // ZonedDateTime pnyDateTime = zdt.withZoneSameInstant(pnewYokZoneId);
// // // String pformatnyDateTime = pnyDateTime.format(pformatter);
// // // String[] psplitnyDateTime = pformatnyDateTime.split("PM");
// // // System.out.println("The String Split is: " + psplitnyDateTime[0]);
// // // String pstrsplitnyDateTime = psplitnyDateTime[0];
// // // System.out.println("The PM Split is: " + pstrsplitnyDateTime);
// // // String[] pmsplitnyDateTime = pstrsplitnyDateTime.split(":");
// // // System.out.println("The String after the Split is: " +
// // pmsplitnyDateTime[0]);
// // // System.out.println("The String after the Split is: " +
// // pmsplitnyDateTime[1]);
// // // System.out.println("The String after the Split is: " +
// // pmsplitnyDateTime[2]);
// // // String pintg1splitnyDateTime = pmsplitnyDateTime[1];
// // // String pintg2splitnyDateTime = pmsplitnyDateTime[2];
// // // Double pdstr1 = Double.valueOf(pintg1splitnyDateTime);
// // // Double pdstr2 = Double.valueOf(pintg2splitnyDateTime);
// // // // Integer istr1= Integer.parseInt(aintg1splitnyDateTime);
// // // // Integer istr2= Integer.parseInt(aintg2splitnyDateTime);
// // // // Long lstr1=Long.parseLong(aintg1splitnyDateTime);
// // // // Long lstr2=Long.parseLong(aintg2splitnyDateTime);
// // // // Float fstr1=Float.parseFloat(aintg1splitnyDateTime);
// // // // Float fstr2=Float.parseFloat(aintg2splitnyDateTime);
// // //
// // // // int aint1splitnyDateTime =Integer.parseInt(aintg1splitnyDateTime);
// // // // int aint2splitnyDateTime = Integer.parseInt(aintg2splitnyDateTime);
// // //
// // // System.out.println("The First Number Part: " + pdstr1);
// // // System.out.println("The Second Number Part: " + pdstr2);
// // if (pformatnyDateTime.endsWith("PM") && pdstr1 >= 6.0 && pdstr2 >= 30 ||
// // pdstr2 <= 59) {
// //
// // changeBtn.click();
// // daySelect.click();
// // Select daySel1 = new Select(daySelect);
// // List<WebElement> daySelOption =
// daySelect.findElements(By.tagName("option"));
// // // String daySelTextt=daySel.getFirstSelectedOption().getText();
// // // Boolean daySelTxt =
// // // daySel1.getFirstSelectedOption().getText().contains("Today");
// //
// // String daySelText = daySelOption.get(0).getText();
// // if (daySelText.contains("Today")) {
// //
// // System.out.println("Pass: " + daySelText + "is Displayed");
// // test.log(LogStatus.INFO, "Pass: " + daySelText + "is Displayed with Right
// // Day");
// // } else {
// //
// // System.out.println("Pass: " + daySelText + "is Displayed with Wrong Day");
// // test.log(LogStatus.INFO, "Fail: " + daySelText + "is Displayed with Wrong
// // Day");
// // }
// //
// // // daySelect.click();
// // //
// // // Select daySel2 = new Select(daySelect);
// // //
// // ////
// // // daySel2.selectByIndex(0);
// // // test.log(LogStatus.INFO, "Day Selected is: Today ");
// //
// // timeSelect.click();
// // Select timeSel1 = new Select(timeSelect);
// //
// // List<WebElement> timeSelOption =
// // timeSelect.findElements(By.tagName("option"));
// // String timeSelTxt = timeSelOption.get(0).getText();
// //
// // // String daySelTextt=daySel.getFirstSelectedOption().getText();
// // if (timeSelTxt.contains("07:30 PM")) {
// // System.out.println("Pass: " + timeSelTxt + "is Displayed");
// // test.log(LogStatus.INFO, "Pass: " + timeSelTxt + "is Displayed with Right
// // Time");
// // } else {
// //
// // System.out.println("Fail: " + timeSelTxt + "is Displayed with Wrong
// Time");
// //
// // test.log(LogStatus.INFO, "Fail: " + timeSelTxt + "is Displayed with Wrong
// // Time");
// // }
// //
// // // String orderTimeText=ordertXpath.getText();
// //
// // // List<WebElement> optTimeList =
// // // ordertXpath.findElements(By.tagName("option"));
// // //
// // // for (int i = 0; i < optTimeList.size(); i++) {
// // //
// // // orderTime.click();
// // // Thread.sleep(5000);
// // // Select orderTimeDel = new Select(orderTime);
// // // Time = optTimeList.get(i).getAttribute("value");
// // // orderTimeDel.selectByValue(Time);
// // // // String
// // orderTimeDelSelTxt=orderTimeDel.getFirstSelectedOption().getText();
// // //
// // // String newTime = Time.replaceAll(":", ".");
// // // Double dblOrderTimeDelValue = Double.parseDouble(newTime);
// //
// // // System.out.println("The Time Values are: " + newTime);
// //
// // // if(Time.equals("09:30")) {
// // // orderTimeDel.selectByValue(Time);
// // // break;
// // // }
// //
// // // orderTimeDel.selectByValue("09:30");
// // // Thread.sleep(5000);
// // //
// // // System.out.println("The Selected Option: " + Time);
// //
// // // String[] amorderTimeDelValueSplit = orderTimeDelValue.split("AM");
// // // String amorderTimeDelValueNumPart1 =
// // amorderTimeDelValueSplit[0].replace(":",
// // // ".");
// // // float amfltorderTimeDelValueSplit =
// // // Float.parseFloat(amorderTimeDelValueNumPart1);
// // //
// // // String[] pmorderTimeDelValueSplit = orderTimeDelValue.split("PM");
// // // String pmorderTimeDelValueNumPart1 =
// // pmorderTimeDelValueSplit[0].replace(":",
// // // ".");
// // // float pmfltorderTimeDelValueSplit =
// // // Float.parseFloat(pmorderTimeDelValueNumPart1);
// //
// // // if (dblOrderTimeDelValue >= dblexpTimeSplitPart1 &&
// dblOrderTimeDelValue <
// // // 21.00) {
// // // System.out.println("Time Selected is within the Delivery Service
// Window: "
// // +
// // // expTimeTxt);
// // // System.out.println("Pass: The Time Selected is: " + Time);
// // // test.log(LogStatus.INFO, "Pass: The Time Selected is: " + Time);
// // // test.log(LogStatus.INFO,
// // // "Time Selected is within the Delivery Service Window. The Expected
// // Delivery
// // // Service Time Window is: "
// // // + expTimeTxt);
// // //
// // // } else {
// // // test.log(LogStatus.INFO, "Fail:The Time Selected is out of Delivery
// // Service
// // // Window: " + Time);
// // // test.log(LogStatus.INFO, "The Expected Delivery Service Time Window is:
// "
// // +
// // // expTimeTxt);
// //
// // // if (orderTimeDelValue.endsWith("PM")) {
// // // if (pmfltorderTimeDelValueSplit >= fexpTimeSplitPart1
// // // && pmfltorderTimeDelValueSplit < fexpTimeSplitPart2) {
// // // test.log(LogStatus.INFO, "Time Selected is within the Delivery Service
// // // Window: " + expTimeDelTxt);
// // //
// // // test.log(LogStatus.INFO, "Pass: Time Selected is: " +
// orderTimeDelValue);
// // // } else {
// // // test.log(LogStatus.INFO, "Fail: Time Selected is: " +
// orderTimeDelValue);
// // // }
// //
// // String delAddrTxt = orderDeliveryAddrText.getText();
// // String zeroMilesTxt = zeroMilesText.getText();
// //
// // if (delAddrTxt.contains(delAddrTxt) && zeroMilesText.isDisplayed()) {
// // System.out.println(
// // "Pass: This Restaurant Address is about 0 mile from the Restaurant Current
// // Address Location"
// // + zeroMilesTxt);
// // test.log(LogStatus.INFO,
// // "Pass: This Restaurant Address is about 0 mile from the Restaurant Current
// // Address Location "
// // + zeroMilesTxt);
// //
// // } else {
// // System.out.println(
// // "Fail: Though the Delivery Address and Restaurant Address are same, about
// 0
// // mile from the Restaurant Current Address Location Text is not Displayed
// // Properly"
// // + delAddrTxt);
// // test.log(LogStatus.INFO,
// // "Fail: Though the Delivery Address and Restaurant Address are not same" +
// // zeroMilesTxt);
// // }
// //
// // Select tipsel = new Select(selectTipAmt);
// // tipsel.selectByValue("15");
// // test.log(LogStatus.INFO, "The Tip Amount is: 15% ");
// // System.out.println("The Selected Tip Amount is 15%: ");
// //
// // float ftotAmount$ = fSubTotAmount + (fSubTotAmount * 15 / 100) + $Tax;
// // // double rtotAmount$=Math.nextDown(totAmount$);
// //
// // String sTotAmount = totalAmt.getText();
// // System.out.println("The Total Amount displayed is: " + sTotAmount);
// //
// // float TotoalAmount$ = Float.parseFloat(sTotAmount);
// //
// // if (ftotAmount$ == TotoalAmount$) {
// // System.out.println("Total Amount is Right " + ftotAmount$);
// // test.log(LogStatus.INFO,
// // "Pass:The Total Amount of Order to Check Out Payment is Right and
// Validated:
// // "
// // + ftotAmount$);
// // } else {
// // System.out.println("The Total Amount is wrong " + ftotAmount$);
// // test.log(LogStatus.INFO,
// // "Fail:The Total Amount of Order to Check Out Payment is wrong and
// Validated:
// // "
// // + ftotAmount$);
// //
// // }
// //
// // Actions act1 = new Actions(driver);
// // act1.moveToElement(chkoutDeliveryBtn).build().perform();
// // Thread.sleep(5000);
// //
// // chkoutDeliveryBtn.click();
// // Thread.sleep(3000);
// //
// // if (checkOutTitleText.isDisplayed()) {
// // System.out.println("Pass:*****" + checkOutTitleText.getText());
// // test.log(LogStatus.INFO, "Pass:The Checkout Page is Displayed: " +
// // checkOutTitleText.getText());
// //
// // } else {
// // test.log(LogStatus.INFO,
// // "Fail:The Checkout Page is Displayed: " +
// checkOutTitleText.isDisplayed());
// // System.out.println("Pass:*****" + checkOutTitleText.isDisplayed());
// // }
// //
// // // firstName.sendKeys("ZZZZ");
// // // System.out.println("Found ZZZZ XPath");
// // firstName.sendKeys(firstname);
// // lastName.sendKeys(lastname);
// // c_Phone.sendKeys(phone);
// // c_Email.sendKeys(email);
// // splInstrctions.sendKeys(specialinstructions);
// //
// // nameOnCard.sendKeys(nameoncard);
// // // }
// // // catch (NullPointerException e) {
// // // System.out.print("Empty String");
// // }
// //
// // cardNumber.sendKeys(cardnumber);
// // expiryMonth.sendKeys(expirymonth);
// // expiryYear.sendKeys(expiryyear);
// // cvvCode.sendKeys(cvvcode);
// // billZip.sendKeys(billingzip);
// //
// // Thread.sleep(7000);
// // placeMyOrderBtn.click();
// //
// // Thread.sleep(9000);
// // if (orderThankYouText.isDisplayed())
// //
// // {
// // System.out.println("Pass:*****" + orderThankYouText.getText());
// // test.log(LogStatus.INFO, "Pass:The Thank You Page is Displayed: " +
// // orderThankYouText.getText());
// // test.log(LogStatus.INFO, "Receipt Number for the Order is: " +
// // receiptNumText.getText());
// // } else {
// // test.log(LogStatus.INFO, "Fail:The Checkout Page is Displayed: " +
// // orderThankYouText.isDisplayed());
// // System.out.println("Fail:*****" + orderThankYouText.isDisplayed());
// // }
// // }
// // }
// // }
// //

// @SuppressWarnings("deprecation")
////// public void reserverSlotTime() throws InterruptedException {
//
//// Thread.sleep(6000);
//// reserveTable.click();
//// Thread.sleep(7000);
//// tSlot.click();
//// Thread.sleep(6000);
// // reserveItButton.click();
//
// // WebElement restbltSlot=selecttSlot;
//
// // String[] spltTimeSlots = timeSlots.split("AM");
// // String FirstPart = spltTimeSlots[0];
// // System.out.println("The Number Part is: " + spltTimeSlots[0]);
//
// // Float.parseFloat(timeSlots);
//
// // ZonedDateTime indTime = ZonedDateTime.of(timePoint,indiaTime);
// // assertThat(newYorkTime.toString(),
// // is("2014-04-28T21:45:50-04:00[America/New_York]"));
//
// // ZonedDateTime newYorkTime = ZonedDateTime.of(timePoint);
// // String snewyorkTime=newyorkTime.toString();
// // String date2= dateFormat.format(date);
// // String snewyorkTime=newYorkTime.toString();
//
// // ZoneId newYokZoneId = ZoneId.of("America/New_York");
//
// // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:h:mm
// // a");
//
// // String formatnyDateTime = zdt.format(formatter);
// // String secondSplit = FirstPart.replace(":", ".");
//
// // float ftimeUnits = Float.parseFloat(secondSplit);
// // System.out.println("The Slot Time is:" + ftimeUnits);
// // int intFormatDateTime=Integer.parseInt(FirstPart);
// // ZoneOffset nyOffSet=ZoneOffset.of("-5:00");
// // ZonedDateTime nyDateTime;
// // =zdt.withZoneSameInstant(nyOffSet).plusHours(9).plusMinutes(30);
// // Print the Date
// // ZonedDateTime newYokZoneId =
// dateTime.atZone(ZoneId.of("America/New_York"))
// ZonedDateTime zdt = ZonedDateTime.now();
// System.out.println("The India Zoned Date/Time: " + zdt);
// DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd:hh:mm
// a");
// String formatzdtDateTime = zdt.format(formatter);
//
// // LocalDateTime timePoint = LocalDateTime.parse(formatzdtDateTime);
// // System.out.println("The Time Point is: "+timePoint);
// // ZonedDateTime zdt = ZonedDateTime.now();
// // ZoneId newYokZoneId = ZoneId.of("America/New_York");
// // ZonedDateTime indTime = ZonedDateTime.of(timePoint);
// ZoneId newYokZoneId = ZoneId.of("America/New_York");
// // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:h:mm
// // a");
//
// // ZonedDateTime zdt = ZonedDateTime.now();
//
// ZonedDateTime nyDateTime = zdt.withZoneSameInstant(newYokZoneId);
// System.out.println("The NY Zoned Date/Time: " + nyDateTime);
// String formatnyDateTime = nyDateTime.format(formatter1);
// System.out.println("The Formatted NY Time is: " + formatnyDateTime);
//
// // ZonedDateTime newYorkTime = ZonedDateTime.of(timePoint, newYokZoneId);
// DayOfWeek dayOfWeek = nyDateTime.getDayOfWeek();
// String dow = dayOfWeek.toString();
//
// // String dow = dayOfWeek.toString();
// System.out.println("The Day of the Week: " + dayOfWeek);
//
// // int idow = Integer.parseInt(dow);
// // System.out.println("The Day of the Week: " + idow);
// // String formatnyDateTime = nyDateTime.format(formatter);
//
// if (formatnyDateTime.endsWith("AM")) {
// System.out.println("Ends With AM");
// // LocalDateTime atimePoint = LocalDateTime.parse("2014-04-28T21:45:50");
// ZoneId anewYokZoneId = ZoneId.of("America/New_York");
//
// DateTimeFormatter aformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:hh:mm
// a");
// ZonedDateTime anyDateTime = zdt.withZoneSameInstant(anewYokZoneId);
// String aformatnyDateTime = anyDateTime.format(aformatter);
// String[] asplitnyDateTime = aformatnyDateTime.split("AM");
// System.out.println("The String Split is: " + asplitnyDateTime[0]);
// String astrsplitnyDateTime = asplitnyDateTime[0];
// System.out.println("The AM Split is: " + astrsplitnyDateTime);
// String[] amsplitnyDateTime = astrsplitnyDateTime.split(":");
// System.out.println("The String after the Split is: " + amsplitnyDateTime[0]);
// System.out.println("The String after the Split is: " + amsplitnyDateTime[1]);
// System.out.println("The String after the Split is: " + amsplitnyDateTime[2]);
// String aintg1splitnyDateTime = amsplitnyDateTime[1];
// String aintg2splitnyDateTime = amsplitnyDateTime[2];
// Double dstr1 = Double.valueOf(aintg1splitnyDateTime);
// Double dstr2 = Double.valueOf(aintg2splitnyDateTime);
// // Integer istr1= Integer.parseInt(aintg1splitnyDateTime);
// // Integer istr2= Integer.parseInt(aintg2splitnyDateTime);
// // Long lstr1=Long.parseLong(aintg1splitnyDateTime);
// // Long lstr2=Long.parseLong(aintg2splitnyDateTime);
// // Float fstr1=Float.parseFloat(aintg1splitnyDateTime);
// // Float fstr2=Float.parseFloat(aintg2splitnyDateTime);
//
// // int aint1splitnyDateTime =Integer.parseInt(aintg1splitnyDateTime);
// // int aint2splitnyDateTime = Integer.parseInt(aintg2splitnyDateTime);
//
// System.out.println("The First Number Part: " + dstr1);
// System.out.println("The Second Number Part: " + dstr2);
//
// System.out.println("The Current Booking System Time is: " +
// aformatnyDateTime);
// WebElement tSlots1130 = tSlots.findElement(
// By.xpath("//form[@id='bookform']/div[1]/div/div[1]/div[3]/descendant::li[position()=1]"));
// // String timeSlots1130 = tSlots1130
// //
// .findElement(By.xpath("//form[@id='bookform']/div[1]/div/div[1]/descendant::li[position()=1]"))
// // .getText();
// String timeSlots1130 = tSlots1130.getText();
//
// // System.out.println("The Time Slot is: " + timeSlots1130);
//
// WebElement tSlots1200 = tSlots
// .findElement(By.xpath("//form[@id='bookform']/div[1]/div/div[1]/descendant::li[position()=2]"));
// String timeSlots1200 = tSlots1200
// .findElement(By.xpath("//form[@id='bookform']/div[1]/div/div[1]/descendant::li[position()=2]"))
// .getText();
//
// //
// // String formatnyDateTime = nyDateTime.format(formatter);
// // WebElement
// wtSlots90=tSlots.findElement(By.xpath("//li[@timeslot_book='09:00
// // AM']"));
// // String timeSlots90 = wtSlots90.getText();
// // System.out.println("The Available Slots: " + timeSlots90);
// //
// // WebElement
// wtSlots93=tSlots.findElement(By.xpath("//li[@timeslot_book='09:30
// // AM']"));
// // String timeSlots93 = wtSlots93.getText();
// //// System.out.println("The Time Slot 9:30 is: " + timeSlots93);
// //
// // WebElement
// wtSlots10=tSlots.findElement(By.xpath("//li[@timeslot_book='10:00
// // AM']"));
// // String timeSlots10 =
// tSlots.findElement(By.xpath("//li[@timeslot_book='10:00
// // AM']")).getText();
// //// System.out.println("The Time Slot 9:30 is: " + timeSlots10);
// // String timeSlots13 =
// tSlots.findElement(By.xpath("//li[@timeslot_book='10:30
// // AM']")).getText();
// //// System.out.println("The Time Slot 9:30 is: " + timeSlots13);
// // String timeSlots11 =
// tSlots.findElement(By.xpath("//li[@timeslot_book='11:00
// // AM']")).getText();
// //// System.out.println("The Time Slot 9:30 is: " + timeSlots11);
// // String timeSlots1130 =
// // tSlots.findElement(By.xpath("//li[contaiins(text()='11:30
// AM')]")).getText();
// // System.out.println("The Time Slot is: "+ timeSlots1130);
// //// String timeSlots113 =
// // tSlots.findElement(By.xpath("//li[@timeslot_book='11:30 AM']")).getText();
// //// System.out.println("The Time Slot 9:30 is: " + timeSlots113);
// // String timeSlots12 =
// tSlots.findElement(By.xpath("//li[@timeslot_book='12:00
// // PM']")).getText();
// //// System.out.println("The Time Slot 9:30 is: " + timeSlots12);
// // String timeSlots123 =
// tSlots.findElement(By.xpath("//li[@timeslot_book='12:30
// // PM']")).getText();
// //// System.out.println("The Time Slot 9:30 is: " + timeSlots123);
// // String timeSlots100 =
// tSlots.findElement(By.xpath("//li[@timeslot_book='01:00
// // PM']")).getText();
// //// System.out.println("The Time Slot 9:30 is: " + timeSlots100);
// // String timeSlots130 =
// tSlots.findElement(By.xpath("//li[@timeslot_book='01:30
// // PM']")).getText();
// //// System.out.println("The Time Slot 9:30 is: " + timeSlots130);
// // String timeSlots200 =
// tSlots.findElement(By.xpath("//li[@timeslot_book='02:00
// // PM']")).getText();
// //// System.out.println("The Time Slot 9:30 is: " + timeSlots200);
// // String timeSlots230 =
// tSlots.findElement(By.xpath("//li[@timeslot_book='02:30
// // PM']")).getText();
// //// System.out.println("The Time Slot 9:30 is: " + timeSlots230);
// // String timeSlots300 =
// tSlots.findElement(By.xpath("//li[@timeslot_book='03:00
// // PM']")).getText();
// //// System.out.println("The Time Slot 9:30 is: " + timeSlots300);
// // String timeSlots330 =
// tSlots.findElement(By.xpath("//li[@timeslot_book='03:30
// // PM']")).getText();
// //// System.out.println("The Time Slot 9:30 is: " + timeSlots330);
// // String timeSlots400 =
// tSlots.findElement(By.xpath("//li[@timeslot_book='04:30
// // PM']")).getText();
// //// System.out.println("The Time Slot 9:30 is: " + timeSlots400);
// // String timeSlots430 =
// tSlots.findElement(By.xpath("//li[@timeslot_book='04:30
// // PM']")).getText();
// //// System.out.println("The Time Slot 9:30 is: " + timeSlots430);
// // String timeSlots500 =
// tSlots.findElement(By.xpath("//li[@timeslot_book='05:00
// // PM']")).getText();
// //// System.out.println("The Time Slot 9:30 is: " + timeSlots500);
// // String timeSlots530 =
// tSlots.findElement(By.xpath("//li[@timeslot_book='05:30
// // PM']")).getText();
// //// System.out.println("The Time Slot 9:30 is: " + timeSlots530);
// // String timeSlots600 =
// tSlots.findElement(By.xpath("//li[@timeslot_book='06:00
// // PM']")).getText();
// //// System.out.println("The Time Slot 9:30 is: " + timeSlots600);
// // String timeSlots630 =
// tSlots.findElement(By.xpath("//li[@timeslot_book='06:30
// // PM']")).getText();
// //// System.out.println("The Time Slot 9:30 is: " + timeSlots630);
// // String timeSlots700 =
// tSlots.findElement(By.xpath("//li[@timeslot_book='07:00
// // PM']")).getText();
// //// System.out.println("The Time Slot 9:30 is: " + timeSlots700);
// // String timeSlots730 =
// tSlots.findElement(By.xpath("//li[@timeslot_book='07:30
// // PM']")).getText();
// //// System.out.println("The Time Slot 9:30 is: " + timeSlots730);
// WebElement tslots800 =
// driver.findElement(By.xpath("//li[@timeslot_book='08:00 AM']"));
// String timeSlots800 = tslots800.getText();
// System.out.println("The Time Slot 8:00 is: " + timeSlots800);
// //
// //
// //
// // // String timeSlots830 =
// // tSlots.findElement(By.xpath("//li[@timeslot_book='08:30
// // // PM']")).getText();
// // // System.out.println("The Time Slot 9:30 is: "+timeSlots93);
// // // String timeSlots900 =
// // tSlots.findElement(By.xpath("//li[@timeslot_book='09:00
// // // PM']")).getText();
// // // System.out.println("The Time Slot 9:30 is: "+timeSlots93);
// // // String timeSlots903 =
// // tSlots.findElement(By.xpath("//li[@timeslot_book='09:30
// // // PM']")).getText();
// // // System.out.println("The Time Slot 9:30 is: "+timeSlots93);
// WebElement tSlots1000 = tSlots.findElement(
// By.xpath("//form[@id='bookform']/div[1]/div/div[1]/div[3]/descendant::li[position()=1]"));
// // String timeSlots1000 = tSlots1000
// //
// .findElement(By.xpath("//form[@id='bookform']/div[1]/div/div[1]/descendant::li[position()=2]"))
// // .getText();
// String timeSlots1000 = tSlots1000.getText();
// WebElement tSlots1030 = tSlots.findElement(
// By.xpath("//form[@id='bookform']/div[1]/div/div[1]/div[3]/descendant::li[position()=2]"));
// // String timeSlots1030 = tSlots1000
// //
// .findElement(By.xpath("//form[@id='bookform']/div[1]/div/div[1]/descendant::li[position()=2]"))
// // .getText();
// String timeSlots1030 = tSlots1030.getText();
//
// WebElement tSlotsNA = tSlots.findElement(
// By.xpath("//form[@id='bookform']/div[1]/div/div[1]/div[3]/descendant::div[position()=1]"));
// String timeSlotsNA = tSlotsNA.getText();
// // // DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy:HH:MM ");
// // // SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
// //
// // // get current date time with Date()
// // // Date date = new Date();
// //
// // // Now format the date
// // // String date1= format.format(date);
// // // Float flDate1= Float.parseFloat(date1);
// // // System.out.println("The Formatted Local Date Time at India is: :
// "+date1);
// //
// // // LocalDateTime Ldt = null;
// //
// // // LocalDateTime timePoint = LocalDateTime.parse("2014-04-28T21:45:50");
// //
// // // LocalDateTime timePoint = LocalDateTime.parse("2014-04-28T21:45:50");
// //
// // // ZoneId newYokZoneId = ZoneId.of("America/New_York");
// // // ZonedDateTime indTime = ZonedDateTime.of(timePoint,indiaTime);
// // // assertThat(newYorkTime.toString(),
// // // is("2014-04-28T21:45:50-04:00[America/New_York]"));
// //
// // // ZonedDateTime newYorkTime = ZonedDateTime.of(timePoint);
// // // String snewyorkTime=newyorkTime.toString();
// // // String date2= dateFormat.format(date);
// // // String snewyorkTime=newYorkTime.toString();
// // // ZonedDateTime zdt = ZonedDateTime.now();
// //
// // // DateTimeFormatter formatter =
// DateTimeFormatter.ofPattern("yyyy-MM-dd:h:mm
// // // a");
// //
// // // String formatindDateTime = zdt.format(formatter);
// // // String secondSplit = FirstPart.replace(":", ".");
// //
// // // float ftimeUnits = Float.parseFloat(secondSplit);
// // // System.out.println("The Slot Time is:" + ftimeUnits);
// // // int intFormatDateTime=Integer.parseInt(FirstPart);
// // // ZoneOffset nyOffSet=ZoneOffset.of("-5:00");
// // // ZonedDateTime nyDateTime
// // // =zdt.withZoneSameInstant(nyOffSet).plusHours(9).plusMinutes(30);
// // // Print the Date
// // // ZonedDateTime newYokZoneId =
// // dateTime.atZone(ZoneId.of("America/New_York"))
// // // ZonedDateTime nyDateTime = zdt.withZoneSameInstant(newYokZoneId);
// // // ZoneId newYokZoneId = ZoneId.of("America/New_York");
// // //
// // // DateTimeFormatter formatter =
// // DateTimeFormatter.ofPattern("yyyy-MM-dd:hh:mm
// // // a");
// // // ZonedDateTime nyDateTime = zdt.withZoneSameInstant(newYokZoneId);
// // // String pformatnyDateTime = pnyDateTime.format(pformatter);
// // // String formatnyDateTime = nyDateTime.format(formatter);
// // System.out.println("The NY Time now is: " + formatnyDateTime);
// //
// // if (formatnyDateTime.endsWith("PM")) {
// // System.out.println("Ends With PM");
// // // LocalDateTime timePoint = LocalDateTime.parse("2014-04-28T21:45:50");
// // // ZoneId newYokZoneId = ZoneId.of("America/New_York");
// // // ZonedDateTime zdt = ZonedDateTime.now();
// // // ZonedDateTime nyDateTime = zdt.withZoneSameInstant(newYokZoneId);
// // // String formatnyDateTime = nyDateTime.format(formatter);
// // //
// // // DateTimeFormatter formatter =
// // DateTimeFormatter.ofPattern("yyyy-MM-dd:h:mm
// // // a");
// // ZonedDateTime nyDateTime = zdt.withZoneSameInstant(newYokZoneId);
// // String pformatnyDateTime = nyDateTime.format(formatter);
// // String[] psplitnyDateTime = pformatnyDateTime.split("PM");
// // String pstrsplitnyDateTime = psplitnyDateTime[0] + psplitnyDateTime[1] +
// // psplitnyDateTime[2];
// // String[] pmsplitnyDateTime = pstrsplitnyDateTime.split(":");
// // int pint1splitnyDateTime = Integer.parseInt(pmsplitnyDateTime[1]);
// // int pint2splitnyDateTime = Integer.parseInt(pmsplitnyDateTime[2]);
//
// if (dow == "TUESDAY" && aformatnyDateTime.endsWith("AM") && dstr1 == 12.0 &&
// dstr2 <= 59.0) {
// if (tslots800.isDisplayed()) {
// System.out.println("Pass: The Available Time Slot Displayed is: " +
// timeSlots800);
// test.log(LogStatus.INFO, "Pass: The Current Reservation Date Time is: " +
// aformatnyDateTime);
// test.log(LogStatus.INFO, "Pass: The Available Time Slot Displayed is: " +
// timeSlots800);
// } else {
// System.out.println("Fail:******" + timeSlots800);
// test.log(LogStatus.INFO, "Fail: The Current Reservation Date Time is: " +
// aformatnyDateTime);
// test.log(LogStatus.INFO, "Fail: The Available Time Slot Displayed is Wrong :"
// + timeSlots800);
//
// }
// }
//
// if (dow == "TUESDAY" && aformatnyDateTime.endsWith("AM") && dstr1 >= 1.0 &&
// dstr1 <= 8.0) {
// if (tslots800.isDisplayed()) {
//
// System.out.println("Ends WitAM *****");
// System.out.println("Pass:The Available Slots for Reservation is: " +
// timeSlots800
// + "The Current Reservation Date Time is: " + aformatnyDateTime);
// test.log(LogStatus.INFO, "Pass: The Current Reservation Date Time is: " +
// aformatnyDateTime);
// test.log(LogStatus.INFO, "Pass: The Available Time Slot Displayed is: " +
// timeSlots800);
//
// // reqresFirstName.sendKeys("Ram");
//
// }
//
// else {
// System.out.println("Fail:******" + timeSlots800);
// test.log(LogStatus.INFO, "Fail: The Current Reservation Date Time is: " +
// aformatnyDateTime);
// test.log(LogStatus.INFO, "Fail: The Available Time Slot Displayed is Wrong :"
// + timeSlots800);
//
// }
// }
//
// if (formatnyDateTime.endsWith("PM")) {
// System.out.println("Ends With PM");
// // LocalDateTime atimePoint = LocalDateTime.parse("2014-04-28T21:45:50");
// ZoneId pnewYokZoneId = ZoneId.of("America/New_York");
//
// DateTimeFormatter pformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd:hh:mm
// a");
// ZonedDateTime pnyDateTime = zdt.withZoneSameInstant(pnewYokZoneId);
// String pformatnyDateTime = pnyDateTime.format(aformatter);
// String[] psplitnyDateTime = pformatnyDateTime.split("PM");
// System.out.println("The String Split is: " + psplitnyDateTime[0]);
// String pstrsplitnyDateTime = psplitnyDateTime[0];
// System.out.println("The PM Split is: " + pstrsplitnyDateTime);
// String[] pmsplitnyDateTime = pstrsplitnyDateTime.split(":");
// System.out.println("The String after the Split is: " + pmsplitnyDateTime[0]);
// System.out.println("The String after the Split is: " + pmsplitnyDateTime[1]);
// System.out.println("The String after the Split is: " + pmsplitnyDateTime[2]);
// String pintg1splitnyDateTime = pmsplitnyDateTime[1];
// String pintg2splitnyDateTime = pmsplitnyDateTime[2];
// Double pdstr1 = Double.valueOf(aintg1splitnyDateTime);
// Double pdstr2 = Double.valueOf(aintg2splitnyDateTime);
// // Integer istr1= Integer.parseInt(aintg1splitnyDateTime);
// // Integer istr2= Integer.parseInt(aintg2splitnyDateTime);
// // Long lstr1=Long.parseLong(aintg1splitnyDateTime);
// // Long lstr2=Long.parseLong(aintg2splitnyDateTime);
// // Float fstr1=Float.parseFloat(aintg1splitnyDateTime);
// // Float fstr2=Float.parseFloat(aintg2splitnyDateTime);
//
// // int aint1splitnyDateTime =Integer.parseInt(aintg1splitnyDateTime);
// // int aint2splitnyDateTime = Integer.parseInt(aintg2splitnyDateTime);
//
// System.out.println("The First Number Part: " + pdstr1);
// System.out.println("The Second Number Part: " + pdstr2);
//
// if (dow == "TUESDAY") {
// System.out.println("The Current Reserevation System Time is: " +
// aformatnyDateTime);
// }
//
// if ((dow == "SATURDAY") && pformatnyDateTime.endsWith("PM") && pdstr1 == 10.0
// && pdstr2 < 29.0) {
// if (tSlots1000.isDisplayed()) {
//
// System.out.println("Pass: The Available Time Slot Displayed is: " +
// timeSlots1000);
// test.log(LogStatus.INFO, "Pass: The Current Reservation Date Time is: " +
// aformatnyDateTime);
// test.log(LogStatus.INFO, "Pass: The Available Time Slot Displayed is: " +
// timeSlots1000);
// } else {
// System.out.println("Fail:******" + timeSlots1000);
// test.log(LogStatus.INFO, "Fail: The Current Reservation Date Time is: " +
// aformatnyDateTime);
// test.log(LogStatus.INFO, "Fail: The Available Time Slot Displayed is Wrong :"
// + timeSlots1000);
//
// }
// }
// if ((dow == "SATURDAY") && pformatnyDateTime.endsWith("PM") && pdstr1 == 10.0
// && pdstr2 >= 29.0
// && pdstr2 <= 59) {
// if (tSlots1030.isDisplayed()) {
//
// System.out.println("Pass: The Available Time Slot Displayed is: " +
// timeSlots1030);
// test.log(LogStatus.INFO, "Pass: The Current Reservation Date Time is: " +
// aformatnyDateTime);
// test.log(LogStatus.INFO, "Pass: The Available Time Slot Displayed is: " +
// timeSlots1030);
// } else {
// System.out.println("Fail:******" + timeSlots1030);
// test.log(LogStatus.INFO, "Fail: The Current Reservation Date Time is: " +
// aformatnyDateTime);
// test.log(LogStatus.INFO, "Fail: The Available Time Slot Displayed is Wrong :"
// + timeSlots1030);
//
// }
// }
// if ((dow == "SATURDAY") && pformatnyDateTime.endsWith("PM") && pdstr1 >=
// 11.0) {
// if (tSlotsNA.isDisplayed()) {
//
// System.out.println("Pass: The Available Time Slot Displayed is: " +
// timeSlotsNA);
// test.log(LogStatus.INFO, "Pass: The Current Reservation Date Time is: " +
// aformatnyDateTime);
// test.log(LogStatus.INFO, "Pass: The Available Time Slot Displayed is: " +
// timeSlotsNA);
// } else {
// System.out.println("Fail:******" + timeSlotsNA);
// test.log(LogStatus.INFO, "Fail: The Current Reservation Date Time is: " +
// aformatnyDateTime);
// test.log(LogStatus.INFO, "Fail: The Available Time Slot Displayed is Wrong :"
// + timeSlotsNA);
//
// }
// }
// }
// }
// }
// }
//
//
////// if (dow == "THURSDAY"&&aformatnyDateTime.endsWith("AM") && dstr1 <= 8.0
// &&
//// dstr2 < 29.0 ) {
//////
////// System.out.println("Ends With AM *****");
////// System.out.println("The Available Slots for Reservation is: " +
//// timeSlots90);
//////
////// test.log(LogStatus.INFO, "Pass: The Available Time Slot Displayed is: " +
//// timeSlots90);
////// // float diff1=fnyDateTime-ftimeUnits;
////// // String fsysnyDateTime=String.valueOf(sysnyDateTime);
////// // System.out.println("The Time at India is: " + formatindDateTime);
////// // System.out.println("The Time at NewYork now is: " + formatnyDateTime);
////// } else {
////// System.out.println("Fail:******" + timeSlots90);
////// test.log(LogStatus.INFO, "Fail:", timeSlots90);
//////
////// }
//// if (dow == "FRIDAY" && aformatnyDateTime.endsWith("AM") && dstr1 == 12.0 &&
//// dstr2 <= 59.0
//// && tSlots1130.isDisplayed()) {
////
//// System.out.println("Ends With 9:30 AM *****");
//// System.out.println("Pass:The Available Slots for Reservation is: " +
//// timeSlots1130);
////
//// test.log(LogStatus.INFO, "Pass: The Available Time Slot Displayed is: " +
//// timeSlots1130);
//// // float diff1=fnyDateTime-ftimeUnits;
//// // String fsysnyDateTime=String.valueOf(sysnyDateTime);
//// // System.out.println("The Time at India is: " + formatindDateTime);
//// // System.out.println("The Time at NewYork now is: " + formatnyDateTime);
//// }
//// // else {
//// // System.out.println("Fail:******" + timeSlots1130);
//// // test.log(LogStatus.INFO, "Fail:", timeSlots1130);
//// //
//// // }
//// if (dow == "FRIDAY" && aformatnyDateTime.endsWith("AM") && dstr1 >= 1.0 &&
//// dstr1 < 11.0) {
//// if(tSlots1130.isDisplayed()) {
////
//// System.out.println("Ends WitAM *****");
//// System.out.println("Pass:The Available Slots for Reservation is: " +
//// timeSlots1130
//// + "The Current Reservation Date Time is: " + aformatnyDateTime);
//// test.log(LogStatus.INFO, "Pass: The Current Reservation Date Time is: " +
//// aformatnyDateTime);
//// test.log(LogStatus.INFO, "Pass: The Available Time Slot Displayed is: " +
//// timeSlots1130);
////
//// reqresFirstName.sendKeys("Ram");
////
////
////
////
//// }
////
////
////
////
////
//// // float diff1=fnyDateTime-ftimeUnits;
//// // String fsysnyDateTime=String.valueOf(sysnyDateTime);
//// // System.out.println("The Time at India is: " + formatindDateTime);
//// // System.out.println("The Time at NewYork now is: " + formatnyDateTime);
////
//// else {
//// System.out.println("Fail:******" + timeSlots1130);
//// test.log(LogStatus.INFO, "Fail: The Current Reservation Date Time is: " +
//// aformatnyDateTime);
//// test.log(LogStatus.INFO, "Fail: The Available Time Slot Displayed is Wrong
// :"
//// + timeSlots1130);
////
//// }
//// }
////
////
//// if (dow == "FRIDAY" && aformatnyDateTime.endsWith("AM") && dstr1 == 11.0 &&
//// dstr2 >= 29.0) {
//// if (tSlots1200.isDisplayed()) {
////
//// System.out.println("Ends WitAM *****");
//// System.out.println("Pass:The Available Slots for Reservation is: " +
//// timeSlots1200
//// + "The Current Reservation Date Time is: " + aformatnyDateTime);
//// test.log(LogStatus.INFO, "Pass: The Current Reservation Date Time is: " +
//// aformatnyDateTime);
//// test.log(LogStatus.INFO, "Pass: The Available Time Slot Displayed is: " +
//// timeSlots1200);
//// }
////
//// else {
//// System.out.println("Fail:******" + timeSlots1200);
//// System.out.println("Fail:The Available Slots for Reservation is: " +
//// timeSlots1200
//// + "The Current Reservation Date Time is: " + aformatnyDateTime);
//// test.log(LogStatus.INFO, "Fail: The Current Reservation Date Time is: " +
//// aformatnyDateTime);
//// test.log(LogStatus.INFO, "Fail: The Available Time Slot Displayed is Wrong
// :
//// " + timeSlots1200);
////
//// }
////
//// }
//// }
//// }
//// }
////
////
////
////
////
//// // if (dow == "THURSDAY"&&aformatnyDateTime.endsWith("AM") && dstr1==9 &&
//// dstr2
//// // > 29 && wtSlots10.isSelected()) {
//// //
//// // System.out.println("Ends With 9:30 AM *****");
//// // System.out.println("Pass:The Available Slots for Reservation is: " +
//// // timeSlots10);
//// //
//// // test.log(LogStatus.INFO, "Pass: The Available Time Slot Displayed is: "
// +
//// // timeSlots10);
//// // // float diff1=fnyDateTime-ftimeUnits;
//// // // String fsysnyDateTime=String.valueOf(sysnyDateTime);
//// // // System.out.println("The Time at India is: " + formatindDateTime);
//// // // System.out.println("The Time at NewYork now is: " +
// formatnyDateTime);
//// // } else {
//// // System.out.println("Fail:******" + timeSlots10);
//// // test.log(LogStatus.INFO, "Fail:", timeSlots10);
//// //
//// // }
//// //
////
//// //// System.out.println("The First Number Part: " + pmsplitnyDateTime[1]);
//// //// System.out.println("The Second Number Part: " + pmsplitnyDateTime[2]);
////
//// //
//// // if(formatnyDateTime.endsWith("AM")) {
//// // System.out.println("Ends With AM");
//// // // LocalDateTime atimePoint =
// LocalDateTime.parse("2014-04-28T21:45:50");
//// // ZoneId anewYokZoneId = ZoneId.of("America/New_York");
//// //
//// // DateTimeFormatter aformatter =
//// DateTimeFormatter.ofPattern("yyyy-MM-dd:hh:mm
//// // a");
//// // ZonedDateTime anyDateTime = zdt.withZoneSameInstant(anewYokZoneId);
//// // String aformatnyDateTime = anyDateTime.format(aformatter);
//// // String[] asplitnyDateTime = aformatnyDateTime.split("AM");
//// // System.out.println("The String Split is: " + asplitnyDateTime[0]);
//// // String astrsplitnyDateTime = asplitnyDateTime[0];
//// // System.out.println("The AM Split is: " + astrsplitnyDateTime);
//// // String[] amsplitnyDateTime = astrsplitnyDateTime.split(":");
//// // System.out.println("The String after the Split is: " +
//// amsplitnyDateTime[0]);
//// // System.out.println("The String after the Split is: " +
//// amsplitnyDateTime[1]);
//// // System.out.println("The String after the Split is: " +
//// amsplitnyDateTime[2]);
//// // String aintg1splitnyDateTime = amsplitnyDateTime[1];
//// // String aintg2splitnyDateTime = amsplitnyDateTime[2];
//// // Double dstr1 = Double.valueOf(aintg1splitnyDateTime);
//// // Double dstr2 = Double.valueOf(aintg2splitnyDateTime);
//// // //
//// // // // int aint1splitnyDateTime =Integer.parseInt(aintg1splitnyDateTime);
//// // // // int aint2splitnyDateTime =
// Integer.parseInt(aintg2splitnyDateTime);
//// // //
//// // System.out.println("The First Number Part: " + dstr1);
//// // System.out.println("The Second Number Part: " + dstr2);
////
//// //// System.out.println("The Current Booking System Time is: " +
//// //// aformatnyDateTime);
//// //
////
////
//// //
//// //
//// //
//// // //
//// // // System.out.println("The Difference is: "+diff1);
//// // // LocalDateTime dateTime = null;
//// // // SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//// // // DateTimeFormatter format = DateTimeFormatter.ofPattern("HHmm, dd MMM
//// // yyyy");
//// //
//// // // Date dt=new Date();
//// // // String fDate=format.format(dt);
//// // // LocalDateTime iDate=LocalDateTime.parse(fDate);
//// //
//// // // ZonedDateTime indTime = timePoint.atZone(ZoneId.of("Asia/Calcutta"));
//// //
//// // // String date = "2016-08-22 14:30";
//// //
//// // // LocalDateTime ldt = LocalDateTime.parse(fDate,
//// // // DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
//// // // System.out.println("LocalDateTime : " + format.format(ldt));
//// //
//// // // Paris, 2016 Apr-Oct = DST, UTC+2, other months UTC+1
//// // // UTC+2
//// // // ZonedDateTime parisDateTime = ldt.atZone(ZoneId.of("Europe/Paris"));
//// // // System.out.println("Depart : " + format.format(parisDateTime));
//// // // ZoneOffset nyOffSet=ZoneOffset.of("-5:00");
//// // // ZonedDateTime nyDateTime
//// // // =zdt.withZoneSameInstant(nyOffSet).plusHours(9).plusMinutes(30);
//// //
//// // // UTC+9
//// // // ZonedDateTime nyTime =
// dateTime.atZone(ZoneId.of("America/New_York"));
//// //
//// // // UTC+9
//// // // ZonedDateTime jpTime = dateTime.atZone(ZoneId.of("Asia/Tokyo"));
//// //
//// // // System.out.println("The Time at NewYork now is: : " + nyDateTime);
//// //
//// // // Convert to instant UTC+0/Z , java.time helps to reduce 9 hours
//// // // Instant instant = indTime.toInstant();
//// // //
//// // // System.out.println("Instant : " + instant);
//// //
//// // // System.out.println("NY Time is : " + format.format(indTime));
//
//// private void elseif(boolean b) {
//// // TODO Auto-generated method stub
////
//// }
