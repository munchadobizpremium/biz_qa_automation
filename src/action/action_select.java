package action;

import java.util.ArrayList;
import global_utility.global_variables;

public class action_select extends global_variables{
	
	public ArrayList<String> ActionSelect(String UseCase_ID,String TestCase_ID,String Description,String Action,String ElementType,String Element,String Input1,String Input2,String Input3,String Input4) 
	{
		
		action_perform act_perform=new action_perform();
		int Status=0;
		ArrayList<String> result_log=new ArrayList<String>();
		try
		{
			log_system.info("Select Action: "+ Action);
			switch(Action)
			{
			case "OpenBrowser":
			{
				log_system.info("Action Open Browser Selected");
				Status=act_perform.Perform_OpenBrowser(Input1,Input2);
				log_system.info("Action Open Browser Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add(Input1+" : Browser Open Successfully");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Input1+" : Browser not Opened");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "GetURL":
			{
				log_system.info("Action Get URL Selected");
				Status=act_perform.Perform_GetURL(Input1);
				log_system.info("Action verify URL Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("url verified: "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("url mismatch: "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifySSL":
			{
				log_system.info("Action Verify SSL");
				Status=act_perform.Perform_VerifySSL();
				log_system.info("Action Verify SSL Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Verify SSL done");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Site is not secure");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifyURL":
			{
				log_system.info("Action Verify URL");
				Status=act_perform.Perform_VerifyURL(Input1);
				log_system.info("Action Verify URL Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Verify URL done");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Site is not secure");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifyText":
			{
				log_system.info("Action verify text Selected");
				Status=act_perform.Perform_VerifyText(ElementType,Element,Input1);
				log_system.info("Action verify text Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("text verified: "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("text mismatch: "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifyTitle":
			{
				log_system.info("Action Title Selected");
				Status=act_perform.Perform_VerifyTitle(Input1,Input2);
				log_system.info("Action Verify Title Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Title verified succesfully: "+ Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Title verification Failed: "+ Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifyElement":
			{
				log_system.info("Action Verify Element Selected");
				Status=act_perform.Perform_VerifyElement(ElementType,Element);
				log_system.info("Action Verify Element Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Element verified succesfully ");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Element verification Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifyFavicon":
			{
				log_system.info("Action Verfy Favicon Selected");
				Status=act_perform.Perform_VerifyFavicon(ElementType,Element);
				log_system.info("Action Verfy Favicon Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Favicon verified succesfully ");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Favicon verification Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "ConsolError":
			{
				log_system.info("Action ConsolError Selected");
				Status=act_perform.Perform_ConsolError();
				log_system.info("Action ConsolError Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("ConsolError succesfully ");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("ConsolError Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifyNoElement":
			{
				log_system.info("Action Verify No Element Selected");
				Status=act_perform.Perform_VerifyNoElement(ElementType,Element);
				log_system.info("Action Verify No Element Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Element verified succesfully ");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Element verification Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "Click":
			{
				log_system.info("Action Click Selected");
				Status=act_perform.Perform_Click(ElementType,Element);
				log_system.info("Action Click Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Click Performed succesfully");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Action Click Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "SelectDropdown":
			{
				log_system.info("Action SelectDropdown Selected");
				Status=act_perform.Perform_SelectDropdown(ElementType,Element);
				log_system.info("Action SelectDropdown Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("SelectDropdown Performed succesfully");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Action SelectDropdown Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "SelectDate":
			{
				log_system.info("Action SelectDate Selected");
				Status=act_perform.Perform_SelectDate(ElementType,Element);
				log_system.info("Action SelectDate Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("SelectDate Performed succesfully");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Action SelectDate Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "SelectTimeSlot":
			{
				log_system.info("Action Select Time Slot Selected");
				Status=act_perform.Perform_SelectTimeSlot(ElementType,Element);
				log_system.info("Action Select Time Slot Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Select Time Slot Performed succesfully");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Action Select Time Slot Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "SetText":
			{
				log_system.info("Action Set Text Selected");
				Status=act_perform.Perform_SetText(ElementType,Element, Input1);
				log_system.info("Action Set Text Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Text Entered successfully: "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Set Text Fail: "+ Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "AddProduct":
			{
				log_system.info("Action Add product Selected");
				Status=act_perform.Perform_AddProduct(ElementType,Element);
				log_system.info("Action Add Product Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Product Added successfully: "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Add Product Fail: "+ Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifyMenuItem":
			{
				log_system.info("Action VerifyMenuItem Selected");
				Status=act_perform.Perform_VerifyMenuItem(ElementType,Element);
				log_system.info("Action VerifyMenuItem Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("VerifyMenuItem successfully: "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("VerifyMenuItem Fail: "+ Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "AddEditProduct":
			{
				log_system.info("Action Edit Product Selected");
				Status=act_perform.Perform_AddEditProduct();
				log_system.info("Action Edit Product Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Product Edited successfully: "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Edit Product Fail: "+ Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "DeleteProduct":
			{
				log_system.info("Action Edit Product Selected");
				Status=act_perform.Perform_DeleteProduct(Input1);
				log_system.info("Action Edit Product Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Product Edited successfully: "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Edit Product Fail: "+ Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "RemoveEditProduct":
			{
				log_system.info("Action Remove Product Selected");
				Status=act_perform.Perform_RemoveEditProduct();
				log_system.info("Action Remove Product Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Product Removed successfully: "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Remove Product Fail: "+ Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifySummary":
			{
				log_system.info("Action Verify Summary Selected");
				Status=act_perform.Perform_VerifySummary(ElementType,Element,Input1);
				log_system.info("Action VerifySummary Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Verify Summary  successfully: "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Verify Summary Fail: "+ Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "Wait":
			{
				log_system.info("Action Wait");
				Status=act_perform.Perform_wait(Input1);
				if(Status==1){result_log.add("Text Entered successfully: "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Set Text Fail: "+ Input1);result_log.add("Fail");result_log.add("-");}
				break;
			}
			case "ClearText":
			{
				log_system.info("Action Clear Text Selected");
				Status=act_perform.Perform_ClearText(ElementType,Element);
				log_system.info("Action Clear Text Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Clear Entered successfully");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Clear Text Fail:");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "CloseBrowser":
			{
				log_system.info("Action Close Browser Selected");				
				Status=act_perform.Perform_CloseBrowser(Input1);
				log_system.info("Action Close Browser Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Action performed successfully: "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Action fail: "+ Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "QuitDriver":
			{
				log_system.info("Action Quit Driver Selected");
				act_perform.Perform_QuitDriver();				
				break;
			}
			}
		}
		catch(Exception e)
		{
 			switch(Action)
			{
			case "OpenBrowser":
			{				
				result_log.add(Input1+" Browser not Opened");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "GetURL":
			{
				result_log.add(Input1+" URL not Opened");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "VerifyURL":
			{
				result_log.add(Input1+" URL not verified");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "VerifySSL":
			{
				result_log.add("Verify SSL failed");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "VerifyText":
			{
				result_log.add("text not verified: "+Input1);
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "ConsolError":
			{
				result_log.add("ConsolError not verified");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "AddProduct":
			{
				result_log.add("Add Product not verified");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "VerifyMenuItem":
			{
				result_log.add("VerifyMenuItem not verified");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "AddEditProduct":
			{
				result_log.add("Edit Product not verified");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "DeleteProduct":
			{
				result_log.add("Edit Product not verified");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "RemoveEditProduct":
			{
				result_log.add("Remove Product not verified");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "VerifySummary":
			{
				result_log.add("Verify Summary not verified");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "VerifyTitle":
			{
				result_log.add(Input1+": Title not verified");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "Wait":
			{
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());
				break;
			}			
			case "VerifyElement":
			{
				result_log.add("Element not verified");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "VerifyNoElement":
			{
				result_log.add("Element not verified");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "VerfyFavicon":
			{
				result_log.add("Favicon not verified");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "Click":
			{
				result_log.add("action click failed");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "SelectDropdown":
			{
				result_log.add("action SelectDropdown failed");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "SelectDate":
			{
				result_log.add("action SelectDate failed");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "SelectTimeSlot":
			{
				result_log.add("action SelectTimeSlot failed");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "SetText":
			{
				result_log.add("action set text failed: "+ Input1);
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "ClearText":
			{
				result_log.add("action Clear text failed");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			default:
				if(e.getMessage().contains("500"))
				{
					Driver.navigate().back();
				}
			}
		}
		
		return result_log;
	}
}
