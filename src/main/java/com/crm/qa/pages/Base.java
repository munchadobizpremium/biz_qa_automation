package com.crm.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Base extends TestBase {

	
	
	public Base() {
		PageFactory.initElements(driver, this);
	}

}
