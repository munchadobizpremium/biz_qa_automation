package global_utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import elements_ui.element_locator;

public class handle_ajax_call extends global_variables{
	
	public static void HandleAjaxCall() throws InterruptedException
	{
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		 LocalDateTime now = LocalDateTime.now();  		   
		 Boolean isJqueryUsed1 = (Boolean)((JavascriptExecutor)Driver).executeScript("return (typeof(jQuery) != 'undefined')");
			if(isJqueryUsed1)
			{				
				while (true)
				{
					Boolean ajaxIsComplete = (Boolean)(((JavascriptExecutor)Driver).executeScript("return jQuery.active == 0"));
				    if (ajaxIsComplete) break;				    
				    do
				    {
				    	System.out.println(dtf.format(now)+ ":  Ajax call in progress...");
				    }
				    while(ajaxIsComplete);
				}
			}		 		
	}

	
	public static void HandleAjaxCallSignin(String ElementKey,String ElementSelector) throws InterruptedException
	{
		if(ElementKey.isEmpty()!=true&&ElementSelector.isEmpty()!=true)
		{
			element_locator element_loc=new element_locator();
			By element_locator=null;
			element_locator=element_loc.getElement(ElementKey, ElementSelector);
			WebDriverWait wait = new WebDriverWait(Driver, 40);
			wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));
		}
		
	}
	
	public static void HandleNodeCall() throws InterruptedException
	{
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		 LocalDateTime now = LocalDateTime.now();  		   
		 Boolean isJqueryUsed1 = (Boolean)((JavascriptExecutor)Driver).executeScript("return (typeof(jQuery) != 'undefined')");
			if(isJqueryUsed1)
			{				
				while (true)
				{
					Boolean ajaxIsComplete = (Boolean)(((JavascriptExecutor)Driver).executeScript("return jQuery.active == 0"));
				    if (ajaxIsComplete) break;				    
				    do
				    {
				    	System.out.println(dtf.format(now)+ ":  Ajax call in progress...");
				    }
				    while(ajaxIsComplete);
				}
			}		 		
	}

	
}

