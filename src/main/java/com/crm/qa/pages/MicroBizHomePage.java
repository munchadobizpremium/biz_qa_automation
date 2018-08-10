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
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.crm.qa.base.TestBase;
import com.crm.qa.testcases.ExtentFactory;
import com.crm.qa.testcases.Screenshots;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MicroBizHomePage extends TestBase {

	GalleryPage gallerypage;
	String sheetName = "TakeOut";
	ExtentTest test;

	// @FindBy(xpath = "//a[contains(text(),'order online')]")
	// WebElement orderOnlineTab;

	@FindBy(xpath = "//a[@class='i_close close']")
	WebElement resTableClose;

	@FindBy(xpath = "//div[@id='pageload']/descendant::ul[position()=1]")
	WebElement topMenuLinks;
	// @FindBy(xpath = "//div[@id='pageload']/descendant::div[position()=3]")
	// @FindBy(xpath ="//div[@id='pageload']/div[1]/div[1]/descendant::a]")
	// @FindBy(tagName = "div")
	// @FindBy(xpath =
	// "//div[@id='pageload']/div[1]/div[1]/descendant::div[position()=1]")

	@FindBy(xpath = "//*[@id='pageload']/descendant::div[position()=2]")
	WebElement restbl_OrderOnln_Links;

	@FindBy(xpath = "//*[@id='pageload']/descendant::div[position()=3]")
	WebElement restbl_OrderOnln_Div3tag_Links;

	@FindBy(xpath = "//p[@class='txt_locationdetail sectiontitle y-popup-title']")
	WebElement mtpt_Orderonline_Popup;

	// @FindBy(xpath = "//*[@id='pageload']/descendant::div[position()=3]")
	// WebElement restbl_OrderOnln_DivA_Links;
	// String restbl_OrderOnln_Links_List_Text =restbl_OrderOnln_Links.getText();

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

	@FindBy(xpath = "//p[contains(text(),'Thank You')]")
	WebElement orderThankYouText;

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

	@FindBy(xpath = "//div[@id='pageload']/div[1]/div/div[1]/descendant::a[position()=1]")
	WebElement orderOnlineTab;
	// "//*[@id='menu_ordersection']/descendant::label[position()=1]

	@FindBy(xpath = "//label[contains(text(),'Delivery')]")
	WebElement orderDeliver;

	@FindBy(xpath = "//a[contains(text(),'checkout for delivery')]")
	WebElement chkoutDeliveryBtn;

	@FindBy(xpath = "//div[@id='menu_ordersection']/descendant::span[position()=1]")
	WebElement orderDeliveryBtn;

	@FindBy(xpath = "//label[@for='t_delivery']/descendant::i[position()=1]")
	WebElement delivernyBtn;

	@FindBy(xpath = "//label[@for='t_delivery']")
	WebElement deliveryButton;

	// @FindBy(xpath="//div[@id='menu']/descendant::span[position()=3]")

	@FindBy(xpath = "//a[@class='ubtn btn_addtocard btn_addtoorder']")
	WebElement orderAddtoCart;

	@FindBy(xpath = "//input[@id='searchTextField']")
	WebElement orderSearchTxtFld;

	@FindBy(xpath = "//a[contains(text(),'verify & proceed to order')]")
	WebElement orderVerifyProceed;

	@FindBy(xpath = "//a[contains(text(),'order takeout')]")
	WebElement orderTakeOut;

	@FindBy(xpath = "//p[contains(text(),'Catering Booking')]")
	WebElement cateringStaticTxt;

	@FindBy(xpath = "//div[@id='catering']/descendant::p[position()=2]")
	WebElement mandatoryFieldsStaticTxt;

	@FindBy(xpath = "//div[@id='contact']/div/div[2]/descendant::p[position()=4]")
	WebElement oredrTopText;

	@FindBy(xpath = "//div[@id='contact']/div/div[2]/descendant::strong[position()=1]")
	WebElement rightAddressTxt;

	@FindBy(xpath = "//a[contains(text(),'+')]")
	WebElement addOrderCloseSymbol;

	@FindBy(xpath = "//div[@id='menu_ordersection']/descendant::label[position()=2]")
	WebElement orderTakeout;

	@FindBy(xpath = "//a[@class='ubtn btn_addtocard add-multiplier']")
	WebElement addMultiplierBtn;

	@FindBy(xpath = "//a[@class='ubtn btn_addtocard decrease subtract-multiplier']")
	WebElement subMultiplierBtn;

	@FindBy(xpath = "html/body/div[3]/div/div/div/div/div[4]/div[1]/descendant::span[position()=1]")
	WebElement addMultiplierTxt;

	// @FindBy(xpath = "//span[@class='sub-total']")
	@FindBy(xpath = "//html/body/div[3]/orderdiv/div/div/div/div[4]/div[2]/descendant::span[position()=1]")
	WebElement orderPrice$;

	@FindBy(xpath = "//html/body/div[3]/descendant::span[position()=1]")
	WebElement radioWhiteBtn;

	@FindBy(xpath = "//html/body/div[3]/descendant::span[position()=2]")
	WebElement radioBrownBtn;

	@FindBy(xpath = "//a[@class='ubtn blackbtn btn_popupaddtoorder add-to-order']")
	WebElement orderAddToOrderBtn;

	// @FindBy(xpath = "//div[@id='menu']/div/descendant::li[position()=1]")

	@FindBy(xpath = "//div[@id='menu']/div/descendant::ul[position()=1]")
	// @FindBy(tagName = "ul")
	WebElement tabLinks;

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

	// @FindBy(xpath = "//div[@id='pageload']/div[1]/descendant::div[position()=2]")
	@FindBy(xpath = "//div[@class='headerlink_topright y-resraurant-services']")
	WebElement orderOnlineLink;
	// *[@id='menu_ordersection']/div[5]/div/descendant::span[last()-4]

	@FindBy(xpath = "//select[@class='t-order-date']")
	WebElement dateTakeout;

	@FindBy(xpath = "//span[@class='order_total']")
	WebElement totalAmt;

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

	@FindBy(xpath = "//a[contains(text(),'Change')]")
	WebElement changeBtn;

	@FindBy(xpath = "//select[@class='t-order-date']")
	WebElement daySelect;

	@FindBy(xpath = "//select[@class='t-order-time']")
	WebElement orderTimeDelivery;

	@FindBy(xpath = "//label[contains(text(),'Delivery')]")
	WebElement orderDelivery;

	@FindBy(xpath = "//div[@id='menu_ordersection']/div[2]/descendant::p[position()=1]")
	WebElement zeroMilesText;

	@FindBy(xpath = "//div[@id='menu_ordersection']/div[2]/descendant::p[position()=2]")
	WebElement orderDeliveryAddrText;

	@FindBy(xpath = "//div[@class='checkoutDiv']/descendant::p[position()=1]")
	WebElement checkOutTitleText;

	@FindBy(xpath = "//a[@data-target='about']")
	WebElement aboutMenu;

	@FindBy(xpath = "//a[contains(text(),'order online')]")
	WebElement orderOnlineStaticTxt;

	@FindBy(xpath = "//div[@id='contact']/div/div[2]/descendant::strong[position()=3]")
	WebElement deliveryAreaText;

	@FindBy(xpath = "//div[contains(text(),'next')]")
	WebElement nextLinkGallery;

	@FindBy(xpath = "//p[contains(text(),'careers')]")
	WebElement careersTitlePage;

	@FindBy(xpath = "//div[@id='career']/descendant::p[position()=6]")
	WebElement careersResponseThanksMsg;

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

	@FindBy(xpath = "//l[@class='ng-hide']")
	WebElement tagliHide;

	// @FindBy(xpath = "//a[contains(text(),'careers')]")
	// WebElement careersLink;

	@FindBy(xpath = "//a[@data-target='career']")
	WebElement careersLink;

	@FindBy(xpath = "//div/descendant::div[position()=12]")
	WebElement aboutText;

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

	@FindBy(xpath = "//span[contains(text(),'Powered by')]")
	WebElement ftrPoweredByTxt;

	@FindBy(xpath = "//span[contains(text(),'Munch Ado ')]")
	WebElement ftrMunchAdoTxt;

	@FindBy(xpath = "//a[contains(text(),'Terms of Use |')]")
	WebElement ftrTermsofUseTxt;

	@FindBy(xpath = "//a[contains(text(),'Privacy Policy')]")
	WebElement ftrPrivacyPolicyTxt;

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
	// @FindBy(xpath = "//div[@id='menu_ordersection']/descendant::a[position()=5]")
	// @FindBy(xpath ="//span[@class='ubtn blackbtn btn_popupaddtoorder
	// add-to-order']")
	@FindBy(xpath = "//a[contains(text(),'ADD TO ORDER')]")
	WebElement addToOrder;

	@FindBy(xpath = "//a[@data-target='gallery']")
	WebElement galleryMenu;

	@FindBy(xpath = "//a[@data-target='career']")
	WebElement careersMenu;

	@FindBy(xpath = "//a[@data-target='contact']")
	WebElement contactMenu;

	@FindBy(xpath = "//span[contains(text(),'YES, DELETE IT')]")
	WebElement yesDeleteIt;

	// Initializing the Page Objects:

	@FindBy(xpath = "//a[contains(text(),'Catering')]")
	WebElement menuLinkCatering;

	@FindBy(xpath = "//input[@name='contact_firstname']")
	WebElement cateringContactFirstName;

	@FindBy(xpath = "//input[@name='contact_phonenumber']")
	WebElement cateringContactPhoneNum;

	@FindBy(xpath = "//input[@name='contact_email']")
	WebElement cateringContactEmail;

	@FindBy(xpath = "//input[@id='nc_days']")
	WebElement cateringDate;

	@FindBy(xpath = "//input[@id='nc_time']")
	WebElement cateringTime;

	@FindBy(xpath = "//div[@id='catering']/div/descendant::label[position()=1]/descendant::span[position()=1]")
	WebElement cateringRadioBtnEmail;

	@FindBy(xpath = "//div[@id='catering']/div/descendant::label[position()=1]/descendant::span[position()=2]")
	WebElement cateringRadioBtnPhone;

	@FindBy(xpath = "//textarea[@class='describe_event']")
	WebElement cateringTypeofParty;

	@FindBy(xpath = "//input[@name='number_of_people']")
	WebElement cateringNoOfPeople;

	@FindBy(xpath = "//div[@id='catering']/descendant::label[position()=3]")
	WebElement cateringRadioBtnYes;

	@FindBy(xpath = "//div[@id='catering']/descendant::label[position()=4]")
	WebElement cateringRadioBtnNo;

	@FindBy(xpath = "//a[contains(text(),'submit')]")
	WebElement cateringSubmitBtn;

	@FindBy(xpath = "//p[contains(text(),'Thank you!')]")
	WebElement cateringSubThankYouPage;

	@FindBy(xpath = "//p[contains(text(),'Catering Booking')]")
	WebElement textCateringBooking;

	@FindBy(xpath = "//input[contains(text(),'Poultry')]")
	WebElement menuTabPoultry;

	@FindBy(xpath = "//input[contains(text(),'Chicken With Broccoli')]")
	WebElement menuItemChkWithBrcl;

	@FindBy(xpath = "//input[contains(text(),'Sesame Chicken')]")
	WebElement menuItemSesmChkn;

	@FindBy(xpath = "//input[contains(text(),'Fish & Seafood')]")
	WebElement menuTabFish;

	@FindBy(xpath = "//input[contains(text(),'Specials')]")
	WebElement menuTabSpecials;

	@FindBy(xpath = "//input[contains(text(),'Chinese Style Combo')]")
	WebElement menuTabChinStyleCombo;

	@FindBy(xpath = "//input[contains(text(),'Chef's Specialities')]")
	WebElement menuTabChefSplty;

	@FindBy(xpath = "//input[contains(text(),'Casserole Special')]")
	WebElement menuTabCassSpl;

	@FindBy(xpath = "//input[contains(text(),'Appetizers')]")
	WebElement menuTabAptzr;

	@FindBy(xpath = "//input[contains(text(),'Vinetnamese Style Cuisine')]")
	WebElement menuTabVineStylCusn;

	@FindBy(xpath = "//input[contains(text(),'Bund Szechuan Specialty')]")
	WebElement menuTabBundSzecSpl;

	@FindBy(xpath = "//input[contains(text(),'Cold Appetizers')]")
	WebElement menuTabColdAptzr;

	@FindBy(xpath = "//input[contains(text(),'Sides')]")
	WebElement menuTabSides;

	@FindBy(xpath = "//input[contains(text(),'Stir-Fried Rice Cake')]")
	WebElement menuTabStirFrdrcCake;

	@FindBy(xpath = "//input[contains(text(),'Bund House Dessert')]")
	WebElement menuTabBundHsDsrt;

	@FindBy(xpath = "//input[contains(text(),'Soup')]")
	WebElement menuTabSoup;

	@FindBy(xpath = "//input[contains(text(),'Beverages')]")
	WebElement menuTabBvrgs;

	@FindBy(xpath = "//input[contains(text(),'Noodle Soup')]")
	WebElement menuTabNdlSoup;

	@FindBy(xpath = "//input[contains(text(),'Shanghainese Dim Sum')]")
	WebElement menuTabDimSum;

	@FindBy(xpath = "//input[contains(text(),'Noodle & Fried Rice')]")
	WebElement menuTabNdlFrdRice;

	@FindBy(xpath = "//input[contains(text(),'Vegetables')]")
	WebElement menuTabVeg;

	@FindBy(xpath = "//input[contains(text(),'Pork & Beef')]")
	WebElement menuTabPrkBeef;

	@FindBy(xpath = "//input[contains(text(),'Served with white or brown rice. Substitute any dark meat to white meat add $2.00.')]")
	WebElement menuTabTxtPltry;

	@FindBy(xpath = "//input[contains(text(),'Served with white or brown rice.')]")
	WebElement menuTabTxtFish;

	@FindBy(xpath = "//input[contains(text(),'Lunch Special')]")
	WebElement menuTabTxtLunSpl;

	@FindBy(xpath = "//input[contains(text(),'Lunch Combo')]")
	WebElement menuTabTxtLunCombo;

	@FindBy(xpath = "//input[contains(text(),'All noodle soup comes with bund special broth.')]")
	WebElement menuTabTxtAllNdlSoup;

	@FindBy(xpath = "//input[contains(text(),'Noodle')]")
	WebElement menuTabTxtNdl;

	@FindBy(xpath = "//input[contains(text(),'Pork')]")
	WebElement menuTabTxtPork;

	@FindBy(xpath = "//input[contains(text(),'order summary')]")
	WebElement menuTabTxtOrderSumry;

	@FindBy(xpath = "//div[@id='pageload']/descendant::span[position()=3]")
	WebElement addPaymentCart;

	@FindBy(xpath = "//div[@id='menu_checkout']/descendant::p[position()=1]")
	WebElement enterConDetailsTxt;

	@FindBy(xpath = "//p[@class='sectiontitle']")
	WebElement aboutTxt;

	public MicroBizHomePage(ExtentTest test) {
		this.test = test;
		PageFactory.initElements(driver, this);
		// WebElement entryPopup =
		// driver.findElement(By.xpath("//div[@class='entrypopup']"));

	}

	private Object tagName(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public void verifyMenuTabClick() {

		try {
			menuTabPoultry.click();
			test.log(LogStatus.INFO, "Pass:The Poultry Tab is Clicked ");
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail:The Poultry Tab is unable to be Clicked", e.getMessage());

		}

		try {
			menuTabFish.click();

			test.log(LogStatus.INFO, "Pass: The Fish & Sea Food Tab is Clicked ");
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: The Fish & Sea Food Tab is unable to be Clicked", e.getMessage());

		}

		try {
			menuTabSpecials.click();

			test.log(LogStatus.INFO, "Pass: The Specials Tab is Clicked ");
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: The Specials Tab is unable to be Clicked", e.getMessage());

		}

		try {
			menuTabChinStyleCombo.click();
			test.log(LogStatus.INFO, "Pass: The Chinese Style Combo Tab is Clicked ");
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: The Chinese Style Combo Tab is unable to be Clicked", e.getMessage());

		}

		try {

			menuTabChefSplty.click();
			test.log(LogStatus.INFO, "Pass: The Chef's Specialities Tab is Clicked ");
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: The Chef's Specialities Tab is unable to be Clicked", e.getMessage());

		}

		try {

			menuTabCassSpl.click();
			test.log(LogStatus.INFO, "Pass: The Casserole Special Tab is Clicked ");
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: The Casserole Special Tab is unable to be Clicked", e.getMessage());

		}

		try {
			menuTabAptzr.click();
			test.log(LogStatus.INFO, "Pass: The Appetizers Tab is Clicked ");
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: The Appetizers Tab is unable to be Clicked", e.getMessage());

		}

		try {

			menuTabVineStylCusn.click();
			test.log(LogStatus.INFO, "Pass: The Vietnamese Style Cousine Tab is Clicked ");
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: The Vietnamese Style Cousinel Tab is unable to be Clicked", e.getMessage());

		}

		try {

			menuTabBundSzecSpl.click();
			test.log(LogStatus.INFO, "Pass: The Bund Szechuan Speciality Tab is Clicked ");
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: The Bund Szechuan Speciality Tab is unable to be Clicked", e.getMessage());

		}

		try {
			menuTabColdAptzr.click();
			test.log(LogStatus.INFO, "Pass: The Cold Appetizers Tab is Clicked ");
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: The Cold Appetizers Tab is unable to be Clicked", e.getMessage());

		}

		try {
			menuTabSides.click();
			test.log(LogStatus.INFO, "Pass: The Sides Tab is Clicked ");
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: The Sides Tab is unable to be Clicked", e.getMessage());

		}

		try {
			menuTabStirFrdrcCake.click();
			test.log(LogStatus.INFO, "Pass: The Stir Fried Rice Cake Tab is Clicked ");
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: The Stir Fried Rice Cake Tab is unable to be Clicked", e.getMessage());

		}

		try {
			menuTabBundHsDsrt.click();
			test.log(LogStatus.INFO, "Pass: The Bund House Dessert Tab is Clicked ");
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: The Bund House Dessert Tab is unable to be Clicked", e.getMessage());

		}

		try {
			menuTabSoup.click();
			test.log(LogStatus.INFO, "Pass: The Soup Tab is Clicked ");
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: The Soup Tab is unable to be Clicked", e.getMessage());

		}

		try {
			menuTabBvrgs.click();
			test.log(LogStatus.INFO, "Pass: The Beverages Tab is Clicked ");
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: The Beverages Tab is unable to be Clicked", e.getMessage());

		}

		try {
			menuTabNdlSoup.click();
			test.log(LogStatus.INFO, "Pass: The Noodle Soup Tab is Clicked ");
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: The Noodle Soup Tab is unable to be Clicked", e.getMessage());

		}

		try {
			menuTabDimSum.click();
			test.log(LogStatus.INFO, "Pass: The  Shangainese Dim Sum Tab is Clicked ");
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: The  Shangainese Dim Sum Tab is unable to be Clicked", e.getMessage());

		}

		try {
			menuTabNdlFrdRice.click();
			test.log(LogStatus.INFO, "Pass: The Noodle & Fried Rice Tab is Clicked ");
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: The Noodle & Fried Rice Tab is unable to be Clicked", e.getMessage());

		}

		try {
			menuTabVeg.click();
			test.log(LogStatus.INFO, "Pass: The Vegetables Tab is Clicked ");
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: The Vegetables Tab is unable to be Clicked", e.getMessage());

		}

		try {
			menuTabPrkBeef.click();
			test.log(LogStatus.INFO, "Pass: The Casserole Special Tab is Clicked ");
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: The Casserole Special Tab is unable to be Clicked", e.getMessage());

		}

		try {
			menuTabTxtPltry.click();
			test.log(LogStatus.INFO, "Pass: The Pork and Beef Tab is Clicked ");
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: The Pork and Beef Tab is unable to be Clicked", e.getMessage());

		}

		try {

			menuTabFish.click();

			if (menuTabTxtFish.isDisplayed()) {

				test.log(LogStatus.INFO, "Pass: The Served with white or brown rice Text Element is Present "
						+ menuTabTxtFish.getText());
			} else {

				test.log(LogStatus.INFO, "Fail: The Served with white or brown rice Text Element is not Present");

			}
		}

		catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: The Fish & Sea Food Tab is unable to be Clicked", e.getMessage());

		}

		try {
			menuTabTxtLunSpl.click();
			test.log(LogStatus.INFO, "Pass: The Casserole Special Tab is Clicked ");
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: The Casserole Special Tab is unable to be Clicked", e.getMessage());

		}

		try {
			menuTabTxtLunCombo.click();
			test.log(LogStatus.INFO, "Pass: The Casserole Special Tab is Clicked ");
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: The Casserole Special Tab is unable to be Clicked", e.getMessage());

		}

		try {
			menuTabTxtAllNdlSoup.click();
			test.log(LogStatus.INFO, "Pass: The Casserole Special Tab is Clicked ");
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: The Casserole Special Tab is unable to be Clicked", e.getMessage());

		}

		try {
			menuTabTxtNdl.click();
			test.log(LogStatus.INFO, "Pass: The Casserole Special Tab is Clicked ");
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: The Casserole Special Tab is unable to be Clicked", e.getMessage());

		}

		try {
			menuTabTxtPork.click();
			test.log(LogStatus.INFO, "Pass: The Casserole Special Tab is Clicked ");
		} catch (Exception e) {

			test.log(LogStatus.INFO, "Fail: The Casserole Special Tab is unable to be Clicked", e.getMessage());

		}

	}

	public void verifyMenuItemChkWithBrclClick(String firstname, String lastname, String Phone, String Email,
			String specialinstructions, String nameoncard, String cardnumber, String expirymonth, String expiryyear,
			String cvvcode, String billingzip) throws InterruptedException {
		menuTabPoultry.click();

		menuItemChkWithBrcl.click();

		radioWhiteBtn.click();

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
		Thread.sleep(3000);
		addPaymentCart.click();

		String orderTakeoutTax = taxTakeout.getText();
		float orderTakeoutTax$ = Float.parseFloat(orderTakeoutTax);

		float ftotAmount$ = fSubTotAmount + orderTakeoutTax$;

		String totAmountOrderTakeout = totTakeout.getText();

		float totAmountOrderTakeout$ = Float.parseFloat(totAmountOrderTakeout);

		if (ftotAmount$ == totAmountOrderTakeout$) {
			System.out.println("Total Amount is Right   " + ftotAmount$);
			test.log(LogStatus.INFO,
					"The Total Amount of Order to Check Out Payment is Right and Validated:     " + ftotAmount$);
		} else {
			System.out.println("The Total Amount is wrong  " + ftotAmount$);
			test.log(LogStatus.INFO,
					"The Total Amount of Order to Check Out Payment is wrong and Validated:   " + ftotAmount$);

		}

		Actions act = new Actions(driver);
		act.moveToElement(checkoutTakeOut).build().perform();

		checkoutTakeOut.click();
		if (checkOutTitleText.isDisplayed()) {

			test.log(LogStatus.INFO, "Pass:The Checkout Page is Displayed: " + checkOutTitleText.getText());

		} else {
			test.log(LogStatus.INFO, "Fail:The Checkout Page is Displayed: " + checkOutTitleText.isDisplayed());

		}
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

		Thread.sleep(7000);
		placeMyOrderBtn.click();

		if (orderThankYouText.isDisplayed())

		{
			System.out.println("Pass:*****" + orderThankYouText.getText());
			test.log(LogStatus.INFO, "Pass:The Thank You Page is Displayed: " + orderThankYouText.getText());
			test.log(LogStatus.INFO, "Receipt Number for the Order is:  " + receiptNumText.getText());
		} else {
			test.log(LogStatus.INFO, "Fail:The Checkout Page is Displayed: " + orderThankYouText.isDisplayed());
			System.out.println("Fail:*****" + orderThankYouText.isDisplayed());
		}
	}

	public void verifyMenuItemSesmChknClick(String firstname, String lastname, String Phone, String Email,
			String specialinstructions, String nameoncard, String cardnumber, String expirymonth, String expiryyear,
			String cvvcode, String billingzip) throws InterruptedException {
		menuTabPoultry.click();
		menuItemSesmChkn.click();

		radioWhiteBtn.click();

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
		Thread.sleep(3000);

		String Tax = orderTaxAmt.getText();
		float $Tax = Float.parseFloat(Tax);
		System.out.println("The Tax for the Total:   " + $Tax);
		test.log(LogStatus.INFO, "The Tax Amount is Validated      " + $Tax);
		// } catch (Exception e) {
		// test.log(LogStatus.INFO, "Tax Amount not Validated");
		// System.out.println(e.getMessage());
		// System.out.println(e.getStackTrace());
		// }

		changeBtn.click();
		daySelect.click();
		Select daySel = new Select(daySelect);
		daySel.selectByVisibleText("Tomorrow");
		test.log(LogStatus.INFO, "Day Selected is: TOMORROW ");

		Select orderTimeDel = new Select(orderTimeDelivery);
		orderTimeDel.selectByValue("09:30");
		test.log(LogStatus.INFO, "Time Selected is: 9:30 AM ");

		String delAddrTxt = orderDeliveryAddrText.getText();
		String zeroMilesTxt = zeroMilesText.getText();
		String restAddressText = rightAddressTxt.getText();

		if (delAddrTxt.contains(restAddressText) && zeroMilesText.isDisplayed()) {
			System.out.println(
					"Pass: This Restaurant Address is about 0 mile from the Restaurant Current Address Location"
							+ zeroMilesTxt);
			test.log(LogStatus.INFO,
					"Pass: This Restaurant Address is about 0 mile from the Restaurant Current Address Location "
							+ zeroMilesTxt);

		} else {
			System.out.println(
					"Fail: Though the Delivery Address and Restaurant Address are same, about 0 mile from the Restaurant Current Address Location Text is not Displayed Properly"
							+ restAddressText);
			test.log(LogStatus.INFO,
					"Fail: Though the Delivery Address and Restaurant Address are not same" + zeroMilesTxt);
		}

		Select tsel = new Select(selectTipAmt);
		tsel.selectByValue("15");
		test.log(LogStatus.INFO, "The Tip Amount is: 15%   ");
		System.out.println("The Selected Tip Amount is 15%:    ");

		float ftotAmount$ = fSubTotAmount + (fSubTotAmount * 15 / 100) + $Tax;
		// double rtotAmount$=Math.nextDown(totAmount$);

		String sTotAmount = totalAmt.getText();
		System.out.println("The Total Amount displayed is:   " + sTotAmount);

		float TotoalAmount$ = Float.parseFloat(sTotAmount);

		if (ftotAmount$ == TotoalAmount$) {
			System.out.println("Total Amount is Right   " + ftotAmount$);
			test.log(LogStatus.INFO,
					"Pass:The Total Amount of Order to Check Out Payment is Right and Validated:     " + ftotAmount$);
		} else {
			System.out.println("The Total Amount is wrong  " + ftotAmount$);
			test.log(LogStatus.INFO,
					"Fail:The Total Amount of Order to Check Out Payment is wrong and Validated:   " + ftotAmount$);

		}

		Actions act = new Actions(driver);
		act.moveToElement(chkoutDeliveryBtn).build().perform();
		Thread.sleep(5000);

		chkoutDeliveryBtn.click();
		Thread.sleep(3000);

		if (checkOutTitleText.isDisplayed()) {
			System.out.println("Pass:*****" + checkOutTitleText.getText());
			test.log(LogStatus.INFO, "Pass:The Checkout Page is Displayed: " + checkOutTitleText.getText());

		} else {
			test.log(LogStatus.INFO, "Fail:The Checkout Page is not Displayed: " + checkOutTitleText.isDisplayed());
			System.out.println("Pass:*****" + checkOutTitleText.isDisplayed());
		}

		// firstName.sendKeys("ZZZZ");
		// System.out.println("Found ZZZZ XPath");
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		phone.sendKeys(Phone);
		email.sendKeys(Email);
		splInstrctions.sendKeys(specialinstructions);

		nameOnCard.sendKeys(nameoncard);
		// }
		// catch (NullPointerException e) {
		// System.out.print("Empty String");
		// }

		cardNumber.sendKeys(cardnumber);
		expiryMonth.sendKeys(expirymonth);
		expiryYear.sendKeys(expiryyear);
		cvvCode.sendKeys(cvvcode);
		billZip.sendKeys(billingzip);

		Thread.sleep(7000);
		placeMyOrderBtn.click();

		if (orderThankYouText.isDisplayed())

		{
			System.out.println("Pass:*****" + orderThankYouText.getText());
			test.log(LogStatus.INFO, "Pass:The Thank You Page is Displayed: " + orderThankYouText.getText());
			test.log(LogStatus.INFO, "Receipt Number for the Order is:  " + receiptNumText.getText());
		} else {
			test.log(LogStatus.INFO, "Fail:The Checkout Page is not Displayed: " + orderThankYouText.isDisplayed());
			System.out.println("Fail:*****" + orderThankYouText.isDisplayed());
		}

	}

	public boolean verifyAboutMenu() throws InterruptedException {

		Actions act = new Actions(driver);
		act.moveToElement(aboutMenu).build().perform();
		Thread.sleep(5000);

		if (aboutMenu.isDisplayed()) {

			test.log(LogStatus.INFO, "Pass:The Static Link at Home Page About Menu Static Text is Present  ",
					aboutMenu.getText());

		} else {
			test.log(LogStatus.INFO, "Fail: The Static Link at Home Page  About Menu Static Text is not Present  ");
		}

		return aboutMenu.isDisplayed();
	}

	public boolean verifyDeliveryAreaStaticText() throws InterruptedException {

		Actions act = new Actions(driver);
		act.moveToElement(deliveryAreaText).build().perform();
		Thread.sleep(5000);

		if (deliveryAreaText.isDisplayed()) {

			test.log(LogStatus.INFO, "Pass:The Static Link at Home Page Delivery Area Static Text is Present  ",
					deliveryAreaText.getText());

		} else {
			test.log(LogStatus.INFO, "Fail: The Static Link at Home Page  Delivery Area Static Text is not Present  ");
		}

		return deliveryAreaText.isDisplayed();

	}

	public boolean verifyHomePageStaticLinks() throws InterruptedException {

		Actions act = new Actions(driver);
		act.moveToElement(ftrPoweredByTxt).build().perform();
		Thread.sleep(3000);

		if (ftrPoweredByTxt.isDisplayed()) {

			test.log(LogStatus.INFO, "Pass:The Static Link at Home Page Footer  Powered By Texti is Present  ",
					ftrPoweredByTxt.getText());
		} else {
			test.log(LogStatus.INFO, "Fail: The Static Link at Home Page Footer  Powered By Texti is not Present  ");
		}

		if (ftrMunchAdoTxt.isDisplayed()) {

			test.log(LogStatus.INFO, "Pass:The Static Link at Home Page Footer  Munch Ado Text is Present  ",
					ftrPoweredByTxt.getText());
		} else {
			test.log(LogStatus.INFO, "Fail: The Static Link at Home Page Footer  Much Ado Text is not Present  ");
		}

		if (ftrTermsofUseTxt.isDisplayed()) {

			test.log(LogStatus.INFO, "Pass:The Static Link at Home Page Footer Terms of Use Text is Present  ",
					ftrPoweredByTxt.getText());
		} else {
			test.log(LogStatus.INFO, "Fail: The Static Link at Home Page Footer Terms of Use Text is not Present  ");
		}

		if (ftrPrivacyPolicyTxt.isDisplayed())

		{

			test.log(LogStatus.INFO, "Pass:The Static Link at Home Page Privacy Policy Text is Present  ",
					ftrPrivacyPolicyTxt.getText());
		} else {
			test.log(LogStatus.INFO, "Fail: The Static Link at Home Page Footer Privacy Policy Text is not Present  ");
		}

		return ftrPrivacyPolicyTxt.isDisplayed();
	}

	public void cateringBookings(String firstname, String phonenumber, String email, String partydate, String partytime,
			String partytype, String numberofpeople) throws InterruptedException {

		Thread.sleep(6000);
		menuLinkCatering.click();
		Thread.sleep(5000);
		cateringContactFirstName.sendKeys(firstname);
		cateringContactPhoneNum.sendKeys(phonenumber);
		cateringContactEmail.sendKeys(email);
		cateringDate.sendKeys(partydate);
		cateringTime.sendKeys(partytime);
		cateringRadioBtnEmail.click();
		cateringTypeofParty.sendKeys(partytype);
		cateringNoOfPeople.sendKeys(numberofpeople);
		cateringRadioBtnYes.click();
		cateringSubmitBtn.click();

		Thread.sleep(5000);

		if (cateringSubThankYouPage.isDisplayed() && textCateringBooking.isDisplayed()) {
			System.out.println("Pass:*****" + cateringSubThankYouPage.getText());
			test.log(LogStatus.INFO, "Catering Booking is displayed  " + textCateringBooking.getText());
			test.log(LogStatus.INFO, "Pass:The Thank You Page is Displayed: " + cateringSubThankYouPage.getText());

		} else {
			test.log(LogStatus.INFO, "Catering Booking is displayed  " + textCateringBooking.isDisplayed());
			test.log(LogStatus.INFO, "Pass:The Thank You Page is Displayed: " + cateringSubThankYouPage.isDisplayed());
			System.out.println("Fail:*****" + cateringSubThankYouPage.isDisplayed());
			System.out.println("Fail:*****" + textCateringBooking.isDisplayed());
		}

	}

	public void clickCheckout(String firstname, String lastname, String Phone, String Email, String specialinstructions,
			String nameoncard, String cardnumber, String expirymonth, String expiryyear, String cvvcode,
			String billingzip) throws InterruptedException {
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

	public void clickCheckoutToEdit(String firstname, String lastname, String Phone, String Email,
			String specialinstructions, String nameoncard, String cardnumber, String expirymonth, String expiryyear,
			String cvvcode, String billingzip) throws InterruptedException {
		Thread.sleep(5000);

		checkoutTakeOut.click();
		editOrderBtn.click();

	}

	public void VerifyMenuTabList() throws InterruptedException {

		Thread.sleep(4000);

		Menu.click();
		Thread.sleep(4000);

		List<WebElement> tab_List = tabLinks.findElements(By.tagName("li"));

		// System.out.println("The TabText is: "+tab_List);

		for (int i = 0; i < tab_List.size(); i++) {

			Actions act = new Actions(driver);
			act.moveToElement(orderDeliver).build().perform();

			// if (!tab_List.get(i).isDisplayed() && !tab_List.get(i).isEnabled()){
			// continue;
			// }
			String tab_List_Text = tab_List.get(i).getText();

			if (tab_List_Text.contains("0")) {
				continue;
			}

			// if(!tabElement.isDisplayed()) {
			//
			// continue;
			// }

			// tabElement.click();

			// if (!tab_List.get(i).isDisplayed()){
			// continue;
			// }
			Thread.sleep(3000);

			WebDriverWait wait = new WebDriverWait(driver, 40);
			WebElement tabElement = wait.until(ExpectedConditions.visibilityOf(tab_List.get(i)));

			if (tab_List.get(i).isDisplayed()) {
				// String tab_List_Text = tab_List.get(i).getText();
				System.out.println("The Text of Li Tags are:  " + tab_List_Text);
				// WebDriverWait wait = new WebDriverWait(driver, 40)
				// WebElement tabElement =
				// wait.until(ExpectedConditions.visibilityOf(tab_List.get(i)));

				tabElement.click();
				// if (tab_List.get(i).getText().length()>0){

				// if(tab_List.get(i).getClass().getName().matches("ng-hide")) {
				// continue;
				// }
				System.out.println("Pass: The Element  " + tab_List_Text + "  is Clicked");
				test.log(LogStatus.INFO, "Pass: The " + tab_List_Text + "  is Clicked  ");
			}
			Thread.sleep(3000);
		}

	}

	public void verifyMenuOrderOnln() throws InterruptedException {
		List<WebElement> orderOnlinkList = orderOnlineLink.findElements(By.tagName("a"));

		for (int i = 3; i < orderOnlinkList.size(); i++) {
			// restbl_OrderOnln_Links_List.get(i1).getText();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement element = wait.until(ExpectedConditions.visibilityOf(orderOnlinkList.get(i)));

			if (orderOnlinkList.get(i).isDisplayed()) {

				String orderOnlinkListText = orderOnlinkList.get(i).getText();

				if (orderOnlinkListText.contains("0")) {
					break;
				}
				System.out.println("The Order Links Text is:    " + orderOnlinkListText);
				// System.out.println("The Text of a Tags are: " + orderOnlinkListText);
				// tab_List.get(i1).click();
				element.click();
				test.log(LogStatus.INFO, "Pass: The " + orderOnlinkListText + "  is Clicked  ");

				// String restbl_OrderOnln_Links_List_Text =
				//
				if (orderOnlinkListText.contains("reserve a table")) {
					System.out.println("The Order Links Text is:    " + orderOnlinkListText);
					element.click();
					Thread.sleep(5000);
					resTableClose.click();
					test.log(LogStatus.INFO, "Pass: The " + orderOnlinkListText + "  is Clicked  ");

				}
			}
		}

	}

	public void verifyTopMenuLinks() throws InterruptedException {
		// List<WebElement> top_Menu_Li_Tag_List =
		// driver.findElements(By.tagName("li"));

		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.moveToElement(aboutTxt).build().perform();

		WebElement top_Menu_ul_Tag_List = driver.findElement(By.tagName("ul"));
		List<WebElement> top_Menu_Links_Li_Tag_List = top_Menu_ul_Tag_List.findElements(By.tagName("li"));
		// List<WebElement> top_Menu_aTag_List =
		// top_Menu_Links_Li_List.findElements(By.tagName("a"));

		// System.out.println("The Menu Links Texts are: " + top_Menu_Links_List_Text);

		// String abtText = driver
		// .findElement(By.xpath("//div[@id='pageload']/div[1]/div/div[2]/ul/li/descendant::a[position()=1]"))
		// .getText();
		// System.out.println("The About Test is: " + abtText);
		// String Xpath1 =
		// "[//div[@id='pageload']/div[1]/div/div[2]/ul/descendant::a[position()=";
		// String Xpath2 = "]";
		// List<WebElement> Ord_Sub_MenuList= driver.findElements(By.tagName("a"));
		// List<WebElement> top_Menu_Links_SubList = top_Menu_Link
		// .findElements(By.xpath("//div[@id='pageload']/div[1]/div/div[2]/ul/descendant::a[position()="));
		// List<WebElement> restbl_OrderOnln_Links_List =
		// restbl_OrderOnln_Links.findElements(By.tagName("a"));
		//
		for (int i = 0; i < top_Menu_Links_Li_Tag_List.size(); i++) {
			// for (int i1 = 0; i1 < top_Menu_aTag_List.size(); i1++) {
			// List<WebElement> top_Menu_Links_SubLists =
			// driver.findElements(By.xpath(Xpath1 +String.valueOf(i+1) + Xpath2));
			// System.out.println(" The Text Tags are:" +
			// top_Menu_Links_SubLists.get(i+1).getText());

			Thread.sleep(4000);
			// for (int i1 = 0; i1 < top_Menu_Links_SubList.size(); i1++) {

			String top_Menu_Li_Tag_List_Text = top_Menu_Links_Li_Tag_List.get(i).getText();

			int Tab_Text_Length = top_Menu_Li_Tag_List_Text.length();

			System.out.println("The Tag Text Length is:    " + Tab_Text_Length);

			if (Tab_Text_Length == 0) {

				System.out.println("The Tag Text is not Available  " + Tab_Text_Length);
				// element=null;

				continue;
			}

			WebDriverWait wait = new WebDriverWait(driver, 40);
			WebElement element = wait.until(ExpectedConditions.visibilityOf(top_Menu_Links_Li_Tag_List.get(i)));

			// int Tab_Text_Length=top_Menu_Li_Tag_List_Text.length();

			// WebDriverWait wait = new WebDriverWait(driver, 40);
			// WebElement element =
			// wait.until(ExpectedConditions.visibilityOf(top_Menu_Links_Li_Tag_List.get(i)));

			// if(top_Menu_Li_Tag_List_Text. {
			//
			// System.out.println("The Tag Text is not Available ");
			//
			// continue;
			// }
			//
			//
			System.out.println("The Text of Li Tags are: " + top_Menu_Li_Tag_List_Text);

			// WebDriverWait wait = new WebDriverWait(driver, 10);
			// WebElement element =
			// wait.until(ExpectedConditions.visibilityOf(top_Menu_Links_Li_Tag_List.get(i)));
			//
			////

			if (top_Menu_Links_Li_Tag_List.get(i).isDisplayed()) {
				// System.out.println("The Class is: " + element.getTagName());
				Thread.sleep(4000);

				element.click();
				System.out.println("Pass: The Li Tag is Clicked " + top_Menu_Li_Tag_List_Text + " is Clicked  ");
				// top_Menu_Li_Tag_List.get(i).click();
				test.log(LogStatus.INFO, "Pass: The " + top_Menu_Li_Tag_List_Text + " is Clicked ");
				// }else
				//
				test.log(LogStatus.INFO, "Fail: The " + top_Menu_Li_Tag_List_Text + " is not Clicked ");

			}
		}

	}

	public void verifyTopOrderOnln() {
		// String Xpath1="//div[@id='pageload']/descendant::a[position()=";
		// String Xpath2="]";
		//
		List<WebElement> restbl_OrderOnln_Links_Tag_A_Lists = restbl_OrderOnln_Links.findElements(By.tagName("a"));

		List<WebElement> restbl_OrderOnln_Links_Tag_Div_Lists = restbl_OrderOnln_Links.findElements(By.tagName("div"));
		// WebElement
		// restbl_OrderOnln_Links_Tag_Div_List=restbl_OrderOnln_Links.findElement(By.tagName("div"));

		// List<WebElement> restbl_OrderOnln_Links_Tag_Div_Div_List =
		// restbl_OrderOnln_Links_Tag_Div_List.findElements(By.tagName("div"));

		List<WebElement> restbl_OrderOnln_Links_Tag_A_List = restbl_OrderOnln_Div3tag_Links
				.findElements(By.tagName("a"));
		WebElement restbl_OrderOnln_Links_Tag_Div_A_List = restbl_OrderOnln_Div3tag_Links.findElement(By.tagName("a"));
		System.out.println("The List Text:   " + restbl_OrderOnln_Links_Tag_Div_A_List.getText());

		for (int i2 = 0; i2 < restbl_OrderOnln_Links_Tag_A_Lists.size(); i2++) {
			// Thread.sleep(9000);

			String a_Text = restbl_OrderOnln_Links_Tag_A_Lists.get(i2).getText();

			if (a_Text.contains("0")) {
				continue;
			}
			// System.out.println("The a Tags are: " + a_Text);

			// String aTag_Text= driver.findElement(By.xpath(Xpath1+i+Xpath2)).getText();
			// System.out.println("The Tag Text is: "+aTag_Text);
			// WebElement aTag= driver.findElement(By.xpath(Xpath1+i+Xpath2));
			// String restbl_OrderOnln_Links_List_Text =
			// restbl_OrderOnln_Links_List.get(i).getText();
			// System.out.println("The Text of a Tags are: " +
			// restbl_OrderOnln_Links_List_Text);

			try {
				// restbl_OrderOnln_Links_List.get(i1).click();
				if (restbl_OrderOnln_Links_Tag_A_Lists.get(i2).isDisplayed()) {
					WebDriverWait wait = new WebDriverWait(driver, 40);
					////
					WebElement element = wait
							.until(ExpectedConditions.visibilityOf(restbl_OrderOnln_Links_Tag_A_Lists.get(i2)));
					element.click();
					System.out.println("Pass: The Tag " + a_Text + " is Clicked  ");
					test.log(LogStatus.INFO, "Pass: The " + a_Text + " is Clicked  ");
					try {

						if (a_Text.contains("reserve a table")) {
							Thread.sleep(4000);
							resTableClose.click();
							System.out.println("Pass: The Tag  " + a_Text + " is Closed");

							test.log(LogStatus.INFO, "Pass: The " + a_Text + " is Closed ");

						}

					} catch (Exception e) {

						System.out.println("Pass: The Tag  " + a_Text + " is not Closed  ");

						test.log(LogStatus.INFO, "Pass: The " + a_Text + " is not Closed  ");
					}

				}

				try {

					if (a_Text.contains("order online")) {
						Thread.sleep(4000);
						String mtpt_Popup_txt = mtpt_Orderonline_Popup.getText();

						if (mtpt_Popup_txt.contains("Select a location to place your delivery or takeout order")) {
							resTableClose.click();
							System.out.println("Pass: The Popup  " + mtpt_Popup_txt + "is Closed:   ");
							test.log(LogStatus.INFO, "Pass: The Popup " + mtpt_Popup_txt + "is Closed:    ");
						}
					}
				} catch (Exception e) {

					String mtpt_Popup_txt = mtpt_Orderonline_Popup.getText();

					System.out.println("Fail: The Tag  " + mtpt_Popup_txt + " is not Closed  " + e.getMessage());

					test.log(LogStatus.INFO, "Fail: The " + mtpt_Popup_txt + " is not Closed  " + e.getMessage());
				}
			}

			catch (Exception e) {
				//
				System.out.println("Fail: The Tag " + a_Text + " is not Clicked");
				test.log(LogStatus.INFO, "Fail: The " + a_Text + " is not Clicked " + e.getMessage());
			}

			// Thread.sleep(6000);

			//

			// try {
			//
			// if (a_Text.contains("reserve a table")) {
			// Thread.sleep(4000);
			// resTableClose.click();
			// System.out.println("Pass: The Tag " + a_Text + " is Clicked");
			//
			// test.log(LogStatus.INFO, "Pass: The " + a_Text + " is Clicked ");
			//
			// }
			// }
			// catch (Exception e) {
			//
			// System.out.println("Pass: The Tag " + a_Text + " is not Closed ");
			//
			// test.log(LogStatus.INFO, "Pass: The " + a_Text + " is not Closed ");
			// }
			// }
			//
			// String mtpt_Popup_txt=mtpt_Orderonline_Popup.getText();
			//
			// //
			// try {
			//
			// if(mtpt_Popup_txt.contains("Select a location to place your delivery or
			// takeout order")) {
			// resTableClose.click();
			// System.out.println("The Popup "+ mtpt_Popup_txt+"is Closed: ");
			// test.log(LogStatus.INFO, "The Popup " + mtpt_Popup_txt+"is Closed: ");
			// }
			// }
			// catch (Exception e) {
			//
			// System.out.println("Pass: The Tag " + mtpt_Popup_txt + " is not Closed ");
			//
			// test.log(LogStatus.INFO, "Pass: The " + mtpt_Popup_txt + " is not Closed ");
			// }
			//
			//

			// }

			for (int i = 0; i < restbl_OrderOnln_Links_Tag_A_List.size(); i++) {

				// String div_Text = restbl_OrderOnln_Links_Tag_Div_Lists.get(i).getText();
				String div_A_Text = restbl_OrderOnln_Links_Tag_Div_A_List.getText();
				System.out.println("The div A Tags are:  " + div_A_Text);
				//

				if (div_A_Text.contains("0")) {
					continue;
				}

				try {

					if (restbl_OrderOnln_Links_Tag_Div_A_List.isDisplayed()) {
						// WebDriverWait wait = new WebDriverWait(driver, 30);
						// ////
						// WebElement element = wait
						// .until(ExpectedConditions.visibilityOf(restbl_OrderOnln_Links_Tag_Div_Lists.get(i)));
						Thread.sleep(5000);
						restbl_OrderOnln_Links_Tag_Div_A_List.click();
						// try {
						//
						// if (a_Text.contains("reserve a table")) {
						// Thread.sleep(4000);
						// resTableClose.click();
						// System.out.println("Pass: The Tag " + a_Text + " is Closed");
						//
						// test.log(LogStatus.INFO, "Pass: The " + a_Text + " is Closed ");
						//
						// }
						//
						// } catch (Exception e) {
						//
						// System.out.println("Pass: The Tag " + a_Text + " is not Closed ");
						//
						// test.log(LogStatus.INFO, "Pass: The " + a_Text + " is not Closed ");
						// }
						//// Thread.sleep(6000);
						//
						// //
						//
						// try {
						//
						// if (a_Text.contains("order online")) {
						// Thread.sleep(4000);
						//
						//
						// if (mtpt_Popup_txt.contains("Select a location to place your delivery or
						// takeout order")) {
						// resTableClose.click();
						// System.out.println("Pass: The Popup " + mtpt_Popup_txt + "is Closed: ");
						// test.log(LogStatus.INFO, "Pass: The Popup " + mtpt_Popup_txt + "is Closed:
						// ");
						// }
						// } catch (Exception e) {
						//
						// System.out.println("Fail: The Tag " + mtpt_Popup_txt + " is not Closed " +
						// e.getMessage());
						//
						// test.log(LogStatus.INFO, "Fail: The " + mtpt_Popup_txt + " is not Closed " +
						// e.getMessage());
						// }
						// }
						//
						//
						Thread.sleep(5000);

						System.out.println("Pass: The Tag  " + div_A_Text + "  is Clicked  ");

						test.log(LogStatus.INFO, "Pass: The Tag " + div_A_Text + " is Clicked ");
					}
				}

				catch (Exception e) {
					//
					System.out.println("Fail: The Tag  " + div_A_Text + "  is not Clicked");
					test.log(LogStatus.INFO, "Fail: The Tag " + div_A_Text + " is not Clicked " + e.getMessage());
				}
			}
		}

		// for (int i3 = 0; i3 < restbl_OrderOnln_Links_Tag_Div_Div_A_List.size(); i3++)
		// {
		//
		// String div_A_Text =
		// restbl_OrderOnln_Links_Tag_Div_Div_A_List.get(i3).getText();
		// System.out.println("The div A Tags are: " + div_A_Text);
		// //
		// if (div_A_Text.contains("0")) {
		// continue;
		// }
		//
		// try {
		// // restbl_OrderOnln_Links_List.get(i1).click();
		// if (restbl_OrderOnln_Links_Tag_Div_Div_A_List.get(i3).isDisplayed()) {
		// WebDriverWait wait2 = new WebDriverWait(driver, 40);
		// ////
		// WebElement element2 = wait2.until(
		// ExpectedConditions.visibilityOf(restbl_OrderOnln_Links_Tag_Div_Div_A_List.get(i3)));
		// element2.click();
		// System.out.println("Pass: The Tag " + div_A_Text + " is Clicked");
		// test.log(LogStatus.INFO, "Pass: The " + div_A_Text + " is Clicked ");
		// }
		// } catch (Exception e) {
		// System.out.println("Fail: The Tag " + div_A_Text + " is not Clicked" +
		// e.getMessage());
		// test.log(LogStatus.INFO, "Fail: The " + div_A_Text + " is not Clicked " +
		// e.getMessage());
		// }

		// if (a_Text.contains("0")) {
		// continue;
		// }
		// System.out.println("The a Tags are: " + a_Text);

	}

	//
	// }
	// }
	//
	//
	//
	// // restbl_OrderOnln_Links_List.get(i1).click();
	//// if (restbl_OrderOnln_Links_Tag_Div_Lists.get(i).isDisplayed()) {
	//// WebDriverWait wait2 = new WebDriverWait(driver, 30);
	//// ////
	//// WebElement element2 = wait2
	//// .until(ExpectedConditions.visibilityOf(restbl_OrderOnln_Links_Tag_Div_Lists.get(i)));
	//// element2.click();
	////
	////
	////
	//// }
	//
	//
	// catch (Exception e) {
	// //
	// System.out.println("Fail: The Tag " + div_Text + " is not Clicked");
	// test.log(LogStatus.INFO, "Fail: The " + div_Text + " is not Clicked " +
	// e.getMessage());
	//
	// }

	// Thread.sleep(6000);
	//
	//// try {
	//// if(restbl_OrderOnln_Links.isDisplayed()){
	//// if (restbl_OrderOnln_Links_List_Text.contains("reserve a table")) {
	//// WebDriverWait wait = new WebDriverWait(driver, 40);
	////
	//// WebElement element = wait
	//// .until(ExpectedConditions.visibilityOf(restbl_OrderOnln_Links));
	//// element.click();
	//// Thread.sleep(6000);
	//// resTableClose.click();
	//// }
	//// }
	//// }
	//// catch (Exception e) {
	////
	//// test.log(LogStatus.INFO,"Fail: The " + restbl_OrderOnln_Links + " is not
	// Present " + e.getMessage());
	// }
	//
	// }
	// }
	//
	//
	//// }
	//
	//
	//// test.log(LogStatus.INFO, "Pass: The " + restbl_OrderOnln_Links_List_Text +
	// " is Clicked ");
	////
	//

	// public void clickMenu() {
	// Menu.click();
	//
	// }

	// public boolean verifyMenu() throws InterruptedException {
	//
	// // Set<String> winids = driver.getWindowHandles();
	// // Iterator<String> iterate = winids.iterator();
	//
	// Menu.click();
	// Thread.sleep(4000);
	// String ItemPrice = itemPrice.getText();
	// // winids = driver.getWindowHandles();
	// // iterate = winids.iterator();
	// // String parentwindow = iterate.next();
	// Baked_French_Onion_Soup.click();
	// System.out.println("Clicked It");
	// Thread.sleep(6000);
	// // driver.switchTo().frame(0);
	// addToOrder.click();
	// System.out.println("Add Order Clicked");
	// // String parentwtitle = driver.getTitle();
	// // System.out.println(parentwtitle);
	//
	// // driver.switchTo().defaultContent();
	//
	// // iterate = winids.iterator();
	// // window id of the main window
	// // String popupwindow = iterate.next(); // window id of the popup window
	//
	// // driver.switchTo().window(popupwindow);
	// // String apopuptitle = driver.getTitle();
	// // String epopuptitle = "Baked French Onion Soup";
	// // // Assert.assertTrue(true,"Baked French Onion Soup");
	// // Assert.assertEquals(epopuptitle, apopuptitle);
	// // String PopUpItemPrice = popupItemPrice.getText();
	// // Assert.assertTrue(ItemPrice.contentEquals(PopUpItemPrice));
	// // System.out.println("Assertion Done");
	//
	// // driver.switchTo().window(parentwindow);
	//
	// return Menu.isDisplayed();
	// }

	public boolean verifyCareersMenu() {
		return careersMenu.isDisplayed();
	}

	public boolean verifyContactText() throws InterruptedException {

		contactLink.click();
		Thread.sleep(5000);
		if (contactMenu.isDisplayed()) {

			test.log(LogStatus.INFO, "Pass:The Static Link at Home Page Contact Text is Present  ",
					contactMenu.getText());
		} else {
			test.log(LogStatus.INFO, "Fail: The Static Link at Home Page ContactText is not Present  ");
		}

		return contactMenu.isDisplayed();

	}

	public boolean verifyOrderOnlineStatic() {

		if (orderOnlineStaticTxt.isDisplayed()) {

			test.log(LogStatus.INFO, "Pass:The Static Link at Home Page Order Online Static Text is Present  ",
					orderOnlineStaticTxt.getText());

		} else {
			test.log(LogStatus.INFO, "Fail: The Static Link at Home Page Order Online Static Text is not Present  ");
		}
		return orderOnlineStaticTxt.isDisplayed();
	}

	public void careersClick(String name, String email, String website, String message) throws InterruptedException {

		Thread.sleep(5000);

		careersLink.click();
		careersName.sendKeys(name);
		careersEmail.sendKeys(email);
		careersWebsite.sendKeys(website);
		careersMessage.sendKeys(message);

		Thread.sleep(5000);
		careersSubmitBtn.click();
		Thread.sleep(7000);

		Actions act = new Actions(driver);
		act.moveToElement(careersTitlePage).build().perform();

		if (careersTitlePage.isDisplayed() && careersResponseThanksMsg.isDisplayed()) {
			System.out.println("Pass:*****" + careersTitlePage.getText());
			test.log(LogStatus.INFO, "Pass: Careers Title Page is displayed  " + careersTitlePage.getText());
			test.log(LogStatus.INFO,
					"Pass: The Thank You Response Message Page is Displayed: " + careersResponseThanksMsg.getText());

		} else {
			test.log(LogStatus.INFO, "Fail: Careers Title Page is not displayed  " + careersTitlePage.isDisplayed());
			test.log(LogStatus.INFO, "Fail: The Thank You Response Message Page is not Displayed: "
					+ careersResponseThanksMsg.isDisplayed());
			System.out.println("Fail:*****" + careersTitlePage.isDisplayed());
			System.out.println("Fail:*****" + careersResponseThanksMsg.isDisplayed());
		}
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
		Thread.sleep(5000);

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

		if (srightAddress.equals(expectedAddress)) {
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

	public void verifyAddPaymentCart(String firstname, String lastname, String Phone, String Email,
			String specialinstructions, String nameoncard, String cardnumber, String expirymonth, String expiryyear,
			String cvvcode, String billingzip) throws InterruptedException {

		orderAddtoCart.click();

		radioWhiteBtn.click();

		addMultiplierBtn.click();
		Thread.sleep(5000);
		orderAddToOrderBtn.click();
		Thread.sleep(3000);

		addPaymentCart.click();
		Thread.sleep(5000);

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

		Thread.sleep(7000);
		placeMyOrderBtn.click();

		if (orderThankYouText.isDisplayed())

		{
			System.out.println("Pass:*****" + orderThankYouText.getText());
			test.log(LogStatus.INFO, "Pass:The Thank You Page is Displayed: " + orderThankYouText.getText());
			test.log(LogStatus.INFO, "Receipt Number for the Order is:  " + receiptNumText.getText());
		} else {
			test.log(LogStatus.INFO, "Fail:The Checkout Page is Displayed: " + orderThankYouText.isDisplayed());
			System.out.println("Fail:*****" + orderThankYouText.isDisplayed());
		}

	}

	public boolean ReserveTbl() throws InterruptedException {
		contactLink.click();
		Thread.sleep(5000);

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
		Actions act = new Actions(driver);
		act.moveToElement(aphoneNumber).build().perform();
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

}
