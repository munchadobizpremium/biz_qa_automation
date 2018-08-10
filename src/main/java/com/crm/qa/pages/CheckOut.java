package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class CheckOut extends TestBase {

	@FindBy(xpath = "//div[@class='checkoutsection']/descendant::input[position()=1]")
	WebElement firstName ;
	
	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastName ;
	
	@FindBy(xpath = "//input[@name='phone_no']")
	WebElement phone ;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement email;
	
	@FindBy(xpath = "//textarea[@name='own_instruction']")
	WebElement splInstrctions;
	
	
	@FindBy(xpath = "//input[@name='card_name']")
	WebElement nameOnCard;
	
	@FindBy(xpath = "//input[@name='card_number']")
	WebElement cardNumber ;
	
	@FindBy(xpath = "//select[@class='card_expire_month']")
	WebElement expiryMonth;
	
	@FindBy(xpath = "//select[@class='card_expire_year']")
	WebElement expiryYear;
	
	@FindBy(xpath = "//select[@class='cvv_code']")
	WebElement cvvCode;
	
	@FindBy(xpath = "//select[@class='zip']")
	WebElement billZip;
	
	@FindBy(xpath = "//a[contains(text(),'place my order')]")
	WebElement placeMyOrderBtn;

	public CheckOut() {
		PageFactory.initElements(driver, this);
	}

//	public CheckOutPage clickOnCheckOutBtn(){
//		checkOut.click();
//		return new CheckOutPage();
//	}
//	public void createNewCustomer(String ftName, String ltName, String phn, String mail, String splin, String namcrd, String crdno, String exmth, String exyr, String cvvcd, String bzip ) throws InterruptedException{
//		Select select = new Select(driver.findElement(By.name("title")));
//		select.selectByVisibleText(title);
		
	public void createNewCustomer() throws InterruptedException{
	    Thread.sleep(5000);
//	    driver.switchTo().frame(0);
		firstName.sendKeys("Deepak");
		lastName.sendKeys("Chandna");
		phone.sendKeys("2103333434");
		email.sendKeys("abc@gmail.com");
		splInstrctions.sendKeys("Make Things as Scheduled");
		nameOnCard.sendKeys("Deepak C");
		cardNumber.sendKeys("2424444455556666");
		expiryMonth.sendKeys("05");
		expiryYear.sendKeys("2020");
		cvvCode.sendKeys("007");
		billZip.sendKeys("20590");
		placeMyOrderBtn.click();
//		driver.switchTo().defaultContent();
		
			
		
	}
	
	

	
}
