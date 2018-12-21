package templates;

import java.io.IOException;

import action.action_career;
import action.action_checkout;
import action.action_common;
import action.action_gallery;
import action.action_menu;
import action.action_openBrowser;
import action.action_product;
import action.action_reserveTable;
import global_utility.global_variables;
import global_utility.takescreenshot;

public class template_testcase extends global_variables{		
	
	action_openBrowser action_openBrowser=new action_openBrowser();
	action_common common_action=new action_common();
	action_menu menu_action =new action_menu();
	action_career career_action=new action_career();
	action_gallery gallery_action=new action_gallery();
	action_product product_action=new action_product();
	action_reserveTable ReserveATable_action=new action_reserveTable();
	action_checkout checkout_action=new action_checkout();
	takescreenshot getscreenshot=new takescreenshot();
	int Status=0;
	public int OpenBrowser(String Environment,String Browser,String Client)
	{
		
		try 
		{			
			ProductDetails.clear();
			Status=action_openBrowser.OpenBrowser(Environment, Browser);			
		} catch (IOException e) {
			log_system.error("Execution failed:  open Browsers "+ Browser+" for Environment "+ Environment);
			log_system.error(e.getMessage());
			Status=0;
		}
		getscreenshot.screenshot(path_lib_screenshot+Client+"/", Thread.currentThread().getStackTrace()[1].getMethodName());
		common_action.updateReport(Status,Thread.currentThread().getStackTrace()[1].getMethodName());
		return Status;
	}
	
	
	public int GetURL(String url,String Client,String templete_ID, gs_utilities.runner gs_runner)
	{
		try 
		{			
			Status=common_action.URL(url,templete_ID,gs_runner);
		} catch (Exception e) {
			log_system.error("Execution failed to get url "+url);
			log_system.error(e.getMessage());
			Status=0;
		}
		getscreenshot.screenshot(path_lib_screenshot+Client+"/", Thread.currentThread().getStackTrace()[1].getMethodName());
		common_action.updateReport(Status,Thread.currentThread().getStackTrace()[1].getMethodName());
		return Status;
	}

	public int VerifySSL(String Client)
	{				
		try {
			Status=common_action.VerifySSL();
		} catch (Exception e) {
			log_system.error("Execution failed to verify SSL ");
			log_system.error(e.getMessage());
			Status=0;
		}		
		common_action.updateReport(Status,Thread.currentThread().getStackTrace()[1].getMethodName());
		return Status;
	}
	
	public int CloseBrowser(String Client)
	{
		try {
			Status=common_action.CloseBrowser();
		} catch (Exception e) {
			log_system.error("Execution failed to Close Browser");
			log_system.error(e.getMessage());
			Status=0;
		}
		
		common_action.updateReport(Status,Thread.currentThread().getStackTrace()[1].getMethodName());
		return Status;
	}
	
	public int VerifyMenu(String url,String Client)
	{
		try {
			
			Status=menu_action.VerifyMenu(url);
		} catch (Exception e) {
			log_system.error("Execution failed to verify Menu");
			log_system.error(e.getMessage());
			Status=0;
		}
		getscreenshot.screenshot(path_lib_screenshot+Client+"/", Thread.currentThread().getStackTrace()[1].getMethodName());
		common_action.updateReport(Status,Thread.currentThread().getStackTrace()[1].getMethodName());
		return Status;
	}
	
	public int ConsolError(String Client)
	{
		try {
			
			Status=common_action.ConsolError();
		} catch (Exception e) {
			log_system.error("Execution failed to verify Consol Error");
			log_system.error(e.getMessage());
			Status=0;
		}
		getscreenshot.screenshot(path_lib_screenshot+Client+"/", Thread.currentThread().getStackTrace()[1].getMethodName());
		common_action.updateReport(Status,Thread.currentThread().getStackTrace()[1].getMethodName());
		return Status;
	}
	
	public int VerifyCareer(String Client)
	{
		try {
			
			Status=career_action.verifyCareer();
		} catch (Exception e) {
			log_system.error("Execution failed to verify Career");
			log_system.error(e.getMessage());
			Status=0;
		}
		getscreenshot.screenshot(path_lib_screenshot+Client+"/", Thread.currentThread().getStackTrace()[1].getMethodName());
		common_action.updateReport(Status,Thread.currentThread().getStackTrace()[1].getMethodName());
		return Status;
	}
	
	public int VerifyGallery(String Client)
	{
		try {
			
			Status=gallery_action.verifyGallery();
		} catch (Exception e) {
			log_system.error("Execution failed to verify Gallery");
			log_system.error(e.getMessage());
			Status=0;
		}
		getscreenshot.screenshot(path_lib_screenshot+Client+"/", Thread.currentThread().getStackTrace()[1].getMethodName());
		common_action.updateReport(Status,Thread.currentThread().getStackTrace()[1].getMethodName());
		return Status;
	}

	public int VerifyMenuItem(String Client)
	{
		try {
			
			Status=product_action.VerifyMenuItem();
		} catch (Exception e) {
			log_system.error("Execution failed to verify Menu Item");
			log_system.error(e.getMessage());
			Status=0;
		}
		getscreenshot.screenshot(path_lib_screenshot+Client+"/", Thread.currentThread().getStackTrace()[1].getMethodName());
		common_action.updateReport(Status,Thread.currentThread().getStackTrace()[1].getMethodName());
		return Status;
	}
	
	public int AddProduct(String Client)
	{
		try {
			
			Status=product_action.AddProduct();
		} catch (Exception e) {
			log_system.error("Execution failed to Add Product");
			log_system.error(e.getMessage());
			Status=0;
		}
		getscreenshot.screenshot(path_lib_screenshot+Client+"/", Thread.currentThread().getStackTrace()[1].getMethodName());
		common_action.updateReport(Status,Thread.currentThread().getStackTrace()[1].getMethodName());
		return Status;
	}
	
	
	public int SelectTakeout(String ElementKey,String ElementSelector,String Client)
	{
		try {
			
			Status=common_action.SelectTakeout(ElementKey, ElementSelector);
		} catch (Exception e) {
			log_system.error("Execution failed to Add Product");
			log_system.error(e.getMessage());
			Status=0;
		}
		getscreenshot.screenshot(path_lib_screenshot+Client+"/", Thread.currentThread().getStackTrace()[1].getMethodName());
		common_action.updateReport(Status,Thread.currentThread().getStackTrace()[1].getMethodName());
		return Status;
	}
	
	public int AddEditProduct(String Client)
	{
		try {
			
			Status=product_action.AddEditProduct();
		} catch (Exception e) {
			log_system.error("Execution failed to Add Edit Product");
			log_system.error(e.getMessage());
			Status=0;
		}
		getscreenshot.screenshot(path_lib_screenshot+Client+"/", Thread.currentThread().getStackTrace()[1].getMethodName());
		common_action.updateReport(Status,Thread.currentThread().getStackTrace()[1].getMethodName());
		return Status;
	}
	
	
	public int RemoveEditProduct(String Client)
	{
		try {
			
			Status=product_action.RemoveEditProduct();
		} catch (Exception e) {
			log_system.error("Execution failed to Remove Edit Product");
			log_system.error(e.getMessage());
			Status=0;
		}
		getscreenshot.screenshot(path_lib_screenshot+Client+"/", Thread.currentThread().getStackTrace()[1].getMethodName());
		common_action.updateReport(Status,Thread.currentThread().getStackTrace()[1].getMethodName());
		return Status;
	}
	
	public int DeleteProduct(String Client,String Instruction)
	{
		try {
			
			Status=product_action.DeleteProduct(Instruction);
		} catch (Exception e) {
			log_system.error("Execution failed to Delete Product");
			log_system.error(e.getMessage());
			Status=0;			
		}
		getscreenshot.screenshot(path_lib_screenshot+Client+"/", Thread.currentThread().getStackTrace()[1].getMethodName());
		common_action.updateReport(Status,Thread.currentThread().getStackTrace()[1].getMethodName());
		return Status;
	}
	
	public int VerifySummary(String Client,String ElementKey, String ElementSelector,String Tax)
	{
		try {
			
			Status=product_action.VerifySummary(ElementKey,ElementSelector,Tax);
		} catch (Exception e) {
			log_system.error("Execution failed to verify Summary");
			log_system.error(e.getMessage());
			Status=0;
		}
		getscreenshot.screenshot(path_lib_screenshot+Client+"/", Thread.currentThread().getStackTrace()[1].getMethodName());
		common_action.updateReport(Status,Thread.currentThread().getStackTrace()[1].getMethodName());
		return Status;
	}
	
	public int VerifySummaryDelivery(String Client,String ElementKey, String ElementSelector,String Tax)
	{
		try {
			
			Status=product_action.VerifySummaryDelivery(ElementKey,ElementSelector,Tax);
		} catch (Exception e) {
			log_system.error("Execution failed to verify Summary");
			log_system.error(e.getMessage());
			Status=0;
		}
		getscreenshot.screenshot(path_lib_screenshot+Client+"/", Thread.currentThread().getStackTrace()[1].getMethodName());
		common_action.updateReport(Status,Thread.currentThread().getStackTrace()[1].getMethodName());
		return Status;
	}
	
	public int VerifyDelivery(String Client,String Address)
	{
		try {
			
			Status=product_action.VerifyDelivery(Address);
		} catch (Exception e) {
			log_system.error("Execution failed for verify delivery");
			log_system.error(e.getMessage());
			Status=0;
		}
		getscreenshot.screenshot(path_lib_screenshot+Client+"/", Thread.currentThread().getStackTrace()[1].getMethodName());
		common_action.updateReport(Status,Thread.currentThread().getStackTrace()[1].getMethodName());
		return Status;
	}
	
	public int VerifyDeliveryTime(String Client,String City,String timeslot)
	{
		try {
			
			Status=product_action.VerifyDeliveryTime(City,timeslot);
		} catch (Exception e) {
			log_system.error("Execution failed for verify delivery");
			log_system.error(e.getMessage());
			Status=0;
		}
		getscreenshot.screenshot(path_lib_screenshot+Client+"/", Thread.currentThread().getStackTrace()[1].getMethodName());
		common_action.updateReport(Status,Thread.currentThread().getStackTrace()[1].getMethodName());
		return Status;
	}
	
	
	public int CheckoutForTakeout(String Client,String City,String timeslot,String Address,String Tax)
	{
		try {
			
			Status=checkout_action.CheckoutforTakeout(City,timeslot,Address,Tax);
		} catch (Exception e) {
			log_system.error("Execution failed for checkout of takeout");
			log_system.error(e.getMessage());
			Status=0;
		}
		getscreenshot.screenshot(path_lib_screenshot+Client+"/", Thread.currentThread().getStackTrace()[1].getMethodName());
		common_action.updateReport(Status,Thread.currentThread().getStackTrace()[1].getMethodName());
		return Status;
	}
	
	
	public int CheckoutForTakeoutWithEdit(String Client,String City,String timeslot,String Address,String Tax)
	{
		try {
			
			Status=checkout_action.CheckoutforTakeoutWithEdit(City,timeslot,Address,Tax);
		} catch (Exception e) {
			log_system.error("Execution failed for checkout of takeout");
			log_system.error(e.getMessage());
			Status=0;
		}
		getscreenshot.screenshot(path_lib_screenshot+Client+"/", Thread.currentThread().getStackTrace()[1].getMethodName());
		common_action.updateReport(Status,Thread.currentThread().getStackTrace()[1].getMethodName());
		return Status;
	}
	
	
	public int CheckoutForDelivery(String Client,String City,String timeslot,String Address,String Tax)
	{
		try {
			
			Status=checkout_action.CheckoutforDelivery(City,timeslot,Address,Tax);
		} catch (Exception e) {
			log_system.error("Execution failed for checkout of Delivery");
			log_system.error(e.getMessage());
			Status=0;
		}
		getscreenshot.screenshot(path_lib_screenshot+Client+"/", Thread.currentThread().getStackTrace()[1].getMethodName());
		common_action.updateReport(Status,Thread.currentThread().getStackTrace()[1].getMethodName());
		return Status;
	}
	

	public int CheckoutForDeliveryEdit(String Client,String City,String timeslot,String Address,String Tax)
	{
		try {
			
			Status=checkout_action.CheckoutforDeliveryEdit(City,timeslot,Address,Tax);
		} catch (Exception e) {
			log_system.error("Execution failed for checkout of Delivery");
			log_system.error(e.getMessage());
			Status=0;
		}
		getscreenshot.screenshot(path_lib_screenshot+Client+"/", Thread.currentThread().getStackTrace()[1].getMethodName());
		common_action.updateReport(Status,Thread.currentThread().getStackTrace()[1].getMethodName());
		return Status;
	}

	
	public int ReserveATable(String Client)
	{
		try {
			
			Status=ReserveATable_action.ReserveATable();
		} catch (Exception e) {
			log_system.error("Execution failed for Reserve A Table");
			log_system.error(e.getMessage());
			Status=0;
		}
		getscreenshot.screenshot(path_lib_screenshot+Client+"/", Thread.currentThread().getStackTrace()[1].getMethodName());
		common_action.updateReport(Status,Thread.currentThread().getStackTrace()[1].getMethodName());
		return Status;
	}
	
	public int verifyTimeforReserveATable(String Client,String City,String TimeSlot)
	{
		try {
			
			Status=ReserveATable_action.verifyTimeforReserveATable(City,TimeSlot);
		} catch (Exception e) {
			log_system.error("Verification failed of time and date for reserve a table");
			log_system.error(e.getMessage());
			Status=0;
		}
		getscreenshot.screenshot(path_lib_screenshot+Client+"/", Thread.currentThread().getStackTrace()[1].getMethodName());
		common_action.updateReport(Status,Thread.currentThread().getStackTrace()[1].getMethodName());
		return Status;
	}
}
