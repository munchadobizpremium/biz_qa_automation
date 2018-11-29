package action;


import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.markuputils.MarkupHelper;

import elements_ui.element_locator;
import global_utility.global_variables;
import global_utility.handle_ajax_call;

public class action_common extends global_variables
{
	element_locator element_loc=new element_locator();
	By element_locator=null;
	int Status=0;	
	public int URL(String url,String templete_ID,gs_utilities.runner gs_runner) throws Exception
	{				
		Driver.get(url);
		handle_ajax_call.HandleAjaxCall();
		Thread.sleep(2000);		
		do
		{
			Thread.sleep(200);
		}while(Driver.findElement(By.id("mainloader")).isDisplayed());
		handle_ajax_call.HandleAjaxCall();
		Thread.sleep(4000);
		try {			
			Driver.findElement(By.xpath("//div[normalize-space(@class) = 'entrypopup text-align-center'] | //div[normalize-space(@class) = 'entrypopupinner'] | //div[normalize-space(@class) = '_popup_bookyourholiday box_hwclub text-align-center']"));
			Driver.findElement(By.xpath("//a[normalize-space(@class) = 'i_close close']")).click();
		} catch (Exception e) {

		}
		
		try
		{
			Driver.findElement(By.xpath("//div[normalize-space(@class) = 'text-align-center landing_list_contact']"));
			Driver.findElement(By.xpath("//a[normalize-space(@dataid) = 'link_orderOnline']")).click();
			handle_ajax_call.HandleAjaxCall();
			Thread.sleep(2000);
			Driver.findElement(By.xpath("//a[normalize-space(@class) = 'ubtn blackbtn y-resUrl']")).click();
			handle_ajax_call.HandleAjaxCall();
			Thread.sleep(3000);
			gs_runner.setTemplateUrl(url+"home.html");
			
		}
		catch(Exception e)
		{
			
		}
			
		log_system.info("URL opened successfully");
		Status=1;		
		return Status;
	}
	
	public int VerifySSL() throws Exception
	{				
		if(Driver.getCurrentUrl().toLowerCase().contains("https"))
		{
			log_system.info("SSL verified successfully");
			Status=1;
		}		
		return Status;
	}
	
	
	
	
	public int ConsolError() 
	{		
		ArrayList<String> error=new ArrayList<String>();
		try
		{		
			 Logs logs = Driver.manage().logs();
		        LogEntries logEntries = logs.get(LogType.BROWSER);
		        for(LogEntry logEntry :logEntries)
		        {
		        	
		            if (logEntry.getLevel().getName().equals("SEVERE")) {
		            	error.add(logEntry.getMessage());
		                log_system.error("Error Message in Console:"+logEntry.getMessage());
		            } else if (logEntry.getLevel().getName().equals("WARNING")){
		            	log_system.warn("Warning Message in Console:"+logEntry.getMessage());
		            }else{
		            	log_system.warn("Information Message in Console:"+logEntry.getMessage());
		            }
		        }		        
		        
		}
		catch(Exception e)
		{
			Status=0;
		}
		
		if(error.size()<=0)
        {
        	log_system.info("Consol Error verified successfully");
        	Status=1;			
        }
		else
		{
			log_system.info("Consol Error verified successfully");
			Status=0;
		}
		return Status;
	}
	
	public int CloseBrowser() throws Exception
	{	
		Driver.close();
		log_system.info("Browser Closed successfully");
		Status=1;
		return Status;
	}
	
	
	public int Click(WebElement element)  throws Exception
	{	
		
		
		try {
			Actions act=new Actions(Driver);
			act.moveToElement(element).build().perform();
			do
			{
				Thread.sleep(200);
			}while(!element.isDisplayed() && !element.isEnabled());
					
			element.click();
			Status=1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		return Status;
	}
	
	
	public int SelectTakeout(String ElementKey,String ElementSelector)  throws Exception
	{	
		
		element_locator=element_loc.getElement(ElementKey, ElementSelector);		
		Actions act=new Actions(Driver);
		
		try {
			Driver.get(Driver.getCurrentUrl());
			Thread.sleep(3000);
			WebElement takeout=Driver.findElement(element_locator);
			act.moveToElement(takeout).build().perform();
			takeout.click();		
			Status=1;
		} catch (Exception e) {
			Status=2;
		}
		
		
		
		return Status;
	}
	
	public int VerifyText(String ElementKey,String ElementSelector,String text) throws Exception
	{
		try {
			Thread.sleep(2000);
			element_locator=element_loc.getElement(ElementKey, ElementSelector);
			WebDriverWait wait = new WebDriverWait(Driver, 40);
			wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));
			Actions act=new Actions(Driver);
			act.moveToElement(Driver.findElement(element_locator)).build().perform();
			
			
			if(Driver.findElement(element_locator).getText().trim().toLowerCase().replace("\"", "").contains(text.toString().trim().toLowerCase()))
			{			
				Status=1;			
			}
		} catch (Exception e) {
			Status=0;
		}				
		
		return Status;
	}
	
	public int SetText(String ElementKey, String ElementSelector,String InputString)  throws Exception
	{		
		
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		Actions act=new Actions(Driver);
		act.moveToElement(Driver.findElement(element_locator)).build().perform();
		WebDriverWait wait = new WebDriverWait(Driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));		
		Driver.findElement(element_locator).sendKeys(Keys.CONTROL+"a");
		Driver.findElement(element_locator).sendKeys(Keys.BACK_SPACE);
		Driver.findElement(element_locator).sendKeys(InputString);
		Status=1;
		return Status;
	}
	
	public int VerifyURL(String url)
	{
		if(Driver.getCurrentUrl().equals(url))
		Status=1;
		return Status;
	}
	
	
	public void updateReport(int Status,String Desc)
	{
		switch(Status)
		{
		case 1:
		{	
			String url="<img width='100px' src=\""+path_lib_screenshotfull+"\" data-src=\""+path_lib_screenshotfull+"\" data-featherlight=\""+path_lib_screenshotfull+"\">";					
			String[][] desc={{"Descritpion","Screenshot"},{Desc,url}};
			qc_testinfo.log(com.aventstack.extentreports.Status.PASS, MarkupHelper.createTable(desc));
			break;
		}
		case 0:
		{
			String url="<img width='100px' src=\""+path_lib_screenshotfull+"\" data-src=\""+path_lib_screenshotfull+"\" data-featherlight=\""+path_lib_screenshotfull+"\">";						
			String[][] desc={{"Descritpion","Screenshot"},{Desc,url}};
			testinfo.log(com.aventstack.extentreports.Status.FAIL, MarkupHelper.createTable(desc));
			qc_testinfo.log(com.aventstack.extentreports.Status.FAIL, MarkupHelper.createTable(desc));
			break;
		}
		case 2:
		{
			String url="<img width='100px' src=\""+path_lib_screenshotfull+"\" data-src=\""+path_lib_screenshotfull+"\" data-featherlight=\""+path_lib_screenshotfull+"\">";						
			String[][] desc={{"Descritpion","Screenshot"},{Desc,url}};			
			qc_testinfo.log(com.aventstack.extentreports.Status.SKIP, MarkupHelper.createTable(desc));
			break;
		}
		}
		
	}
	
	
	public int VerifyElement(String ElementKey, String ElementSelector) 
	{		
		try
		{		
			element_locator=element_loc.getElement(ElementKey, ElementSelector);
			Actions act=new Actions(Driver);
			WebDriverWait wait = new WebDriverWait(Driver, 20);
			wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));
			act.moveToElement(Driver.findElement(element_locator)).build().perform();
			if(Driver.findElement(element_locator).isDisplayed())
				Status=1;	
			else
				Status=0;
			
		}
		catch(Exception e)
		{
			Status=0;
		}
		return Status;
	}
	
	public int VerifyNoElement(String ElementKey, String ElementSelector) 
	{	
		
		try
		{
			Thread.sleep(2000);
			element_locator=element_loc.getElement(ElementKey, ElementSelector);
			Driver.findElement(element_locator);
			Status=0;
		}
		catch(Exception e)
		{
			Status=1;
		}						
		return Status;
	}
	
}
