package com.crm.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DeleteOrderPage extends TestBase {

	@FindBy(xpath = "//p[contains(text(),'Thank You')]")
	WebElement orderThankYouText;

	@FindBy(xpath = "//p[@class='txt_receiptid']")
	WebElement receiptNumText;

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
	WebElement orderDelivery;

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
	@FindBy(xpath = "//html/body/div[3]/div/div/div/div/div[4]/div[2]/descendant::span[position()=1]")
	WebElement orderPrice$;

	
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

	@FindBy(xpath = "//div[contains(text(),'Total')]")
	WebElement totalAmountTxt;
	// div[@id='menu_ordersection']/div[5]/div/div[1]/descendant::p[position()=2]

	@FindBy(xpath = "///span[@class='order_subtotal']")
	WebElement subtotTakeout;

	@FindBy(xpath = "//span[@class='order_tax']")
	WebElement taxTakeout;

	@FindBy(xpath = "//span[@class='order_total']")
	WebElement totTakeout;

	@FindBy(xpath = "//a[contains(text(),'Change')]")
	WebElement changeBtn;

	@FindBy(xpath = "//select[@class='t-order-date']")
	WebElement daySelect;

	@FindBy(xpath = "//select[@class='t-order-time']")
	WebElement orderTimeDelivery;

	@FindBy(xpath = "//div[@id='menu_ordersection']/div[2]/descendant::p[position()=1]")
	WebElement zeroMilesText;

	@FindBy(xpath = "//div[@id='menu_ordersection']/div[2]/descendant::p[position()=2]")
	WebElement orderDeliveryAddrText;

	@FindBy(xpath = "//div[@class='checkoutDiv']/descendant::p[position()=1]")
	WebElement checkOutTitleText;

	@FindBy(xpath = "//a[@data-target='menu']")
	WebElement Menu;

	@FindBy(xpath = "//p[contains(text(),'$4.99')]")
	WebElement itemPrice;

	@FindBy(xpath = "//p[contains(text(),'$4.99')]")
	WebElement popupItemPrice;

	// @FindBy(xpath = "//span[contains(text(),'Baked French Onion Soup')]")
	@FindBy(xpath = "//span[contains(text(),'Baked French Onion Soup')]")

	WebElement Baked_French_Onion_Soup;

	@FindBy(xpath = "//span[contains(text(),'YES, DELETE IT')]")

	WebElement yesDeleteIt;

	@FindBy(xpath = "//span[contains(text(),'1')]")
	WebElement itemQtyOrdered;

	// @FindBy(xpath = "//a[contains(text(),'ADD TO ORDER')]")
	@FindBy(xpath = "//div[@class='a_modal-dialog']/descendant::div[position()=14]")
	// @FindBy(xpath ="//span[@class='ubtn blackbtn btn_popupaddtoorder
	// add-to-order']")
	WebElement addToOrder;

	@FindBy(xpath = "//a[contains(text(),'checkout for takeout')]")
	WebElement checkoutTakeOut;

	// Initializing the Page Objects:
	//
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

	@FindBy(xpath = "//p[@class='title_bs_order']")
	WebElement textYourOrder;

	@FindBy(xpath = "//a[contains(text(),'Edit Order')]")
	WebElement editOrderBtn;

	@FindBy(xpath = "//div[@id='menu_ordersection']/descendant::a[position()=5]")
	WebElement deleteBtn;
	
	@FindBy(xpath = "//a[contains(text(),'View Menu')]")
	WebElement viewMenu;
	
	@FindBy(xpath = "//div[@class='popup_location _p30']/descendant::a[position()=2]")
	WebElement btnLocation2;

	@FindBy(xpath = "//input[@data-label='White Rice']/following::span[@class='control_indicator']")
	WebElement radioWhiteBtn;

	@FindBy(xpath = "//input[@data-label='Brown Rice']/following::span[@class='control_indicator']")
	WebElement radioBrownBtn;
	
	@FindBy(xpath = "//div[@id='pageload']/following::div[@class='custom_checkbox']")
	WebElement checkBoxWhiteMeat;

	
	ExtentTest test;

	GalleryPage gallerypage;
	public String rightAddress;

	public DeleteOrderPage(ExtentTest test) {
		this.test = test;
		gallerypage = new GalleryPage(test);
		PageFactory.initElements(driver, this);
	}

	public void deleteBtnClick() throws InterruptedException {

		
		try {
			if (isElementPresent("//a[contains(text(),'View Menu')]") == true) {

				viewMenu.click();
				Thread.sleep(3000);
			}
		} catch (Exception e) {

			System.out.println("WebElement View Menu is unavailable " + e.getMessage());
		}

		try {

			if (isElementPresent("//div[@class='popup_location _p30']") == true
					&& isElementPresent("//div[@class='popup_location _p30']/descendant::a[position()=2]") == true) {

				Thread.sleep(3000);
				btnLocation2.click();

				Thread.sleep(4000);

			}

		} catch (Exception e) {

			System.out.println("Web Element not Available");
		}
		Thread.sleep(3000);

		try {
			if (isElementPresent("//a[contains(text(),'order online')]") == true
					&& isElementPresent("//label[@class='ubtn btn_service hide']") == false) {

				orderOnlineTab.click();

			}
		} catch (Exception e) {

			System.out.println("WebElement Order Online Tab  is unavailable " + e.getMessage());
		}


		Thread.sleep(5000);
		orderTakeout.click();
		Thread.sleep(3000);

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
			if (isElementPresent("//div[@id='pageload']/following::div[@class='custom_checkbox']")==true) {
				
				checkBoxWhiteMeat.click();
				Thread.sleep(3000);
			
			}
		} catch (Exception e) {

			System.out.println("WebElement White Meat Check Box is unavailable " + e.getMessage());
		}
		
			


		addMultiplierBtn.click();
		Thread.sleep(4000);

		orderAddToOrderBtn.click();
		Thread.sleep(3000);

		Actions act = new Actions(driver);
		act.moveToElement(textYourOrder).build().perform();
       
		Thread.sleep(4000);
		deleteBtn.click();
		
		Thread.sleep(4000);
		yesDeleteIt.click();

		System.out.println("The Item is Deleted  ");
		test.log(LogStatus.INFO, "The Item is Deleted  ");

	}
}
